package com.aneon.po;

public class Project {
    private String Pnumber;
    private String Pname;
    private int UpTime;
    private String Info;
    private int isPass = 0;

    public Project(String pname, int upTime, String info) {
        Pname = pname;
        UpTime = upTime;
        Info = info;
    }

    public String getPnumber() {
        return Pnumber;
    }

    public String getPname() {
        return Pname;
    }

    public int getUpTime() {
        return UpTime;
    }

    public String getInfo() {
        return Info;
    }

    public int getIsPass() {
        return isPass;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public void setUpTime(int upTime) {
        UpTime = upTime;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public void setIsPass(int isPass) {
        this.isPass = isPass;
    }
}
