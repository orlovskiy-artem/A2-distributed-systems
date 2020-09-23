package com.orlovsky.mooc_platform.service.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.orlovsky.mooc_platform.model.*;
import com.orlovsky.mooc_platform.service.EducationalMaterialService;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.Duration;
import java.util.*;

@Service
public class EducationalMaterialServiceImpl implements EducationalMaterialService {
    private final Map<UUID, Course> coursesStorage = new HashMap<>();
    private final Map<UUID, EducationalStep> educationalStepStorage = new HashMap<>();
    private final Map<UUID, TestStep> testStepStorage = new HashMap<>();

    private final ObjectIdGenerators.UUIDGenerator coursesHolder = new ObjectIdGenerators.UUIDGenerator();
    private final ObjectIdGenerators.UUIDGenerator educationalStepHolder = new ObjectIdGenerators.UUIDGenerator();
    private final ObjectIdGenerators.UUIDGenerator testStepHolder = new ObjectIdGenerators.UUIDGenerator();

    // CRUD
    // Create
    @Override
    public void createEmptyCourse(String title,
                                  String description,
                                  Collection<Author> authors,
                                  Duration duration,
                                  long price) {
        ArrayList<Step> steps = new ArrayList<>();
        UUID id = UUID.randomUUID();
        Course course = new Course(id,
                title,
                description,
                authors,
                duration,
                CourseStatus.IN_DEVELOPMENT,
                steps,
                price);
        coursesStorage.put(id, course);
    }


    // Read
    @Override
    public Course getCourse(UUID courseId) {
        if(coursesStorage.containsKey(courseId)){
            return coursesStorage.get(courseId);
        } else
            throw new MissingResourceException("Course not found",
                    "Course",courseId.toString());
    }

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(coursesStorage.values());
    }

    @Override
    public TestStep getTestStep(UUID testStepId) {
        return testStepStorage.get(testStepId);
    }

    @Override
    public void updateCourseInfo(UUID courseId,
                                 String title,
                                 String description,
                                 Collection<Author> authors,
                                 Duration duration, long price) {
        if(coursesStorage.containsKey(courseId)){
            Course course = coursesStorage.get(courseId);
            course.setTitle(title);
            course.setDescription(description);
            course.setAuthors(authors);
            course.setDuration(duration);
            course.setPrice(price);
        } else
            throw new MissingResourceException("Course not found",
                    "Course",courseId.toString());
    }


    // Update
    @Override
    public void activateCourse(UUID courseId) {
        Course course = coursesStorage.get(courseId);
        course.setStatus(CourseStatus.ACTIVE);
        System.out.println(course.getTitle() + " course is activated");
    }

    @Override
    public void deactivateCourse(UUID courseId) {
        Course course = coursesStorage.get(courseId);
        course.setStatus(CourseStatus.DEPRECATED);
        System.out.println(course.getTitle() + " course is deprecated");
    }

    @Override
    public void addEducationalStep(UUID courseId,
                                   URI educationalMaterialUri) {
        Course course = coursesStorage.get(courseId);
        UUID stepId = UUID.randomUUID();
        EducationalStep educationalStep = new EducationalStep(
                stepId,
                courseId,
                educationalMaterialUri);
        course.getSteps().add(educationalStep);
        educationalStepStorage.put(educationalStep.getId(), educationalStep);
    }

    @Override
    public void addTestStep(UUID courseId,
                            URI descriptionUri,
                            Collection<TestAnswer> answers,
                            TestAnswer correctAnswer,
                            int score) {
        Course course = coursesStorage.get(courseId);
        UUID stepId = UUID.randomUUID();
        TestStep testStep = new TestStep(
                stepId,
                course.getId(),
                descriptionUri,
                answers,
                correctAnswer,
                score);
        course.getSteps().add(testStep);
        testStepStorage.put(testStep.getId(), testStep);
    }

    @Override
    public void deleteTestStep(UUID courseId,
                               TestStep testStep) {
        Course course = coursesStorage.get(courseId);
        course.getSteps().remove(testStep);
        testStepStorage.remove(testStep.getId());
    }


    @Override
    public void deleteCourse(UUID courseId) {
        Course course = coursesStorage.remove(courseId);
    }

    // Delete
    @Override
    public void deleteEducationalStep(UUID courseId,
                                      EducationalStep educationalStep) {
        Course course = coursesStorage.get(courseId);
        course.getSteps().remove(educationalStep);
        educationalStepStorage.remove(educationalStep.getId());
    }
}
