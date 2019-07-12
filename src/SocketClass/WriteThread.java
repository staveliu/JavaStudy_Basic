package SocketClass;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public class WriteThread implements Runnable{
    private Socket sock;
    PrintWriter dos;
    BufferedReader console;
    public WriteThread(Socket sock) {
        this.sock = sock;
        try {
            dos = new PrintWriter(sock.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        console = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run() {

        while(true) {
            try {
                String str = console.readLine();
                dos.println(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
