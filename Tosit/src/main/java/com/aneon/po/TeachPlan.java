package com.aneon.po;

public class TeachPlan {
    private String planName;
    private String teacherName;
    private String URL;

    public TeachPlan(String planName, String teacherName, String URL) {
        this.planName = planName;
        this.teacherName = teacherName;
        this.URL = URL;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "TeachPlan {" +
                "planName='" + planName +
                "' teacherName='" + teacherName +
                "' URL='" + URL + "'}";
    }
}
