package com.aneon.po;

public class Task {
    private String TaskName;
    private String startDate;
    private String endDate;
    private String Tnumber;
    private int Cnumber;
    private String detail;

    public Task(String taskName, String startDate, String endDate, String tnumber, int cnumber, String detail) {
        TaskName = taskName;
        this.startDate = startDate;
        this.endDate = endDate;
        Tnumber = tnumber;
        Cnumber = cnumber;
        this.detail = detail;
    }

    public String getTaskName() {
        return TaskName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getTnumber() {
        return Tnumber;
    }

    public int getCnumber() {
        return Cnumber;
    }

    public String getDetail() {
        return detail;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTnumber(String tnumber) {
        Tnumber = tnumber;
    }

    public void setCnumber(int cnumber) {
        Cnumber = cnumber;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
