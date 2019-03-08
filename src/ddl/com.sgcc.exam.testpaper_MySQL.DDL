
    drop table if exists TEST_PAPER;

    create table TEST_PAPER (
        TEST_PAPER_ID varchar(10) not null comment '试卷ID',
        TEST_PAPER_NAME varchar(64) comment '试卷名称',
        AREA_ID varchar(10) comment '区域ID',
        STRU_ID varchar(255) comment '组织ID',
        ANSWER_TIME datetime comment '答题时间',
        TEST_PAPER_TYPE varchar(1) comment '试卷生成类型(自动手动)',
        REMARKS varchar(255) comment '备注',
        CREATE_DATE datetime comment '创建时间',
        CREATE_BY varchar(64) comment '创建者',
        UPDATE_BY varchar(64) comment '更新者',
        UPDATE_DATE datetime comment '更新时间',
        DEL_FLAG varchar(1) comment '删除标记',
        primary key (TEST_PAPER_ID)
    ) comment='TestPaper';
