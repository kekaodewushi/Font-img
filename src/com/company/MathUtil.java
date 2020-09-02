package com.company;

import javax.swing.*;
import java.util.Random;

public class MathUtil {
    private static JFrame frame;
    private static String[] strings1 = {"1", "2", "3", "4", "5", "6", "7", "8", "8", "0"};
    private static String[] strings2 = {
            "q", "w", "e", "r", "t", "y", "u", "i", "o", "p",
            "a", "s", "d", "f", "g", "h", "j", "k", "l",
            "z", "x", "c", "v", "b", "n", "m", ",", "w", "q", "w",};
    private static String[] strings3 = {"1", "2", "3", "4", "5", "6", "7", "8", "8", "0",
            "q", "w", "e", "r", "t", "y", "u", "i", "o", "p",
            "a", "s", "d", "f", "g", "h", "j", "k", "l",
            "z", "x", "c", "v", "b", "n", "m", ",", "w", "q", "w",};
    private static String[] strings4 = {"!", "@", "#", "$", "%", "^", "&", "*",
            "1", "2", "3", "4", "5", "6", "7", "8", "8", "0",
            "q", "w", "e", "r", "t", "y", "u", "i", "o", "p",
            "a", "s", "d", "f", "g", "h", "j", "k", "l",
            "z", "x", "c", "v", "b", "n", "m", ",", "w", "q", "w",};

    public static void main(String args[]) {
        // 创建 JFrame 实例
        frame = new JFrame("Font-img");
        // Setting the width and height of frame
        frame.setSize(600, 600);
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


    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel pathJLabel = new JLabel("输入密码长度:");
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
        path.setText("16");
        panel.add(path);

        // 输入密码的文本域
        JLabel baseJLabel = new JLabel("请输入密码复杂度:");
        baseJLabel.setBounds(10, 50, 150, 30);
        panel.add(baseJLabel);

        JTextField base = new JTextField(20);
        base.setBounds(170, 50, 300, 25);
        base.setText("1纯数字，2纯英文，3中英混合，4带特殊字符");
        panel.add(base);


        // 创建登录按钮
        JButton gogogo = new JButton("gogogo");
        gogogo.setBounds(10, 110, 80, 25);
        panel.add(gogogo);

        // 输入日志的文本域

        JLabel textbookJLabel = new JLabel("结果~~~~~~~~~~~~~~~~~：");
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
            textbook.append("密码长度："+path.getText() + "\r\n");
            textbook.append("密码复杂度："+base.getText() + "\r\n");
            if (null == base.getText() || null == path.getText()) {
                textbook.append(path.getText() + "是个啥？？？ " + "\r\n" + path.getText() + "是个啥？？？ " + "\r\n");

            }
            int lent = 16;
            int flag = 4;
            try {
                flag = Integer.valueOf(base.getText());
                lent = Integer.valueOf(path.getText());
            } catch (NumberFormatException e) {
                textbook.append(path.getText() + "是个啥？？？ " + "\r\n" + path.getText() + "是个啥？？？ " + "\r\n");

            }
            String paw="";
           if(flag==1){
               paw= getLengthArr(lent, strings1);
           }else if(flag==2){
               paw=getLengthArr(lent, strings2);
           }else if(flag==3){
               paw=getLengthArr(lent, strings3);
           }else {
               paw= getLengthArr(lent, strings4);
           }

            System.gc();
            textbook.append("已运行完成，密码是：\r\n"+paw+"\r\n");

        });


    }

    private static String getLengthArr(int length, String[] strings) {
        StringBuffer s = new StringBuffer();
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            int ran1 = r.nextInt(strings.length);
            s.append(strings[ran1]);
        }
        return s.toString();

    }
}
