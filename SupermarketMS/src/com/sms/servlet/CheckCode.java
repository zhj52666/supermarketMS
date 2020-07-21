package com.sms.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckCode
 */
@WebServlet("/checkCode")
public class CheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCode() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub		
		int width=80;
		int height=30;
		int len=4;
		Random r = new Random();
		//0.创建空白图片
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//1.获取图片的画笔
		Graphics g = image.getGraphics();
		//2.设置画笔的颜色
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		//3.绘制矩形背景
		g.fillRect(0, 0, width, height);
		//4.调用自定的方法,获取长度为len的字母和数组的字符串
		String number=this.getNumber(len);
		//5.把随机生成的验证码存储到session中
		HttpSession session=req.getSession();
		session.setAttribute("code",number);
		//6.重新设置画笔,准备画验证码
		g.setColor(new Color(0,0,0));
		g.setFont(new Font(null,Font.BOLD,24));
		//7.绘制验证码
		g.drawString(number, 10, 25);
		//8.绘制8条干扰线
		for(int i=0;i<8;i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}
		//9.设置响应内容类型
		resp.setContentType("image/jpeg");
		OutputStream os=resp.getOutputStream();
		//10.把image图片写出到响应中(写到网络输出流上)
		ImageIO.write(image, "jpeg", os);
		os.flush();
		os.close();
    }
    
    private String getNumber(int  size){
    	String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghigklmnopqrstuvwxyz";
    	String number="";
    	Random r=new Random();
    	for(int i=0;i<size;i++){
    		number+=str.charAt(r.nextInt(str.length()));
    	}
    	return number;
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }

}
