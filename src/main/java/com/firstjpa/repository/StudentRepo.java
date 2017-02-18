package com.firstjpa.repository;

import com.firstjpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by abhi on 18/02/17.
 */
public interface StudentRepo extends JpaRepository<Student,Integer> {

    List<Student>findAll();
    Student findById(Integer id);
}
