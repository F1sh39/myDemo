package com.fish.Web02.web.Servlet;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckcodeServlet")
public class CheckcodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1生成带缓冲区的图像对象
        int width = 100; int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2图像对象加工验证码内容
        //2.1生成"画笔"对象，Graphics类具有绘图功能
        Graphics gra = image.getGraphics();
        //2.2设置背景色
        gra.setColor(Color.lightGray);  //设置前景色
        gra.fillRect(0, 0, width, height);  //画一个填充的矩形，左上角点为(0,0)，及其宽高
        //2.3写验证字符
        gra.setColor(Color.BLACK);
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String checkCode = new String();
        for(int i=1; i<=4; ++i){
            Random rad = new Random();
            int radIndex = rad.nextInt(abc.length());
            char radChar = abc.charAt(radIndex);
            checkCode += radChar;
            gra.drawString(radChar+"", width/5*i, height/2);
        }
        //2.4画干扰线条
        for(int i=1; i<=10; ++i){
            Random rad = new Random();
            int x1 = rad.nextInt(width);
            int x2 = rad.nextInt(width);
            int y1 = rad.nextInt(height);
            int y2 = rad.nextInt(height);
            gra.setColor(Color.MAGENTA);
            gra.drawLine(x1, y1, x2, y2);
        }

        //3上传验证码图像对象
        ImageIO.write(image, "jpg", resp.getOutputStream());

        //4存储验证码文本以供对照
        HttpSession session = req.getSession();
        session.setAttribute("checkcode", checkCode);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
