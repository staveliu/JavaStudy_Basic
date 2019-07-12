package 刘文杰homework_old.hmk_0711;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;

public class Homework {
    public static void main(String[] args) throws Exception {
        SQLClass sql = new SQLClass("45.32.249.128",3306,"root","153007lwj","studb");
        sql.createConn();

        //Question1(sql);
        //Question2(sql);
        //Question3(sql);

        Question4(sql);
        sql.close();
    }

    public static void Question1(SQLClass sql){
        //Question 1
        String sql1 = "insert into studentInfo values('0004','麻六','男',20)";
        int row1 = sql.update(sql1);
        if (row1 > 0){
            System.out.println("Insert 0004 successful");
        }else{
            System.out.println("Insert 0004 failed");
        }
    }
    public static void Question2(SQLClass sql){
        //Question 2
        String sql2 = "update studentInfo set stuAge = 21 where stuNo = '0003'";
        int row2 = sql.update(sql2);
        if (row2 > 0){
            System.out.println("update 0003 successful");
        }else{
            System.out.println("update 0003 failed");
        }
    }
    public static void Question3(SQLClass sql) throws Exception{
        //Question 3
        for (int i=1;i<=3;i++){
            String stuNo = "000"+i;
            String sql3 = "select * from studentInfo where stuNo='"+stuNo+"'";
            ResultSet rs = sql.query(sql3);
            if (rs.next()){
                Student stud = new Student(rs.getString("stuNo"),rs.getString("stuName"),"stuSex:"+rs.getString("stuSex"),rs.getInt("stuAge"));
                System.out.println(stud.toString());
                String sql4 = "delete from studentInfo where stuNo='"+stuNo+"'";
                int row3 = sql.update(sql4);
                if (row3 > 0) {
                    System.out.println("这条数据删除成功");
                }else{
                    System.out.println("这条数据删除失败");
                }
            }else{
                System.out.println("数据:"+stuNo+"不存在");
            }

        }
    }
    public static void Question4(SQLClass sql) throws Exception{
        //Question 4
        FileWriter fw=new FileWriter(new File("./student.txt"));
        BufferedWriter bw=new BufferedWriter(fw);
        String sqlQuery = "select * from studentInfo";
        ResultSet rs = sql.query(sqlQuery);
        while (rs.next()){
            Student stud = new Student(rs.getString("stuNo"),rs.getString("stuName"),"stuSex:"+rs.getString("stuSex"),rs.getInt("stuAge"));
            bw.write(stud.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
        System.out.println("Finished write to student.txt");
    }
}
