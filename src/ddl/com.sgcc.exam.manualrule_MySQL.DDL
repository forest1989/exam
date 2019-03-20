
    drop table if exists MANUAL_RULE;

    create table MANUAL_RULE (
        MANUAL_RULE_ID varchar(10) not null comment '手动规则试卷内容',
        TEST_PAPER_ID varchar(10) comment '试卷ID',
        EXAM_TYPE_ID varchar(10) comment '试题类型ID',
        EXAM_IDS varchar(100) comment '试题ID集合',
        DEL_FLAG varchar(1) comment '删除标记',
        primary key (MANUAL_RULE_ID)
    ) comment='ManualRule';
