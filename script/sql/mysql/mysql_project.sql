
SET NAMES utf8mb4;

-- ----------------------------
-- 1、项目基本信息表
-- ----------------------------
DROP TABLE IF EXISTS `project_base_info`;
CREATE TABLE `project_base_info` (
                                     `project_id` bigint NOT NULL AUTO_INCREMENT COMMENT '项目id',
                                     `leading_unit` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '项目牵头单位',
                                     `assigned_subject_name` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '承担课题名称',
                                     `project_assignment_serial_no` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '项目任务书编号',
                                     `project_source` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '项目来源',
                                     `project_level` char(2) COLLATE utf8mb4_bin DEFAULT NOT NULL COMMENT '项目级别，0国家级，1省级，2企业级',
                                     `has_leading_role` tinyint DEFAULT NULL COMMENT '是否是牵头单位，1是，0否',
                                     `assigned_subject_section` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '负责课题',
                                     `subject_assignment_serial_no` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '课题任务书编号',
                                     `project_establish_time` date DEFAULT NULL COMMENT '立项日期',
                                     `project_scheduled_completion_time` date DEFAULT NULL COMMENT '项目计划验收时间',
                                     `project_duration` varchar(50) DEFAULT NULL COMMENT '项目执行时间（年）',
                                     `project_description` varchar(1000) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '项目简介',
                                     `significance_and_necessity` varchar(2000) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '意义及必要性',
                                     `project_progress_status` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '项目推进情况',
                                     `completion_progress` varchar(2000) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '完成进度',
                                     `collaborating_unit` varchar(300) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '合作单位',
                                     `expert_team` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '涉及专家、团队',
                                     `has_cooperative_unit` tinyint DEFAULT NULL COMMENT '有无合作单位，1有，0无',
                                     `award_details` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '获奖情况（项）',
                                     `publication_details` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '论文情况（项）',
                                     `patent_details` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '专利情况',
                                     `software_copyright_details` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '软著情况',
                                     `standard_details` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标准情况',
                                     `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                     `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                     `create_by` varchar(100) COLLATE utf8mb4_bin DEFAULT '' COMMENT '创建人',
                                     `update_by` varchar(100) COLLATE utf8mb4_bin DEFAULT '' COMMENT '更新人',
                                     `deleted` tinyint DEFAULT '0' COMMENT '是否删除，2删除，0未删除',
                                     PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='项目表';

-- ----------------------------
-- 2、项目成员表
-- ----------------------------
DROP TABLE IF EXISTS `project_user`;
CREATE TABLE `project_user` (
                                `project_id` bigint NOT NULL COMMENT '项目id',
                                `user_id` bigint NOT NULL COMMENT '项目人员id',
                                `project_user_role` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '项目成员角色，0：项目负责人；1：公司负责人；2：部门负责人；3：科研管理负责人；4：普通成员；5：未知角色',
                                PRIMARY KEY (`project_id`,`user_id`,`project_user_role`),
                                KEY `project_user_project_id_index` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目和成员关联表';

-- ----------------------------
-- 3、项目经费预算表
-- ----------------------------

DROP TABLE IF EXISTS `project_funds`;
-- auto-generated definition
create table project_funds
(
    funds_id           bigint auto_increment comment '经费id'
        primary key,
    project_id         bigint                          not null comment '项目id',
    total_funds_all    decimal(12, 6) default 0.000000 null comment '项目经费总额',
    total_funds_zx     decimal(12, 6) default 0.000000 null comment '专项经费总额',
    sbf_zx             decimal(12, 6) default 0.000000 null comment '专项设备费',
    total_funds_zx_zj  decimal(12, 6) default 0.000000 null comment '专项直接费用',
    total_funds_zx_jj  decimal(12, 6) default 0.000000 null comment '专项间接费用',
    total_funds_zc     decimal(12, 6) default 0.000000 null comment '自筹经费总额',
    sbf_zc             decimal(12, 6) default 0.000000 null comment '自筹设备费',
    total_funds_zc_zj  decimal(12, 6) default 0.000000 null comment '自筹直接费用',
    total_funds_zc_jj  decimal(12, 6) default 0.000000 null comment '自筹间接费用',
    sbf_zx_zj          decimal(12, 6) default 0.000000 null comment '设备费_专项_直接',
    sbf_zc_zj          decimal(12, 6) default 0.000000 null comment '设备费_自筹_直接',
    sbf_gzsb_zx_zj     decimal(12, 6) default 0.000000 null comment '设备费_购置设备费_专项_直接',
    sbf_gzsb_zc_zj     decimal(12, 6) default 0.000000 null comment '设备费_购置设备费_自筹_直接',
    sbf_szsb_zx_zj     decimal(12, 6) default 0.000000 null comment '设备费_试制设备费_专项_直接',
    sbf_szsb_zc_zj     decimal(12, 6) default 0.000000 null comment '设备费_试制设备费_自筹_直接',
    sbf_sbgzyzl_zx_zj  decimal(12, 6) default 0.000000 null comment '设备费_设备改造与租赁费_专项_直接',
    sbf_sbgzyzl_zc_zj  decimal(12, 6) default 0.000000 null comment '设备费_设备改造与租赁费_自筹_直接',
    clf_zx_zj          decimal(12, 6) default 0.000000 null comment '材料费_专项_直接',
    clf_zc_zj          decimal(12, 6) default 0.000000 null comment '材料费_自筹_直接',
    kyhdf_zx_zj        decimal(12, 6) default 0.000000 null comment '科研活动费_专项_直接',
    kyhdf_zc_zj        decimal(12, 6) default 0.000000 null comment '科研活动费_自筹_直接',
    kyhdf_zl_zx_zj     decimal(12, 6) default 0.000000 null comment '科研活动费_资料费_专项_直接',
    kyhdf_zl_zc_zj     decimal(12, 6) default 0.000000 null comment '科研活动费_资料费_自筹_直接',
    kyhdf_cshyjg_zx_zj decimal(12, 6) default 0.000000 null comment '科研活动_测试化验加工费_专项_直接',
    kyhdf_cshyjg_zc_zj decimal(12, 6) default 0.000000 null comment '科研活动_测试化验加工费_自筹_直接',
    kyhdf_bg_zx_zj     decimal(12, 6) default 0.000000 null comment '科研活动费_办公费_专项_直接',
    kyhdf_bg_zc_zj     decimal(12, 6) default 0.000000 null comment '科研活动费_办公费_自筹_直接',
    kyhdf_sjybcj_zx_zj decimal(12, 6) default 0.000000 null comment '科研活动费_数据/样本采集费_专项_直接',
    kyhdf_sjybcj_zc_zj decimal(12, 6) default 0.000000 null comment '科研活动费_数据/样本采集费_自筹_直接',
    kyhdf_yscb_zx_zj   decimal(12, 6) default 0.000000 null comment '科研活动费_印刷/出版费_专项_直接',
    kyhdf_yscb_zc_zj   decimal(12, 6) default 0.000000 null comment '科研活动费_印刷/出版费_自筹_直接',
    kyhdf_zscqsw_zx_zj decimal(12, 6) default 0.000000 null comment '科研活动费_知识产权事务费_专项_直接',
    kyhdf_zscqsw_zc_zj decimal(12, 6) default 0.000000 null comment '科研活动费_知识产权事务费_自筹_直接',
    kyhdf_rldl_zx_zj   decimal(12, 6) default 0.000000 null comment '科研活动费_燃料动力费_专项_直接',
    kyhdf_rldl_zc_zj   decimal(12, 6) default 0.000000 null comment '科研活动费_燃料动力费_自筹_直接',
    kyhdf_clsy_zx_zj   decimal(12, 6) default 0.000000 null comment '科研活动费_车辆使用费_专项_直接',
    kyhdf_clsy_zc_zj   decimal(12, 6) default 0.000000 null comment '科研活动费_车辆使用费_自筹_直接',
    kyfwf_zx_zj        decimal(12, 6) default 0.000000 null comment '科研服务费_专项_直接',
    kyfwf_zc_zj        decimal(12, 6) default 0.000000 null comment '科研服务费_自筹_直接',
    kyfwf_zjzx_zx_zj   decimal(12, 6) default 0.000000 null comment '科研服务费_专家咨询费_专项_直接',
    kyfwf_zjzx_zc_zj   decimal(12, 6) default 0.000000 null comment '科研服务费_专家咨询费_自筹_直接',
    kyfwf_cl_zx_zj     decimal(12, 6) default 0.000000 null comment '科研服务费_差旅费_专项_直接',
    kyfwf_cl_zc_zj     decimal(12, 6) default 0.000000 null comment '科研服务费_差旅费_自筹_直接',
    kyfwf_hyhw_zx_zj   decimal(12, 6) default 0.000000 null comment '科研服务费_会议/会务费_专项_直接',
    kyfwf_hyhw_zc_zj   decimal(12, 6) default 0.000000 null comment '科研服务费_会议/会务费_自筹_直接',
    kyfwf_gjhzjl_zx_zj decimal(12, 6) default 0.000000 null comment '科研服务费_国际合作交流_直接',
    kyfwf_gjhzjl_zc_zj decimal(12, 6) default 0.000000 null comment '科研服务费_国际合作交流_自筹_直接',
    kyfwf_gnxz_zx_zj   decimal(12, 6) default 0.000000 null comment '科研服务费_国内协作费_专项_直接',
    kyfwf_gnxz_zc_zj   decimal(12, 6) default 0.000000 null comment '科研服务费_国内协作费_自筹_直接',
    ryhlwbzf_zx_zj     decimal(12, 6) default 0.000000 null comment '人员和劳务补助费_专项_直接',
    ryhlwbzf_zc_zj     decimal(12, 6) default 0.000000 null comment '人员和劳务补助费_自筹_直接',
    jxzc_zx            decimal(12, 6) default 0.000000 null comment '间接费用_绩效支出_专项',
    jxzc_zc            decimal(12, 6) default 0.000000 null comment '间接费用_绩效支出_自筹',
    others_zx          decimal(12, 6) default 0.000000 null comment '间接费用_其他支出_专项',
    others_zc          decimal(12, 6) default 0.000000 null comment '间接费用_其他支出_自筹',
    jfly_zx            decimal(12, 6) default 0.000000 null comment '经费来源_专项',
    jfly_zc            decimal(12, 6) default 0.000000 null comment '经费来源_自筹',
    jfly_qtczbk_zc     decimal(12, 6) default 0.000000 null comment '经费来源_其他财政拨款_自筹',
    jfly_dwzyhbzj_zc   decimal(12, 6) default 0.000000 null comment '经费来源_单位自有货币资金_自筹',
    jfly_qtzj_zc       decimal(12, 6) default 0.000000 null comment '经费来源_其他资金_自筹',
    sbf_zx_jj          decimal(12, 6) default 0.000000 null comment '设备费_专项_间接',
    sbf_zc_jj          decimal(12, 6) default 0.000000 null comment '设备费_自筹_间接',
    sbf_gzsb_zx_jj     decimal(12, 6) default 0.000000 null comment '设备费_购置设备费_专项_间接',
    sbf_gzsb_zc_jj     decimal(12, 6) default 0.000000 null comment '设备费_购置设备费_自筹_间接',
    sbf_szsb_zx_jj     decimal(12, 6) default 0.000000 null comment '设备费_试制设备费_专项_间接',
    sbf_szsb_zc_jj     decimal(12, 6) default 0.000000 null comment '设备费_试制设备费_自筹_间接',
    sbf_sbgzyzl_zx_jj  decimal(12, 6) default 0.000000 null comment '设备费_设备改造与租赁费_专项_间接',
    sbf_sbgzyzl_zc_jj  decimal(12, 6) default 0.000000 null comment '设备费_设备改造与租赁费_自筹_间接',
    clf_zx_jj          decimal(12, 6) default 0.000000 null comment '材料费_专项_间接',
    clf_zc_jj          decimal(12, 6) default 0.000000 null comment '材料费_自筹_间接',
    kyhdf_zx_jj        decimal(12, 6) default 0.000000 null comment '科研活动费_专项_间接',
    kyhdf_zc_jj        decimal(12, 6) default 0.000000 null comment '科研活动费_自筹_间接',
    kyhdf_zl_zx_jj     decimal(12, 6) default 0.000000 null comment '科研活动费_资料费_专项_间接',
    kyhdf_zl_zc_jj     decimal(12, 6) default 0.000000 null comment '科研活动费_资料费_自筹_间接',
    kyhdf_cshyjg_zx_jj decimal(12, 6) default 0.000000 null comment '科研活动_测试化验加工费_专项_间接',
    kyhdf_cshyjg_zc_jj decimal(12, 6) default 0.000000 null comment '科研活动_测试化验加工费_自筹_间接',
    kyhdf_bg_zx_jj     decimal(12, 6) default 0.000000 null comment '科研活动费_办公费_专项_间接',
    kyhdf_bg_zc_jj     decimal(12, 6) default 0.000000 null comment '科研活动费_办公费_自筹_间接',
    kyhdf_sjybcj_zx_jj decimal(12, 6) default 0.000000 null comment '科研活动费_数据/样本采集费_专项_间接',
    kyhdf_sjybcj_zc_jj decimal(12, 6) default 0.000000 null comment '科研活动费_数据/样本采集费_自筹_间接',
    kyhdf_yscb_zx_jj   decimal(12, 6) default 0.000000 null comment '科研活动费_印刷/出版费_专项_间接',
    kyhdf_yscb_zc_jj   decimal(12, 6) default 0.000000 null comment '科研活动费_印刷/出版费_自筹_间接',
    kyhdf_zscqsw_zx_jj decimal(12, 6) default 0.000000 null comment '科研活动费_知识产权事务费_专项_间接',
    kyhdf_zscqsw_zc_jj decimal(12, 6) default 0.000000 null comment '科研活动费_知识产权事务费_自筹_间接',
    kyhdf_rldl_zx_jj   decimal(12, 6) default 0.000000 null comment '科研活动费_燃料动力费_专项_间接',
    kyhdf_rldl_zc_jj   decimal(12, 6) default 0.000000 null comment '科研活动费_燃料动力费_自筹_间接',
    kyhdf_clsy_zx_jj   decimal(12, 6) default 0.000000 null comment '科研活动费_车辆使用费_专项_间接',
    kyhdf_clsy_zc_jj   decimal(12, 6) default 0.000000 null comment '科研活动费_车辆使用费_自筹_间接',
    kyfwf_zx_jj        decimal(12, 6) default 0.000000 null comment '科研服务费_专项_间接',
    kyfwf_zc_jj        decimal(12, 6) default 0.000000 null comment '科研服务费_自筹_间接',
    kyfwf_zjzx_zx_jj   decimal(12, 6) default 0.000000 null comment '科研服务费_专家咨询费_专项_间接',
    kyfwf_zjzx_zc_jj   decimal(12, 6) default 0.000000 null comment '科研服务费_专家咨询费_自筹_间接',
    kyfwf_cl_zx_jj     decimal(12, 6) default 0.000000 null comment '科研服务费_差旅费_专项_间接',
    kyfwf_cl_zc_jj     decimal(12, 6) default 0.000000 null comment '科研服务费_差旅费_自筹_间接',
    kyfwf_hyhw_zx_jj   decimal(12, 6) default 0.000000 null comment '科研服务费_会议/会务费_专项_间接',
    kyfwf_hyhw_zc_jj   decimal(12, 6) default 0.000000 null comment '科研服务费_会议/会务费_自筹_间接',
    kyfwf_gjhzjl_zx_jj decimal(12, 6) default 0.000000 null comment '科研服务费_国际合作交流_间接',
    kyfwf_gjhzjl_zc_jj decimal(12, 6) default 0.000000 null comment '科研服务费_国际合作交流_自筹_间接',
    kyfwf_gnxz_zx_jj   decimal(12, 6) default 0.000000 null comment '科研服务费_国内协作费_专项_间接',
    kyfwf_gnxz_zc_jj   decimal(12, 6) default 0.000000 null comment '科研服务费_国内协作费_自筹_间接',
    ryhlwbzf_zx_jj     decimal(12, 6) default 0.000000 null comment '人员和劳务补助费_专项_间接',
    ryhlwbzf_zc_jj     decimal(12, 6) default 0.000000 null comment '人员和劳务补助费_自筹_间接',
    constraint project_funds_pk
        unique (project_id)
)
    comment '项目经费表';

create index project_funds_project_id_index
    on project_funds (project_id);



-- ----------------------------
-- 4、项目指标表
-- ----------------------------

DROP TABLE IF EXISTS `project_target`;
CREATE TABLE `project_target` (
                                  `target_id` bigint NOT NULL AUTO_INCREMENT COMMENT '指标id',
                                  `project_id` bigint NOT NULL COMMENT '项目id',
                                  `target_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '指标名称',
                                  `midterm_target` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '中期指标值/状态',
                                  `end_target` varchar(200) DEFAULT NULL COMMENT '结束时指标值/状态',
                                  PRIMARY KEY (`target_id`),
                                  KEY `project_target_project_id_index` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1737287645603508227 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目指标';

-- ----------------------------
-- 5、项目附件表
-- ----------------------------

DROP TABLE IF EXISTS `project_attachments`;
CREATE TABLE `project_attachments` (
                                       `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                       `project_id` bigint NOT NULL COMMENT '项目id',
                                       `oss_id` bigint NOT NULL COMMENT '文件oss_id',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目附件表';

-- ----------------------------
-- 6、项目大事纪表
-- ----------------------------

DROP TABLE IF EXISTS `project_milestone`;
CREATE TABLE `project_milestone` (
                                     `milestone_id` bigint NOT NULL AUTO_INCREMENT COMMENT '事纪id',
                                     `project_id` bigint NOT NULL COMMENT '项目id',
                                     `milestone_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '事纪名',
                                     `milestone_remark` varchar(100) DEFAULT NULL COMMENT '事纪描述',
                                     `milestone_date` date DEFAULT NULL COMMENT '大事纪时间',
                                     PRIMARY KEY (`milestone_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1731601395865317473 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目大事纪';

-- ----------------------------
-- 7、项目大事纪附件表
-- ----------------------------

DROP TABLE IF EXISTS `project_milestone_oss`;
CREATE TABLE `project_milestone_oss` (
                                         `milestone_id` bigint NOT NULL COMMENT '项目大事纪id',
                                         `oss_id` bigint NOT NULL COMMENT '文件ossID',
                                         PRIMARY KEY (`milestone_id`,`oss_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='大事记和文件关联表';


-- ----------------------------
-- 8、项目计划表
-- ----------------------------
DROP TABLE IF EXISTS `project_plan`;
create table project_plan
(
    stage_id         bigint auto_increment comment '阶段id'
        primary key,
    project_id       bigint        not null comment '项目Id',
    stage_start_date date          null comment '阶段开始日期',
    stage_end_date   date          null comment '阶段结束日期',
    stage_task       varchar(3000) null comment '阶段任务'
)
    comment '项目计划表';

create index project_plan_project_id_index
    on project_plan (project_id);
-- ----------------------------
-- 9、知识产权表
-- ----------------------------
DROP TABLE IF EXISTS `intellectual_property`;
create table intellectual_property
(
    ip_id        bigint auto_increment comment '知识产权id'
        primary key,
    project_id   bigint       default -1 not null comment '项目id,没有关联项目默认为-1',
    ip_name      varchar(255) default '' not null comment '知识产权名',
    ip_type      tinyint                 null comment '知识产权类别,国内发明专利0、软件著作权1、论文2、标准3',
    ip_status    tinyint                 null comment '知识产权状态,专利受理0，专利授权1，软著已获取2，标准正在申报3，标准已通过4，论文已发表5',
    ip_date      date                    null comment '获得日期',
    create_time  datetime                null comment '创建时间',
    update_time  datetime                null comment '更新时间',
    create_by    varchar(100) default '' null comment '创建人',
    update_by    varchar(100) default '' null comment '更新人',
    deleted      tinyint      default 0  null comment '是否删除，2删除，0未删除'
)
    comment '知识产权表';

-- ----------------------------
-- 9、知识产权和存储对象关联表
-- ----------------------------
DROP TABLE IF EXISTS `ip_oss`;
create table ip_oss
(
    id     bigint auto_increment comment 'id'
        primary key,
    ip_id  bigint not null comment '知识产权id',
    oss_id bigint not null comment '存储对象id'
)
    comment '知识产权和存储对象关联表';

create index ip_oss_ip_id_oss_id_index
    on ip_oss (ip_id, oss_id);
-- ----------------------------
-- 9、知识产权和用户关联表
-- ----------------------------
DROP TABLE IF EXISTS `ip_user`;
create table ip_user
(
    id      bigint not null comment 'id'
        primary key,
    ip_id   bigint not null comment '知识产权id',
    user_id bigint not null comment '成员id'
)
    comment '知识产权和用户关联表';

create index ip_user_ip_id_user_id_index
    on ip_user (ip_id, user_id);

