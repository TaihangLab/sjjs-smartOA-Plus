
SET NAMES utf8mb4;

-- ----------------------------
-- 1、项目基本信息表
-- ----------------------------
DROP TABLE IF EXISTS `project_base_info`;
create table project_base_info
(
    project_id                        bigint auto_increment comment '项目id'
        primary key,
    leading_unit                      varchar(100)            null comment '项目牵头单位',
    assigned_subject_name             varchar(200)            null comment '承担课题名称',
    project_contact                   varchar(100)            null comment '科研项目管理人',
    project_assignment_serial_no      varchar(50)             null comment '项目任务书编号',
    project_source                    varchar(100)            null comment '项目来源',
    project_level                     tinyint                 not null comment '项目级别，0国家级，1省级，2企业级',
    has_leading_role                  tinyint                 null comment '是否是牵头单位，1是，0否',
    assigned_subject_section          varchar(200)            null comment '负责课题',
    subject_assignment_serial_no      varchar(50)             null comment '课题任务书编号',
    project_establish_time            date                    null comment '立项日期',
    project_scheduled_completion_time date                    null comment '项目计划验收时间',
    project_duration                  varchar(50)             null comment '项目执行时间（年）',
    project_description               varchar(3000)           null comment '项目简介',
    significance_and_necessity        varchar(2000)           null comment '意义及必要性',
    project_progress_status           tinyint                 null comment '项目推进情况，0正在需求申报，1已完成需求申报，2正在项目申报，3已完成项目申报，4已签订任务书并推进中，5已完成中期评审，6已完成项目验收',
    completion_progress               varchar(2000)           null comment '完成进度',
    collaborating_unit                varchar(300)            null comment '合作单位',
    expert_team                       varchar(200)            null comment '涉及专家、团队',
    has_cooperative_unit              tinyint                 null comment '有无合作单位，1有，0无',
    award_details                     varchar(500)            null comment '获奖情况（项）',
    publication_details               varchar(500)            null comment '论文情况（项）',
    patent_details                    varchar(500)            null comment '专利情况',
    software_copyright_details        varchar(500)            null comment '软著情况',
    standard_details                  varchar(500)            null comment '标准情况',
    create_time                       datetime                null comment '创建时间',
    update_time                       datetime                null comment '更新时间',
    create_by                         varchar(100) default '' null comment '创建人',
    update_by                         varchar(100) default '' null comment '更新人',
    deleted                           tinyint      default 0  null comment '是否删除，2删除，0未删除'
)
    comment '项目表';

-- ----------------------------
-- 2、项目成员表
-- ----------------------------
DROP TABLE IF EXISTS `project_user`;
create table project_user
(
    project_id        bigint     not null comment '项目id',
    user_id           bigint     not null comment '项目人员id',
    project_user_role varchar(5) not null comment '项目成员角色，0：项目负责人；1：公司负责人；2：部门负责人；3：科研管理负责人；4：普通成员；5：未知角色',
    primary key (project_id, user_id, project_user_role)
)
    comment '项目和成员关联表' charset = utf8mb4;

create index project_user_project_id_index
    on project_user (project_id);

-- ----------------------------
-- 3、项目经费预算表
-- ----------------------------

