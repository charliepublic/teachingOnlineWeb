package com.aneon.po;

public class Class {
    private int Cnumber;
    private  String Cname;

    public Class(){

    }
    public Class(String cname){
        Cname = cname;
    }
    public Class(int cnumber,String cname) {
        Cnumber=cnumber;
        Cname = cname;
    }

    public int getCnumber() {
        return Cnumber;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    @Override
    public String toString() {

        return "classInfo {" +
                "classnumber='" + Cnumber +
                "' classname='" + Cname +
                "'}";
    }
}
