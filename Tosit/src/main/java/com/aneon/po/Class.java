package com.aneon.po;

public class Class {
    private int Cnumber;
    private  String Cname;

    public Class(String cname) {
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
}
