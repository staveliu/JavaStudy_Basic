package maphomework.studentmanage;

public class Student {
    private String stud_no;
    private String name;
    private int sex;
    private int age;
    private String major;
    private String classNo;
    private String address;

    public Student() {
    }


    public Student(String stud_no, String name, int sex, int age, String major, String classNo, String address) {
        this.stud_no = stud_no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.major = major;
        this.classNo = classNo;
        this.address = address;
    }


    public String getStud_no() {
        return stud_no;
    }

    public void setStud_no(String stud_no) {
        this.stud_no = stud_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
