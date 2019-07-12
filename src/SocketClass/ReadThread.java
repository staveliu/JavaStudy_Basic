package SocketClass;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread implements Runnable
{
    private Socket sock;
    private BufferedReader dis;
    public ReadThread(Socket sock) {
        this.sock = sock;
        try {
            dis = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println(dis.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
