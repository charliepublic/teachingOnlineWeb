package com.aneon.po;

public class Team {
    private int Gnumber;
    private String Gname;
    private  int Cnumber;
    private  String Pnumber;

    public Team( String gname, int cnumber) {

        Gname = gname;
        Cnumber = cnumber;
    }

    public int getGnumber() {
        return Gnumber;
    }

    public String getGname() {
        return Gname;
    }



    public int getCnumber() {
        return Cnumber;
    }

    public String getPnumber() {
        return Pnumber;
    }



    public void setPnumber(String pnumber) {
        Pnumber = pnumber;
    }
}
