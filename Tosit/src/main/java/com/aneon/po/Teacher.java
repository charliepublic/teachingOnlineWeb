package com.aneon.po;

public class Teacher extends User {
    private String teachFile;

    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getTeachFile() {
        return teachFile;
    }

    public void setTeachFile(String teachFile) {
        this.teachFile = teachFile;
    }
}
