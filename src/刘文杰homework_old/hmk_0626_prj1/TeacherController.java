package 刘文杰homework_old.hmk_0626_prj1;

public class TeacherController {
    private Teacher teacher;

    public TeacherController(Teacher film) {
        this.teacher = film;
    }

    public void add(){
        Main.sqlPool.execute(new SQLAddThread(teacher));
        Main.downloadPool.execute(new ImgDownloadThread(teacher));
    }
}
