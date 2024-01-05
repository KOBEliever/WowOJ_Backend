package com.dy.wowoj.judge.codesandbox.impl;

import com.dy.wowoj.judge.codesandbox.CodeSandbox;
import com.dy.wowoj.judge.codesandbox.mode.ExecuteCodeRequest;
import com.dy.wowoj.judge.codesandbox.mode.ExecuteCodeResponse;
import com.dy.wowoj.model.dto.questionsubmit.JudgeInfo;
import com.dy.wowoj.model.enums.JudgeInfoMessageEnum;
import com.dy.wowoj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱
 */
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("ExampleCodeSandbox");
        List<String> inputList = executeCodeRequest.getInputList();

        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage(JudgeInfoMessageEnum.ACCEPTED.getValue());
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getValue());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);

        return executeCodeResponse;
    }
}
