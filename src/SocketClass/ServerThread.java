package SocketClass;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread implements Runnable {
    private DataInputStream dis;
    private DataOutputStream dos;
    public ServerThread(Socket client){
        try {
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                dos.writeUTF("我收到你说的："+dis.readUTF()+"了");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
