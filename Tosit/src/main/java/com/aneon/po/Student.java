package com.aneon.po;

public class Student extends User {
    private Integer groupNumber;
    private Integer classNumber;
    private String teacher;
    private String Spass;

    public Student(String username, String name, String spass) {
        super(username, name, Identify.STUDENT);
        Spass = spass;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSpass() {
        return Spass;
    }

    public void setSpass(String spass) {
        Spass = spass;
    }
}
