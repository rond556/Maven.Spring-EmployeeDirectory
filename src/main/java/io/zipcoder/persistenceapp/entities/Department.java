package io.zipcoder.persistenceapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Department {
    @Id
    @GeneratedValue
    Long departmentNumber;

    String departmentName;
    @OneToOne
    Employee manager;

    public Department() {
    }

    public Department(String departmentName, Employee manager) {
        this.departmentName = departmentName;
        this.manager = manager;
    }

    public Long getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmenTnumber(Long departmenTnumber) {
        this.departmentNumber = departmenTnumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
