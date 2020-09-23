package com.orlovsky.mooc_platform.service.impl;


import com.orlovsky.mooc_platform.model.ActionType;
import com.orlovsky.mooc_platform.model.TestAnswer;
import com.orlovsky.mooc_platform.model.TestStep;
import com.orlovsky.mooc_platform.service.AutoCheckService;
import org.springframework.stereotype.Service;

@Service
public class AutoCheckServiceImpl implements AutoCheckService {


    // Now Task Steps are only one-answer tests, so the answers will be checked easily
    // but it's possible to make multitest task (like many correct answers), or essay task

    // Checker knows nothing about student
    @Override
    public ActionType checkTestTask(TestStep testStep,
                                    TestAnswer chosenTestAnswer) {
        ActionType actionType;
        String chosenAnswerText = chosenTestAnswer.getAnswerText();
        String correctAnswerText = testStep.getCorrectAnswer().getAnswerText();
        if (chosenAnswerText.equals(correctAnswerText)) {
            actionType = ActionType.PASSED;
            System.out.println("Correct answer, great!");
        } else {
            actionType = ActionType.TRIED;
            System.out.println("Wrong answer, try again");
        }
        return actionType;
    }
}
