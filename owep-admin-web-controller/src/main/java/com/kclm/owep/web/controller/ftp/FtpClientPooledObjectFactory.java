package com.kclm.owep.web.controller.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;


public class FtpClientPooledObjectFactory implements PooledObjectFactory<FTPClient> {

    private FtpProperties ftpProperties;

    private static  final Logger log =LoggerFactory.getLogger(FtpClientPooledObjectFactory.class);

    public FtpClientPooledObjectFactory(FtpProperties ftpProperties) {
        this.ftpProperties = ftpProperties;
    }

    @Override
    public PooledObject<FTPClient> makeObject() throws Exception {
        FTPClient ftpClient = new FTPClient();
        try {
            System.out.println(ftpProperties.getPort());
            System.out.println(ftpProperties.getIp());
            ftpClient.connect(ftpProperties.getIp(), Integer.valueOf(ftpProperties.getPort()));
            System.out.println(ftpProperties.getPort());
            System.out.println(ftpProperties.getUsername());
            System.out.println(ftpProperties.getPassword());
            ftpClient.login(ftpProperties.getUsername(), ftpProperties.getPassword());
            log.info("连接ftp服务返回码：" + ftpClient.getReplyCode());
            ftpClient.setBufferSize(ftpProperties.getBufferSize());
            ftpClient.setControlEncoding(ftpProperties.getEncoding());
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            return new DefaultPooledObject<>(ftpClient);
        } catch (Exception e) {
            if (ftpClient.isAvailable()) {
                ftpClient.disconnect();
            }
            ftpClient = null;
            log.error("建立ftp连接失败！", (Object) e.getStackTrace());
            throw new Exception("建立ftp连接失败！", e);
        }

    }

    @Override
    public void destroyObject(PooledObject<FTPClient> pooledObject) throws Exception {
        FTPClient ftpClient = getObject(pooledObject);
        if (null != ftpClient && ftpClient.isConnected()) {
            ftpClient.disconnect();
        }

    }

    private FTPClient getObject(PooledObject<FTPClient> pooledObject) {
        if (null == pooledObject || null == pooledObject.getObject()) {
            return null;
        }
        return pooledObject.getObject();
    }


    @Override
    public boolean validateObject(PooledObject<FTPClient> pooledObject) {
        FTPClient ftpClient = getObject(pooledObject);
        if (null == ftpClient || !ftpClient.isConnected()) {
            return false;
        }
        try {
            ftpClient.changeWorkingDirectory("/");
            return true;
        } catch (IOException e) {
            log.error("验证ftp连接失败！", (Object) e.getStackTrace());
            return false;
        }

    }

    @Override
    public void activateObject(PooledObject<FTPClient> pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject<FTPClient> pooledObject) throws Exception {

    }
}
