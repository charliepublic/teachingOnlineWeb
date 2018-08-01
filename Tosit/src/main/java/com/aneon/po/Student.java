package com.aneon.po;

public class Student extends User {
    private String Snumber;
    private String Sname;
    private String Spass;
    private Integer Gnumber;
    private Integer Cnumber;
    private String Tnumber;

    public Student(){

    }
    public Student(String snumber,String sname,String spass,Integer classnumber){
        Snumber = snumber;
        Sname=sname;
        Spass=spass;
        Gnumber=classnumber;


    }
    public Student(String snumber,String sname,String spass) {
        Snumber = snumber;
        Sname = sname;
        Spass = spass;
    }
    public String getSnumber(){
        return Snumber;
    }
    public void setSnumber(String Snumber){
        this.Snumber=Snumber;
    }
    public String getSname(){
        return Sname;
    }
    public void setSname(String Sname){
        this.Sname=Sname;
    }
    public Integer getGroupNumber() {
        return Gnumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.Gnumber = groupNumber;
    }

    public Integer getClassNumber() {
        return Cnumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.Cnumber = classNumber;
    }

    public String getTeacher() {
        return Tnumber;
    }

    public void setTeacher(String teacher) {
        this.Tnumber = teacher;
    }

    @Override
    public String toString() {
        return "StuInfo {" +
                "Snumber='" + Snumber +
                "' Sname='" + Sname +
                "' Spass='" + Spass +
                "' Gnumber='" + Gnumber +
                "'Cnumber='"+Cnumber+"'}";
    }
}