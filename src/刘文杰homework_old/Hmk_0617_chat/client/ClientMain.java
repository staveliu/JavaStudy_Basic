package 刘文杰homework_old.Hmk_0617_chat.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientMain {

    public static class ClientWindowMain {
        static Socket sock;
        static DataInputStream dis;
        static DataOutputStream dos;
        static ClientWindow client;
        static String name;
        public static void main(String[] args) throws Exception{
            sock = new Socket("localhost",7777);
            dis = new DataInputStream(sock.getInputStream());
            dos = new DataOutputStream(sock.getOutputStream());
            client = new ClientWindow();

        }
        public static void gotoChat(){
            client.dispose();
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);

            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (UnsupportedLookAndFeelException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        ChatFrame frame = new ChatFrame();
                        frame.setVisible(true);
                        new Thread(new WriteThread(sock)).start();
                        new Thread(new ReadThread(sock)).start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static class Listener implements ActionListener { //ActionListener用来响应用户点击按钮
        private static JFrame frame;

        public void actionPerformed(ActionEvent e) {  //定义处理事件的方法
            // TODO Auto-generated method stub
            String name = e.getActionCommand();//返回与此动作相关的命令字符串
            if (name.equals("登录")) {
                String username = ClientWindow.jtf.getText();
                String password = ClientWindow.jpf.getText();
                Map<String,String> jsondata = new HashMap<>();
                jsondata.put("command","login");
                jsondata.put("username",username);
                jsondata.put("password",password);
                String json = new Gson().toJson(jsondata);
                try {
                    ClientWindowMain.dos.writeUTF(json);
                    String result = ClientWindowMain.dis.readUTF();
                    JsonObject resultJson = new Gson().fromJson(result,JsonObject.class);
                    if (resultJson.get("status").toString().equals("true")){
                        JOptionPane.showMessageDialog(frame,resultJson.get("message").toString().replaceAll("\"*\"",""),"登陆成功",JOptionPane.INFORMATION_MESSAGE);
                        ClientWindowMain.name = username;
                        ClientWindowMain.gotoChat();
                    }else{
                        JOptionPane.showMessageDialog(frame,resultJson.get("message").toString().replaceAll("\"*\"",""),"登陆失败",JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame,"登陆失败，服务器可能已经关闭","登陆失败",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }


            } else if (name.equals("注册")) {
                String email = "xxxxx@xxx.com";
                String username = ClientWindow.jtf.getText();
                String password = ClientWindow.jpf.getText();
                Map<String,String> jsondata = new HashMap<>();
                jsondata.put("command","register");
                jsondata.put("email",email);
                jsondata.put("username",username);
                jsondata.put("password",password);
                String json = new Gson().toJson(jsondata);
                try {
                    ClientWindowMain.dos.writeUTF(json);
                    String result = ClientWindowMain.dis.readUTF();
                    JsonObject resultJson = new Gson().fromJson(result,JsonObject.class);
                    JOptionPane.showMessageDialog(frame, resultJson.get("message").toString().replaceAll("\"*\"",""), "提示", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame,"注册失败，服务器可能已经关闭","注册失败",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

            }
        }
    }


    public static class ClientWindow extends JFrame{
        //定义组件
        static JPanel jp1, jp2, jp3;
        static JLabel jl1, jl2;
        static JTextField jtf;
        static JTextField jpf;
        static JButton jb1, jb2;
        public ClientWindow(){
            jp1 = new JPanel();
            jp2 = new JPanel();
            jp3 = new JPanel();

            jl1 = new JLabel("用户名");
            jl2 = new JLabel("密    码");

            jtf = new JTextField(10);
            jpf = new JTextField(10);

            jb1 = new JButton("登录");
            jb2 = new JButton("注册");

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
            jb2.addActionListener(l);
            jpf.addActionListener(l);
            jtf.addActionListener(l);

        }
    }

    public static class ChatFrame extends JFrame {
        static JButton button_2;
        static JTextArea textArea_1;
        static JTextPane textArea;
        public ChatFrame() {
            super();

            setTitle(ClientWindowMain.name+"—聊天窗");
            setBounds(100, 100, 558, 576);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            final JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout(5,5));
            getContentPane().add(panel, BorderLayout.NORTH);

            final JLabel label = new JLabel(new ImageIcon("Images/logo.jpg"));
            panel.add(label, BorderLayout.WEST);
            label.setPreferredSize(new Dimension(74,74));

            final JPanel panel_1 = new JPanel();
            panel_1.setLayout(new BorderLayout());
            panel.add(panel_1, BorderLayout.CENTER);

            final JLabel advancingSwiftLabel = new JLabel();
            advancingSwiftLabel.setText("欢迎"+ ClientWindowMain.name);
            panel_1.add(advancingSwiftLabel, BorderLayout.CENTER);

            final JLabel neverWasteTimeLabel = new JLabel();
            neverWasteTimeLabel.setText("加入本聊天室");
            panel_1.add(neverWasteTimeLabel, BorderLayout.SOUTH);

            final JSplitPane splitPane = new JSplitPane();
            splitPane.setDividerLocation(300);
            splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
            getContentPane().add(splitPane, BorderLayout.CENTER);

            final JPanel panel_2 = new JPanel();
            panel_2.setLayout(new BorderLayout());
            splitPane.setRightComponent(panel_2);

            final JPanel panel_3 = new JPanel();
            final FlowLayout flowLayout = new FlowLayout();
            flowLayout.setAlignment(FlowLayout.LEFT);
            panel_3.setLayout(flowLayout);
            panel_2.add(panel_3, BorderLayout.NORTH);

            final JButton button = new JButton();
            button.setText("字体");
            panel_3.add(button);

            final JPanel panel_4 = new JPanel();
            final FlowLayout flowLayout_1 = new FlowLayout();
            flowLayout_1.setAlignment(FlowLayout.RIGHT);
            panel_4.setLayout(flowLayout_1);
            panel_2.add(panel_4, BorderLayout.SOUTH);

            final JButton button_1 = new JButton();
            button_1.setText("关闭");
            panel_4.add(button_1);

            button_2 = new JButton();
            button_2.setText("发送");
            panel_4.add(button_2);

            final JScrollPane scrollPane = new JScrollPane();
            panel_2.add(scrollPane, BorderLayout.CENTER);

            textArea_1 = new JTextArea();
            scrollPane.setViewportView(textArea_1);

            final JScrollPane scrollPane_1 = new JScrollPane();
            splitPane.setLeftComponent(scrollPane_1);

            textArea = new JTextPane();

            scrollPane_1.setViewportView(textArea);

        }

    }

    public static class ReadThread implements Runnable
    {
        private DataInputStream dis;

        private boolean flag = true;

        public ReadThread(Socket sock) {
            try {
                dis = new DataInputStream(sock.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while(flag) {
                try {
                    String oldThing = ChatFrame.textArea.getText();
                    if (oldThing.length()>=10000){
                        oldThing = oldThing.substring(5000,oldThing.length()-1);
                    }
                    String newThing = oldThing + "\n" + dis.readUTF();
                    ChatFrame.textArea.setText(newThing);

                } catch (Exception e) {
                    flag = false;
                    JOptionPane.showMessageDialog(Listener.frame,"服务器已关闭","Server Closed",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        }
    }

    public static class WriteThread implements Runnable{
        DataOutputStream dos;
        BufferedReader console;
        private boolean flag = true;
        public WriteThread(Socket sock) {
            try {
                dos = new DataOutputStream(sock.getOutputStream());
            } catch (IOException e) {
                flag = false;
                e.printStackTrace();
            }
            console = new BufferedReader(new InputStreamReader(System.in));
        }


        @Override
        public void run() {
            while(true) {
                try {
                    ChatFrame.button_2.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            String str = ChatFrame.textArea_1.getText();
                            if (!str.equals("")) {
                                try {
                                    dos.writeUTF(str);
                                    ChatFrame.textArea_1.setText("");
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }
                    });
                    Thread.sleep(100);
                } catch (Exception e) {
                    flag = false;
                    JOptionPane.showMessageDialog(Listener.frame,"服务器已关闭","Server Closed",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        }
    }
}
