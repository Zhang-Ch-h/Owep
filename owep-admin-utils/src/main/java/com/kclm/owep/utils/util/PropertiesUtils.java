package com.kclm.owep.utils.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;


/**
 * @ClassName: PropertiesUtils
 * @Description: 获取Properties属性工具类
 * @author: huangfei
 * @date: 2017年3月31日 下午4:02:41
 */
public class PropertiesUtils {
	private static final String MENU_RESOURCE = "menu.properties";
	/**  
     * 读取配置文件  
     *   
     * @return  
     */  
    public static Properties getProperties(String file) {  
        Properties pro = null;  
        // 从文件mdxbu.properties中读取网元ID和模块ID信息  
        InputStream in = null;  
        try {  
            in = PropertiesUtils.class.getClassLoader().getResourceAsStream(file);  
            BufferedReader bf = new BufferedReader(new InputStreamReader(in)); 
            pro = new Properties();  
            pro.load(bf);  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return pro;  
    }

    public static String getPropertiesValueByKey(String key){
        Properties properties = getProperties(MENU_RESOURCE);
        String value = (String)properties.get(key);
        return value == null?"":value;
    }

   

   
	public static void main(String[] args) {
		String test = getPropertiesValueByKey("/group/toGroup");
		System.out.println("test="+test);

	}

	private static final String DEFAULT_ENCODING = "UTF-8";

	private static PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();

	private static ResourceLoader resourceLoader = new DefaultResourceLoader();

	private static Properties sendserviceProperties;

	/**
	 * 载入多个properties文件, 相同的属性在最后载入的文件中的值将会覆盖之前的载入. 文件路径使用Spring Resource格式,
	 * 文件编码使用UTF-8.
	 * 
	 * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
	 */
	public static Properties loadProperties(String... resourcesPaths) throws IOException {
		Properties props = new Properties();

		for (String location : resourcesPaths) {
			InputStream is = null;
			try {
				Resource resource = resourceLoader.getResource(location);
				is = resource.getInputStream();
				propertiesPersister.load(props, new InputStreamReader(is, DEFAULT_ENCODING));
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (is != null) {
					is.close();
				}
			}
		}
		return props;
	}

	public static Properties load(String path) {
		Properties p = new Properties();
		try {
			InputStream in = ClassLoader.getSystemResourceAsStream(path);
			p.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * @Title: getSystemValue
	 * @Description: 获取属性值
	 * @param key
	 * @return
	 * @date: 2017年3月31日 下午4:19:24
	 * @return: String
	 */
	public static String getSystemValue(String key,String proeprtieName) {
		Properties sendserviceProperties = null;
		try {
			if (sendserviceProperties == null) {
				sendserviceProperties = PropertiesUtils.loadProperties(proeprtieName);
			}
			return new String((sendserviceProperties.getProperty(key))).trim();
		} catch (Exception e) {
		}
		return "";
	}

	
}
