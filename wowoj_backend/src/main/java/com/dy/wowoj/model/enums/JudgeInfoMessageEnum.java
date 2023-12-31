package com.dy.wowoj.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum JudgeInfoMessageEnum {

    ACCEPTED("成功", "accepted"),
    WRONG("失败", "wrong"),
    COMPILE_ERROR("编译错误", "compile_error"),
    MEMORY_LIMIT_EXCEEDED("内存限制", "MEMORY_LIMIT_EXCEEDED"),
    TIME_LIMIT_EXCEEDED("时间限制", "TIME_LIMIT_EXCEEDED"),
    PRESENTATION_ERROR("显示错误", "PRESENTATION_ERROR"),
    WAITING("排队中", "WAITING"),
    OUTPUT_LIMIT_EXCEEDED("输出错误", "OUTPUT_LIMIT_EXCEEDED"),
    DANGEROUS_OPERATION("危险操作", "DANGEROUS_OPERATION"),
    RUNTIME_ERROR("运行时间错误", "RUNTIME_ERROR"),
    SYSTEM_ERROR("系统错误", "SYSTEM_ERROR");

    private final String text;

    private final String value;

    JudgeInfoMessageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessageEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessageEnum anEnum : JudgeInfoMessageEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
