package com.orlovsky.mooc_platform.service;


import com.orlovsky.mooc_platform.model.*;

import java.net.URI;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface EducationalMaterialService {
    // CRUD
    // Create
    void createEmptyCourse(String title,
                           String description,
                           Collection<Author> authors,
                           Duration duration,
                           long price);
    // Read
    Course getCourse(UUID courseId);

    List<Course> getAllCourses();

    TestStep getTestStep(UUID testStepId);

    // Update
    void updateCourseInfo(UUID courseId,
                          String title,
                          String description,
                          Collection<Author> authors,
                          Duration duration,
                          long price);

    void addEducationalStep(UUID courseId,
                            URI educationalMaterialUri);

    void addTestStep(UUID courseId,
                     URI descriptionUri,
                     Collection<TestAnswer> answers,
                     TestAnswer correctAnswer,
                     int score);

    // if it is necessary to edit the course
    void deleteEducationalStep(UUID courseId,
                               EducationalStep educationalStep);

    void deleteTestStep(UUID courseId,
                        TestStep testStep);

    void activateCourse(UUID courseId);

    void deactivateCourse(UUID courseId);

    void deleteCourse(UUID courseId);


}
