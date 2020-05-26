package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

public class Main {
    private static JFrame frame;

    public static void main(String args[]) {
        // 创建 JFrame 实例
        frame = new JFrame("Font-img");
        // Setting the width and height of frame
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);
        frame.setVisible(true);

    }

    public static void createFontImg(String path, String base, String outPath) {
        base = base == null ? "你最美" : base;
        try {
            BufferedImage image = ImageIO.read(new File(path));
            BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
            Graphics2D graphics2D = (Graphics2D) newImage.getGraphics();
            graphics2D.setFont(new Font("宋体", Font.PLAIN, 14));
            int index = 0;
            for (int y = 0; y < image.getHeight(); y += 12) {
                for (int x = 0; x < image.getWidth(); x += 12) {
                    int pxcolor = image.getRGB(x, y);
                    int r = (pxcolor & 0xff0000) >> 16,
                            g = (pxcolor & 0xff00) >> 8,
                            b = pxcolor & 0xff;
                    graphics2D.setColor(new Color(r, g, b));
                    graphics2D.drawString(String.valueOf(base.charAt(index % base.length())), x, y);
                    index++;
                }
            }
            ImageIO.write(newImage, "JPG", new FileOutputStream(outPath));
            System.out.println("已运行完成，请在" + outPath + "目录查看");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel pathJLabel = new JLabel("请输入你的图片绝对路径:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        pathJLabel.setBounds(10, 20, 150, 30);
        panel.add(pathJLabel);

        /*
         * 创建文本域用于用户输入
         */
        JTextField path = new JTextField(30);
        path.setBounds(170, 20, 300, 30);
        path.setText("E:\\poho\\IMG_20200429_132931.jpg");
        panel.add(path);

        // 输入密码的文本域
        JLabel baseJLabel = new JLabel("请输入你想转换的文字:");
        baseJLabel.setBounds(10, 50, 150, 30);
        panel.add(baseJLabel);

        JTextField base = new JTextField(20);
        base.setBounds(170, 50, 300, 25);
        base.setText("喜欢你");
        panel.add(base);


        // 输入下载图片的文本域
        JLabel outJLabel = new JLabel("请输入你图片下载路径:");
        outJLabel.setBounds(10, 80, 150, 25);
        panel.add(outJLabel);
        JTextField outPath = new JTextField(20);
        outPath.setBounds(170, 80, 300, 25);
        outPath.setText("E:\\poho\\temp.jpg");
        panel.add(outPath);
        // 创建登录按钮
        JButton gogogo = new JButton("gogogo");
        gogogo.setBounds(10, 110, 80, 25);
        panel.add(gogogo);

        // 输入日志的文本域

        JLabel textbookJLabel = new JLabel("日志~~~~~~~~~~~~~~~~~：");
        textbookJLabel.setBounds(10, 140, 80, 25);
        panel.add(textbookJLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JTextArea textbook = new JTextArea();
        textbook.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(textbook);
        textbook.setBounds(100, 50, 165, 25);
        //设置矩形大小.参数依次为(矩形左上角横坐标x,矩形左上角纵坐标y，矩形长度，矩形宽度)
        jsp.setBounds(10, 170, 350, 340);
        //默认的设置是超过文本框才会显示滚动条，以下设置让滚动条一直显示
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(jsp);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        gogogo.addActionListener(event -> {
            //点击弹框显示
            textbook.append(path.getText() + "\r\n");
            textbook.append(base.getText() + "\r\n");
            textbook.append(outPath.getText() + "\r\n");
            createFontImg(path.getText(), base.getText(), outPath.getText());
            System.gc();
            textbook.append("已运行完成，请在" + outPath.getText() + "目录查看" + "\r\n");
            try {
                Runtime.getRuntime().exec("explorer.exe /select, " + outPath.getText());
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "打开目录失败！", "错误提示", JOptionPane.ERROR_MESSAGE);

            }
            // JOptionPane.showMessageDialog(null, "完成");
        });


    }


}
