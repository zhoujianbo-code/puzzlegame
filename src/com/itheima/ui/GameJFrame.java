package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameJFrame extends JFrame{
    //JFrame 界面 窗体
    //规定:GameJFrame类是游戏的主界面
    //以后跟游戏相关的逻辑都写在这

    //创建一个二维数组,用于存放图片数据
    int[][] data = new int[4][4];

    public GameJFrame(){
        

        //初始化界面
        this.initJFrame();

        //初始化菜单
        this.initJMenuBar();

        //打乱图片数据
        this.initData();

        //初始化图片
        this.initImage();



        //设置界面可见
        this.setVisible(true);
    }


    private void initData(){
        //打乱图片数据
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random random = new Random();

        for(int i = 0;i < tempArr.length;i++){
            int index = random.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        
        for(int i = 0;i < tempArr.length;i++){
            data[i/4][i%4] = tempArr[i];
        }
    }
    

    //初始化图片
    private void initImage(){
         
        for(int i = 0;i < 4;i++){
            for(int j = 0;j < 4;j++){
                
                //创建一个图片ImageIcon对象

                //创建一个jLabel的对象(管理容器)
                JLabel jLabel = new JLabel(new ImageIcon("image/animal/animal1/"+data[i][j]+".jpg"));

                //指定图片位置
                jLabel.setBounds(j*105+83,i*105+134,105,105);

                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

               //把管理容器添加到界面中
               // this.add(jLabel);
               this.getContentPane().add(jLabel);
            }
 
        }

        //添加背景图片
        JLabel jLabel = new JLabel(new ImageIcon("image/background.png"));
        jLabel.setBounds(40,40,508,560);
        //把背景图片添加到界面中
        this.getContentPane().add(jLabel);


    }


    private void initJMenuBar(){
        //初始化菜单
        //创建整个的菜单对象
        JMenuBar JMenuBar = new JMenuBar();

        //创建菜单选项的对象
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");


        //创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");



        //将每个选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);


        //将菜单里面的两个选项添加到菜单当中
        JMenuBar.add(functionJMenu);
        JMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(JMenuBar);
    }

    private void initJFrame(){
        //设置界面的宽高
        this.setSize(600,680);

        //设置界面标题
        this.setTitle("拼图游戏 v1.0");

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);

        //设置游戏关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //取消默认的居中放置,只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);

        //给整个界面添加键盘监听事件
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                System.out.println("键盘按下");
            }
        });


    }

    


}
