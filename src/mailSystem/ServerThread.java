package mailSystem;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread implements Runnable{
    private Account account;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean flag = true;
    public ServerThread(Socket client) {
        this.account = account;
        try {
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("New Socket");
        while (flag){
            try {
                String command = dis.readUTF();
                String command_1 = command.substring(0,command.indexOf(':'));
                System.out.println(command_1);
                if (command_1.equals("LOGIN")){

                    String mailName = command.substring(command.indexOf(':')+1,command.indexOf('#'));
                    String password = command.substring(command.indexOf('#')+1,command.length());
                    account = new Account(mailName,password);
                    if (account.isFlag()){
                        String token = account.set_token();
                        System.out.println("connected");
                        dos.writeUTF("Successful:"+token);
                    }else{
                        dos.writeUTF("Failed:MailName or Password error");
                    }
                }
                if (command_1.equals("REGISTER")){
                    String mailName = command.substring(command.indexOf(':')+1,command.indexOf('#'));
                    String password = command.substring(command.indexOf('#')+1,command.length());
                    account = new Account(mailName,password);
                    if (account.isFlag()){
                        dos.writeUTF("Failed:MailName Exist");
                    }else{
                        boolean status = account.register();
                        if (status){
                            dos.writeUTF("Successful:Successful,Please Login");
                        }else{
                            dos.writeUTF("Failed:Unknown Error");
                        }
                    }
                }
                if (command_1.equals("SENDMAIL")){
                    String token = command.substring(command.indexOf(':')+1,command.indexOf('@'));
                    String sendTo = command.substring(command.indexOf('@')+1,command.indexOf('@'));
                    String message = command.substring(command.indexOf('@')+1,command.length());
                }
            } catch (IOException e) {
                e.printStackTrace();
                flag = false;
            }
        }
    }
}
