package 刘文杰homework_old.Hmk_0617_chat.client.multi.client;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientWindowMain {
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
