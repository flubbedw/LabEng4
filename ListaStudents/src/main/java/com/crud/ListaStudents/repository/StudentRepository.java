package com.crud.ListaStudents.repository;

import com.crud.ListaStudents.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}