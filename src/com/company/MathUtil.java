package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MathUtil {
    private static JFrame frame;
    private static String[] strings1 = {"1", "2", "3", "4", "5", "6", "7", "8", "8", "0"};
    private static String[] strings2 = {
            "q", "w", "e", "r", "t", "y", "u", "i", "o", "p",
            "a", "s", "d", "f", "g", "h", "j", "k", "l",
            "z", "x", "c", "v", "b", "n", "m", ",", "w", "q", "w",};

    private static String[] strings3 = {"!", "@", "#", "$", "%", "^", "&", "*"};
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

//        JTextField base = new JTextField(20);
//        base.setBounds(170, 50, 300, 25);
//        base.setText("1纯数字，2纯英文，3中英混合，4带特殊字符");
//        panel.add(base);

        List<String> listRule1 = new ArrayList<>();
        listRule1.add("数字");
        listRule1.add("不需要");
        JComboBox jcbCity = new JComboBox(listRule1.toArray());
        jcbCity.setBounds(170, 50, 70, 25);
        panel.add(jcbCity);

        List<String> listRule2 = new ArrayList<>();
        listRule2.add("英文");
        listRule2.add("不需要");
        JComboBox jcbCity2 = new JComboBox(listRule2.toArray());
        jcbCity2.setBounds(250, 50, 70, 25);
        panel.add(jcbCity2);

        List<String> listRule3 = new ArrayList<>();
        listRule3.add("特殊字符");
        listRule3.add("不需要");
        JComboBox jcbCity3 = new JComboBox(listRule3.toArray());
        jcbCity3.setBounds(330, 50, 70, 25);
        panel.add(jcbCity3);
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
            textbook.append("密码长度：" + path.getText() + "\r\n");

            int lent = 16;

            //取得当前选中du的City 的名字
            String rule1 = jcbCity.getSelectedItem().toString();
            String rule2 = jcbCity2.getSelectedItem().toString();
            String rule3 = jcbCity3.getSelectedItem().toString();
            try {
                lent = Integer.valueOf(path.getText());
            } catch (NumberFormatException e) {
                textbook.append(path.getText() + "是个啥？？？ " + "\r\n" + path.getText() + "是个啥？？？ " + "\r\n");

            }

            List<String> list = new ArrayList<>();
            String paw = "";
            if (rule1 == "数字") {
                List arrList = Arrays.asList(strings1);
                list.addAll(arrList);
            }
            if (rule2 == "英文") {
                List<String> list2 = Arrays.asList(strings2);
                List arrList = new ArrayList(list2);
                list.addAll(arrList);
            }
            if (rule3 == "特殊字符") {
                List<String> list3 = Arrays.asList(strings3);
                List arrList = new ArrayList(list3);
                list.addAll(arrList);
            }
            if (list.size() == 0) {
                list = Arrays.asList(strings4);
            }
            paw = getLengthArr(lent, list.toArray(new String[list.size()]));
            System.gc();
            textbook.append("已运行完成，密码是：\r\n" + paw + "\r\n");

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
