package com.firstjpa.controller;

import com.firstjpa.domain.Student;
import com.firstjpa.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by abhi on 18/02/17.
 */

@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @RequestMapping(value="/savedata")
    public ResponseEntity<?> save(@RequestBody Student student){

        ResponseEntity<String> entity=null;

        studentRepo.save(student);

        entity=new ResponseEntity<String>("Saved", HttpStatus.OK);
        return entity;
    }


    @RequestMapping(value="/getdata/{id}/{name}")
    public ResponseEntity<?> get(@PathVariable Integer id,@PathVariable String name){

        ResponseEntity<String> entity=null;

        Student stu=studentRepo.findById(id);
        //studentRepo.delete(stu);

        stu.setName(name);

        studentRepo.save(stu);

        entity=new ResponseEntity<String>("Data updated", HttpStatus.OK);
        return entity;
    }
}
