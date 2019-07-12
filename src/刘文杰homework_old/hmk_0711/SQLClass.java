package 刘文杰homework_old.hmk_0711;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLClass {
    private String drv = "com.mysql.jdbc.Driver";//驱动
    private String url;
    private String usr;
    private String pwd;

    public SQLClass(String ip, int port, String usr, String pwd, String data) {
        this.url = "jdbc:mysql://"+ip+":"+port+"/"+data;
        this.usr = usr;
        this.pwd = pwd;
    }

    private Connection conn = null;
    private Statement stm = null;
    public boolean createConn() {
        boolean b = false;
        try {
            Class.forName(drv).newInstance();
            conn = (Connection)DriverManager.getConnection(url, usr, pwd);
            b = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }
    //数据库更新语句
    public int update(String sql) {
        boolean b = false;
        try {
            stm = (Statement)conn.createStatement();
            int row = stm.executeUpdate(sql);
            return row;
        } catch (Exception e) {
            System.out.println(e.toString());
            return 0;
        }
    }
    //查询语句
    public ResultSet query(String sql) {
        try {
            stm = (Statement)conn.createStatement();
            return stm.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void close() {
        try {
            if (conn != null)
                conn.close();

        } catch (SQLException e) {
        }
        try {
            if (stm != null)
                stm.close();
        } catch (SQLException e) {
        }
    }

    public void closeConn() {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
        }
    }

    public void closeStm() {
        try {
            if (stm != null)
                stm.close();
        } catch (SQLException e) {
        }
    }




    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getDrv() {
        return drv;
    }

    public void setDrv(String drv) {
        this.drv = drv;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }
}
