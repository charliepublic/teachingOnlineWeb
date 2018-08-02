package com.aneon.po;

public class Stu_file_lib {
    private String filename;
    private String furl;
    private String Snumber;
    private int Pnumber;
    private double grand;
    private String detail;


    public String getFilename() {
        return filename;
    }

    public String getFurl() {
        return furl;
    }

    public String getSnumber() {
        return Snumber;
    }

    public int getPnumber() {
        return Pnumber;
    }

    public double getGrand() {
        return grand;
    }

    public String getDetail() {
        return detail;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setFurl(String furl) {
        this.furl = furl;
    }

    public void setSnumber(String snumber) {
        Snumber = snumber;
    }

    public void setPnumber(int pnumber) {
        Pnumber = pnumber;
    }

    public void setGrand(double grand) {
        this.grand = grand;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
