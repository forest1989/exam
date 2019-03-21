
    alter table AUTOMATIC_RULE 
        drop 
        foreign key FKC66594B0C33095CE;

    alter table MANUAL_RULE 
        drop 
        foreign key FK6F93D7D5C33095CE;

    drop table if exists AUTOMATIC_RULE;

    drop table if exists MANUAL_RULE;

    drop table if exists TEST_PAPER;

    create table AUTOMATIC_RULE (
        AUTOMATIC_RULE_ID varchar(10) not null comment '自动规则试卷内容',
        TEST_PAPER_ID varchar(10),
        EXAM_TYPE_ID varchar(10) comment '试题类型ID',
        EXAM_COUNT varchar(100) comment '试题道数',
        DEL_FLAG varchar(1) comment '删除标记',
        primary key (AUTOMATIC_RULE_ID)
    ) comment='AutomaticRule';

    create table MANUAL_RULE (
        MANUAL_RULE_ID varchar(10) not null comment '手动规则试卷内容',
        TEST_PAPER_ID varchar(10),
        EXAM_TYPE_ID varchar(10) comment '试题类型ID',
        EXAM_IDS varchar(100) comment '试题ID集合',
        DEL_FLAG varchar(1) comment '删除标记',
        primary key (MANUAL_RULE_ID)
    ) comment='ManualRule';

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

    alter table AUTOMATIC_RULE 
        add index FKC66594B0C33095CE (TEST_PAPER_ID), 
        add constraint FKC66594B0C33095CE 
        foreign key (TEST_PAPER_ID) 
        references TEST_PAPER (TEST_PAPER_ID);

    alter table MANUAL_RULE 
        add index FK6F93D7D5C33095CE (TEST_PAPER_ID), 
        add constraint FK6F93D7D5C33095CE 
        foreign key (TEST_PAPER_ID) 
        references TEST_PAPER (TEST_PAPER_ID);
