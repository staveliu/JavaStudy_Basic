package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{
    public String ipaddr;
    public int port=9999;
    public Client(String ipaddr){
        this.ipaddr = ipaddr;
    }
    public void run(){
        while (true) {
            try {
                Socket sock = new Socket(this.ipaddr, this.port);
                Scanner in = new Scanner(System.in);
                String send = in.nextLine();
                DataOutputStream out = new DataOutputStream(sock.getOutputStream());
                out.writeUTF(send);
                DataInputStream input = new DataInputStream(sock.getInputStream());
                String instr = input.readUTF();
                System.out.println(instr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        Client client = new Client("127.0.0.1");
        client.run();
    }
}
