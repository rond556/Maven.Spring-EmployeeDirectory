package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.entities.Department;
import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.repositories.DepartmentRepository;
import io.zipcoder.persistenceapp.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department create(Department department){
        return departmentRepository.save(department);
    }

    public Department changeManager(Long id, Employee newEmployeeData) {
        Department originalDepartment = departmentRepository.findOne(id);
        originalDepartment.setManager(newEmployeeData.getManager());
        return departmentRepository.save(originalDepartment);
    }

    public Department changeDepartmentName(Long id, String name) {
        Department originalDepartment = departmentRepository.findOne(id);
        originalDepartment.setDepartmentName(name);
        return departmentRepository.save(originalDepartment);
    }

    public List<Employee> getAllEmployeesInDepartment(Department department){
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Iterable<Employee> allEmployees= employeeService.index();
        List<Employee> results = new ArrayList<>();
        for(Employee e : allEmployees){
            if(e.getDepartmentNumber().equals(department.getDepartmentNumber())){
                results.add(e);
            }
        }
        return results;
    }
}
