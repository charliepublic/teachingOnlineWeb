package com.aneon.po;

public class Teacher_file_lib {
    private String filename;
    private String furl;
    private String Tnumber;
    private String Pnumber;
    private String detail;

    public Teacher_file_lib(){

    }
    public Teacher_file_lib(String filename, String furl, String tnumber, String pnumber, String detail) {
        this.filename = filename;
        this.furl = furl;
        Tnumber = tnumber;
        Pnumber = pnumber;
        this.detail = detail;
    }

    public String getFilename() {
        return filename;
    }

    public String getFurl() {
        return furl;
    }

    public String getTnumber() {
        return Tnumber;
    }

    public String getPnumber() {
        return Pnumber;
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

    public void setTnumber(String tnumber) {
        Tnumber = tnumber;
    }

    public void setPnumber(String pnumber) {
        Pnumber = pnumber;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
