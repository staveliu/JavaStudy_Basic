package 刘文杰homework_old.Hmk_0617_chat.client.multi.client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class WriteThread implements Runnable{
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
                System.out.println("服务器已关闭");
                System.exit(0);
            }
        }
    }
}
