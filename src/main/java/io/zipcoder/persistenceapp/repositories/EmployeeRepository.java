package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
