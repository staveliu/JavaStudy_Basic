package 刘文杰homework_old.Hmk_0617_chat.server;

import com.google.gson.*;

import java.io.*;

public class User {
    private String username;
    private String password;
    private String email;
    private boolean login = false;
    private boolean exist = false;
    private Gson g = new Gson();
    private JsonObject user;
    private JsonArray data;
    static final String datapath = "刘文杰homework_old/Hmk_0617_chat/server/data.json";

    public User(String username,String password){
        this.username = username;
        this.password = password;
        try {
            FileInputStream fis = new FileInputStream(new File(datapath));
            int len;
            byte[] read = new byte[1024];
            String str="";

            while((len = fis.read(read))!= -1) {
                str = new String(read,0,len);
            }
            fis.close();

            this.data = new Gson().fromJson(str,JsonArray.class);
            for (JsonElement a: data){
                user = a.getAsJsonObject();
                String un = user.get("username").toString();
                un = un.substring(1,un.length()-1);
                if (un.equals(username)){
                    this.exist = true;
                    String pwd = user.get("password").toString();
                    if (pwd.substring(1,pwd.length()-1).equals(password)){
                        this.login = true;
                        String email = user.get("email").toString();
                        this.email = email.substring(1,email.length()-1);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public synchronized boolean register(String email){
        this.email = email;
        System.out.println(this.exist);
        if (!this.exist){
            FileOutputStream outSTr = null;
            try {
                String newuser = "{'username':"+this.username+",'password':"+this.password+",'email':"+this.email+"}";
                data.add(new Gson().fromJson(newuser,JsonObject.class));
                outSTr = new FileOutputStream(new File(datapath));
                BufferedOutputStream Buff = new BufferedOutputStream(outSTr);
                Buff.write(data.toString().getBytes());
                Buff.flush();
                Buff.close();
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
