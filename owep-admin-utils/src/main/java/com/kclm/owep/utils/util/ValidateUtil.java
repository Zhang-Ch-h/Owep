package com.kclm.owep.utils.util;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.*;  
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;  
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;  
import java.util.Date;  
import java.util.Random;  
  
/**
 *  
 * @ClassName: ValidateUtil
 * @Description: 验证码生成工具
 * @author: ZJ
 * @date: 2017年4月6日 上午10:44:01
 */
public class ValidateUtil {  
    // 图片的宽度。  
    private static final int width = 160;  
    // 图片的高度。  
    private static final int height = 40;  
    // 验证码字符个数  
    private static final int codeCount = 5;  
    // 验证码干扰线数  
    private static final int lineCount = 150;  
    // 验证码  
    private static String code = null;  
    // 验证码图片Buffer  
    private static BufferedImage buffImg = null;  
  
    // 验证码范围,去掉0(数字)和O(拼音)容易混淆的(小写的1和L也可以去掉,大写不用了)  
    private static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',  
            'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',  
            'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};  
    
    /**
     * 
     * @Title: getCode
     * @Description: 生成验证码
     * @author ZJ
     * @return String
     * @throws IOException 
     * @date: 2017年4月6日 上午11:52:14
     */
    public static String getCode(HttpServletRequest request,HttpServletResponse response,Integer width) throws IOException {  
    	if(width==null || width==0){
    		width=ValidateUtil.width;
    	}
        int x = 0, fontHeight = 0, codeY = 0;  
        int red = 0, green = 0, blue = 0;  
  
        x = width / (codeCount + 2);//每个字符的宽度(左右各空出一个字符)  
        fontHeight = height - 2;//字体的高度  
        codeY = height - 4;  
  
        // 图像buffer  
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        Graphics2D g = buffImg.createGraphics();  
        // 生成随机数  
        Random random = new Random();  
        // 将图像填充为白色  
        g.setColor(Color.lightGray);  
        g.fillRect(0, 0, width, height);  
        // 创建字体,可以修改为其它的  
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);  
//	        Font font = new Font("Times New Roman", Font.ROMAN_BASELINE, fontHeight);  
        g.setFont(font);  
  
        for (int i = 0; i < lineCount; i++) {  
            // 设置随机开始和结束坐标  
            int xs = random.nextInt(width);//x坐标开始  
            int ys = random.nextInt(height);//y坐标开始  
            int xe = xs + random.nextInt(width / 8);//x坐标结束  
            int ye = ys + random.nextInt(height / 8);//y坐标结束  
  
            // 产生随机的颜色值，让输出的每个干扰线的颜色值都将不同。  
            red = 115;  
            green = 150;  
            blue = 174;  
            g.setColor(new Color(red, green, blue));  
            g.drawLine(xs, ys, xe, ye);  
        }  
  
        // randomCode记录随机产生的验证码  
        StringBuffer randomCode = new StringBuffer();  
        // 随机产生codeCount个字符的验证码。  
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);  
            // 产生随机的颜色值，让输出的每个字符的颜色值都将不同。  
            red = random.nextInt(100);  
            green = random.nextInt(100);  
            blue = random.nextInt(100);  
            g.setColor(new Color(red, green, blue));  
            g.drawString(strRand, (i + 1) * x, codeY);  
            // 将产生的四个随机数组合在一起。  
            randomCode.append(strRand);  
        }  
     // 将四位数字的验证码保存到Session中。     
        HttpSession session = request.getSession();     
        session.setAttribute("validateCode", randomCode.toString());  
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");     
        response.setHeader("Cache-Control", "no-cache");     
        response.setDateHeader("Expires", 0);     
     
        response.setContentType("image/jpeg");     
        // 将图像输出到Servlet输出流中。     
        ServletOutputStream sos = response.getOutputStream();     
        ImageIO.write(buffImg, "png", sos);  
        sos.close();
        return randomCode.toString();
    }  
    /**
     * 
     * @Title: write
     * @Description: io流输出图片到服务器path文件夹中
     * @author ZJ
     * @param path
     * @throws IOException void
     * @date: 2017年4月6日 上午11:51:50
     */
    public static void write(String path) throws IOException {    	
    	OutputStream sos = new FileOutputStream(path);
        ImageIO.write(buffImg, "png", sos);
        sos.close();  
    }
  
   /**
    * 
    * @Title: main
    * @Description: 测试
    * @author ZJ
    * @param args void
 * @throws IOException 
    * @date: 2017年4月6日 上午10:43:51
    */
    public static void main(String[] args) throws IOException {
    	String url=ValidateUtil.class.getClassLoader().getResource("").getPath().substring(1); 
    	int num=url.indexOf("owep-common");
    	url=url.substring(0, num);
    	url.indexOf("owep-common");
    	System.out.println(url);
//        try {  
//            String path="D:/"+new Date().getTime()+".png";
//            //String imgPath="images/validate.png";
//            System.out.println(ValidateUtil.getCode()+" >"+path);  
//            ValidateUtil.write(path);  
//        } catch (IOException e) {
//            e.printStackTrace();  
//        }    	
    }  
}

