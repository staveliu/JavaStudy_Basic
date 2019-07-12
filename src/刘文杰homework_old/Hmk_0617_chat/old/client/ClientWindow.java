package 刘文杰homework_old.Hmk_0617_chat.old.client;

import javax.swing.*;
import java.awt.*;

public class ClientWindow extends JFrame{
    //定义组件
    static JPanel jp1, jp2, jp3;
    static JLabel jl1, jl2;
    static JTextField jtf;
    static JTextField jpf;
    static JButton jb1, jb2;
    //构造函数 初始化组件
    public ClientWindow(){
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jl1 = new JLabel("用户名");
        jl2 = new JLabel("密    码");

        jtf = new JTextField(10);
        jpf = new JTextField(10);

        jb1 = new JButton("登录");
        jb2 = new JButton("取消");

        jp1.add(jl1);
        jp1.add(jtf);
        jp2.add(jl2);
        jp2.add(jpf);
        jp3.add(jb1);
        jp3.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setLayout(new GridLayout(3, 1));
        this.setTitle("窗体名");
        this.setSize(200,200);
        this.setLocation(100,200);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Listener l=new Listener();
        jb1.addActionListener(l);
        jb2.addActionListener(l);//按钮登录，退出共享绑定事件监控器
        jpf.addActionListener(l);
        jtf.addActionListener(l);

    }
}