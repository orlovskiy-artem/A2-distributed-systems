package com.orlovsky.mooc_platform.service.impl;


import com.orlovsky.mooc_platform.model.ActionType;
import com.orlovsky.mooc_platform.model.TestAnswer;
import com.orlovsky.mooc_platform.model.TestStep;
import com.orlovsky.mooc_platform.service.AutoCheckService;
import org.springframework.stereotype.Service;

@Service
public class AutoCheckServiceImpl implements AutoCheckService {
    @Override
    public ActionType checkTestTask(TestStep testStep,
                                    TestAnswer chosenTestAnswer) {
        // Will be implemented later
        return ActionType.PASSED;
    }
}
