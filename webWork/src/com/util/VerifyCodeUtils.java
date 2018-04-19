package com.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyCodeUtils {
	
	private static StringBuffer codesave = null;

	//ctrl + shift + o
    public static BufferedImage paintImage(int width, int height) {
        //核心对象，第一参数是图片的宽度，第二个参数是高度，第三个参数是颜色的模式
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //获得画笔
        Graphics graphics = img.getGraphics();
        //给画笔设置为黑色
        graphics.setColor(Color.BLACK);
        //绘制矩形
        graphics.fillRect(0, 0, width, height);
        //给画笔设置为白色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(1, 1, width-2, height-2);

        //定义字符数据
        String code = "0123456789";
        Random rd = new Random();
        codesave = new StringBuffer();
        //设置画笔的字体样式为楷体、加粗，行高
        graphics.setFont(new Font("楷体", Font.BOLD, height-4));
        for (int i = 0; i < 4; i++) {
            //设置颜色
            graphics.setColor(new Color(rd.nextInt(256), rd.nextInt(256), rd.nextInt(256)));
            //取出随机索引
            int index = rd.nextInt(code.length());
            codesave.append(code.substring(index, index+1));
            //画字符串
            graphics.drawString(code.substring(index, index+1), width/6*(i+1), height-4);
        }

        return img;
    }

    public static String getCode(){
        if (codesave==null) {
            return "";
        }
        return codesave.toString();
    }

}
