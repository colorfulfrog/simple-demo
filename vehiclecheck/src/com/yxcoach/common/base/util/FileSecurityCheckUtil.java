/**
 * 
 */
package com.yxcoach.common.base.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 文件安全校验
 * @ClassName: FileSecurityCheck
 * @Description: TODO
 * @author nizhi
 * @date 2017年7月4日 上午10:26:47
 */
public class FileSecurityCheckUtil {
	/**
	 * 1)、判断文件的扩展名是否是要求的图片扩展名
	 * 这种判断是用得比较多的一种方式，不过这种方式非常的不妥，别人稍微的把一个不是图片的文件的扩展名修改为图片的扩展名，就绕开了你的这种校验，
	 * 如果这上传的文件是shell、php或者jsp，那你的网站基本上可以说就在别人的手里面了。
	 * 不过这种判断方式也不是完全没有用，我们可以把它放在判断图片的最外层，如果一个文件连扩展名都不是我们所要求的图片扩展名，
	 * 那就根本不用后面的内容格式检查了，从一定程度上说，对减少服务器的压力还是有一定的帮助，否则所有的文件都等上传完后成后再通过服务器去判断，那会在一定程度上浪费器资源的。
	 * 
	 * 2）、根据文件的前面几个字节，即常说的魔术数字进行判断，不同文件类型的开头几个字节，可以查看我的另外一篇专站介绍：表示不同文件类型的魔术数字。
	 * 但是这种判断方式也是非常不靠谱的，因为他只能够验证文件的前面几个字节，如此时有人把一个可执行的PHP文件的扩展名修改为PNG,然后再在前面补上”89 50″两个字节，
	 * 就又绕开了这种验证方式。
	 * @param src
	 * @return
	 */
	public static String bytesToHexString(byte[] src) {  
        StringBuilder stringBuilder = new StringBuilder();  
        if (src == null || src.length <= 0) {  
            return null;  
        }  
        for (int i = 0; i < src.length; i++) {  
            int v = src[i] & 0xFF;  
            String hv = Integer.toHexString(v);  
            if (hv.length() < 2) {  
                stringBuilder.append(0);  
            }  
            stringBuilder.append(hv);  
        }  
        return stringBuilder.toString();  
    }
	/** 
	 * 通过读取文件并获取其width及height的方式，来判断判断当前文件是否图片，这是一种非常简单的方式。 
	 *  
	 * @param imageFile 
	 * @return 
	 */  
	public static boolean isImage(File imageFile) {  
	    if (!imageFile.exists()) {  
	        return false;  
	    }  
	    Image img = null;  
	    try {  
	        img = ImageIO.read(imageFile);  
	        if (img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0) {  
	            return false;  
	        }  
	        return true;  
	    } catch (Exception e) {  
	        return false;  
	    } finally {  
	        img = null;  
	    }  
	}
	
	/**
     * 添加图片水印 
     * 
     * @param srcImg 目标图片路径，如：C:\\kutuku.jpg 
     * @param waterImg 水印图片路径，如：C:\\kutuku.png 
     * @param x 水印图片距离目标图片左侧的偏移量，如果x<0, 则在正中间 
     * @param y 水印图片距离目标图片上侧的偏移量，如果y<0, 则在正中间 
     * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明) 
     * @throws IOException 
     */
    public final static void addWaterMark(String srcImg, String waterImg, int x, int y, float alpha) throws IOException {  
        // 加载目标图片  
        File file = new File(srcImg);  
        String ext = srcImg.substring(srcImg.lastIndexOf(".") + 1);  
        Image image = ImageIO.read(file);  
        int width = image.getWidth(null);  
        int height = image.getHeight(null);  
   
        // 将目标图片加载到内存。  
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        Graphics2D g = bufferedImage.createGraphics();  
        g.drawImage(image, 0, 0, width, height, null);  
   
        // 加载水印图片。 
        Image waterImage = ImageIO.read(new File(waterImg));
        int width_1 = waterImage.getWidth(null);
        int height_1 = waterImage.getHeight(null);
        // 设置水印图片的透明度。  
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));  
   
        // 设置水印图片的位置。  
        int widthDiff = width - width_1;  
        int heightDiff = height - height_1;  
        if (x < 0) {  
            x = widthDiff / 2;  
        } else if (x > widthDiff) {  
            x = widthDiff;  
        }  
        if (y < 0) {  
            y = heightDiff / 2;  
        } else if (y > heightDiff) {  
            y = heightDiff;  
        }  
   
        // 将水印图片“画”在原有的图片的制定位置。  
        g.drawImage(waterImage, x, y, width_1, height_1, null);  
        // 关闭画笔。  
        g.dispose();  
   
        // 保存目标图片。  
        ImageIO.write(bufferedImage, ext, file);  
    }  
    
    public static void main(String[] args) throws IOException {  
        String imagePath = "c:/test.bmp";  
        File image = new File(imagePath); 
        InputStream is = new FileInputStream(image);
        byte[] bt = new byte[2];
        is.read(bt);
        System.out.println(checkFileType(bytesToHexString(bt)));
        
//        
//        String imagePath = "c:/txt.bmp";  
//        File image = new File(imagePath); 
//        System.out.println(isImage(image));
        
        
        
        
    } 
    
    /**
     * 文件类型验证
     * @param oxStr
     * @return
     */
    public static String checkFileType(String oxStr){
    				
//    	文件类型	扩展名	16进制数字	Ascii数字
//    			xx这里表示变量	. = 不是Ascii字符
//    	Bitmap format	.bmp	42 4d	BM
//    	FITS format	.fits	53 49 4d 50 4c 45	SIMPLE
//    	GIF format	.gif	47 49 46 38	GIF8
//    	Graphics Kernel System	.gks	47 4b 53 4d	GKSM
//    	IRIS rgb format	.rgb	01 da	..
//    	ITC (CMU WM) format	.itc	f1 00 40 bb	….
//    	JPEG File Interchange Format	.jpg	ff d8 ff e0	….
//    	NIFF (Navy TIFF)	.nif	49 49 4e 31	IIN1
//    	PM format	.pm	56 49 45 57	VIEW
//    	PNG format	.png	89 50 4e 47	.PNG
//    	Postscript format	.[e]ps	25 21	%!
//    	Sun Rasterfile	.ras	59 a6 6a 95	Y.j.
//    	Targa format	.tga	xx xx xx	…
//    	TIFF format (Motorola – big endian)	.tif	4d 4d 00 2a	MM.*
//    	TIFF format (Intel – little endian)	.tif	49 49 2a 00	II*.
//    	X11 Bitmap format	.xbm	xx xx	
//    	XCF Gimp file structure	.xcf	67 69 6d 70 20 78 63 66 20 76	gimp xcf
//    	Xfig format	.fig	23 46 49 47	#FIG
//    	XPM format	.xpm	2f 2a 20 58 50 4d 20 2a 2f	/* XPM */
    	String type="";
    	switch(oxStr) {
    	case "424d":
    		type = ".bmp";
    		
    	case "47494638":
    		type = ".gif";
    	
    	case "89504e47":
    		type = ".png";
    		
    	default:
    		
    	}
    	return type;
    }

    
    
}
