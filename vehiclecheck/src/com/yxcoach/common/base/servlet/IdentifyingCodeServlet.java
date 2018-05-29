package com.yxcoach.common.base.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.yxcoach.common.base.constant.Constants;
/**
 * 验证码处理
 *
 */
public class IdentifyingCodeServlet extends HttpServlet{
	
	private static final long serialVersionUID = -8765642283107293966L;
	private static Logger log = Logger.getLogger(IdentifyingCodeServlet.class);
	 // 验证码干扰线数  
    private int lineCount = 15;  

	private char[] dictinary = new char[]{'0','1','2','3','4','5','6','7','8','9'};
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		StringBuffer verifyCode = randomVerifyCode();
		ServletOutputStream sos=null;
		try {
			HttpSession session = req.getSession(true);
			session.setAttribute(Constants.VALIDATE_CODE, verifyCode.toString());
			BufferedImage outImg = new BufferedImage(70, 23,  BufferedImage.TYPE_INT_RGB);
			Graphics2D g = (Graphics2D) outImg.getGraphics();
			g.setColor(Color.WHITE);  
			g.fillRect(0, 0, 70, 23);    
			g.setFont(new Font("Dialog", Font.BOLD, 19));
			g.setPaintMode();
			Random random = new Random();  
			int red = 0, green = 0, blue = 0;  
			for (int i = 0; i < lineCount; i++) {  
	            int xs = random.nextInt(70);  
	            int ys = random.nextInt(23);  
	            int xe = xs+random.nextInt(70/8);  
	            int ye = ys+random.nextInt(23/8);  
	            red = random.nextInt(255);  
	            g.setColor(new Color(red, red, red));  
	            g.drawLine(xs, ys, xe, ye);  
	        }  
			for (int i = 0; i < verifyCode.length(); i++) {
				red = random.nextInt(110);
				green = random.nextInt(110);
				blue = random.nextInt(110);
				g.setColor(new Color(red, green, blue));
				if(i == 0){
					g.drawString(String.valueOf(verifyCode.charAt(i)), 5, 18);
				}else if( i == 1){
					g.drawString(String.valueOf(verifyCode.charAt(i)), 19, 18);
				}else{
					g.drawString(String.valueOf(verifyCode.charAt(i)), i*17, 18);
				}
			}
			g.dispose();
			
			sos = resp.getOutputStream();  
			ImageIO.write(outImg, "jpg", sos);  
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(sos);  
			encoder.encode(outImg);  
			sos.flush();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}finally{
			if(sos!=null){
				sos.close();
			}
		}
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		this.doPost(req, resp);
	}
	
	private StringBuffer randomVerifyCode() {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for(int i=0; i<4; i++) {
			sb.append(dictinary[random.nextInt(9)]);
		}
		return sb;
	}
}
