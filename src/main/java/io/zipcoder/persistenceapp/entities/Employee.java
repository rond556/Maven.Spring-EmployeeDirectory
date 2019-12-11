package io.zipcoder.persistenceapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    Long employeeNumber;

    Date hireDate = new Date();
    String firstName;
    String lastName;
    String title;
    String phoneNumber;
    String email;

    @ManyToOne
    Employee manager;
    Long departmentNumber;

    public Employee() {
    }

    public Employee(Date hireDate, String firstName, String lastName, String title, String phoneNumber, String email,
                    Employee manager, Long departmentNumber) {
        this.hireDate = hireDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.manager = manager;
        this.departmentNumber = departmentNumber;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Long getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Long departmentNumber) {
        this.departmentNumber = departmentNumber;
    }
}
