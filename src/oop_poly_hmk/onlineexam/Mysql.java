package oop_poly_hmk.onlineexam;

import java.sql.*;
/*
Database Structure

 */
public class Mysql {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/questionSystem";
    static final String USER = "";
    static final String PASS = "";
    public static String[] getQuestion(int number,int type) {
        Connection conn = null;
        Statement stmt = null;
        String[] arr = {"",""};
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            if (type==1) {
                sql = "SELECT * FROM multiple_questions WHERE number = '"+number+"'";
                rs = stmt.executeQuery(sql);
            }else{
                sql = "SELECT * FROM single_questions WHERE number = '"+number+"'";
                rs = stmt.executeQuery(sql);
            }
            arr[0]=rs.getString("content");
            arr[1]=rs.getString("answer");
            rs.close();
            stmt.close();
            conn.close();
            return arr;
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
            return arr;
        }
    }
}