DROP TABLE IF EXISTS `project_funds`;
-- auto-generated definition
create table project_funds
(
    funds_id                          bigint auto_increment comment '经费id'
        primary key,
    project_id                        bigint                          not null comment '项目id',
    total_funds_all                   decimal(12, 6) default 0.000000 null comment '项目经费总额',
    total_funds_zx                    decimal(12, 6) default 0.000000 null comment '专项经费总额',
    total_funds_zx_dk                 decimal(12, 6) default 0.000000 null comment '专项到款总额',
    zctz_done                         decimal(12, 6) default 0.000000 null comment '已完成自筹投资',
    zxtz_done                         decimal(12, 6) default 0.000000 null comment '已完成专项投资',
    zc_gspt                           decimal(12, 6) default 0.000000 null comment '自筹经费公司配套',
    zx_gslc                           decimal(12, 6) default 0.000000 null comment '专项经费公司留存（计划）',
    sbf_zx                            decimal(12, 6) default 0.000000 null comment '专项设备费',
    total_funds_zx_zj                 decimal(12, 6) default 0.000000 null comment '专项直接费用',
    total_funds_zx_jj                 decimal(12, 6) default 0.000000 null comment '专项间接费用',
    total_funds_zc                    decimal(12, 6) default 0.000000 null comment '自筹经费总额',
    sbf_zc                            decimal(12, 6) default 0.000000 null comment '自筹设备费',
    total_funds_zc_zj                 decimal(12, 6) default 0.000000 null comment '自筹直接费用',
    total_funds_zc_jj                 decimal(12, 6) default 0.000000 null comment '自筹间接费用',
    sbf_zx_zj                         decimal(12, 6) default 0.000000 null comment '设备费_专项_直接',
    sbf_zc_zj                         decimal(12, 6) default 0.000000 null comment '设备费_自筹_直接',
    sbf_gzsb_zx_zj                    decimal(12, 6) default 0.000000 null comment '设备费_购置设备费_专项_直接',
    sbf_gzsb_zc_zj                    decimal(12, 6) default 0.000000 null comment '设备费_购置设备费_自筹_直接',
    sbf_szsb_zx_zj                    decimal(12, 6) default 0.000000 null comment '设备费_试制设备费_专项_直接',
    sbf_szsb_zc_zj                    decimal(12, 6) default 0.000000 null comment '设备费_试制设备费_自筹_直接',
    sbf_sbsjgz_zx_zj                  decimal(12, 6) default 0.000000 null comment '设备费_设备升级改造费_专项_直接',
    sbf_sbsjgz_zc_zj                  decimal(12, 6) default 0.000000 null comment '设备费_设备升级改造费_自筹_直接',
    sbf_sbzl_zx_zj                    decimal(12, 6) default 0.000000 null comment '设备费_设备租赁费_专项_直接',
    sbf_sbzl_zc_zj                    decimal(12, 6) default 0.000000 null comment '设备费_设备租赁费_自筹_直接',
    ywf_zx_zj                         decimal(12, 6) default 0.000000 null comment '业务费_专项_直接',
    ywf_zc_zj                         decimal(12, 6) default 0.000000 null comment '业务费_自筹_直接',
    ywf_clf_zx_zj                     decimal(12, 6) default 0.000000 null comment '业务费_材料费_专项_直接',
    ywf_clf_zc_zj                     decimal(12, 6) default 0.000000 null comment '业务费_材料费_自筹_直接',
    ywf_zlf_zx_zj                     decimal(12, 6) default 0.000000 null comment '业务费_资料费_专项_直接',
    ywf_zlf_zc_zj                     decimal(12, 6) default 0.000000 null comment '业务费_资料费_自筹_直接',
    ywf_sjybcjf_zx_zj                 decimal(12, 6) default 0.000000 null comment '业务费_数据样本采集费_专项_直接',
    ywf_sjybcjf_zc_zj                 decimal(12, 6) default 0.000000 null comment '业务费_数据样本采集费_自筹_直接',
    ywf_cshyjgf_zx_zj                 decimal(12, 6) default 0.000000 null comment '业务费_测试化验加工费_专项_直接',
    ywf_cshyjgf_zc_zj                 decimal(12, 6) default 0.000000 null comment '业务费_测试化验加工费_自筹_直接',
    ywf_rldlf_zx_zj                   decimal(12, 6) default 0.000000 null comment '业务费_燃料动力费_专项_直接',
    ywf_rldlf_zc_zj                   decimal(12, 6) default 0.000000 null comment '业务费_燃料动力费_自筹_直接',
    ywf_bgf_zx_zj                     decimal(12, 6) default 0.000000 null comment '业务费_办公费_专项_直接',
    ywf_bgf_zc_zj                     decimal(12, 6) default 0.000000 null comment '业务费_办公费_自筹_直接',
    ywf_yscbf_zx_zj                   decimal(12, 6) default 0.000000 null comment '业务费_印刷出版费_专项_直接',
    ywf_yscbf_zc_zj                   decimal(12, 6) default 0.000000 null comment '业务费_印刷出版费_自筹_直接',
    ywf_zscqswf_zx_zj                 decimal(12, 6) default 0.000000 null comment '业务费_知识产权事务费_专项_直接',
    ywf_zscqswf_zc_zj                 decimal(12, 6) default 0.000000 null comment '业务费_知识产权事务费_自筹_直接',
    ywf_clsyf_zx_zj                   decimal(12, 6) default 0.000000 null comment '业务费_车辆使用费_专项_直接',
    ywf_clsyf_zc_zj                   decimal(12, 6) default 0.000000 null comment '业务费_车辆使用费_自筹_直接',
    ywf_chlf_zx_zj                    decimal(12, 6) default 0.000000 null comment '业务费_差旅费_专项_直接',
    ywf_chlf_zc_zj                    decimal(12, 6) default 0.000000 null comment '业务费_差旅费_自筹_直接',
    ywf_hyhwf_zx_zj                   decimal(12, 6) default 0.000000 null comment '业务费_会议会务费_专项_直接',
    ywf_hyhwf_zc_zj                   decimal(12, 6) default 0.000000 null comment '业务费_会议会务费_自筹_直接',
    ywf_gnxzf_zx_zj                   decimal(12, 6) default 0.000000 null comment '业务费_国内协作费_专项_直接',
    ywf_gnxzf_zc_zj                   decimal(12, 6) default 0.000000 null comment '业务费_国内协作费_自筹_直接',
    ywf_gjhzjlf_zx_zj                 decimal(12, 6) default 0.000000 null comment '业务费_国际合作交流费_专项_直接',
    ywf_gjhzjlf_zc_zj                 decimal(12, 6) default 0.000000 null comment '业务费_国际合作交流费_自筹_直接',
    ywf_hyclgjhzyjlf_zx_zj            decimal(12, 6) default 0.000000 null comment '业务费_会议/差旅/国际合作与交流费_专项_直接',
    ywf_hyclgjhzyjlf_zc_zj            decimal(12, 6) default 0.000000 null comment '业务费_会议/差旅/国际合作与交流费_自筹_直接 ',
    ywf_hyclgjhzyjlf_hyf_zx_zj        decimal(12, 6) default 0.000000 null comment '业务费_会议/差旅/国际合作与交流费_会议费_专项_直接  ',
    ywf_hyclgjhzyjlf_hyf_zc_zj        decimal(12, 6) default 0.000000 null comment '业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接  ',
    ywf_hyclgjhzyjlf_clf_zx_zj        decimal(12, 6) default 0.000000 null comment '业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接  ',
    ywf_hyclgjhzyjlf_clf_zc_zj        decimal(12, 6) default 0.000000 null comment '业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接  ',
    ywf_hyclgjhzyjlf_gjhzf_zx_zj      decimal(12, 6) default 0.000000 null comment '业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接  ',
    ywf_hyclgjhzyjlf_gjhzf_zc_zj      decimal(12, 6) default 0.000000 null comment '业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接  ',
    ywf_cbwxxxcbzscqswf_zx_zj         decimal(12, 6) default 0.000000 null comment '业务费_出版/文献/信息传播/知识产权事务费_专项_直接',
    ywf_cbwxxxcbzscqswf_zc_zj         decimal(12, 6) default 0.000000 null comment '业务费_出版/文献/信息传播/知识产权事务费_自筹_直接',
    ywf_cbwxxxcbzscqswf_zscqswf_zx_zj decimal(12, 6) default 0.000000 null comment '业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接',
    ywf_cbwxxxcbzscqswf_zscqswf_zc_zj decimal(12, 6) default 0.000000 null comment '业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接',
    ywf_cbwxxxcbzscqswf_ysdyzzf_zx_zj decimal(12, 6) default 0.000000 null comment '业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接',
    ywf_cbwxxxcbzscqswf_ysdyzzf_zc_zj decimal(12, 6) default 0.000000 null comment '业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接',
    ywf_cbwxxxcbzscqswf_wxsjkf_zx_zj  decimal(12, 6) default 0.000000 null comment '业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接',
    ywf_cbwxxxcbzscqswf_wxsjkf_zc_zj  decimal(12, 6) default 0.000000 null comment '业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接',
    ywf_cbwxxxcbzscqswf_xxcbf_zx_zj   decimal(12, 6) default 0.000000 null comment '业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接',
    ywf_cbwxxxcbzscqswf_xxcbf_zc_zj   decimal(12, 6) default 0.000000 null comment '业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接',
    lwf_zx_zj                         decimal(12, 6) default 0.000000 null comment '劳务费_专项_直接',
    lwf_zc_zj                         decimal(12, 6) default 0.000000 null comment '劳务费_自筹_直接',
    lwf_zjzxf_zx_zj                   decimal(12, 6) default 0.000000 null comment '劳务费_专家咨询费_专项_直接',
    lwf_zjzxf_zc_zj                   decimal(12, 6) default 0.000000 null comment '劳务费_专家咨询费_自筹_直接',
    lwf_rylwf_zx_zj                   decimal(12, 6) default 0.000000 null comment '劳务费_人员劳务费_专项_直接',
    lwf_rylwf_zc_zj                   decimal(12, 6) default 0.000000 null comment '劳务费_人员劳务费_自筹_直接',
    clf_zx_zj                         decimal(12, 6) default 0.000000 null comment '材料费_专项_直接',
    clf_zc_zj                         decimal(12, 6) default 0.000000 null comment '材料费_自筹_直接',
    clf_clf_zx_zj                     decimal(12, 6) default 0.000000 null comment '材料费_材料费_专项_直接',
    clf_clf_zc_zj                     decimal(12, 6) default 0.000000 null comment '材料费_材料费_自筹_直接',
    kyhdf_zx_zj                       decimal(12, 6) default 0.000000 null comment '科研活动费_专项_直接',
    kyhdf_zc_zj                       decimal(12, 6) default 0.000000 null comment '科研活动费_自筹_直接',
    kyhdf_zl_zx_zj                    decimal(12, 6) default 0.000000 null comment '科研活动费_资料费_专项_直接',
    kyhdf_zl_zc_zj                    decimal(12, 6) default 0.000000 null comment '科研活动费_资料费_自筹_直接',
    kyhdf_cshyjg_zx_zj                decimal(12, 6) default 0.000000 null comment '科研活动费_测试化验加工费_专项_直接',
    kyhdf_cshyjg_zc_zj                decimal(12, 6) default 0.000000 null comment '科研活动费_测试化验加工费_自筹_直接',
    kyhdf_bg_zx_zj                    decimal(12, 6) default 0.000000 null comment '科研活动费_办公费_专项_直接',
    kyhdf_bg_zc_zj                    decimal(12, 6) default 0.000000 null comment '科研活动费_办公费_自筹_直接',
    kyhdf_sjybcj_zx_zj                decimal(12, 6) default 0.000000 null comment '科研活动费_数据/样本采集费_专项_直接',
    kyhdf_sjybcj_zc_zj                decimal(12, 6) default 0.000000 null comment '科研活动费_数据/样本采集费_自筹_直接',
    kyhdf_yscb_zx_zj                  decimal(12, 6) default 0.000000 null comment '科研活动费_印刷/出版费_专项_直接',
    kyhdf_yscb_zc_zj                  decimal(12, 6) default 0.000000 null comment '科研活动费_印刷/出版费_自筹_直接',
    kyhdf_zscqsw_zx_zj                decimal(12, 6) default 0.000000 null comment '科研活动费_知识产权事务费_专项_直接',
    kyhdf_zscqsw_zc_zj                decimal(12, 6) default 0.000000 null comment '科研活动费_知识产权事务费_自筹_直接',
    kyhdf_rldl_zx_zj                  decimal(12, 6) default 0.000000 null comment '科研活动费_燃料动力费_专项_直接',
    kyhdf_rldl_zc_zj                  decimal(12, 6) default 0.000000 null comment '科研活动费_燃料动力费_自筹_直接',
    kyhdf_clsy_zx_zj                  decimal(12, 6) default 0.000000 null comment '科研活动费_车辆使用费_专项_直接',
    kyhdf_clsy_zc_zj                  decimal(12, 6) default 0.000000 null comment '科研活动费_车辆使用费_自筹_直接',
    kyfwf_zx_zj                       decimal(12, 6) default 0.000000 null comment '科研服务费_专项_直接',
    kyfwf_zc_zj                       decimal(12, 6) default 0.000000 null comment '科研服务费_自筹_直接',
    kyfwf_zjzx_zx_zj                  decimal(12, 6) default 0.000000 null comment '科研服务费_专家咨询费_专项_直接',
    kyfwf_zjzx_zc_zj                  decimal(12, 6) default 0.000000 null comment '科研服务费_专家咨询费_自筹_直接',
    kyfwf_cl_zx_zj                    decimal(12, 6) default 0.000000 null comment '科研服务费_差旅费_专项_直接',
    kyfwf_cl_zc_zj                    decimal(12, 6) default 0.000000 null comment '科研服务费_差旅费_自筹_直接',
    kyfwf_hyhw_zx_zj                  decimal(12, 6) default 0.000000 null comment '科研服务费_会议/会务费_专项_直接',
    kyfwf_hyhw_zc_zj                  decimal(12, 6) default 0.000000 null comment '科研服务费_会议/会务费_自筹_直接',
    kyfwf_gjhzjl_zx_zj                decimal(12, 6) default 0.000000 null comment '科研服务费_国际合作交流_专项_直接',
    kyfwf_gjhzjl_zc_zj                decimal(12, 6) default 0.000000 null comment '科研服务费_国际合作交流_自筹_直接',
    kyfwf_gnxz_zx_zj                  decimal(12, 6) default 0.000000 null comment '科研服务费_国内协作费_专项_直接',
    kyfwf_gnxz_zc_zj                  decimal(12, 6) default 0.000000 null comment '科研服务费_国内协作费_自筹_直接',
    ryhlwbzf_zx_zj                    decimal(12, 6) default 0.000000 null comment '人员和劳务补助费_专项_直接',
    ryhlwbzf_zc_zj                    decimal(12, 6) default 0.000000 null comment '人员和劳务补助费_自筹_直接',
    ryhlwbzf_rylw_zx_zj               decimal(12, 6) default 0.000000 null comment '人员和劳务补助费_人员劳务费_专项_直接',
    ryhlwbzf_rylw_zc_zj               decimal(12, 6) default 0.000000 null comment '人员和劳务补助费_人员劳务费_自筹_直接',
    jxzc_zx_zj                        decimal(12, 6) default 0.000000 null comment '绩效支出_专项_直接',
    jxzc_zc_zj                        decimal(12, 6) default 0.000000 null comment '绩效支出_自筹_直接',
    others_zx                         decimal(12, 6) default 0.000000 null comment '间接费用_其他支出_专项',
    others_zc                         decimal(12, 6) default 0.000000 null comment '间接费用_其他支出_自筹',
    jfly_zx                           decimal(12, 6) default 0.000000 null comment '经费来源_专项',
    jfly_zc                           decimal(12, 6) default 0.000000 null comment '经费来源_自筹',
    jfly_qtczbk_zc                    decimal(12, 6) default 0.000000 null comment '经费来源_其他财政拨款_自筹',
    jfly_dwzyhbzj_zc                  decimal(12, 6) default 0.000000 null comment '经费来源_单位自有货币资金_自筹',
    jfly_qtzj_zc                      decimal(12, 6) default 0.000000 null comment '经费来源_其他资金_自筹',
    sbf_zx_jj                         decimal(12, 6) default 0.000000 null comment '设备费_专项_间接',
    sbf_zc_jj                         decimal(12, 6) default 0.000000 null comment '设备费_自筹_间接',
    sbf_gzsb_zx_jj                    decimal(12, 6) default 0.000000 null comment '设备费_购置设备费_专项_间接',
    sbf_gzsb_zc_jj                    decimal(12, 6) default 0.000000 null comment '设备费_购置设备费_自筹_间接',
    sbf_szsb_zx_jj                    decimal(12, 6) default 0.000000 null comment '设备费_试制设备费_专项_间接',
    sbf_szsb_zc_jj                    decimal(12, 6) default 0.000000 null comment '设备费_试制设备费_自筹_间接',
    sbf_sbsjgz_zx_jj                  decimal(12, 6) default 0.000000 null comment '设备费_设备升级改造费_专项_间接',
    sbf_sbsjgz_zc_jj                  decimal(12, 6) default 0.000000 null comment '设备费_设备升级改造费_自筹_间接',
    sbf_sbzl_zx_jj                    decimal(12, 6) default 0.000000 null comment '设备费_设备租赁费_专项_间接',
    sbf_sbzl_zc_jj                    decimal(12, 6) default 0.000000 null comment '设备费_设备租赁费_自筹_间接',
    lwf_zx_jj                         decimal(12, 6) default 0.000000 null comment '劳务费_专项_间接',
    lwf_zc_jj                         decimal(12, 6) default 0.000000 null comment '劳务费_自筹_间接',
    lwf_zjzxf_zx_jj                   decimal(12, 6) default 0.000000 null comment '劳务费_专家咨询费_专项_间接',
    lwf_zjzxf_zc_jj                   decimal(12, 6) default 0.000000 null comment '劳务费_专家咨询费_自筹_间接',
    lwf_rylwf_zx_jj                   decimal(12, 6) default 0.000000 null comment '劳务费_人员劳务费_专项_间接',
    lwf_rylwf_zc_jj                   decimal(12, 6) default 0.000000 null comment '劳务费_人员劳务费_自筹_间接',
    clf_zx_jj                         decimal(12, 6) default 0.000000 null comment '材料费_专项_间接',
    clf_zc_jj                         decimal(12, 6) default 0.000000 null comment '材料费_自筹_间接',
    clf_clf_zx_jj                     decimal(12, 6) default 0.000000 null comment '材料费_材料费_专项_间接',
    clf_clf_zc_jj                     decimal(12, 6) default 0.000000 null comment '材料费_材料费_自筹_间接',
    kyhdf_zx_jj                       decimal(12, 6) default 0.000000 null comment '科研活动费_专项_间接',
    kyhdf_zc_jj                       decimal(12, 6) default 0.000000 null comment '科研活动费_自筹_间接',
    kyhdf_zl_zx_jj                    decimal(12, 6) default 0.000000 null comment '科研活动费_资料费_专项_间接',
    kyhdf_zl_zc_jj                    decimal(12, 6) default 0.000000 null comment '科研活动费_资料费_自筹_间接',
    kyhdf_cshyjg_zx_jj                decimal(12, 6) default 0.000000 null comment '科研活动费_测试化验加工费_专项_间接',
    kyhdf_cshyjg_zc_jj                decimal(12, 6) default 0.000000 null comment '科研活动费_测试化验加工费_自筹_间接',
    kyhdf_bg_zx_jj                    decimal(12, 6) default 0.000000 null comment '科研活动费_办公费_专项_间接',
    kyhdf_bg_zc_jj                    decimal(12, 6) default 0.000000 null comment '科研活动费_办公费_自筹_间接',
    kyhdf_sjybcj_zx_jj                decimal(12, 6) default 0.000000 null comment '科研活动费_数据/样本采集费_专项_间接',
    kyhdf_sjybcj_zc_jj                decimal(12, 6) default 0.000000 null comment '科研活动费_数据/样本采集费_自筹_间接',
    kyhdf_yscb_zx_jj                  decimal(12, 6) default 0.000000 null comment '科研活动费_印刷/出版费_专项_间接',
    kyhdf_yscb_zc_jj                  decimal(12, 6) default 0.000000 null comment '科研活动费_印刷/出版费_自筹_间接',
    kyhdf_zscqsw_zx_jj                decimal(12, 6) default 0.000000 null comment '科研活动费_知识产权事务费_专项_间接',
    kyhdf_zscqsw_zc_jj                decimal(12, 6) default 0.000000 null comment '科研活动费_知识产权事务费_自筹_间接',
    kyhdf_rldl_zx_jj                  decimal(12, 6) default 0.000000 null comment '科研活动费_燃料动力费_专项_间接',
    kyhdf_rldl_zc_jj                  decimal(12, 6) default 0.000000 null comment '科研活动费_燃料动力费_自筹_间接',
    kyhdf_clsy_zx_jj                  decimal(12, 6) default 0.000000 null comment '科研活动费_车辆使用费_专项_间接',
    kyhdf_clsy_zc_jj                  decimal(12, 6) default 0.000000 null comment '科研活动费_车辆使用费_自筹_间接',
    kyfwf_zx_jj                       decimal(12, 6) default 0.000000 null comment '科研服务费_专项_间接',
    kyfwf_zc_jj                       decimal(12, 6) default 0.000000 null comment '科研服务费_自筹_间接',
    kyfwf_zjzx_zx_jj                  decimal(12, 6) default 0.000000 null comment '科研服务费_专家咨询费_专项_间接',
    kyfwf_zjzx_zc_jj                  decimal(12, 6) default 0.000000 null comment '科研服务费_专家咨询费_自筹_间接',
    kyfwf_cl_zx_jj                    decimal(12, 6) default 0.000000 null comment '科研服务费_差旅费_专项_间接',
    kyfwf_cl_zc_jj                    decimal(12, 6) default 0.000000 null comment '科研服务费_差旅费_自筹_间接',
    kyfwf_hyhw_zx_jj                  decimal(12, 6) default 0.000000 null comment '科研服务费_会议/会务费_专项_间接',
    kyfwf_hyhw_zc_jj                  decimal(12, 6) default 0.000000 null comment '科研服务费_会议/会务费_自筹_间接',
    kyfwf_gjhzjl_zx_jj                decimal(12, 6) default 0.000000 null comment '科研服务费_国际合作交流_专项_间接',
    kyfwf_gjhzjl_zc_jj                decimal(12, 6) default 0.000000 null comment '科研服务费_国际合作交流_自筹_间接',
    kyfwf_gnxz_zx_jj                  decimal(12, 6) default 0.000000 null comment '科研服务费_国内协作费_专项_间接',
    kyfwf_gnxz_zc_jj                  decimal(12, 6) default 0.000000 null comment '科研服务费_国内协作费_自筹_间接',
    ryhlwbzf_zx_jj                    decimal(12, 6) default 0.000000 null comment '人员和劳务补助费_专项_间接',
    ryhlwbzf_zc_jj                    decimal(12, 6) default 0.000000 null comment '人员和劳务补助费_自筹_间接',
    ryhlwbzf_rylw_zx_jj               decimal(12, 6) default 0.000000 null comment '人员和劳务补助费_人员劳务费_专项_间接',
    ryhlwbzf_rylw_zc_jj               decimal(12, 6) default 0.000000 null comment '人员和劳务补助费_人员劳务费_自筹_间接',
    jxzc_zx_jj                        decimal(12, 6) default 0.000000 null comment '绩效支出_专项_间接',
    jxzc_zc_jj                        decimal(12, 6) default 0.000000 null comment '绩效支出_自筹_间接',
    constraint project_funds_pk
        unique (project_id)
)
    comment '项目经费表（单位：万元）' collate = utf8mb4_bin;

