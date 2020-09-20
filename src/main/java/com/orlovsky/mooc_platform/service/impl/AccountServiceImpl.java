package com.orlovsky.mooc_platform.service.impl;


import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.orlovsky.mooc_platform.model.Author;
import com.orlovsky.mooc_platform.model.Student;
import com.orlovsky.mooc_platform.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {
    private final Map<UUID, Student> studentsStorage = new HashMap<>();
    private final Map<UUID, Author> authorsStorage = new HashMap<>();

    private final ObjectIdGenerators.UUIDGenerator studentsIdHolder = new ObjectIdGenerators.UUIDGenerator();
    private final ObjectIdGenerators.UUIDGenerator authorsIdHolder = new ObjectIdGenerators.UUIDGenerator();

    // CRUD
    // Create
    @Override
    public void signUpStudent(Student studentDetails) {

        final UUID studentId = studentsIdHolder.generateId(studentDetails);
        Student student = new Student(studentId,
                studentDetails.getFirstName(),
                studentDetails.getLastName(),
                studentDetails.getDescription());
        studentsStorage.put(studentId, student);
    }

    @Override
    public void signUpAuthor(Author authorDetails) {
        final UUID authorId = authorsIdHolder.generateId(authorDetails);
        Author author = new Author(authorId,
                authorDetails.getFirstName(),
                authorDetails.getLastName(),
                authorDetails.getDescription());
        authorsStorage.put(authorId, author);
    }

    // Read
    @Override
    public Student getStudentById(UUID studentId) {
        return studentsStorage.get(studentId);
    }

    @Override
    public Author getAuthorById(UUID authorId) {
        return authorsStorage.get(authorId);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentsStorage.values());
    }

    @Override
    public List<Author> getAllAuthors() {
        return new ArrayList<>(authorsStorage.values());
    }

    //Update
    @Override
    public boolean updateStudent(UUID studentId, Student studentDetails) {
        if(studentsStorage.containsKey(studentId)){
            Student student = studentsStorage.get(studentId);
            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());
            student.setDescription(studentDetails.getDescription());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAuthor(UUID authorId, Author authorDetails) {
        if(authorsStorage.containsKey(authorId)){
            Author author = authorsStorage.get(authorId);
            author.setFirstName(authorDetails.getFirstName());
            author.setLastName(authorDetails.getLastName());
            author.setDescription(authorDetails.getDescription());
            return true;
        }
        return false;
    }

    //Delete
    @Override
    public boolean deleteStudent(UUID studentId) {
        return studentsStorage.remove(studentId)!=null;
    }

    @Override
    public boolean deleteAuthor(UUID authorId) {
        return authorsStorage.remove(authorId)!=null;
    }




}
