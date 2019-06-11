package Advanced.NIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteNio {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("a.txt");
        String str = "Helloworld";
        ByteBuffer buff = ByteBuffer.allocate(1024);
        FileOutputStream fos = new FileOutputStream(file);
        buff.put(str.getBytes());

    }
}
