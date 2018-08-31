package com.tutorialspoint.eclipselink.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

    @Id
    @Column(name="dep_id")
    private int id;

    private String name;

    @OneToMany(mappedBy="department", cascade = CascadeType.ALL) // mappedBy field name should map to Department variable in Employee class
    private List<Employee> employeeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String deptName) {
        this.name = deptName;
    }

    public List<Employee> getEmployeelist() {
        return employeeList;
    }

    public void setEmployeelist(List<Employee> employeelist) {
        this.employeeList = employeelist;
    }

}
