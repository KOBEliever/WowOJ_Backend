package com.dy.wowoj.judge;

import com.dy.wowoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题服务
 */
@Service
public interface JudgeService {
    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
