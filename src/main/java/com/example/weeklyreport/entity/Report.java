package com.example.weeklyreport.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * @author 丁鹏益
 * 周报实体类
 */
public class Report {
    private Integer report_id;
    private Integer student_number;
    private String class_id;
    private String class_name;
    private String student_name;
    private Integer teacher_num;
    private String study_aim;
    private String reason;
    private String problem;
    private String live;
    private String next_aim;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp creatime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp modifytime;

    public Report() {
    }

    public Report(Integer report_id, Integer student_number, String class_id, Integer teacher_number, String student_aim, String reason, String problem, String live, String next, Timestamp creatime, Timestamp modifytime) {
        this.report_id = report_id;
        this.student_number = student_number;
        this.class_id = class_id;
        this.teacher_num = teacher_number;
        this.study_aim = student_aim;
        this.reason = reason;
        this.problem = problem;
        this.live = live;
        this.next_aim = next;
        this.creatime = creatime;
        this.modifytime = modifytime;
    }

    public Report(String student_name) {
        this.student_name = student_name;
    }


    public Integer getReport_id() {
        return report_id;
    }

    public void setReport_id(Integer report_id) {
        this.report_id = report_id;
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

    public Integer getTeacher_number() {
        return teacher_num;
    }

    public void setTeacher_number(Integer teacher_number) {
        this.teacher_num = teacher_number;
    }

    public String getStudent_aim() {
        return study_aim;
    }

    public void setStudent_aim(String student_aim) {
        this.study_aim = student_aim;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getNext() {
        return next_aim;
    }

    public void setNext(String next_aim) {
        this.next_aim = next_aim;
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

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "Report{" +
                "report_id=" + report_id +
                ", student_number=" + student_number +
                ", class_id='" + class_id + '\'' +
                ", class_name='" + class_name + '\'' +
                ", student_name='" + student_name + '\'' +
                ", teacher_num=" + teacher_num +
                ", study_aim='" + study_aim + '\'' +
                ", reason='" + reason + '\'' +
                ", problem='" + problem + '\'' +
                ", live='" + live + '\'' +
                ", next_aim='" + next_aim + '\'' +
                ", creatime=" + creatime +
                ", modifytime=" + modifytime +
                '}';
    }
}
