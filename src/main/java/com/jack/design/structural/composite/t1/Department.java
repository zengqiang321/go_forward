package com.jack.design.structural.composite.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manchong on 2020/4/9.
 */
public class Department {

    private String name;//部门名称

    private Employee leader;//部门领导

    private List<Department> subDepartMent = new ArrayList<>();

    List<Employee> employeeList = new ArrayList<Employee>();


    public Department (String name) {
        this.name = name;
    }

    public void addSubDepartMent(Department department) {
        subDepartMent.add(department);
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
       // addEmployee(leader);
    }

    public List<Department> getSubDepartMent(){
        return this.subDepartMent;
    }

    public List<Employee> getEmployeeList(){
        return this.employeeList;
    }
}
