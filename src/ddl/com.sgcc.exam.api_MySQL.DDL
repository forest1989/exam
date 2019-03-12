
    drop table if exists AREA;

    create table AREA (
        AREA_ID varchar(10) not null comment '区域ID',
        PARENT_ID varchar(10) comment '父级编号',
        PARENT_IDS text comment '所有父级编号',
        AREA_NAME varchar(255) comment '区域名称',
        AREA_CODE varchar(64) comment '区域编码',
        REMARKS varchar(255) comment '备注',
        CREATE_DATE datetime comment '创建时间',
        CREATE_BY varchar(64) comment '创建者',
        UPDATE_BY varchar(64) comment '更新者',
        UPDATE_DATE datetime comment '更新时间',
        DEL_FLAG varchar(1) comment '删除标记',
        primary key (AREA_ID)
    ) comment='Area';
