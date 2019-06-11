package Advanced.Chat;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ClientClass {
    public static class Client {
        public static void main(String[] args) throws IOException {
            System.out.println("请输入昵称");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String name = br.readLine();

            Socket client = new Socket("us1.stave.tech",7777);

            new Thread(new Send(client,name)).start();

            new Thread(new Receive(client)).start();
        }
    }
    public static class Receive implements Runnable{

        private DataInputStream dis;

        private boolean flag = true;


        public Receive(Socket client){
            try {
                dis = new DataInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                flag = false;
                try {
                    dis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        public String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                flag = false;
                try {
                    dis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            return msg;
        }

        @Override
        public void run() {
            while(flag){
                System.out.println(receive());
            }
        }
    }


    public static class Send implements Runnable{
        private BufferedReader console;
        private DataOutputStream dos;
        private boolean flag= true;

        private String name;

        public Send() {
            console = new BufferedReader(new InputStreamReader(System.in));
        }

        public Send(Socket client,String name){
            this();
            this.name = name;
            try {
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {

                flag = false;
            }

        }

        private String getMsgFromConsole() {
            try {
                return console.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }


        public void send(String msg){
            if (null != msg && !msg.equals("")){
                try {
                    dos.writeUTF(name +": " + msg);
                    Date now = new Date(System.currentTimeMillis());
                    String time = new SimpleDateFormat("hh:mm:ss   yyyy/MM/dd  ").format(now);
                    System.out.println(time);
                    System.out.println(name + ":" + msg);
                    dos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        flag = false;
                        dos.close();
                        console.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
            }else{
                try {
                    dos.writeUTF(name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            send("");
            while (flag){
                send(getMsgFromConsole());
            }
        }
    }


}
