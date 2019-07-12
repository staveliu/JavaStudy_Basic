package 刘文杰homework_old.Hmk_0617_chat.old.client;

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
                System.out.println(dis.readUTF());
            } catch (Exception e) {
                flag = false;
                System.out.println("服务器已关闭");
                System.exit(0);
            }
        }
    }
}
