package com.aneon.po;

public class Stu_file_lib {
    private String filename;
    private String furl;
    private String Snumber;
    private String Pnumber;
    private double grand;
    private String detail;

    public Stu_file_lib(String filename, String furl, String Snumber, String pnumber, String detail) {
        this.filename = filename;
        this.furl = furl;
        this.Snumber = Snumber;
        Pnumber = pnumber;
        this.detail = detail;
    }

    public String getFilename() {
        return filename;
    }

    public String getFurl() {
        return furl;
    }

    public String getSnumber() {
        return Snumber;
    }

    public String getPnumber() {
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

    public void setPnumber(String pnumber) {
        Pnumber = pnumber;
    }

    public void setGrand(double grand) {
        this.grand = grand;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
