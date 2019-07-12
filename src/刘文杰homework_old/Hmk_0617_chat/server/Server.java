package 刘文杰homework_old.Hmk_0617_chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {
    static List<Socket> userlist = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(7777);
        System.out.println("Server Start Running.");
        while (true){
            Socket client = server.accept();
            userlist.add(client);
            System.out.println(client.getInetAddress()+" :Connected");
            new Thread(new ServerThread(client)).start();
        }
    }
}
