package Advanced.Chat;

import java.io.IOException;
import java.net.Socket;

public class clienttest {

    public static void main(String[] args){
        Socket[] socks=new Socket[10];
        for (int i=0;i<10;i++){
            try {
                socks[i] = new Socket("192.168.1.104",8877);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
