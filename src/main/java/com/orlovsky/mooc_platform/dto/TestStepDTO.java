package com.orlovsky.mooc_platform.dto;

import com.orlovsky.mooc_platform.model.TestAnswer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.Collection;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestStepDTO {
    private UUID id;
    private UUID courseId;
    private URI descriptionUri;
    private Collection<TestAnswer> answers;
    private TestAnswer correctAnswer;
    private int score;
    private int position;
}
