package com.dy.wowoj.judge;

import com.dy.wowoj.judge.strategy.DefaultJudgeStrategy;
import com.dy.wowoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.dy.wowoj.judge.strategy.JudgeContext;
import com.dy.wowoj.judge.strategy.JudgeStrategy;
import com.dy.wowoj.model.dto.questionsubmit.JudgeInfo;
import com.dy.wowoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}

