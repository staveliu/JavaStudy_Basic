package 刘文杰homework_old.Hmk_0617_chat.old.client;

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
                String str = console.readLine();
                dos.writeUTF(str);
            } catch (Exception e) {
                flag = false;
                System.out.println("服务器已关闭");
                System.exit(0);
            }
        }
    }
}
