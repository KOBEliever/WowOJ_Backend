package com.dy.wowoj.judge.codesandbox;

import com.dy.wowoj.judge.codesandbox.mode.ExecuteCodeRequest;
import com.dy.wowoj.judge.codesandbox.mode.ExecuteCodeResponse;

/**
 * 代码沙箱
 */
public interface CodeSandbox {
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
