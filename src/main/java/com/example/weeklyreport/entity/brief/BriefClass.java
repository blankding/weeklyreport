package com.example.weeklyreport.entity.brief;

import java.io.Serializable;

/**
 * @author 丁鹏益
 * 表class
 */
public class BriefClass implements Serializable {
    private String class_id;
    private String class_name;
    private String create_id;

    public BriefClass() {
    }

    public BriefClass(String class_id, String class_name, String create_id) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.create_id = create_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getCreate_id() {
        return create_id;
    }

    public void setCreate_id(String create_id) {
        this.create_id = create_id;
    }

    @Override
    public String toString() {
        return "briefClass{" +
                "class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                ", create_id='" + create_id + '\'' +
                '}';
    }
}
