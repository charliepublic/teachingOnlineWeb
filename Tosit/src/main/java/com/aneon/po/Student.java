package com.aneon.po;

public class Student extends User {
    private String Spass;
    private Integer Gnumber;
    private Integer Cnumber;
    private String Tnumber;

    public Student(String username, String name) {
        super(username, name, Identify.STUDENT);
    }

    public Student(String snumber, String sname, Integer classnumber){
        super(snumber, sname, Identify.STUDENT);
        Gnumber=classnumber;
    }
    public Student(String snumber,String sname,String spass) {
        super(snumber, sname, Identify.STUDENT);
        Spass = spass;
    }

    public Student(String username, String name, Integer gnumber, Integer cnumber, String tnumber) {
        super(username, name, Identify.STUDENT);
        Gnumber = gnumber;
        Cnumber = cnumber;
        Tnumber = tnumber;
    }

    public String getSpass() {
        return Spass;
    }

    public void setSpass(String spass) {
        Spass = spass;
    }

    public Integer getGnumber() {
        return Gnumber;
    }

    public void setGnumber(Integer gnumber) {
        Gnumber = gnumber;
    }

    public Integer getCnumber() {
        return Cnumber;
    }

    public void setCnumber(Integer cnumber) {
        Cnumber = cnumber;
    }

    public String getTnumber() {
        return Tnumber;
    }

    public void setTnumber(String tnumber) {
        Tnumber = tnumber;
    }
}
