package com.tutorialspoint.eclipselink.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Department;
import com.tutorialspoint.eclipselink.entity.Employee;


public class Service {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        Department department = new Department();
        department.setId(1234);
        department.setName("development");

        // // Create Employee1 Entity
        Employee employee1 = new Employee();
        employee1.setEname("Satish");
        employee1.setSalary(45000.0);
        employee1.setDeg("Technical Writer");
        employee1.setDepartment(department);
        
        //
        //
        // // Create Employee2 Entity
        Employee employee2 = new Employee();
        employee2.setEname("Krishna");
        employee2.setSalary(45000.0);
        employee2.setDeg("Technical Writer");
        employee2.setDepartment(department);
        
        //
        //
        // // Create Employee3 Entity
        Employee employee3 = new Employee();
        employee3.setEname("Masthanvali");
        employee3.setSalary(50000.0);
        employee3.setDeg("Technical Writer");
        employee3.setDepartment(department);
        
        
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

        
        department.setEmployeelist(employeeList);

        em.persist(department);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
