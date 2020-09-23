package com.orlovsky.mooc_platform.dto;

import com.orlovsky.mooc_platform.model.Author;
import com.orlovsky.mooc_platform.model.CourseStatus;
import com.orlovsky.mooc_platform.model.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private UUID id;
    private String title;
    private String description;
    private Collection<Author> authors;
    private Duration duration;
    private CourseStatus status;
    private List<Step> steps;
    private long price;
}
