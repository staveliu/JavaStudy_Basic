package mailSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Account {

    private String mailName;
    private String password;
    private int uid;
    private boolean flag = false;

    private Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://wxapi.cy.stave.tech:3306/bank";
    private String user = "root";
    private String pwd = "153007lwj";

    public String getMailName() {
        return mailName;
    }

    public void setMailName(String mailName) {
        this.mailName = mailName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Account(String mailName, String password) {
        this.mailName = mailName;
        this.password = password;
        try {
            Class.forName(driver);
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pwd);
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM `account` WHERE `mailName` = '"+mailName+"'";
            ResultSet rs = statement.executeQuery(sql);
            String chkpwd = null;
            rs.next();
            chkpwd = rs.getString("password");
            if (password.equals(chkpwd)) {
                this.uid = rs.getInt("uid");
                this.flag = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            flag = false;
        } catch (SQLException e) {
            e.printStackTrace();
            flag = false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean register(){
        if (!flag) {
            try {
                Class.forName(driver);
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, pwd);
                Statement statement = con.createStatement();
                String sql = "INSERT INTO account(mailName,password) VALUES('" + this.mailName + "','" + this.password + "')";
                flag = true;
                return statement.execute(sql);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            return false;
        }
    }

    public int get_uid() {
        int uid = 0;
        if (flag) {
            try {
                Class.forName(driver);
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, pwd);
                Statement statement = con.createStatement();
                String sql = "SELECT * FROM account WHERE mailName = '" + this.mailName + "'";
                ResultSet rs = statement.executeQuery(sql);
                rs.next();
                uid = rs.getInt("uid");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return uid;
    }
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    public String set_token(){
        String token = null;
        if (flag) {
            try{
                Class.forName(driver);
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, pwd);
                Statement statement = con.createStatement();
                token = getRandomString(32);
                String sql = "UPDATE account SET token = '"+token+"' WHERE uid = "+this.uid;
                boolean status = statement.execute(sql);
                return token;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public String get_token(){
        if (flag) {
            try{
                Class.forName(driver);
                Class.forName(driver);
                con = DriverManager.getConnection(url,user,pwd);
                Statement statement = con.createStatement();
                String sql = "SELECT * FROM account WHERE uid = "+uid;
                ResultSet rs = statement.executeQuery(sql);
                String token = null;
                rs.next();
                token = rs.getString("token");
                return token;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
