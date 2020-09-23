package com.orlovsky.mooc_platform.controller;

import com.orlovsky.mooc_platform.dto.CourseDTO;
import com.orlovsky.mooc_platform.model.Course;
import com.orlovsky.mooc_platform.service.EducationalMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.MissingResourceException;
import java.util.UUID;

//@RestController
//@RequestMapping("/courses")
//public class EducationalMaterialController {
//    private final EducationalMaterialService educationalMaterialService;
//
//    @Autowired
//    public EducationalMaterialController(EducationalMaterialService
//             educationalMaterialService){
//        this.educationalMaterialService = educationalMaterialService;
//    }
//
//    // CRUD
//    // Create
//    @PostMapping
//    public ResponseEntity<Void> createCourse(@RequestBody CourseDTO body){
//        educationalMaterialService.createEmptyCourse(
//                body.getTitle(),
//                body.getDescription(),
//                body.getAuthors(),
//                body.getDuration(),
//                body.getPrice());
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    // Read
//    @GetMapping("/{id}")
//    public ResponseEntity<Course> getCourse(@PathVariable UUID id){
//        try{
//            Course course = educationalMaterialService.getCourse(id);
//            return new ResponseEntity<>(course,HttpStatus.OK);
//        } catch (MissingResourceException e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity<?> getAllCourses(){
//        List<Course> courses = educationalMaterialService.getAllCourses();
//        return new ResponseEntity<>(courses,HttpStatus.OK);
//    }
//
//    // Update
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<?> updateCourseInfo(@PathVariable(name = "id") UUID id,
//                                              @RequestBody CourseDTO bodyInfo){
//        try {
//            educationalMaterialService.updateCourseInfo(id,
//                    bodyInfo.getTitle(),
//                    bodyInfo.getDescription(),
//                    bodyInfo.getAuthors(),
//                    bodyInfo.getDuration(),
//                    bodyInfo.getPrice());
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (MissingResourceException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//    }
//
//
//
//
//
//
//}
