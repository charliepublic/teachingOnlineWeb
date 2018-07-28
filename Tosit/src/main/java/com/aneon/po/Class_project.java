package com.aneon.po;

public class Class_project {
    private int Cnumber;
    private int Pnumber;

    public Class_project(int cnumber, int pnumber) {
        Cnumber = cnumber;
        Pnumber = pnumber;
    }

    public int getCnumber() {
        return Cnumber;
    }

    public int getPnumber() {
        return Pnumber;
    }

    public void setPnumber(int pnumber) {
        Pnumber = pnumber;
    }

    public void setCnumber(int cnumber) {
        Cnumber = cnumber;
    }
}
