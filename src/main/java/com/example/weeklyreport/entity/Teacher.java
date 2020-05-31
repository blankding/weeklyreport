package com.example.weeklyreport.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * @author 丁鹏益
 * 教师实体类
 */
public class Teacher {
    private Integer teacher_id;
    private Integer teacher_num;
    private String teacher_name;
    private String PASSWORD;
    private String username;
    private String email;
    private String mobile_phone;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp creatime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp modifytime;

    public Teacher() {
    }

    public Teacher(String username) {
        this.username = username;
    }

    public Teacher(Integer teacher_id, Integer teacher_num, String teacher_name, String password, String email, String mobile_phone, Timestamp creatime, Timestamp modifytime) {
        this.teacher_id = teacher_id;
        this.teacher_num = teacher_num;
        this.teacher_name = teacher_name;
        this.PASSWORD = password;
        this.email = email;
        this.mobile_phone = mobile_phone;
        this.creatime = creatime;
        this.modifytime = modifytime;

    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getTeacher_num() {
        return teacher_num;
    }

    public void setTeacher_num(Integer teacher_num) {
        this.teacher_num = teacher_num;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public void setPassword(String password) {
        this.PASSWORD = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile_phone;
    }

    public void setMobile(String mobile_phone) {
        this.mobile_phone = mobile_phone;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", teacher_num=" + teacher_num +
                ", teacher_name='" + teacher_name + '\'' +
                ", password='" + PASSWORD + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", creatime=" + creatime +
                ", modifytime=" + modifytime +
                '}';
    }
}
