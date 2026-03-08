package com.kclm.owep.utils.util;

import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import org.apache.commons.io.IOUtils;

public class PDFUtil extends PdfPageEventHelper{

	private String header="";//页眉

	private int presentFontSize = 12;//文档字体大小，页脚页眉最好和文本大小一致

	private Rectangle pageSize = PageSize.A4;//文档页面大小，最好前面传入，否则默认为A4纸张，A4，A5，A6横转翻转等Rectangle对象

	private PdfTemplate total;// 模板

	private BaseFont bf = null; // 基础字体对象

	private Font fontDetail = null; // 利用基础字体生成的字体对象，一般用于生成中文文字

	private String image="";

	public PDFUtil() {
	}

	public PDFUtil(String image) {
		this.image = image;
	}

	/*
	 * 文档打开时创建模板
	 * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
	 */
	@Override
	public void onOpenDocument(PdfWriter writer, Document document) {
		total = writer.getDirectContent().createTemplate(50, 50);// 共 页 的矩形的长宽高
	}

	/*
	 * 关闭每页的时候，写入页眉，写入'第几页共'这几个字。
	 * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
	 */
	@Override
	public void onEndPage(PdfWriter writer, Document document) {

		try {
			if (bf == null) {
				bf = BaseFont.createFont("msyh.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			}
			if (fontDetail == null) {
				fontDetail = new Font(bf, presentFontSize, Font.NORMAL);// 数据体字体
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Phrase headerPhrase=new Phrase(header, fontDetail);
		// 1.写入页眉
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, headerPhrase, document.left(), document.top() + 20, 0);

		// 2.写入前半部分的 第 X页/共
		int pageS = writer.getPageNumber();
		String foot1 = "第 " + pageS + " 页 /共";
		Phrase footer = new Phrase(foot1, fontDetail);

		// 3.计算前半部分的foot1的长度，后面好定位最后一部分的'Y页'这俩字的x轴坐标，字体长度也要计算进去 = len
		float len = bf.getWidthPoint(foot1, presentFontSize);

		// 4.拿到当前的PdfContentByte
		PdfContentByte cb = writer.getDirectContent();

		// 5.写入页脚1，x轴就是(右margin+左margin + right() -left()- len)/2.0F 再给偏移20F适合人类视觉感受，否则肉眼看上去就太偏左了 ,y轴就是底边界-20,否则就贴边重叠到数据体里了就不是页脚了；注意Y轴是从下往上累加的，最上方的Top值是大于Bottom好几百开外的。
		ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footer, (document.rightMargin() + document.right() + document.leftMargin() - document.left() - len) / 2.0F + 20F, document.bottom() - 20, 0);

		// 6.写入页脚2的模板（就是页脚的Y页这俩字）添加到文档中，计算模板的和Y轴,X=(右边界-左边界 - 前半部分的len值)/2.0F + len ， y 轴和之前的保持一致，底边界-20
		cb.addTemplate(total, (document.rightMargin() + document.right() + document.leftMargin() - document.left()) / 2.0F + 20F, document.bottom() - 20); // 调节模版显示的位置

	}

	/*
	 * 关闭文档时，替换模板，完成整个页眉页脚组件
	 * @see com.itextpdf.text.pdf.PdfPageEventHelper#onCloseDocument(com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
	 */
	@Override
	public void onCloseDocument(PdfWriter writer, Document document) {
		// 7.最后一步了，就是关闭文档的时候，将模板替换成实际的 Y 值,至此，page x of y 制作完毕，完美兼容各种文档size。
		total.beginText();
		total.setFontAndSize(bf, presentFontSize);// 生成的模版的字体、颜色
		String foot2 = " " + (writer.getPageNumber()) + " 页";
		total.showText(foot2);// 模版显示的内容
		total.endText();
		total.closePath();
	}

//////////////////////////////////////以上是创建页眉页脚办法/////////////////////////////////////////////////////////////
	/**
	 * 创建一份笔记PDF文件
	 * @return 
	 * @throws Exception 
	 */
	public void createNormalTable(List<List<Object>> normalTableContent,HttpServletResponse response,String image,String stuName){
		this.image=image;
		String tempDir=System.getProperty("java.io.tmpdir");
	    Document document=new Document();
	    String tempFile=tempDir+"/tempPdf.pdf";
	   // String tempFile="d:/tempPdf.pdf";
	    InputStream input=null;
	    File file=null;
	    try {
	        //构建一个PDF文档输出流程  
	        OutputStream pdfFileOutputStream = new FileOutputStream(tempFile);
			PdfWriter writer=null;
			try {
				writer=PdfWriter.getInstance(document,pdfFileOutputStream);
			} catch (DocumentException e) {
				e.printStackTrace();
			}

			writer.setBoxSize("art", PageSize.A4);
			writer.setPageEvent(PDFUtil.this);//让自身监听

			//打开PDF文件流
			document.open();
			//设置中文字体和字体样式
	        //BaseFont bfChinese = BaseFont.createFont("./SIMYOU.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED); 
	        BaseFont bfChinese = BaseFont.createFont("msyh.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//微软雅黑

            //初始化一个空行,Paragraph:段落
            Paragraph blankRow = new Paragraph(" ", new Font(bfChinese,11));

            //头部图片
			Image headImg = Image.getInstance(image);
			headImg.scalePercent(10);//百分比

			//头部table
			PdfPTable headTable=new PdfPTable(3);//定义n列的表格
			headTable.setWidthPercentage(100);//宽度百分比
			headTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);//横向对齐方式
			int headTableWidth[] = {25,50,25};//列宽度的百分比
			headTable.setWidths(headTableWidth);

			PdfPCell theadTablecel1 = new PdfPCell(new Paragraph(stuName+"的学习笔记",new Font(bfChinese,14)));
			theadTablecel1.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);//横向对齐方式：0靠左、1居中、2靠右
			theadTablecel1.setVerticalAlignment(PdfPTable.ALIGN_MIDDLE);//纵向对齐方式：0靠左、1居中、2靠右
			theadTablecel1.setBorder(Rectangle.NO_BORDER);
			theadTablecel1.setBorderWidthBottom(1);//底边框宽度
			theadTablecel1.setBorderColorBottom(new BaseColor(0,0,0));//底边框颜色
			theadTablecel1.setPaddingBottom(15f);

			PdfPCell theadTablecel2 = new PdfPCell(new Paragraph(" ",new Font(bfChinese,11)));
			theadTablecel2.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);//横向对齐方式：0靠左、1居中、2靠右
			theadTablecel2.setVerticalAlignment(PdfPTable.ALIGN_CENTER);//纵向对齐方式：0靠左、1居中、2靠右
			theadTablecel2.setBorder(Rectangle.NO_BORDER);
			theadTablecel2.setBorderWidthBottom(1);//底边框宽度
			theadTablecel2.setBorderColorBottom(new BaseColor(0,0,0));//底边框颜色
			theadTablecel2.setPaddingBottom(15f);

			PdfPCell theadTablecel3 = new PdfPCell(headImg);
			theadTablecel3.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);//横向对齐方式：0靠左、1居中、2靠右
			theadTablecel3.setVerticalAlignment(PdfPTable.ALIGN_CENTER);//纵向对齐方式：0靠左、1居中、2靠右
			theadTablecel3.setBorder(Rectangle.NO_BORDER);
			theadTablecel3.setBorderWidthBottom(1);//底边框宽度
			theadTablecel3.setBorderColorBottom(new BaseColor(0,0,0));//底边框颜色
			theadTablecel3.setPaddingBottom(15f);

			headTable.addCell(theadTablecel1);
			headTable.addCell(theadTablecel2);
			headTable.addCell(theadTablecel3);

			document.add(headTable);

	        
	        for(int i=0;i<normalTableContent.size();i++){//循环笔记次数
				/*
				*	根据 SMyNoteController: downloadPDFNote方法中定义
				*	normalTableContent.get(i).get(j)
				*   username//j=0
					courseName//j=1
					noteContenttext//j=2
					videPosition//j=3
					createtime//j=4
					chapnum//j=5
					secnum//j=6
					secname//j=7
				* */
	        	//插入空行
				document.add(blankRow);
	        	 //创建一个2列的表格控件
		        PdfPTable tab1 = new PdfPTable(2);
		        tab1.setWidthPercentage(100); 
		        tab1.setHorizontalAlignment(PdfPTable.ALIGN_LEFT);
				PdfPCell tab1cel1=null;
				if(i!=0 && normalTableContent.get(i).get(1).equals(normalTableContent.get(i-1).get(1))){
					tab1cel1 = new PdfPCell(
							new Paragraph("    第"+normalTableContent.get(i).get(5)+
											"章第"+normalTableContent.get(i).get(6)+
											"节    "+normalTableContent.get(i).get(7),
									new Font(bfChinese,11)));//课程章节名

				}else{
					tab1cel1 = new PdfPCell(
							new Paragraph(
									normalTableContent.get(i).get(1)+
											"\n\n"+
											"    第"+normalTableContent.get(i).get(5)+
											"章第"+normalTableContent.get(i).get(6)+
											"节    "+normalTableContent.get(i).get(7),
									new Font(bfChinese,11)));//课程章节名
				}

	            tab1cel1.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//上下居中
	            tab1cel1.setHorizontalAlignment(PdfPTable.ALIGN_LEFT);//左对齐
	            tab1cel1.setBorder(Rectangle.NO_BORDER);//无边框
				tab1cel1.setPaddingBottom(8f);

				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				Date createTime=sdf.parse(normalTableContent.get(i).get(4)+"");
				PdfPCell tab1cel2 = new PdfPCell(new Paragraph(sdf.format(createTime)+"",new Font(bfChinese,10,Font.ITALIC,new BaseColor(128,128,128))));//时间
				tab1cel2.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//上下居中
				tab1cel2.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT);//右对齐
				tab1cel2.setBorder(Rectangle.NO_BORDER);//无边框
				tab1cel2.setPaddingBottom(8f);

				Paragraph tab1cel3paragraph=new Paragraph();
				Chunk chunk = new Chunk(normalTableContent.get(i).get(2)+"", new Font(bfChinese,11,Font.NORMAL,new BaseColor(102,102,102)));//笔记内容
				tab1cel3paragraph.add(chunk);
	            PdfPCell tab1cel3 = new PdfPCell(tab1cel3paragraph);//笔记内容
	            tab1cel3.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//上下居中
	            tab1cel3.setHorizontalAlignment(PdfPTable.ALIGN_LEFT);//左对齐
	            tab1cel3.setBorder(Rectangle.NO_BORDER);//无边框
				tab1cel3.setColspan(2);
				tab1cel3.setLeading(14,1);//设置：行距,倍数
				tab1cel3.setIndent(25);//首航缩进

		        tab1.addCell(tab1cel1);
		        tab1.addCell(tab1cel2);
				tab1.addCell(tab1cel3);
				document.add(tab1);
		        //插入空行
				document.add(blankRow);
	        }
	    }catch(FileNotFoundException de) {  
	        de.printStackTrace();  
	        System.err.println("pdf file: " + de.getMessage());
	    }catch(DocumentException de) {  
	        de.printStackTrace();  
	        System.err.println("document: " + de.getMessage());
	    }catch(IOException de) {  
	        de.printStackTrace();  
	        System.err.println("pdf font: " + de.getMessage());
	    }catch (ParseException e) {
			e.printStackTrace();
		}finally{
	    	//关闭PDF文档流，OutputStream文件输出流也将在PDF文档流关闭方法内部关闭  
	        if(document!=null && document.isOpen()){
				document.close();
	        }
	        file=new File(tempFile);
	        if(file.exists()){
				byte[] data;
				try {
					input = new FileInputStream(file);
					data = IOUtils.toByteArray(input);
					response.reset();
					//设置响应的报头信息(中文问题解决办法)
					response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(new Date().getTime()+".pdf", "UTF-8"));
					response.addHeader("Content-Length", "" + data.length);
					response.setContentType("application/vnd.ms-excel; charset=UTF-8");
					IOUtils.write(data, response.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(input!=null){
						IOUtils.closeQuietly(input);
					}
					if(file!=null && file.exists()){
						file.delete();
					}
				}
			}
	    }          
	}
}
