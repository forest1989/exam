
    drop table if exists EXAM_TYPE;

    create table EXAM_TYPE (
        EXAM_TYPE_ID varchar(10) not null comment '试题分类ID',
        PARENT_ID varchar(10) comment '父级编号',
        PARENT_IDS text comment '所有父级编号',
        TYPE_NAME varchar(255) comment '分类名称',
        TYPE_CODE varchar(64) comment '分类编码',
        REMARKS varchar(255) comment '备注',
        CREATE_DATE datetime comment '创建时间',
        CREATE_BY varchar(64) comment '创建者',
        UPDATE_BY varchar(64) comment '更新者',
        UPDATE_DATE datetime comment '更新时间',
        DEL_FLAG varchar(1) comment '删除标记',
        primary key (EXAM_TYPE_ID)
    ) comment='ExamType';
