package mailSystem;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException{
        boolean status=false;
        String token;
        DataInputStream dis;
        DataOutputStream dos;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Socket client = new Socket("localhost",7777);
        dis = new DataInputStream(client.getInputStream());
        dos = new DataOutputStream(client.getOutputStream());
        System.out.println("Connect to server successful...\n");
        while (true){
            if (!status) {
                System.out.println("Please input command, LOGIN/REGISTER");
                System.out.println("Ex: LOGIN:stave#153007lwj");
                System.out.println("Ex: REGISTER:stave#153007lwj");
                String command = br.readLine();
                dos.writeUTF(command);
                String com = command.substring(0, command.indexOf(':'));
                String recv = dis.readUTF();
                if (com.equals("LOGIN")) {
                    String result = recv.substring(0, recv.indexOf(':'));
                    String content = recv.substring(recv.indexOf(':') + 1, recv.length());
                    if (result.equals("Successful")) {
                        status = true;
                        token = content;
                    } else {
                        status = false;
                        System.out.println("登陆出错，请重新尝试.");
                    }
                }
                if (com.equals("REGISTER")){
                    String result = recv.substring(0, recv.indexOf(':'));
                    String content = recv.substring(recv.indexOf(':') + 1, recv.length());
                    System.out.println(content);
                }
            }else{
                System.out.println("您已经登陆，现在可以使用sendto和receive命令");
                String command = br.readLine();
                dos.writeUTF(command);
                String recv = dis.readUTF();
            }
        }

    }
}
