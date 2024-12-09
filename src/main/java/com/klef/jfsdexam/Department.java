package com.klef.jfsdexam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "hod_name")
    private String hodName;

    @Column(name = "location")
    private String location;

    // Getters and Setters
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
               "deptId=" + deptId +
               ", name='" + name + '\'' +
               ", hodName='" + hodName + '\'' +
               ", location='" + location + '\'' +
               '}';
    }
}
