create table t_contact
(
    con_id    int auto_increment
        primary key,
    con_name  varchar(10)            not null comment '联系人名字',
    con_sex   varchar(3)  default '' null comment '联系人性别',
    con_job   varchar(20) default '' null comment '联系人职位',
    con_tel   varchar(11) default '' null comment '办公电话',
    con_phone varchar(11) default '' null comment '联系人手机号',
    con_note  varchar(200)           null comment '备注',
    cus_id    int                    not null comment '客户编号'
)
    collate = utf8mb4_bin;

create table t_customer
(
    cus_id         int auto_increment comment '客户编号'
        primary key,
    cus_name       varchar(50)                        null comment '客户名称',
    cus_region     int                                null comment '客户地区。1-东北，2-华北，3-西北，4-西南，5-华南，6-华中，7-华东',
    cus_industry   int                                null comment '客户行业. 1-金融，2-房地产，3-商业服务，4-运输物流，
   5-生产，6-政府，7-文化传媒，8-其它',
    cus_level      char                               null comment '客户等级. A-重点客户；B-普通客户；C-非优先客户',
    cus_satisfy    int                                null comment '客户满意度. 1-一级，2-二级，3-三级，4-四级，5-五级',
    cus_credit     int                                null comment '客户信用度. 1-一级，2-二级，3-三级，4-四级，5-五级',
    cus_addr       varchar(100)                       null comment '客户地址',
    cus_zipcode    int                                null comment '客户邮编',
    cus_phone      varchar(50)                        null comment '客户电话',
    cus_fax        varchar(50)                        null comment '客户传真',
    cus_url        varchar(100)                       null comment '客户网址',
    user_id        int                                null comment '客户经理id',
    cus_status     int      default 1                 not null comment '客户状态.1-正常，0-流失',
    cus_createtime datetime default CURRENT_TIMESTAMP not null comment '创建时间，默认当前时间'
)
    collate = utf8mb4_bin;

create table t_role
(
    r_id   int auto_increment
        primary key,
    r_name varchar(50)  not null comment '角色名',
    r_desc varchar(200) null comment '角色描述'
)
    collate = utf8_bin;

create table t_sale_chance
(
    sc_id           int auto_increment
        primary key,
    sc_cusname      varchar(200)                       not null comment '客户名称',
    sc_comming      int                                null comment '机会来源（0促销、1广告、2搜索引擎、3线上咨询、4电话咨询、5邮件咨询、6客户介绍）',
    sc_name         varchar(50)                        null comment '联系人',
    sc_phone        varchar(20)                        null comment '联系电话',
    sc_success      varchar(20)                        null comment '成功几率(%)',
    sc_message      varchar(300)                       null comment '概要',
    sc_desc         varchar(200)                       null comment '机会描述',
    sc_createuserid int                                null comment '创建人',
    sc_createtime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    sc_giveuserid   int                                null comment '指派给谁',
    sc_givetime     datetime                           null comment '指派时间',
    sc_status       int      default 0                 not null comment '状态（0未分配、1已分配、2开发成功、3开发失败、4开发中）'
)
    collate = utf8mb4_bin;

create table t_user
(
    u_id       int auto_increment
        primary key,
    u_name     varchar(50) not null,
    u_password varchar(50) not null,
    r_id       int         not null,
    constraint t_user_ibfk_1
        foreign key (r_id) references t_role (r_id)
)
    collate = utf8_bin;

create index role_id
    on t_user (r_id);


