package io.github.xxyopen.novel.core.common.util;

import lombok.experimental.UtilityClass;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

@UtilityClass
public class ImgVerifyCodeUtils {

    private final String randNumber = "0123456789";

    private final int width = 100;

    private final int heigth = 38;

    private final Random random = new Random();

    private Font getFont() {
        return new Font("Fixed", Font.PLAIN, 23);
    }

    public String genVerifyCodeImg(String verifyCode) throws IOException {
        BufferedImage image = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.fillRect(0, 0, width, heigth);
        g.setColor(new Color(204, 204, 104));
        int lineSize = 40;
        for (int i = 0; i < lineSize; i++) {
            drawLine(g);
        }
        drawString(g, verifyCode);
        g.dispose();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(image, "JPEG", stream);
        //System.out.println(stream.toString());
        return Base64.getEncoder().encodeToString(stream.toByteArray());
    }

    private void drawString(Graphics g, String verifyCode) {
        for (int i = 1; i <= verifyCode.length(); i++) {
            g.setFont(getFont());
            g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
            g.translate(random.nextInt(3), random.nextInt(3));
            g.drawString(String.valueOf(verifyCode.charAt(i -1)), 13 * i, 23);
        }
    }

    private void drawLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(heigth);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

    public String getRandomVerifyCode(int num) {
        int randNumberSize = randNumber.length();
        StringBuilder verifyCode = new StringBuilder();
        for (int i = 0; i < num; i++) {
            String rand = String.valueOf(randNumber.charAt(random.nextInt(randNumberSize)));
            verifyCode.append(rand);
        }
        return verifyCode.toString();
    }

    public static void main(String[] args) throws IOException {
        ImgVerifyCodeUtils imgVerifyCodeUtils = new ImgVerifyCodeUtils();
        String s = imgVerifyCodeUtils.genVerifyCodeImg("4568");
        System.out.println(s);
    }

}
