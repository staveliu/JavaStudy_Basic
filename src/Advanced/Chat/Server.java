package Advanced.Chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;

public class Server{
    public static class Serverclass {
        private List<MyChannel> all = new ArrayList<MyChannel>();

        public static void main(String[] args) throws IOException {
            new Serverclass().start();
        }

        public void start() throws IOException {
            ServerSocket server = new ServerSocket(7777);
            new Thread(new Send()).start();
            while(true) {
                Socket client = server.accept();
                MyChannel channel = new MyChannel(client);
                all.add(channel);
                new Thread(channel).start();

            }
        }

        private  class Send implements Runnable{
            private BufferedReader console;
            private boolean flag= true;

            public Send() {
                console = new BufferedReader(new InputStreamReader(System.in));
            }

            private String getMsgFromConsole() {
                try {
                    String str = console.readLine();
                    if (str.equals("online")){
                        String nameList = "当前在线用户：";
                        for(MyChannel cn:all){
                            nameList = nameList+", "+cn.name;
                            return nameList;
                        }
                    }
                    return str;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "";
            }


            public void send(String msg){
                for (MyChannel cn:all){
                    cn.send("服务器通知："+msg);
                }
            }

            @Override
            public void run() {
                send("");
                while (flag){
                    String message = getMsgFromConsole();
                    System.out.println(message);
                    send(message);
                }
            }
        }

        private  class MyChannel implements Runnable {

            private DataInputStream dis;
            private DataOutputStream dos;
            private boolean flag = true;
            private String name;


            public MyChannel(Socket client) {
                try {
                    dis = new DataInputStream(client.getInputStream());
                    dos = new DataOutputStream(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                    flag = false;
                    try {
                        dis.close();
                        dos.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            private String receive() {
                String msg = "";
                try {
                    msg = dis.readUTF();
                    System.out.println(msg);
                } catch (IOException e) {
                    flag = false;
                    e.printStackTrace();
                    sendOthers(this.name+"离开了");
                    all.remove(this);

                    try {
                        dis.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                return msg;
            }


            private void send(String msg) {
                if (null == msg || msg.equals("")) {
                    return;
                }
                try {

                    dos.writeUTF(time());
                    dos.writeUTF(msg);
                } catch (IOException e) {
                    flag = false;
                    e.printStackTrace();
                    sendOthers(this.name+"离开了");
                    all.remove(this);
                    try {
                        dos.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            private void sendOthers(String msg) {
                if (msg.contains("@")){
                    String spot = null;

                    String secreName = msg.substring(msg.indexOf("@") + 1, msg.indexOf("："));
                    String secretMsg = msg.substring(msg.indexOf("：") + 1);

                    for (MyChannel other : all) {
                        if (secreName.equals(other.name)) {
                            other.send(name + "悄悄地对你说：" + secretMsg);
                        }

                    }
                }else{
                    String msgContent = msg.substring(msg.indexOf(": ") + 2);
                    System.out.println(msgContent+" "+this.name);
                    if (this.name.equals("Stave")){
                        msg = "【管理员爸爸】Stave: "+msgContent;
                    }
                    for (MyChannel other : all) {
                        if (other == this) {
                            continue;
                        }
                        other.send(msg);
                    }
                }
            }


            private String time () {
                Date now = new Date(System.currentTimeMillis());
                String time = new SimpleDateFormat("yyyy.MM.dd  hh:mm:ss").format(now);
                return time;
            }

            @Override
            public void run () {
                send("欢迎加入群聊");
                name = receive();
                if (name.equals("Stave")){
                    sendOthers("管理员爸爸Stave已上线");
                }
                sendOthers(name + "加入了群聊");
                System.out.println(name + "加入了群聊");
                while (flag) {
                    sendOthers(receive());
                }
            }
        }
    }
}