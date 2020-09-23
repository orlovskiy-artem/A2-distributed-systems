package com.orlovsky.mooc_platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private UUID id;
    private String title;
    private String description;
    private Collection<Author> authors;
    private Duration duration;
    private CourseStatus status;
    private List<Step> steps;
    private long price;

//    public Collection<Author> getAuthors() {
//        return authors;
//    }
//
//    public void setAuthors(Collection<Author> authors) throws IllegalArgumentException {
//        if (authors.isEmpty()) {
//            throw new IllegalArgumentException("Number of authors must be more than 1!");
//        }
//        this.authors = authors;
//    }
//
//
//    public List<Step> getSteps() {
//        return steps;
//    }
//
//    public void setSteps(List<Step> steps) throws Exception {
//        if (steps.isEmpty()) {
//            throw new Exception("Number of steps must be more than 1!");
//        }
//        this.steps = steps;
//    }
//
//    public CourseStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(CourseStatus status) {
//        this.status = status;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) { this.title = title; }
//
//    public Duration getDuration() {
//        return duration;
//    }
//
//    public void setDuration(Duration duration) {
//        this.duration = duration;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) throws IllegalArgumentException {
//        if (description.isBlank()) {
//            throw new IllegalArgumentException("Description must contain some information.");
//        }
//        this.description = description;
//    }
//
//    public long getPrice() {
//        return price;
//    }
//
//    public void setPrice(long price) {this.price = price;}
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Course course = (Course) o;
//        return id.equals(course.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//
//    @Override
//    public String toString() {
//        return "Course{" +
//                "platformId=" + id +
//                ", title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                ", authors=" + authors +
//                ", duration=" + duration +
//                ", status=" + status +
//                ", steps=" + steps +
//                ", price=" + price +
//                '}';
//    }
}
