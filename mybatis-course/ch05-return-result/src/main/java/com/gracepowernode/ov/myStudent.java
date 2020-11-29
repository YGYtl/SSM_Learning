package com.gracepowernode.ov;

public class myStudent {
    private Integer stuid;
    private String stuname;
    private String stuemail;
    private Integer stuage;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuemail() {
        return stuemail;
    }

    public void setStuemail(String stuemail) {
        this.stuemail = stuemail;
    }

    public Integer getStuage() {
        return stuage;
    }

    public void setStuage(Integer stuage) {
        this.stuage = stuage;
    }
    public myStudent(){}

    public myStudent(Integer stuid, String stuname, String stuemail, Integer stuage) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stuemail = stuemail;
        this.stuage = stuage;
    }

    @Override
    public String toString() {
        return "myStudent{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                ", stuemail='" + stuemail + '\'' +
                ", stuage=" + stuage +
                '}';
    }
}
