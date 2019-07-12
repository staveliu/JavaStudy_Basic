package 刘文杰homework_old.Hmk_0617_chat.client.multi.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args){
        try {
            Socket sock = new Socket("localhost",7777);
            DataInputStream dis = new DataInputStream(sock.getInputStream());
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            boolean flag = false;
            while (!flag){
                System.out.println("请输入命令login或者register来登陆或者注册, 输入e退出:");
                String command = console.readLine();
                if (command.equals("login")){
                    System.out.println("用户名:");
                    String username = console.readLine();
                    System.out.println("密码:");
                    String password = console.readLine();
                    System.out.println("登陆中........");
                    Map<String,String> jsondata = new HashMap<>();
                    jsondata.put("command","login");
                    jsondata.put("username",username);
                    jsondata.put("password",password);
                    String json = new Gson().toJson(jsondata);
                    dos.writeUTF(json);
                    String result = dis.readUTF();
                    JsonObject resultJson = new Gson().fromJson(result,JsonObject.class);
                    if (resultJson.get("status").toString().equals("true")){
                        flag = true;
                    }
                    System.out.println(resultJson.get("message").toString());
                }
                if (command.equals("register")){
                    System.out.println("用户名:");
                    String username = console.readLine();
                    System.out.println("密码:");
                    String password = console.readLine();
                    System.out.println("邮箱地址:");
                    String email = console.readLine();
                    System.out.println("注册中........");
                    Map<String,String> jsondata = new HashMap<>();
                    jsondata.put("command","register");
                    jsondata.put("email",email);
                    jsondata.put("username",username);
                    jsondata.put("password",password);
                    String json = new Gson().toJson(jsondata);
                    dos.writeUTF(json);
                    String result = dis.readUTF();
                    JsonObject resultJson = new Gson().fromJson(result,JsonObject.class);
                    System.out.println(resultJson.get("message").toString());
                }
                if(command.equals("e")){
                    System.exit(0);
                }
            }

            System.out.println("您已经进入聊天室");
            new Thread(new ReadThread(sock)).start();
            new Thread(new WriteThread(sock)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
