package SocketClass;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws IOException{
        Socket sock = new Socket("192.168.1.104",8877);
        new Thread(new WriteThread(sock)).start();
        new Thread(new ReadThread(sock)).start();
    }
}
