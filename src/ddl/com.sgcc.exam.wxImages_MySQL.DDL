
    drop table if exists WX_IMAGE_CONF;

    create table WX_IMAGE_CONF (
        ID varchar(10) not null comment '图标序列',
        WX_IDENTIFY varchar(255) comment '图标标识',
        WX_IMAGE varchar(255) comment '图标名称',
        primary key (ID)
    ) comment='微信图标';
