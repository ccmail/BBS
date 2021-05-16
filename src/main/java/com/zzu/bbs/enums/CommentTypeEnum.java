package com.zzu.bbs.enums;

public enum CommentTypeEnum {
    POSTING(1),
    COMMENT(2);

    public Integer getType() {
        return type;
    }

    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
