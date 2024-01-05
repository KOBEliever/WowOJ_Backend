package com.dy.wowoj.judge.codesandbox;

import com.dy.wowoj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.dy.wowoj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.dy.wowoj.judge.codesandbox.impl.ThirdPartySandbox;

/**
 * 代码沙箱工厂(根据传入字符串创建指定代码沙箱实例)
 */
public class CodeSandboxFactory {
    /**
     * 创建代码沙箱实例
     * @param type
     * @return
     */
    public static CodeSandbox newInstance(String type){
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartySandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
