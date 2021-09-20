package com.prashant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
