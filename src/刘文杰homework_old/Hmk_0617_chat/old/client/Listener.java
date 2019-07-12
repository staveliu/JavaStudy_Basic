package 刘文杰homework_old.Hmk_0617_chat.old.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Listener implements ActionListener { //ActionListener用来响应用户点击按钮
    private static JFrame frame;

    public void actionPerformed(ActionEvent e) {  //定义处理事件的方法
        // TODO Auto-generated method stub
        String name = e.getActionCommand();//返回与此动作相关的命令字符串
        if (name.equals("登录")) {
            String username = ClientWindow.jtf.getText();
            String password = ClientWindow.jpf.getText();
            Map<String,String> jsondata = new HashMap<>();
            jsondata.put("command","login");
            jsondata.put("username",username);
            jsondata.put("password",password);
            String json = new Gson().toJson(jsondata);
            try {
                ClientWindowMain.dos.writeUTF(json);
                String result = ClientWindowMain.dis.readUTF();
                JsonObject resultJson = new Gson().fromJson(result,JsonObject.class);
                if (resultJson.get("status").toString().equals("true")){
                    JOptionPane.showMessageDialog(frame,resultJson.get("message").toString().replaceAll("\"*\"",""),"登陆成功",JOptionPane.INFORMATION_MESSAGE);
                    ClientWindowMain.name = username;
                    ClientWindowMain.gotoChat();
                }else{
                    JOptionPane.showMessageDialog(frame,resultJson.get("message").toString().replaceAll("\"*\"",""),"登陆失败",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }


        } else if (name.equals("取消")) {
            JOptionPane.showMessageDialog(frame, "确定要退出吗", "提示", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0); //退出
        }
    }
}