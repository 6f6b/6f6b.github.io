package com.fengliu.initializer.demo.proj.model;

public class Dept {
    private String depName;
    private String depNo;

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepNo() {
        return depNo;
    }

    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "depName='" + depName + '\'' +
                ", depNo='" + depNo + '\'' +
                '}';
    }
}
