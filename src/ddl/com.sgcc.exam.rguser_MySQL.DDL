
    drop table if exists M_USER;

    create table M_USER (
        M_USER_ID varchar(10) not null comment '用户ID',
        OPEN_ID text comment '微信用户唯一标识',
        AREA_ID varchar(10) comment '归属区域ID',
        NICK_NAME text comment '微信昵称',
        PHOTO_URL text comment '微信头像URL',
        GENDER varchar(1) comment '性别',
        LOGIN_DATE datetime comment '最后登陆时间',
        primary key (M_USER_ID)
    ) comment='MUser';
