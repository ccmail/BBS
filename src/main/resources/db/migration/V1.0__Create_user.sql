-- auto-generated definition
create table user
(
    id         int auto_increment
        primary key,
    account_id varchar(100) null,
    name       varchar(50)  null,
    token      char(36)     null,
    gmt_create bigint       null,
    gmt_modify bigint       null
);


# flyway是被的sql文件命名格式:
#V${版本号}__${操作}_${表名}