-- auto-generated definition
create table posting
(
    id            int auto_increment
        primary key,
    title         varchar(128)  null comment '������ӵı���',
    description   text          null comment '������ӵ�����
',
    gmt_create    bigint        null comment '����ʱ��',
    gmt_modify    bigint        null comment '����޸�ʱ��',
    creator       int           null comment '������',
    comment_count int default 0 null comment '�ظ���',
    view_count    int default 0 null comment '�Ķ���',
    like_count    int default 0 null comment '������',
    dislike_int   int default 0 null comment '�����',
    tag           varchar(256)  null
)
    comment '������ӵı�';

