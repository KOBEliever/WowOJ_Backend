package com.dy.wowoj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dy.wowoj.common.ErrorCode;
import com.dy.wowoj.exception.BusinessException;
import com.dy.wowoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.dy.wowoj.model.entity.Question;
import com.dy.wowoj.model.entity.QuestionSubmit;
import com.dy.wowoj.model.entity.User;
import com.dy.wowoj.model.enums.QuestionSubmitLanguageEnum;
import com.dy.wowoj.model.enums.QuestionSubmitStatusEnum;
import com.dy.wowoj.service.QuestionService;
import com.dy.wowoj.service.QuestionSubmitService;
import com.dy.wowoj.mapper.QuestionSubmitMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author dingyi
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService{
    @Resource
    private QuestionService questionService;

    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if(languageEnum == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"编程语言错误");
        }
        long questionId = questionSubmitAddRequest.getQuestionId();
        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        long userId = loginUser.getId();
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setLanguage(questionSubmitAddRequest.getLanguage());
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setJudgeInfo("{}");
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setUserId(userId);
        boolean res = this.save(questionSubmit);
        if(!res){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"题目提交异常");
        }
        return questionSubmit.getId();
    }

}




