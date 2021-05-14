package com.in28minutes.springboot.rest.example.springboot2restservicebasic.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	

}
