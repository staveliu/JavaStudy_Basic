package Socket;

import sun.jvm.hotspot.runtime.Threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server implements Runnable{
    int port;

    public Server(int port){
        this.port = port;
    }

    public void run(){
        try{
            ServerSocket sock = new ServerSocket(this.port);
            while (true){
                System.out.println("Wait for client connect..");
                Socket socket = sock.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String str = in.readUTF();
                System.out.println("Getdata from:"+socket.getRemoteSocketAddress().toString() + "  Data is:"+str);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("GETGETGET");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server server1 = new Server(9999);
        server1.run();
    }
}
