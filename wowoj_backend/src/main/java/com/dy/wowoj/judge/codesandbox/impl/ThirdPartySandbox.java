package com.dy.wowoj.judge.codesandbox.impl;

import com.dy.wowoj.judge.codesandbox.CodeSandbox;
import com.dy.wowoj.judge.codesandbox.mode.ExecuteCodeRequest;
import com.dy.wowoj.judge.codesandbox.mode.ExecuteCodeResponse;

/**
 * 第三方代码沙箱
 */
public class ThirdPartySandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("ThirdPartySandbox");
        return null;
    }
}
