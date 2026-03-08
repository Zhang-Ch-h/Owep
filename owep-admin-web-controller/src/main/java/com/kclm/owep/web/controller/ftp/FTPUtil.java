package com.kclm.owep.web.controller.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: FTPUtil
 * @Description: ftp文件上传工具
 * @author: ZJ
 * @date: 2017年4月18日 上午11:43:01
 */
public class FTPUtil {  
	public static final Logger LOG = LoggerFactory.getLogger(FTPUtil.class);
    /**  
     * Description: 向FTP服务器上传文件  
     * @param host FTP服务器hostname  
     * @param port FTP服务器端口  
     * @param username FTP登录账号  
     * @param password FTP登录密码  
     * @param basePath FTP服务器基础目录 
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath 
     * @param filename 上传到FTP服务器上的文件名  
     * @param input 输入流  
     * @return 成功返回true，否则返回false  
     */    
    public static boolean uploadFile(String host, int port, String username, String password, String basePath,  
            String filePath, String filename, InputStream input) {  
    	LOG.info("FTPUtil: Execute Method uploadFile =====================username==="+username+"password="+password);
        boolean result = false;  
        FTPClient ftp = new FTPClient();  
        try {  
            int reply;
            ftp.connect(host, port);// 连接FTP服务器  
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器  
            ftp.login(username, password);// 登录  
            reply = ftp.getReplyCode();  
            LOG.info("FTPUtil: Execute Method uploadFile =====================reply==="+reply);
            if (!FTPReply.isPositiveCompletion(reply)) {  
                ftp.disconnect();  
                return result;  
            }
           String remotePath=basePath+filePath;
           LOG.info("FTPUtil: Execute Method uploadFile =====================enter remotePath===remotePath="+remotePath);
           boolean changeDire=ftp.changeWorkingDirectory(remotePath);
           LOG.info("FTPUtil: Execute Method uploadFile =====================enter changeDire===changeDire="+changeDire);
            //切换到上传目录  
            if (!changeDire) {
                //如果目录不存在创建目录
                String[] dirs = (basePath+filePath).split("/");
                String tempPath = "";
                for (String dir : dirs) {  
                    if (null == dir || "".equals(dir)) continue;
                    tempPath += "/" + dir;  
                    if (!ftp.changeWorkingDirectory(tempPath)) {  
                        if (!ftp.makeDirectory(tempPath)) {  
                            return result;
                        } else {  
                            ftp.changeWorkingDirectory(tempPath);  
                        }  
                    }  
                }  
            }  
            //设置上传文件的类型为二进制类型  
            ftp.setFileType(FTP.BINARY_FILE_TYPE); 
//            ftp.enterLocalActiveMode();//主动方式
            ftp.enterLocalPassiveMode();// PORT方式PASV方式(主动式和被动式),centos使用的是PASV方式
            LOG.info("FTPUtil: Execute Method uploadFile =====================enterLocalPassiveMode===");
            //上传文件  
            try {
            	 if (!ftp.storeFile(filename, input)) { 
                 	LOG.info("FTPUtil: Execute Method uploadFile =====================enter storeFile===result="+result);
                     return result;  
                 }  
			} catch (Exception e) {
				LOG.info("FTPUtil: Execute Method uploadFile =====================enter e.getMessage===result="+e.getMessage());
			}
           
            input.close();  
            ftp.logout();  
            result = true;  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (ftp.isConnected()) {  
                try {  
                    ftp.disconnect();  
                } catch (IOException ioe) {  
                }  
            }  
        }  
        return result;  
    }  
      
    /**  
     * Description: 从FTP服务器下载文件  
     * @param host FTP服务器hostname  
     * @param port FTP服务器端口  
     * @param username FTP登录账号  
     * @param password FTP登录密码  
     * @param remotePath FTP服务器上的相对路径  
     * @param fileName 要下载的文件名  
     * @param localPath 下载后保存到本地的路径  
     * @return  
     */
    public static void downloadFile(String host, int port, String username, String password, String remotePath,
                                    String fileName, HttpServletResponse response) {
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect(host, port);
            LOG.info("Connected to FTP server: {}:{}", host, port);

            boolean login = ftp.login(username, password);
            if (!login) {
                LOG.error("FTP login failed for user: {}", username);
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "FTP login failed");
                return;
            }
            LOG.info("Logged in to FTP server with user: {}", username);

            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            LOG.info("Set FTP client to binary file type");

