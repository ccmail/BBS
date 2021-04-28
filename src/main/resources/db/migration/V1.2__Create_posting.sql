-- auto-generated definition
create table posting
(
    id            int auto_increment
        primary key,
    title         varchar(128)  null comment '存放帖子的标题',
    description   text          null comment '存放帖子的内容
',
    gmt_create    bigint        null comment '发帖时间',
    gmt_modify    bigint        null comment '最后修改时间',
    creator       int           null comment '发帖人',
    comment_count int default 0 null comment '回复数',
    view_count    int default 0 null comment '阅读量',
    like_count    int default 0 null comment '点赞数',
    dislike_int   int default 0 null comment '点踩数',
    tag           varchar(256)  null
)
    comment '存放帖子的表';

