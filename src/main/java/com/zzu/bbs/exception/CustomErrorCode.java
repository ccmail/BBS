package com.zzu.bbs.exception;
/*
 * User:程成
 * Date:2021/5/16
 * Time:17:38
 * Description:
 */

public enum CustomErrorCode implements  ICustomErrorCode{
    QUESTION_NOT_FOUND(2001, "当前帖子不存在, 换成其他帖子吧"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论进行回复"),
    NO_LOGIN(2003, "当前操作需要登录，请登陆后重试"),
    SYS_ERROR(2004, "服务器出现了一些问题, 明天再来试试"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "回复的评论不存在"),
    CONTENT_IS_EMPTY(2007, "输入内容不能为空"),
    READ_NOTIFICATION_FAIL(2008, "兄弟你这是读别人的信息呢？"),
    NOTIFICATION_NOT_FOUND(2009, "消息莫非是不翼而飞了？"),
    FILE_UPLOAD_FAIL(2010, "图片上传失败"),
    INVALID_INPUT(2011, "非法输入"),
    INVALID_OPERATION(2012, "兄弟，是不是走错房间了？"),
    INVALID_REQUEST(0x11,"请求出错了");


    private String message;
    private Integer code;

    CustomErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }


    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
