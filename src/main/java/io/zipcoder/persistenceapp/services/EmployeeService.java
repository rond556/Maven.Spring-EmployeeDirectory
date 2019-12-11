package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> index(){
        return employeeRepository.findAll();
    }

    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee changeManager(Long id, Employee newEmployeeData) {
        Employee originalEmployee = employeeRepository.findOne(id);
        originalEmployee.setManager(newEmployeeData.getManager());
        return employeeRepository.save(originalEmployee);
    }

    public Employee changeInformation(Long id, Employee newEmployeeData) {
        Employee originalEmployee = employeeRepository.findOne(id);
        originalEmployee.setManager(newEmployeeData.getManager());
        originalEmployee.setFirstName(newEmployeeData.getFirstName());
        originalEmployee.setLastName(newEmployeeData.getLastName());
        originalEmployee.setTitle(newEmployeeData.getTitle());
        originalEmployee.setPhoneNumber(newEmployeeData.getPhoneNumber());
        originalEmployee.setPhoneNumber(newEmployeeData.getPhoneNumber());
        originalEmployee.setDepartmentNumber(newEmployeeData.getDepartmentNumber());
        return employeeRepository.save(originalEmployee);
    }

    public List<Employee> getEmployeesUnderManager (Employee manager){
        Iterable<Employee> employeeList = employeeRepository.findAll();
        List<Employee> results = new ArrayList<>();
        for(Employee e : employeeList){
            if(e.getManager().getEmployeeNumber().equals(manager.getEmployeeNumber())){
                results.add(e);
            }
        }
        return results;
    }

    public List<Employee> getManagerHierarchy(Employee employee){
        List<Employee> managers = new ArrayList<>();
        managers.add(employee.getManager());
        while(managers.get(managers.size() - 1).getManager() != null){
            managers.add(managers.get(managers.size() - 1).getManager());
        }
        return managers;
    }

    public List<Employee> getEmployeesWithNoManager(){
        Iterable<Employee> allEmployees = employeeRepository.findAll();
        List<Employee> results = new ArrayList<>();
        for(Employee e : allEmployees){
            if(e.getManager() == null){
                results.add(e);
            }
        }
        return results;
    }


}