            boolean changeDire = ftp.changeWorkingDirectory(remotePath);
            if (!changeDire) {
                LOG.error("Failed to change directory to {}", remotePath);
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "FTP directory not found");
                return;
            }
            LOG.info("Changed directory to {}", remotePath);

            FTPFile[] fs = ftp.listFiles();
            boolean fileFound = false;
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    fileFound = true;
                    LOG.info("Starting download of file: {}", fileName);
                    try (InputStream input = ftp.retrieveFileStream(fileName)) {
                        byte[] data = IOUtils.toByteArray(input);
                        response.reset();
                        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
                        response.addHeader("Content-Length", "" + data.length);
                        response.setContentType("application/octet-stream");
                        IOUtils.write(data, response.getOutputStream());
                        response.getOutputStream().flush();
                        LOG.info("File downloaded successfully: {}", fileName);
                    } finally {
                        if (!ftp.completePendingCommand()) {
                            LOG.error("FTP complete pending command failed");
                        }
                    }
                    break;
                }
            }
            if (!fileFound) {
                LOG.error("File not found: {}", fileName);
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found on FTP server");
            }
        } catch (IOException e) {
            LOG.error("IOException during FTP operation", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                    LOG.info("Disconnected from FTP server");
                } catch (IOException ioe) {
                    LOG.error("Error disconnecting from FTP server", ioe);
                }
            }
        }
    }

    /*public static void downloadFile(String host, int port, String username, String password, String remotePath,
            String fileName,HttpServletResponse response) { 
        FTPClient ftp = new FTPClient();  
        try {  
            int reply;  
            ftp.connect(host, port);  
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器  
            ftp.login(username, password);// 登录  
            reply = ftp.getReplyCode();  
            if (!FTPReply.isPositiveCompletion(reply)) {  
                ftp.disconnect();
            }  
            boolean changeDire=ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录  
            if(changeDire){
            	FTPFile[] fs = ftp.listFiles();
                for (FTPFile ff : fs) {
                    if (ff.getName().equals(fileName)) {
                        InputStream input=ftp.retrieveFileStream(fileName);
        	 	        byte[] data = IOUtils.toByteArray(input);        	 	   
        	 	        response.reset();
        	 	        //设置响应的报头信息(中文问题解决办法)
        	 	        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));  
        	 	        response.addHeader("Content-Length", "" + data.length);  
        	 	        response.setContentType("application/vnd.ms-excel; charset=UTF-8");         	 	        
        	 	        IOUtils.write(data, response.getOutputStream());
                    }
                }
            }
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (ftp.isConnected()) {  
                try {  
                    ftp.disconnect();  
                } catch (IOException ioe) {  
                }  
            }  
        }
    }*/
    
    /**
     * 
     * @Title: deleteFile
     * @Description: 从服务器上删除文件
     * @author ZJ
     * @param host
     * @param port
     * @param username
     * @param password
     * @param basePath
     * @param filePath
     * @param filename
     * @param input
     * @return boolean
     * @date: 2017年4月18日 下午4:53:47
     */
    public static boolean deleteFile(String host, int port, String username, String password,  
            String filePath, String filename) {  
        boolean result = false;  
        FTPClient ftp = new FTPClient();  
        try {  
            int reply;  
            ftp.connect(host, port);// 连接FTP服务器  
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器  
            ftp.login(username, password);// 登录  
            reply = ftp.getReplyCode();  
            if (!FTPReply.isPositiveCompletion(reply)) {  
                ftp.disconnect();  
                return result;
            }
           
            //切换到文件目录若不存在则返回false
            if (!ftp.changeWorkingDirectory(filePath)) {
                return false;
            }
            //删除文件
            ftp.deleteFile(filename);
           
            ftp.logout();  
            result = true;  
        } catch (IOException e) {
            e.printStackTrace();  
        } finally {  
            if (ftp.isConnected()) {  
                try {  
                    ftp.disconnect();  
                } catch (IOException ioe) {  
                }  
            }  
        }  
        return result;  
    }  

    //支持批量删除
    public static boolean deleteFilesInDifferentDirectories(String host, int port, String username, String password, Map<String, String> fileMap) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect(host, port);
            ftp.login(username, password);

            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                ftp.disconnect();
                return false;
            }

            for (Map.Entry<String, String> entry : fileMap.entrySet()) {
                String directoryPath = entry.getValue();
                String filename = entry.getKey();

                if (ftp.changeWorkingDirectory(directoryPath)) {
                    ftp.deleteFile(filename);
                }
            }

            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    // Handle disconnection error
                }
            }
        }
        return result;
    }

    /**  
     * Description: 从FTP服务器复制文件  
     * @param host FTP服务器hostname  
     * @param port FTP服务器端口  
     * @param username FTP登录账号  
     * @param password FTP登录密码  
     * @param remotePath FTP服务器上的相对路径  
     * @param fileName 要下载的文件名  
     * @return  
     */  
    public static InputStream copeFile(String host, int port, String username, String password, String remotePath, String fileName) { 
        FTPClient ftp = new FTPClient();  
        try {  
            int reply;  
            ftp.connect(host, port);  
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器  
            ftp.login(username, password);// 登录  
            reply = ftp.getReplyCode();  
            if (!FTPReply.isPositiveCompletion(reply)) {  
                ftp.disconnect();
            }

            ftp.enterLocalPassiveMode();// PORT方式PASV方式(主动式和被动式),centos使用的是PASV方式
            boolean changeDire=ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录  
            if(changeDire){
            	FTPFile[] fs = ftp.listFiles();
                for (FTPFile ff : fs) {
                    if (ff.getName().equals(fileName)) {
                        InputStream input=ftp.retrieveFileStream(fileName);
                        return input;
                    }
                }
            }
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (ftp.isConnected()) {  
                try {  
                    ftp.disconnect();  
                } catch (IOException ioe) {  
                }  
            }  
        }
		return null;
    }
    
//    public static void main(String[] args) {
//    	String host = "127.0.0.1";
//    	int port = 21;
//    	String username = "admin";
//    	String password = "admin";
//    	String basePath = "test/";
//    	String filePath = "text/";
//    	String filename = "XMq我.mp4";
//    	File file = new File("D:\\java学习视频\\第1阶段\\JavaSE核心技术\\001Java环境相关的知识\\JavaSE-day01-1-86分钟-软件的前因后果.mp4");
//    	InputStream input = null;
//		try {
//			input = new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//		}
//    	uploadFile(host, port, username, password, basePath, filePath, filename, input);
//	}

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 21;
        String username = "admin";
        String password = "admin";
        String filePath = "video/";
        String filename = "12.mp4";


        deleteFile(host, port, username, password,filePath,filename);
    }


}  
