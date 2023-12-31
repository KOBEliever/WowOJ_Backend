package com.dy.wowoj.service;

import com.dy.wowoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.dy.wowoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dy.wowoj.model.entity.User;

/**
* @author dingyi
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

}
