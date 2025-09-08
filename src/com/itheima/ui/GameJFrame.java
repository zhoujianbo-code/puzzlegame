package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameJFrame extends JFrame implements KeyListener,ActionListener{
    //JFrame 界面 窗体
    //规定:GameJFrame类是游戏的主界面
    //以后跟游戏相关的逻辑都写在这

    //创建一个二维数组,用于存放图片数据
    int[][] data = new int[4][4];


    //记录空白方块在二维数组中的位置
    int x=0;
    int y=0;

    //定义一个变量,展示当前图片的路径

    String path = "image/animal/animal1/";

    //定义一个完成的正确二维数组
    int[][] win = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};

    int step = 0;

     //创建选项下面的条目对象
     JMenuItem replayItem = new JMenuItem("重新游戏");
    //  JMenuItem reLoginItem = new JMenuItem("重新登录");
     JMenuItem closeItem = new JMenuItem("关闭游戏");

     JMenuItem accountItem = new JMenuItem("公众号");

     JMenuItem girl = new JMenuItem("美女");
     JMenuItem animals = new JMenuItem("动物");
     JMenuItem sport = new JMenuItem("运动");

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

        //给二维数组添加数据
        //遍历一维驻足tepArr得到每一个元素,把每一个元素一次添加到二维数组汇中        
        for(int i = 0;i < tempArr.length;i++){
            if(tempArr[i] == 0){
                x = i/4;
                y = i%4;

            }
                
            data[i/4][i%4] = tempArr[i];
            
            
        }
    }
    

    //初始化图片
    private void initImage(){

        //清空原本已经出现的所有图片
        this.getContentPane().removeAll();

        if(isWin()){

            //如果完成,则展示胜利的图片
            JLabel win = new JLabel(new ImageIcon("image/win.png"));

            win.setBounds(203,283,197,73);

            this.getContentPane().add(win);

        }


        JLabel stepLabel = new JLabel("步数: "+step);

        stepLabel.setBounds(50,30,100,20);

        this.getContentPane().add(stepLabel);


        for(int i = 0;i < 4;i++){
            for(int j = 0;j < 4;j++){
                
                //创建一个图片ImageIcon对象

                //创建一个jLabel的对象(管理容器)
                JLabel jLabel = new JLabel(new ImageIcon(path+data[i][j]+".jpg"));

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


        //刷新界面
        this.repaint();

    }


    private void initJMenuBar(){
        //初始化菜单
        //创建整个的菜单对象
        JMenuBar JMenuBar = new JMenuBar();

        //创建菜单选项的对象
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changePictureJMenu = new JMenu("更换图片");

        //将每个选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        // functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        functionJMenu.add(changePictureJMenu);

        aboutJMenu.add(accountItem);

        //放入到更换图片中
        changePictureJMenu.add(girl);
        changePictureJMenu.add(animals);
        changePictureJMenu.add(sport);

        //给条目绑定事件
        replayItem.addActionListener(this);
        // reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        
        girl.addActionListener(this);
        animals.addActionListener(this);
        sport.addActionListener(this);

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
        this.addKeyListener(this);


    }

    //重写键盘输入事件
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    //重写键盘按下事件
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == 65){

            //把界面中所有的图片删除
            this.getContentPane().removeAll();

            //加载第一张完整的图片

            //加载第一张完整的图片
            JLabel all = new JLabel(new ImageIcon(path+"all.jpg"));

            all.setBounds(83,134,420,420);

            this.getContentPane().add(all);

            //加载背景图片
            JLabel background = new JLabel(new ImageIcon("image/background.png"));

            background.setBounds(40,40,508,560);

            //把背景图片添加到界面中
            this.getContentPane().add(background);

            //刷新界面
            this.repaint();
        }
    }

    //重写键盘释放事件
    @Override
    public void keyReleased(KeyEvent e) {


        //判断游戏是否已经胜利
        if(isWin()){
            return;
        }



        //对上下左右进行判断
        //左 : 37 右 : 39 上 : 38 下 : 40

        int keyCode = e.getKeyCode();

        if(keyCode == 37){
            //左

            if(y==3){
                return;
            }


            //逻辑
            //把空白方块右边的数字往左移动
            //x,y表示空白方块
            //x,y-1表示空白方块右边的数字

            //把空白方块右边的数字赋值给空白方块
            data[x][y] = data[x][y+1];

            data[x][y+1] = 0;

            y++;

            step++;
        }else if(keyCode == 39){
            //右

            if(y==0){
                return;
            }

            //逻辑
            //把空白方块左边的数字往右移动
            //x,y表示空白方块
            //x,y+1表示空白方块左边的数字

            //把空白方块左边的数字赋值给空白方块
            data[x][y] = data[x][y-1];

            data[x][y-1] = 0;

            y--;

            step++;
        }else if(keyCode == 38){
            //上

            if(x==3){
                return;
            }

            //逻辑
            //把空白方块下面的数字往上移动
            //x,y表示空白方块
            //x+1,y表示空白方块下面的数字

            //把空白方块下方的数字赋值给空白方块
            data[x][y] = data[x+1][y];

            data[x+1][y] = 0;

            x++;

            step++;

        }else if(keyCode == 40){
            //下

            if(x==0){
                return;
            }

            //逻辑
            //把空白方块上面的数字往下移动
            //x,y表示空白方块
            //x-1,y表示空白方块上面的数字

            //把空白方块上方的数字赋值给空白方块
            data[x][y] = data[x-1][y];

            data[x-1][y] = 0;

            x--;

            step++;

        }else if(keyCode == 65){
            //A
            
        }else if(keyCode == 66){
            //B
            //一键完成

            data = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};

        }

        //调用initImage方法加载图片
        initImage();
        
    }
    

    //判断是否完成
    public boolean isWin(){
        for(int i = 0;i < data.length;i++){
            for(int j = 0;j < data[i].length;j++){
                if(data[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    //重写选项下面的条目事件监听
    //ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        //获取事件源
        Object obj = e.getSource();

        if(obj == replayItem){
            //重新游戏

            System.out.println("重新游戏");
            
            step = 0;

            initData();

            initImage();

        }
        // else if(obj == reLoginItem){
        //     //重新登录
        //     this.setVisible(false);

        //     new LoginJFrame();

        // }
        else if(obj == closeItem){
            //关闭游戏
            System.exit(0);

        }else if(obj == accountItem){
            //公众号
            JDialog dialog = new JDialog();

            //弹框添加图片
            JLabel jLabel = new JLabel(new ImageIcon("image/about.jpg"));

            jLabel.setBounds(0,0,258,258);

            //弹框添加图片
            dialog.getContentPane().add(jLabel);

            //弹框大小
            dialog.setSize(344,344);

            //弹框置顶
            dialog.setAlwaysOnTop(true);

            //弹框居中
            dialog.setLocationRelativeTo(null);

            //弹框设置为模态  弹框不关闭则无法操作下面界面
            dialog.setModal(true);

            //弹框可见
            dialog.setVisible(true);


        }else if(obj == girl){
            //美女
            System.out.println("美女");
            //从13组美女中随机选择一组
            Random random = new Random();
            int index = random.nextInt(13);
            path = "image/girl/girl" + index + "/";
            step = 0;

            System.out.println(path);
            initData();

            initImage();

        }else if(obj == animals){
            //动物
            System.out.println("动物");
            //从13组动物中随机选择一组
            Random random = new Random();
            int index = random.nextInt(8);
            path = "image/animal/animal" + index + "/";
            step = 0;

            initData();

            initImage();
        }else if(obj == sport){
            //运动
            System.out.println("运动");
            //从13组运动中随机选择一组
            Random random = new Random();
            int index = random.nextInt(10);
            path = "image/sport/sport" + index + "/";
            step = 0;

            initData();

            initImage();
        }
    }




}
