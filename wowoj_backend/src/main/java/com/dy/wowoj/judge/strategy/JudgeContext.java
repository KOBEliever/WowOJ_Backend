package com.dy.wowoj.judge.strategy;

import com.dy.wowoj.model.dto.question.JudgeCase;
import com.dy.wowoj.model.dto.questionsubmit.JudgeInfo;
import com.dy.wowoj.model.entity.Question;
import com.dy.wowoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
