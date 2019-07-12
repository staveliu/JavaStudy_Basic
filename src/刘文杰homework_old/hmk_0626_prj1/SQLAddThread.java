package 刘文杰homework_old.hmk_0626_prj1;

public class SQLAddThread implements Runnable{
    private Teacher teacher;

    public SQLAddThread(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public void run() {
        SQLClass sql = new SQLClass(Main.sql_addr,Main.sql_port,Main.sql_usr,Main.sql_pwd,Main.sql_data);
        if (!sql.createConn()){
            try {
                throw new Exception("MySQL Connect Error");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String s = "INSERT INTO teacher(name,career,picUrl,intro) VALUE ('"+teacher.getName()+"','"+teacher.getCareer()+"','"+teacher.getPicUrl()+"','"+teacher.getIntro()+"')";

        boolean status = sql.insert(s);
        if (!status){
            System.out.println("Thread:"+Thread.currentThread().getName()+" add a data "+teacher.getName()+" to MySQL Successful");
        }else{
            System.out.println("Thread:"+Thread.currentThread().getName()+" add a data \"+json.get(\"name\")+\" to MySQL Failed");
        }
        sql.close();
    }
}
