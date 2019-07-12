
package 刘文杰homework_old.Hmk_0617_chat.server;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerThread implements Runnable{
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean flag;
    private Socket client;

    private boolean login = false;
    private String username = null;


    public ServerThread(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
            flag = true;
        } catch (IOException e) {
            flag = false;
            Server.userlist.remove(this.client);
            try {
                dis.close();
                dos.close();
                Thread.interrupted();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();

        }
    }

    public void chatStart() throws IOException{
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        String date = df.format(day);
        for (Socket sock:Server.userlist){
            DataOutputStream othersDos = new DataOutputStream(sock.getOutputStream());
            othersDos.writeUTF("["+date+"]"+"Server: 欢迎 "+this.username+" 进入房间");
        }
        while (flag){
            day=new Date();
            df = new SimpleDateFormat("HH:mm:ss");
            date = df.format(day);
            String rev = dis.readUTF();
            String data = "["+date+"]"+this.username+": "+rev;
            System.out.println(data);
            for (Socket sock:Server.userlist){
                DataOutputStream othersDos = new DataOutputStream(sock.getOutputStream());
                othersDos.writeUTF(data);
            }
        }
    }
    @Override
    public void run() {
        while (flag){
            try {
                String content = dis.readUTF();
                String reply = null;
                JsonObject json = new Gson().fromJson(content,JsonObject.class);
                String command = json.get("command").toString();
                command = command.substring(1,command.length()-1);
                if (command.equals("login")) {
                    String username = json.get("username").toString();
                    String password = json.get("password").toString();
                    username = username.substring(1, username.length() - 1);
                    password = password.substring(1, password.length() - 1);
                    User user = new User(username, password);
                    if (user.isLogin()) {
                        reply = "{'status':true,'message':'登陆成功！'}";
                        this.login = true;
                        this.username = username;
                    }else{
                        reply = "{'status':false,'message':'登陆失败，密码错误！'}";
                    }
                    dos.writeUTF(reply);
                }
                if (command.equals("register")){
                    String username = json.get("username").toString();
                    String password = json.get("password").toString();
                    String email = json.get("email").toString();
                    username = username.substring(1, username.length() - 1);
                    password = password.substring(1, password.length() - 1);
                    email = email.substring(1,email.length() - 1);
                    User user = new User(username, password);
                    if (user.isLogin()){
                        reply = "{'status':false,'message':'注册失败，您已经注册过'}";
                    }else{
                        boolean result = user.register(email);
                        if (result) {
                            reply = "{'status':true,'message':'注册成功'}";
                        }else{
                            reply = "{'status':false,'message':'注册失败，用户名已存在'}";
                        }
                    }
                    dos.writeUTF(reply);
                }
                if (this.login){
                    chatStart();
                }
            } catch (IOException e) {
                flag = false;
                Server.userlist.remove(this.client);
                try {
                    dis.close();
                    dos.close();
                    Thread.interrupted();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println(client.getInetAddress()+" :Disconnected");
            }
        }
    }
}
