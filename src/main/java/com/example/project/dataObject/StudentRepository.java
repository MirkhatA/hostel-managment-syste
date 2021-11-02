package com.example.project.dataObject;

import com.example.project.entities.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    @Override
    public List<Student> findAll();

    public Student findByStudentId(long theId);
}