create index project_funds_project_id_index
    on project_funds (project_id);

-- ----------------------------
-- 项目支出表
-- ----------------------------

DROP TABLE IF EXISTS `project_expenditure`;
create table project_expenditure
(
    expenditure_id       bigint auto_increment comment '支出id'
        primary key,
    project_id           bigint                          not null comment '项目id',
    expenditure_date     datetime                        null comment '支出日期',
    project_name         varchar(200)                    null comment '项目名称',
    voucher_no           varchar(100)                    null comment '凭证号',
    expenditure_abstract varchar(300)                    null comment '摘要',
    zxzc                 tinyint                         null comment '专项/自筹,0专项,1自筹',
    first_level_subject  tinyint                         null comment '一级科目',
    second_level_subject tinyint                         null comment '二级科目',
    amount               decimal(12, 2) default 0.00 null comment '支出金额,单位:元',
    create_time          datetime                        null comment '创建时间',
    update_time          datetime                        null comment '更新时间',
    create_by            varchar(100)   default ''       null comment '创建人',
    update_by            varchar(100)   default ''       null comment '更新人',
    deleted              tinyint        default 0        null comment '是否删除，2删除，0未删除'
)
    comment '项目支出表';

create index project_expenditure_project_id_index
    on project_expenditure (project_id);

