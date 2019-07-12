package 刘文杰homework_old.Hmk_0617_chat.client.multi.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadThread implements Runnable
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
                String newThing = oldThing + "\n" + dis.readUTF();
                ChatFrame.textArea.setText(newThing);
            } catch (Exception e) {
                flag = false;
                System.out.println("服务器已关闭");
                System.exit(0);
            }
        }
    }
}
