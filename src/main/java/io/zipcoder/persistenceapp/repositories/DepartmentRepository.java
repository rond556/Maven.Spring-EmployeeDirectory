package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.entities.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
