package com.orlovsky.mooc_platform.service;

import com.orlovsky.mooc_platform.model.ActionType;
import com.orlovsky.mooc_platform.model.TestAnswer;
import com.orlovsky.mooc_platform.model.TestStep;

public interface AutoCheckService {
    ActionType checkTestTask(TestStep testStep,
                             TestAnswer chosenTestAnswer);
}
