package com.orlovsky.mooc_platform.controller;

import com.orlovsky.mooc_platform.model.Author;
import com.orlovsky.mooc_platform.model.Student;
import com.orlovsky.mooc_platform.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping(value = "/students")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        accountService.signUpStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/students")
    public ResponseEntity<?> readStudends(){
        final List<Student> students = accountService.getAllStudents();

        return students != null && !students.isEmpty()
                ?  new ResponseEntity<>(students,HttpStatus.OK)
                :  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/students/{id}")
    public ResponseEntity<?> readStudent(@PathVariable(name = "id") UUID id){
        final Student student = accountService.getStudentById(id);
        return student != null
                ? new ResponseEntity<>(student,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/students/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable(name = "id") UUID id,
                                           @RequestBody Student student){
        final boolean updated = accountService.updateStudent(id,student);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "id") UUID id){
        final boolean deleted = accountService.deleteStudent(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @PostMapping(value = "/authors")
    public ResponseEntity<?> createAuthor(@RequestBody Author author){
        accountService.signUpAuthor(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/authors")
    public ResponseEntity<?> readAuthors(){
        final List<Author> authors = accountService.getAllAuthors();

        return authors != null && !authors.isEmpty()
                ?  new ResponseEntity<>(authors,HttpStatus.OK)
                :  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/authors/{id}")
    public ResponseEntity<?> readAuthor(@PathVariable(name = "id") UUID id){
        final Author author = accountService.getAuthorById(id);
        return author != null
                ? new ResponseEntity<>(author,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/authors/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable(name = "id") UUID id,
                                           @RequestBody Author author){

        final boolean updated = accountService.updateAuthor(id,author);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/authors/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable(name = "id") UUID id){
        final boolean deleted = accountService.deleteAuthor(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
