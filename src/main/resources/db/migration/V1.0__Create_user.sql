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


# flyway�Ǳ���sql�ļ�������ʽ:
#V${�汾��}__${����}_${����}