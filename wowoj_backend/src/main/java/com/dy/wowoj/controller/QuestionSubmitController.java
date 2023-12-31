package com.dy.wowoj.controller;

import com.dy.wowoj.common.BaseResponse;
import com.dy.wowoj.common.ErrorCode;
import com.dy.wowoj.common.ResultUtils;
import com.dy.wowoj.exception.BusinessException;
import com.dy.wowoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.dy.wowoj.model.entity.User;
import com.dy.wowoj.service.QuestionSubmitService;
import com.dy.wowoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 收藏 / 取消收藏
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return resultNum 收藏变化数
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能操作
        final User loginUser = userService.getLoginUser(request);
        long result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(result);
    }
}
