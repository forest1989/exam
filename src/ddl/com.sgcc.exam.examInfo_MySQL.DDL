
    drop table if exists EXAMINFO;

    create table EXAMINFO (
        EXAM_ID varchar(10) not null comment '试题ID',
        STRU_ID varchar(255) comment '组织ID',
        AREA_ID varchar(10) comment '区域ID',
        READING_ID varchar(10) comment '阅读内容ID',
        EXAM_CONTENT_TEXT text comment '试题内容(文本)',
        EXAM_CONTENT_IMG text comment '试题内容(图片)',
        EXAM_ANSWER varchar(64) comment '试题答案',
        ANSWER_ANALYZE text comment '答案解析',
        EXAM_SUBJECT varchar(32) comment '试题类型单选多选',
        EXAM_GRADES varchar(32) comment '难易程度难度等级暂定',
        EXAM_MARK varchar(10) comment '试题分数',
        EXAM_TYPE_ID varchar(10) comment '试题分类ID',
        CREATE_DATE datetime comment '创建时间',
        CREATE_BY varchar(64) comment '创建者',
        UPDATE_BY varchar(64) comment '更新者',
        UPDATE_DATE datetime comment '更新时间',
        DEL_FLAG varchar(1) comment '删除标记',
        primary key (EXAM_ID)
    ) comment='Examinfo';