-- ----------------------------
-- 4、项目指标表
-- ----------------------------

DROP TABLE IF EXISTS `project_target`;
create table project_target
(
    target_id      bigint auto_increment comment '指标id'
        primary key,
    project_id     bigint       not null comment '项目id',
    target_name    varchar(100) null comment '指标名称',
    midterm_target varchar(200) null comment '中期指标值/状态',
    end_target     varchar(200) null comment '结束时指标值/状态'
)
    comment '项目指标' charset = utf8mb4;

create index project_target_project_id_index
    on project_target (project_id);

-- ----------------------------
-- 5、项目附件表
-- ----------------------------

DROP TABLE IF EXISTS `project_attachments`;
create table project_attachments
(
    id         bigint auto_increment comment '主键id'
        primary key,
    project_id bigint not null comment '项目id',
    oss_id     bigint not null comment '文件oss_id'
)
    comment '项目附件表' charset = utf8mb4;

create index project_attachments_project_id_oss_id_index
    on project_attachments (project_id, oss_id);

-- ----------------------------
-- 6、项目大事纪表
-- ----------------------------

DROP TABLE IF EXISTS `project_milestone`;
create table project_milestone
(
    milestone_id     bigint auto_increment comment '事纪id'
        primary key,
    project_id       bigint       not null comment '项目id',
    milestone_title  varchar(50)  null comment '事纪名',
    milestone_remark varchar(100) null comment '事纪描述',
    milestone_date   date         null comment '大事纪时间'
)
    comment '项目大事纪' charset = utf8mb4;

create index project_milestone_project_id_index
    on project_milestone (project_id);

-- ----------------------------
-- 7、项目大事纪附件表
-- ----------------------------

DROP TABLE IF EXISTS `project_milestone_oss`;
create table project_milestone_oss
(
    milestone_id bigint not null comment '项目大事纪id',
    oss_id       bigint not null comment '文件ossID',
    primary key (milestone_id, oss_id)
)
    comment '大事记和文件关联表' charset = utf8mb4;


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

