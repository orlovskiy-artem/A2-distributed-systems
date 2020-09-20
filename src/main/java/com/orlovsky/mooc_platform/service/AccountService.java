package com.orlovsky.mooc_platform.service;

import com.orlovsky.mooc_platform.model.Student;
import com.orlovsky.mooc_platform.model.Author;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    void signUpStudent(Student student);

    void signUpAuthor(Author author);

    Student getStudentById(UUID studentId);

    Author getAuthorById(UUID authorId);

    List<Student> getAllStudents();

    List<Author> getAllAuthors();

    boolean updateStudent(UUID studentId,Student student);

    boolean updateAuthor(UUID authorId, Author author);

    boolean deleteStudent(UUID studentId);

    boolean deleteAuthor(UUID authorId);


}
