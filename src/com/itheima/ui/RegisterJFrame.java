package com.itheima.ui;

import javax.swing.JFrame;

public class RegisterJFrame extends JFrame{
    //JFrame 界面 窗体
    //规定:RegisterJFrame类是注册界面
    //以后跟注册相关的逻辑都写在这
    
    public RegisterJFrame(){
        this.setSize(488,500);

        this.setTitle("拼图注册 v1.0");

        this.setAlwaysOnTop(true);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
