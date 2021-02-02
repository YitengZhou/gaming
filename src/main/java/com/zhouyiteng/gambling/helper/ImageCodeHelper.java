package com.zhouyiteng.gambling.helper;

import io.netty.util.internal.StringUtil;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 图形验证码工具类
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/1.
 */
public class ImageCodeHelper {

    /**
     * 获取随机颜色
     * @param random
     * @return
     */
    private static Color getRandomColor(Random random){
        int red = random.nextInt(200);
        int green = random.nextInt(200);
        int blue = random.nextInt(200);
        return new Color(red, green, blue);
    }

    /**
     * 生成图片验证码
     * @param width
     * @param height
     * @param code
     * @param disturbCount
     * @return
     */
    public static BufferedImage getImageCode(int width, int height, String code, int disturbCount) {
        if(width<=0 || height<=0 || StringUtil.isNullOrEmpty(code)){
            return null;
        }else{
            int fontHeight = (int) (height * 0.95);
            Font font = new Font("Serif",Font.PLAIN, fontHeight);
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = image.createGraphics();
            try {
                graphics.setColor(Color.WHITE);
                graphics.fillRect(0, 0, width, height);
                Random random = new Random();
                char[] codeArray = code.toCharArray();
                int codeWidth = (int) (width * 0.95) / codeArray.length;
                int offsetWidth = (int) (width * 0.05);
                int offsetHeight = (height - fontHeight) * 2;
                for (int i = 0; i < codeArray.length; i++) {
                    graphics.setFont(font);
                    graphics.setColor(getRandomColor(random));
                    graphics.drawString(String.valueOf(codeArray[i]), i * codeWidth + offsetWidth, fontHeight - random.nextInt(offsetHeight));
                }
                for (int i = 0; i < disturbCount; i++) {
                    int xStart = random.nextInt(width);
                    int yStart = random.nextInt(height);
                    int xEnd = random.nextInt(width);
                    int yEnd = random.nextInt(height);
                    graphics.setColor(getRandomColor(random));
                    graphics.drawLine(xStart, yStart, xStart + xEnd, yStart + yEnd);
                }
            }finally {
                if(null != graphics){
                    graphics.dispose();
                }
            }
            return image;
        }
    }

}