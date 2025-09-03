package com.itheima.ui;

import javax.swing.JFrame;

public class LoginJFrame extends JFrame{
    //JFrame 界面 窗体
    //规定:LoginJFrame类是登录界面
    //以后跟登录相关的逻辑都写在这

    public LoginJFrame(){
        this.setSize(488,430);

        this.setTitle("拼图登录 v1.0");

        this.setAlwaysOnTop(true);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
    
}
