/**
 * @author Stave(LIU WENJIE)
 * Normal copy program(Directory or File) Test.
 * Note:
 * Please input absolute path on desitination.
 * For origin directory, relative path is OK.
 */
package Advanced.adv1_hmk;

import java.io.*;

public class DirectoryCopyer {
    public static void copyFile(File originPath, File destPath){
        try {
            destPath.createNewFile();
            FileInputStream input = new FileInputStream(originPath);
            FileOutputStream output = new FileOutputStream(destPath);
            byte[] data = new byte[(int)originPath.length()];
            input.read(data);
            output.write(data);
            output.close();
            input.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void directoryCopy(File originDir, File destDir){
        File[] files = originDir.listFiles();
        for (File f:files){
            if (f.isFile()){
                String path = f.getAbsolutePath();
                File dest = new File(destDir+File.separator+f.getName());
                copyFile(f, dest);
                System.out.println("Copy from \""+f.getAbsolutePath()+"\" to Destination \""+dest.getAbsolutePath()+"\" successful");
            }
            if (f.isDirectory()){
                File directory1 = new File(destDir+File.separator+f.getName());
                directory1.mkdir();
                directoryCopy(f, directory1);
                /**
                 * analyse log
                 * C:\lwj
                 * D:\stave\lwj
                 */
            }
        }
    }
    public static void main(String[] args){
        File dir1 = new File("./src");
        File dir2 = new File("./src1/");

        dir2.mkdir();
        if (dir1.isDirectory()) {
            directoryCopy(dir1, dir2);
        }else if (dir1.isFile()){
            copyFile(dir1,dir2);
        }else{
            System.out.println("Error: Origin File or Directory Not Exist");
            System.exit(0);
        }

    }
}
