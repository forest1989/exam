
    drop table if exists READING_TEXT;

    create table READING_TEXT (
        READING_ID varchar(10) not null comment '阅读内容ID',
        READING_CODE varchar(64) comment '阅读内容编码',
        READING_IMG text comment '阅读图片内容',
        READING_TEXT text comment '阅读文本内容',
        REMARKS varchar(255) comment '备注',
        CREATE_DATE datetime comment '创建时间',
        CREATE_BY varchar(64) comment '创建者',
        UPDATE_BY varchar(64) comment '更新者',
        UPDATE_DATE datetime comment '更新时间',
        DEL_FLAG varchar(1) comment '删除标记',
        primary key (READING_ID)
    ) comment='ReadingText';
