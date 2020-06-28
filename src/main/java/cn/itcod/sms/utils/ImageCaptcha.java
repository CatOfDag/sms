package cn.itcod.sms.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.UUID;

/**
 * @author ITCod
 */
public class ImageCaptcha {
    private int weight = 100;
    private int height = 40;
    private static String captcha;
    private Random r = new Random();
    private String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312","Georgia"};

    /**
     * 获取验证码文本的方法
     * @return string
     */
    public static String getCaptcha() {
        if (captcha == null || "".equals(captcha)) {
            throw new NullPointerException();
        }
        return captcha;
    }

    private void setCaptcha() {
        //使用UUID随机生成验证码
        captcha = UUID.randomUUID().toString().substring(0, 4);
    }

    /**
     * 获取随机的颜色
     *
     * @return
     */
    private Color randomColor() {
        int r = this.r.nextInt(225);
        int g = this.r.nextInt(225);
        int b = this.r.nextInt(225);
        return new Color(r, g, b);
    }

    /**
     * 获取随机字体
     * @return font
     */
    private Font randomFont() {
        int index = r.nextInt(fontNames.length);
        String fontName = fontNames[index];
        int style = r.nextInt(4);
        int size = r.nextInt(10) + 24;
        return new Font(fontName, style, size);
    }

    /**
     * 画干扰线，验证码干扰线用来防止计算机解析图片
     *
     * @param bufferedImage
     */
    private void drawLine(BufferedImage bufferedImage) {
        //定义干扰线的数量
        int num = r.nextInt(10);
        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
        for (int i = 0; i < num; i++) {
            int x1 = r.nextInt(weight);
            int y1 = r.nextInt(height);
            int x2 = r.nextInt(weight);
            int y2 = r.nextInt(height);
            g.setColor(randomColor());
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 创建图片的方法
     * @return BufferedImage
     */
    private BufferedImage createImage() {
        //创建图片缓冲区
        BufferedImage image = new BufferedImage(weight, height, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics2D g = (Graphics2D) image.getGraphics();
        //设置背景色随机
        g.setColor(new Color(255, 255, r.nextInt(245) + 10));
        g.fillRect(0, 0, weight, height);
        //返回一个图片
        return image;
    }

    /**
     * 获取验证码图片的方法
     * @return bufferedImage
     */
    private BufferedImage setCaptchaImage() {
        // 设置随机验证码
        this.setCaptcha();
        BufferedImage image = createImage();
        //获取画笔
        Graphics2D g = (Graphics2D) image.getGraphics();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < captcha.length(); i++)
        {
            String s = String.valueOf(captcha.charAt(i));
            sb.append(s);
            float x = i * 1.0F * weight / 4;
            g.setFont(randomFont());
            g.setColor(randomColor());
            g.drawString(s, x, height - 5);
        }
        captcha = sb.toString();
        drawLine(image);
        return image;
    }

    public static BufferedImage getCaptchaImage(){
        return new ImageCaptcha().setCaptchaImage();
    }

    private ImageCaptcha(){}
}
