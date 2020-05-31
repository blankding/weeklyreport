package com.example.weeklyreport.entity;

import com.example.weeklyreport.entity.brief.BriefClass;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;

public class Student {

    private Integer student_id;
    private Integer student_number;
    private String class_id;
    private String student_name;
    private String password;
    private String email;
    private Integer sex;//性别，0:男，1:女
    private String mobile;
    private String class_name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp creatime;//创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp modifytime;//修改时间

    private BriefClass briefClass;

    public Student() {
    }

    public Student(Integer student_id, Integer student_number, String class_id, String student_name, String password, String email, Integer sex, String mobile, String class_name, Timestamp creatime, Timestamp modifytime, BriefClass briefClass) {
        this.student_id = student_id;
        this.student_number = student_number;
        this.class_id = class_id;
        this.student_name = student_name;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.mobile = mobile;
        this.class_name = class_name;
        this.creatime = creatime;
        this.modifytime = modifytime;
    }


    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getStudent_number() {
        return student_number;
    }

    public void setStudent_number(Integer student_number) {
        this.student_number = student_number;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
    }

    public Timestamp getModifytime() {
        return modifytime;
    }

    public void setModifytime(Timestamp modifytime) {
        this.modifytime = modifytime;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }



    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_number=" + student_number +
                ", class_id=" + class_id +
                ", student_name='" + student_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", class_name='" + class_name + '\'' +
                ", creatime=" + creatime +
                ", modifytime=" + modifytime +

                '}';
    }
}
