package com.orlovsky.mooc_platform.service.impl;


import com.orlovsky.mooc_platform.model.*;
import com.orlovsky.mooc_platform.service.AccountService;
import com.orlovsky.mooc_platform.service.AutoCheckService;
import com.orlovsky.mooc_platform.service.CourseProgressService;
import com.orlovsky.mooc_platform.service.EducationalMaterialService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.*;

// Will be implemented in next commit
@Service
public class CourseProgressServiceImpl implements CourseProgressService {
    // this format for next line: Map<CourseId, Set<StudentId>>
    private final Map<UUID, Set<UUID>> registrationStorage = new LinkedHashMap<>();
    // this format for next line: Map<StudentId, Map<CourseId,List<StepId>>>
    private final Map<UUID, Map<UUID, List<UUID>>> progressStorage = new HashMap<>();
    // will be used for analytics
    private final List<CourseAction> timedActionsStorage = new LinkedList<>();

    // will be deleted in REST API step?
    private AutoCheckService autoCheckService;
    private EducationalMaterialService educationalMaterialService;
    private AccountService accountService;


    @Override
    public void signUpUser(UUID courseId,
                           UUID studentId) {
        Set<UUID> studentsIds = registrationStorage.computeIfAbsent(courseId, k -> new HashSet<>());
        studentsIds.add(studentId);
        System.out.println("Student is signed up now");
    }

    @Override
    public void setAutoCheckService(AutoCheckService autoCheckService) {
        this.autoCheckService = autoCheckService;
    }

    @Override
    public void setEducationalMaterialService(EducationalMaterialService educationalMaterialService) {
        this.educationalMaterialService = educationalMaterialService;
    }

    @Override
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }




    @Override
    public void setStartProgress(UUID courseId,
                                 UUID studentId) {
        Map<UUID, List<UUID>> studentProgress = progressStorage.computeIfAbsent(studentId, k -> new HashMap<>());
        List<UUID> progressInSteps = new ArrayList<>();
        studentProgress.put(courseId, progressInSteps);
        System.out.println("Progress is initialized");
    }

    @Override
    public void makePassedEducationalStep(UUID courseId,
                                          UUID studentId,
                                          UUID educationalStepId) {
        Map<UUID, List<UUID>> studentProgress = progressStorage.get(studentId);
        studentProgress.get(courseId).add(educationalStepId);
        CourseAction courseAction = buildCourseAction(courseId, studentId, ActionType.SEEN, 0);
        timedActionsStorage.add(courseAction);
        System.out.println("Educational step is passed");
    }

    @Override
    public void makeProcessedTestStep(UUID courseId,
                                      UUID studentId,
                                      UUID testStepId,
                                      TestAnswer chosenTestAnswer) {
        TestStep testStep = educationalMaterialService.getTestStepById(testStepId);
        Map<UUID, List<UUID>> studentProgress = progressStorage.get(studentId);
        ActionType receivedActionType = autoCheckService.checkTestTask(testStep, chosenTestAnswer);
        CourseAction courseAction = buildCourseAction(courseId, studentId, receivedActionType, testStep.getScore());
        timedActionsStorage.add(courseAction);
        if (receivedActionType == ActionType.PASSED) {
            studentProgress.get(courseId).add(testStepId);
        }
    }

    @Override
    public Step getCurrentStep(UUID courseId,
                               UUID studentId) {
//        Will be implemented in next commit
        return null;
    }

    @Override
    public void congratulateStudent(Student student,
                                    Course course) {
        String congratulation = "Congratulations," + student.getFirstName() + " " + student.getLastName() +
                ",! You've done well. You've already finished course " + course.getTitle();
        System.out.println(congratulation);
    }


    @Override
    public CourseAction buildCourseAction(UUID courseId,
                                          UUID studentId,
                                          ActionType actionType,
                                          Integer score) {
        ZonedDateTime actionTime = ZonedDateTime.now();
        switch (actionType) {
            case SEEN:
                return new CourseAction(courseId,
                        studentId,
                        actionType,
                        actionTime,
                        0);
            case TRIED:
                return new CourseAction(courseId,
                        studentId,
                        actionType,
                        actionTime,
                        0);
            case PASSED:
                return new CourseAction(courseId,
                        studentId,
                        actionType,
                        actionTime,
                        score);
            default:
                throw new RuntimeException("No such a case for actionType:" + actionType.name());
        }
    }


}
