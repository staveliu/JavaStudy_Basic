package OOPclass1;

public class Teacher {

    private String name;
    private String direction;
    private String course;
    private int teachAge;

    Teacher(String name, String direction, String course, int teachAge){
        this.name = name;
        this.direction = direction;
        this.course = course;
        this.teachAge = teachAge;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public void setTeachAge(int teachAge){
        this.teachAge = teachAge;
    }
    public String getName() {
        return name;
    }
    public String getCourse() {
        return course;
    }
    public int getTeachAge() {
        return teachAge;
    }
    public String getDirection() {
        return direction;
    }


    public void showTeacherInfo(){
        System.out.println("Name: " + name);
        System.out.println("Teaching Direction: " + direction);
        System.out.println("Teaching Course: " + course);
        System.out.println("Teaching Age: " + teachAge);
        System.out.println("===================================");
    }
}
