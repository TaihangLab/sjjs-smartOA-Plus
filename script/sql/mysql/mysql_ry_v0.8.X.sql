-- ----------------------------
-- 1、部门表
-- ----------------------------
drop table if exists sys_dept;
create table sys_dept (
  dept_id           bigint(20)      not null                   comment '部门id',
  parent_id         bigint(20)      default 0                  comment '父部门id',
  ancestors         varchar(500)    default ''                 comment '祖级列表',
  dept_name         varchar(30)     default ''                 comment '部门名称',
  order_num         int(4)          default 0                  comment '显示顺序',
  leader            varchar(20)     default null               comment '负责人',
  phone             varchar(11)     default null               comment '联系电话',
  email             varchar(50)     default null               comment '邮箱',
  status            char(1)         default '0'                comment '部门状态（0正常 1停用）',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  primary key (dept_id)
) engine=innodb comment = '部门表';

-- ----------------------------
-- 初始化-部门表数据
-- ----------------------------
insert into sys_dept values(100,  0,   '0',          '若依科技',   0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(101,  100, '0,100',      '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(102,  100, '0,100',      '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(103,  101, '0,100,101',  '研发部门',   1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(104,  101, '0,100,101',  '市场部门',   2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(105,  101, '0,100,101',  '测试部门',   3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(106,  101, '0,100,101',  '财务部门',   4, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(107,  101, '0,100,101',  '运维部门',   5, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(108,  102, '0,100,102',  '市场部门',   1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(109,  102, '0,100,102',  '财务部门',   2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);


-- ----------------------------
-- 2、用户信息表
-- ----------------------------
drop table if exists sys_user;
create table sys_user (
  user_id           bigint(20)      not null                   comment '用户ID',
  dept_id           bigint(20)      default null               comment '部门ID',
  user_name         varchar(30)     not null                   comment '用户账号',
  nick_name         varchar(30)     not null                   comment '用户昵称',
  user_type         varchar(10)     default 'sys_user'         comment '用户类型（sys_user系统用户）',
  email             varchar(50)     default ''                 comment '用户邮箱',
  phonenumber       varchar(11)     default ''                 comment '手机号码',
  job_title   tinyint                         null comment '用户职称，0正高级，1副高级，2中级，3初级，4无',
  diploma     tinyint                         null comment '学历，0博士研究生，1硕士研究生，2本科，3专科',
  sex               char(1)         default '0'                comment '用户性别（0男 1女 2未知）',
  avatar            varchar(100)    default ''                 comment '头像地址',
  password          varchar(100)    default ''                 comment '密码',
  status            char(1)         default '0'                comment '帐号状态（0正常 1停用）',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  login_ip          varchar(128)    default ''                 comment '最后登录IP',
  login_date        datetime                                   comment '最后登录时间',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (user_id)
) engine=innodb comment = '用户信息表';

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
insert into sys_user values(1,  103, 'admin', '若依管理员', 'sys_user', 'ry@163.com', '15888888888',0,0, '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', sysdate(), 'admin', sysdate(), '', null, '管理员');
insert into sys_user values(2,  105, 'ry',    '若依'     , 'sys_user', 'ry@qq.com',  '15666666666',1,1, '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', sysdate(), 'admin', sysdate(), '', null, '测试员');


-- ----------------------------
-- 3、岗位信息表
-- ----------------------------
drop table if exists sys_post;
create table sys_post
(
  post_id       bigint(20)      not null                   comment '岗位ID',
  post_code     varchar(64)     not null                   comment '岗位编码',
  post_name     varchar(50)     not null                   comment '岗位名称',
  post_sort     int(4)          not null                   comment '显示顺序',
  status        char(1)         not null                   comment '状态（0正常 1停用）',
  create_by     varchar(64)     default ''                 comment '创建者',
  create_time   datetime                                   comment '创建时间',
  update_by     varchar(64)     default ''                 comment '更新者',
  update_time   datetime                                   comment '更新时间',
  remark        varchar(500)    default null               comment '备注',
  primary key (post_id)
) engine=innodb comment = '岗位信息表';

-- ----------------------------
-- 初始化-岗位信息表数据
-- ----------------------------
insert into sys_post values(1, 'ceo',  '董事长',    1, '0', 'admin', sysdate(), '', null, '');
insert into sys_post values(2, 'se',   '项目经理',  2, '0', 'admin', sysdate(), '', null, '');
insert into sys_post values(3, 'hr',   '人力资源',  3, '0', 'admin', sysdate(), '', null, '');
insert into sys_post values(4, 'user', '普通员工',  4, '0', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 4、角色信息表
-- ----------------------------
drop table if exists sys_role;
create table sys_role (
  role_id              bigint(20)      not null                   comment '角色ID',
  role_name            varchar(30)     not null                   comment '角色名称',
  role_key             varchar(100)    not null                   comment '角色权限字符串',
  role_sort            int(4)          not null                   comment '显示顺序',
  data_scope           char(1)         default '1'                comment '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  menu_check_strictly  tinyint(1)      default 1                  comment '菜单树选择项是否关联显示',
  dept_check_strictly  tinyint(1)      default 1                  comment '部门树选择项是否关联显示',
  status               char(1)         not null                   comment '角色状态（0正常 1停用）',
  del_flag             char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  create_by            varchar(64)     default ''                 comment '创建者',
  create_time          datetime                                   comment '创建时间',
  update_by            varchar(64)     default ''                 comment '更新者',
  update_time          datetime                                   comment '更新时间',
  remark               varchar(500)    default null               comment '备注',
  primary key (role_id)
) engine=innodb comment = '角色信息表';

-- ----------------------------
-- 初始化-角色信息表数据
-- ----------------------------
insert into sys_role values('1', '超级管理员',  'admin',  1, 1, 1, 1, '0', '0', 'admin', sysdate(), '', null, '超级管理员');
insert into sys_role values('2', '普通角色',    'common', 2, 2, 1, 1, '0', '0', 'admin', sysdate(), '', null, '普通角色');


-- ----------------------------
-- 5、菜单权限表
-- ----------------------------
drop table if exists sys_menu;
create table sys_menu (
  menu_id           bigint(20)      not null                   comment '菜单ID',
  menu_name         varchar(50)     not null                   comment '菜单名称',
  parent_id         bigint(20)      default 0                  comment '父菜单ID',
  order_num         int(4)          default 0                  comment '显示顺序',
  path              varchar(200)    default ''                 comment '路由地址',
  component         varchar(255)    default null               comment '组件路径',
  query_param       varchar(255)    default null               comment '路由参数',
  is_frame          int(1)          default 1                  comment '是否为外链（0是 1否）',
  is_cache          int(1)          default 0                  comment '是否缓存（0缓存 1不缓存）',
  menu_type         char(1)         default ''                 comment '菜单类型（M目录 C菜单 F按钮）',
  visible           char(1)         default 0                  comment '显示状态（0显示 1隐藏）',
  status            char(1)         default 0                  comment '菜单状态（0正常 1停用）',
  perms             varchar(100)    default null               comment '权限标识',
  icon              varchar(100)    default '#'                comment '菜单图标',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default ''                 comment '备注',
  primary key (menu_id)
) engine=innodb comment = '菜单权限表';

-- ----------------------------
-- 初始化-菜单信息表数据
-- ----------------------------
-- 一级菜单
insert into sys_menu values('1', '系统管理', '0', '1', 'system',   null, '', 1, 0, 'M', '0', '0', '', 'system',   'admin', sysdate(), '', null, '系统管理目录');
insert into sys_menu values('2', '系统监控', '0', '2', 'monitor',  null, '', 1, 0, 'M', '0', '0', '', 'monitor',  'admin', sysdate(), '', null, '系统监控目录');
insert into sys_menu values('3', '系统工具', '0', '3', 'tool',     null, '', 1, 0, 'M', '0', '0', '', 'tool',     'admin', sysdate(), '', null, '系统工具目录');
insert into sys_menu values('4', '流程管理', '0', '4', 'process',  null, '', 1, 0, 'M', '0', '0', '', 'skill',    'admin', sysdate(), '', null, '流程管理目录');
insert into sys_menu values('5', '办公管理', '0', '5', 'work',     null, '', 1, 0, 'M', '0', '0', '', 'job',      'admin', sysdate(), '', null, '办公管理目录');

-- 二级菜单
insert into sys_menu values('100',  '用户管理', '1',   '1', 'user',       'system/user/index',        '', 1, 0, 'C', '0', '0', 'system:user:list',        'user',          'admin', sysdate(), '', null, '用户管理菜单');
insert into sys_menu values('101',  '角色管理', '1',   '2', 'role',       'system/role/index',        '', 1, 0, 'C', '0', '0', 'system:role:list',        'peoples',       'admin', sysdate(), '', null, '角色管理菜单');
insert into sys_menu values('102',  '菜单管理', '1',   '3', 'menu',       'system/menu/index',        '', 1, 0, 'C', '0', '0', 'system:menu:list',        'tree-table',    'admin', sysdate(), '', null, '菜单管理菜单');
insert into sys_menu values('103',  '部门管理', '1',   '4', 'dept',       'system/dept/index',        '', 1, 0, 'C', '0', '0', 'system:dept:list',        'tree',          'admin', sysdate(), '', null, '部门管理菜单');
insert into sys_menu values('104',  '岗位管理', '1',   '5', 'post',       'system/post/index',        '', 1, 0, 'C', '0', '0', 'system:post:list',        'post',          'admin', sysdate(), '', null, '岗位管理菜单');
insert into sys_menu values('105',  '字典管理', '1',   '6', 'dict',       'system/dict/index',        '', 1, 0, 'C', '0', '0', 'system:dict:list',        'dict',          'admin', sysdate(), '', null, '字典管理菜单');
insert into sys_menu values('106',  '参数设置', '1',   '7', 'config',     'system/config/index',      '', 1, 0, 'C', '0', '0', 'system:config:list',      'edit',          'admin', sysdate(), '', null, '参数设置菜单');
insert into sys_menu values('107',  '通知公告', '1',   '8', 'notice',     'system/notice/index',      '', 1, 0, 'C', '0', '0', 'system:notice:list',      'message',       'admin', sysdate(), '', null, '通知公告菜单');
insert into sys_menu values('108',  '日志管理', '1',   '9', 'log',        '',                         '', 1, 0, 'M', '0', '0', '',                        'log',           'admin', sysdate(), '', null, '日志管理菜单');
insert into sys_menu values('109',  '在线用户', '2',   '1', 'online',     'monitor/online/index',     '', 1, 0, 'C', '0', '0', 'monitor:online:list',     'online',        'admin', sysdate(), '', null, '在线用户菜单');
insert into sys_menu values('111',  '数据监控', '2',   '3', 'druid',      'monitor/druid/index',      '', 1, 0, 'C', '0', '0', 'monitor:druid:list',      'druid',         'admin', sysdate(), '', null, '数据监控菜单');
insert into sys_menu values('112',  '缓存列表', '2',   '6', 'cacheList',  'monitor/cache/list',       '', 1, 0, 'C', '0', '0', 'monitor:cache:list',      'redis-list',    'admin', sysdate(), '', null, '缓存列表菜单');
insert into sys_menu values('113',  '缓存监控', '2',   '5', 'cache',      'monitor/cache/index',      '', 1, 0, 'C', '0', '0', 'monitor:cache:list',      'redis',         'admin', sysdate(), '', null, '缓存监控菜单');
insert into sys_menu values('114',  '表单构建', '3',   '1', 'build',      'tool/build/index',         '', 1, 0, 'C', '0', '0', 'tool:build:list',         'build',         'admin', sysdate(), '', null, '表单构建菜单');
insert into sys_menu values('115',  '代码生成', '3',   '2', 'gen',        'tool/gen/index',           '', 1, 0, 'C', '0', '0', 'tool:gen:list',           'code',          'admin', sysdate(), '', null, '代码生成菜单');
-- springboot-admin监控
insert into sys_menu values('117',  'Admin监控', '2',  '5', 'Admin',      'monitor/admin/index',      '', 1, 0, 'C', '0', '0', 'monitor:admin:list',      'dashboard',     'admin', sysdate(), '', null, 'Admin监控菜单');
-- oss菜单
insert into sys_menu values('118',  '文件管理', '1', '10', 'oss', 'system/oss/index', '', 1, 0, 'C', '0', '0', 'system:oss:list', 'upload', 'admin', sysdate(), '', null, '文件管理菜单');
-- xxl-job-admin控制台
insert into sys_menu values('120',  '任务调度中心', '2',  '5', 'XxlJob',      'monitor/xxljob/index',      '', 1, 0, 'C', '0', '0', 'monitor:xxljob:list',      'job',     'admin', sysdate(), '', null, 'Xxl-Job控制台菜单');
-- 流程管理
insert into sys_menu values('121',  '流程分类', '4',   '1', 'category',   'workflow/category/index',      '', 1, 0, 'C', '0', '0', 'workflow:category:list',   'nested',    'admin', sysdate(), '', null, '流程分类菜单');
insert into sys_menu values('122',  '表单配置', '4',   '2', 'form',       'workflow/form/index',          '', 1, 0, 'C', '0', '0', 'workflow:form:list',       'form',      'admin', sysdate(), '', null, '表单配置菜单');
insert into sys_menu values('123',  '流程模型', '4',   '3', 'model',      'workflow/model/index',         '', 1, 0, 'C', '0', '0', 'workflow:model:list',      'component', 'admin', sysdate(), '', null, '流程模型菜单');
insert into sys_menu values('124',  '部署管理', '4',   '4', 'deploy',     'workflow/deploy/index',        '', 1, 0, 'C', '0', '0', 'workflow:deploy:list',     'example',   'admin', sysdate(), '', null, '部署管理菜单');
-- 办公管理
insert into sys_menu values('125',  '新建流程', '5',   '1', 'create',     'workflow/work/index',       '', 1, 0, 'C', '0', '0', 'workflow:process:startList',    'guide',      'admin', sysdate(), '', null, '新建流程菜单');
insert into sys_menu values('126',  '我的流程', '5',   '2', 'own',        'workflow/work/own',         '', 1, 0, 'C', '0', '0', 'workflow:process:ownList',      'cascader',   'admin', sysdate(), '', null, '我的流程菜单');
insert into sys_menu values('127',  '待办任务', '5',   '3', 'todo',       'workflow/work/todo',        '', 1, 0, 'C', '0', '0', 'workflow:process:todoList',     'time-range', 'admin', sysdate(), '', null, '待办任务菜单');
insert into sys_menu values('128',  '待签任务', '5',   '4', 'claim',      'workflow/work/claim',       '', 1, 0, 'C', '0', '0', 'workflow:process:claimList',    'checkbox',   'admin', sysdate(), '', null, '待签任务菜单');
insert into sys_menu values('129',  '已办任务', '5',   '5', 'finished',   'workflow/work/finished',    '', 1, 0, 'C', '0', '0', 'workflow:process:finishedList', 'checkbox',   'admin', sysdate(), '', null, '已办任务菜单');
insert into sys_menu values('130',  '抄送我的', '5',   '6', 'copy',       'workflow/work/copy',        '', 1, 0, 'C', '0', '0', 'workflow:process:copyList',     'checkbox',   'admin', sysdate(), '', null, '抄送我的菜单');

-- 三级菜单
insert into sys_menu values('500',  '操作日志', '108', '1', 'operlog',    'monitor/operlog/index',    '', 1, 0, 'C', '0', '0', 'monitor:operlog:list',    'form',          'admin', sysdate(), '', null, '操作日志菜单');
insert into sys_menu values('501',  '登录日志', '108', '2', 'logininfor', 'monitor/logininfor/index', '', 1, 0, 'C', '0', '0', 'monitor:logininfor:list', 'logininfor',    'admin', sysdate(), '', null, '登录日志菜单');
-- 用户管理按钮
insert into sys_menu values('1001', '用户查询', '100', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1002', '用户新增', '100', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1003', '用户修改', '100', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1004', '用户删除', '100', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1005', '用户导出', '100', '5',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:export',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1006', '用户导入', '100', '6',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:import',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1007', '重置密码', '100', '7',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd',       '#', 'admin', sysdate(), '', null, '');
-- 角色管理按钮
insert into sys_menu values('1010', '角色查询', '101', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1011', '角色新增', '101', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1012', '角色修改', '101', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1013', '角色删除', '101', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1014', '角色导出', '101', '5',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:export',         '#', 'admin', sysdate(), '', null, '');
-- 菜单管理按钮
insert into sys_menu values('1020', '菜单查询', '102', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1021', '菜单新增', '102', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1022', '菜单修改', '102', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1023', '菜单删除', '102', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove',         '#', 'admin', sysdate(), '', null, '');
-- 部门管理按钮
insert into sys_menu values('1030', '部门查询', '103', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1031', '部门新增', '103', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1032', '部门修改', '103', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1033', '部门删除', '103', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove',         '#', 'admin', sysdate(), '', null, '');
-- 岗位管理按钮
insert into sys_menu values('1040', '岗位查询', '104', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1041', '岗位新增', '104', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1042', '岗位修改', '104', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1043', '岗位删除', '104', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1044', '岗位导出', '104', '5',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:export',         '#', 'admin', sysdate(), '', null, '');
-- 字典管理按钮
insert into sys_menu values('1050', '字典查询', '105', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1051', '字典新增', '105', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1052', '字典修改', '105', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1053', '字典删除', '105', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1054', '字典导出', '105', '5', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export',         '#', 'admin', sysdate(), '', null, '');
-- 参数设置按钮
insert into sys_menu values('1060', '参数查询', '106', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query',        '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1061', '参数新增', '106', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1062', '参数修改', '106', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1063', '参数删除', '106', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove',       '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1064', '参数导出', '106', '5', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export',       '#', 'admin', sysdate(), '', null, '');
-- 通知公告按钮
insert into sys_menu values('1070', '公告查询', '107', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query',        '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1071', '公告新增', '107', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1072', '公告修改', '107', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1073', '公告删除', '107', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove',       '#', 'admin', sysdate(), '', null, '');
-- 操作日志按钮
insert into sys_menu values('1080', '操作查询', '500', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:query',      '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1081', '操作删除', '500', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:remove',     '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1082', '日志导出', '500', '4', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:export',     '#', 'admin', sysdate(), '', null, '');
-- 登录日志按钮
insert into sys_menu values('1090', '登录查询', '501', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:query',   '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1091', '登录删除', '501', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:remove',  '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1092', '日志导出', '501', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:export',  '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1093', '账户解锁', '501', '4', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:unlock',  '#', 'admin', sysdate(), '', null, '');
-- 在线用户按钮
insert into sys_menu values('1100', '在线查询', '109', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query',       '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1101', '批量强退', '109', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1102', '单条强退', '109', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', sysdate(), '', null, '');
-- 代码生成按钮
insert into sys_menu values('1120', '生成查询', '115', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query',             '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1121', '生成修改', '115', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit',              '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1122', '生成删除', '115', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1123', '导入代码', '115', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1124', '预览代码', '115', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1125', '生成代码', '115', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code',              '#', 'admin', sysdate(), '', null, '');
-- oss相关按钮
insert into sys_menu values('1130', '文件查询', '118', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:oss:query',        '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1131', '文件上传', '118', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:oss:upload',       '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1132', '文件下载', '118', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:oss:download',     '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1133', '文件删除', '118', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:oss:remove',       '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1134', '配置添加', '118', '5', '#', '', '', 1, 0, 'F', '0', '0', 'system:oss:add',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1135', '配置编辑', '118', '6', '#', '', '', 1, 0, 'F', '0', '0', 'system:oss:edit',         '#', 'admin', sysdate(), '', null, '');
-- 流程分类管理
insert into sys_menu values('1140', '分类查询', '121', '1', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:category:query',  '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1141', '分类新增', '121', '2', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:category:add',    '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1142', '分类编辑', '121', '3', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:category:edit',   '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1143', '分类删除', '121', '4', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:category:remove', '#', 'admin', sysdate(), '', null, '');
-- 表单配置
insert into sys_menu values('1150', '表单查询', '122', '1', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:form:query',   '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1151', '表单新增', '122', '2', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:form:add',     '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1152', '表单修改', '122', '3', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:form:edit',    '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1153', '表单删除', '122', '4', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:form:remove',  '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1154', '表单导出', '122', '5', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:form:export',  '#', 'admin', sysdate(), '', null, '');
-- 流程模型
insert into sys_menu values('1160', '模型查询', '123', '1', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:model:query',    '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1161', '模型新增', '123', '2', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:model:add',      '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1162', '模型修改', '123', '3', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:model:edit',     '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1163', '模型删除', '123', '4', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:model:remove',   '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1164', '模型导出', '123', '5', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:model:export',   '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1165', '模型导入', '123', '6', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:model:import',   '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1166', '模型设计', '123', '7', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:model:designer', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1167', '模型保存', '123', '8', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:model:save',     '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1168', '流程部署', '123', '9', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:model:deploy',   '#', 'admin', sysdate(), '', null, '');
-- 部署管理
insert into sys_menu values('1170', '部署查询', '124', '1', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:deploy:query',   '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1171', '部署删除', '124', '2', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:deploy:remove',  '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1172', '更新状态', '124', '3', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:deploy:status',  '#', 'admin', sysdate(), '', null, '');
-- 新建流程
insert into sys_menu values('1180', '发起流程',    '125', '1', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:start',       '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1181', '新建流程导出', '125', '2', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:startExport', '#', 'admin', sysdate(), '', null, '');
-- 我的流程
insert into sys_menu values('1190', '流程详情',    '126', '1', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:query',     '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1191', '流程删除',    '126', '2', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:remove',    '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1192', '流程取消',    '126', '3', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:cancel',    '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1193', '我的流程导出', '126', '4', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:ownExport', '#', 'admin', sysdate(), '', null, '');
-- 待办任务
insert into sys_menu values('1200', '流程办理',    '127', '1', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:approval',   '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1201', '待办流程导出', '127', '2', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:todoExport', '#', 'admin', sysdate(), '', null, '');
-- 待签任务
insert into sys_menu values('1210', '流程签收',    '128', '1', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:claim',        '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1211', '待签流程导出', '128', '2', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:claimExport',  '#', 'admin', sysdate(), '', null, '');
-- 已办任务
insert into sys_menu values('1220', '流程撤回',    '129', '1', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:revoke',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1221', '已办流程导出', '129', '2', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:finishedExport', '#', 'admin', sysdate(), '', null, '');
-- 抄送我的
insert into sys_menu values('1230', '抄送流程导出', '130', '1', '#', '', '', 1, 0, 'F', '0', '0', 'workflow:process:copyExport', '#', 'admin', sysdate(), '', null, '');
-- 项目管理
insert into sys_menu values(1727245396517777410,'项目管理',0,6,'project',NULL,NULL,1,0,'M','0','0',NULL,'documentation','admin','2023-11-22 16:39:28','admin','2023-11-23 11:11:05','');
insert into sys_menu values(1727249354451775490,'项目列表',1727245396517777410,1,'all','project/ProjectList',NULL,1,0,'C','0','0','project:list:getAllList','list','admin','2023-11-22 16:55:12','fjx888888','2024-01-09 09:40:39','');
insert into sys_menu values(1727250417435209729,'我的项目',1727245396517777410,2,'my','project/MyProject',NULL,1,0,'C','0','0','project:my:getMyList','user','admin','2023-11-22 16:59:25','admin','2024-01-09 10:02:28','');
insert into sys_menu values(1739944930012246017,'成员列表',1727245396517777410,3,'members','project/Members',NULL,1,0,'C','0','0','project:user:getAllList','peoples','admin','2023-12-27 17:42:53','admin','2024-01-09 10:12:28','');
insert into sys_menu values(1742380260892028929,'项目附件',1727245396517777410,4,'projectAttachments','project/ProjectAttachments',NULL,1,0,'C','0','0','project:user:getAllList','clipboard','admin','2024-01-03 11:00:01','admin','2024-01-09 10:13:57','');
insert into sys_menu values(1742717842318348289,'知识产权',1727245396517777410,5,'intellectualProperty','project/IntellectualProperty',NULL,1,0,'C','0','0','project:ip:list','tab','admin','2024-01-04 09:21:26','admin','2024-01-09 14:48:05','');
insert into sys_menu values(1744536917178482690,'项目详情',1727249354451775490,1,'',NULL,NULL,1,0,'F','0','0','project:list:getDetails','#','admin','2024-01-09 09:49:48','admin','2024-01-09 09:49:48','');
insert into sys_menu values(1744539218823806978,'查询大事纪',1727249354451775490,2,'',NULL,NULL,1,0,'F','0','0','project:list:queryMilestone','#','admin','2024-01-09 09:58:56','admin','2024-01-09 09:58:56','');
insert into sys_menu values(1744540570819952642,'新增项目',1727250417435209729,1,'',NULL,NULL,1,0,'F','0','0','project:my:add','#','admin','2024-01-09 10:04:19','admin','2024-01-09 10:04:19','');
insert into sys_menu values(1744540855583834114,'编辑项目信息',1727250417435209729,2,'',NULL,NULL,1,0,'F','0','0','project:my:edit','#','admin','2024-01-09 10:05:27','admin','2024-01-09 10:05:27','');
insert into sys_menu values(1744541006335508481,'删除项目信息',1727250417435209729,3,'',NULL,NULL,1,0,'F','0','0','project:my:delete','#','admin','2024-01-09 10:06:03','admin','2024-01-09 10:06:03','');
insert into sys_menu values(1744541337593249793,'新增项目大事纪',1727250417435209729,4,'',NULL,NULL,1,0,'F','0','0','project:my:milestoneadd','#','admin','2024-01-09 10:07:22','admin','2024-01-09 10:07:22','');
insert into sys_menu values(1744541802850615297,'删除单条项目大事纪',1727250417435209729,5,'',NULL,NULL,1,0,'F','0','0','project:my:milestonedelete','#','admin','2024-01-09 10:09:12','admin','2024-01-09 10:09:12','');
insert into sys_menu values(1744542065145610241,'删除项目对应大事纪',1727250417435209729,6,'',NULL,NULL,1,0,'F','0','0','project:my:milestonedeletebypro','#','admin','2024-01-09 10:10:15','admin','2024-01-09 10:10:15','');
insert into sys_menu values(1744542342632374274,'修改大事纪',1727250417435209729,7,'',NULL,NULL,1,0,'F','0','0','project:my:milestoneedit','#','admin','2024-01-09 10:11:21','admin','2024-01-09 10:11:21','');
insert into sys_menu values(1744542828257280001,'项目成员详情',1739944930012246017,1,'',NULL,NULL,1,0,'F','0','0','project:user:getDetails','#','admin','2024-01-09 10:13:17','admin','2024-01-09 10:13:17','');
insert into sys_menu values(1744548323504345090,'知识产权详情',1742717842318348289,1,'',NULL,NULL,1,0,'F','0','0','project:ip:getDetails','#','admin','2024-01-09 10:35:07','admin','2024-01-09 14:54:01','');
insert into sys_menu values(1744548471965929473,'更新知识产权',1742717842318348289,3,'ip:update',NULL,NULL,1,0,'F','0','0','project:ip:update','#','admin','2024-01-09 10:35:43','admin','2024-01-09 14:54:08','');
insert into sys_menu values(1744548596041830401,'新增知识产权',1742717842318348289,2,'ip:add',NULL,NULL,1,0,'F','0','0','project:ip:add','#','admin','2024-01-09 10:36:12','admin','2024-01-09 14:53:50','');
insert into sys_menu values(1744548707459321858,'删除知识产权',1742717842318348289,4,'',NULL,NULL,1,0,'F','0','0','project:ip:delete','#','admin','2024-01-09 10:36:39','admin','2024-01-09 14:54:16','');

-- ---------------------------
-- 6、用户和角色关联表  用户N-1角色
-- ----------------------------
drop table if exists sys_user_role;
create table sys_user_role (
  user_id   bigint(20) not null comment '用户ID',
  role_id   bigint(20) not null comment '角色ID',
  primary key(user_id, role_id)
) engine=innodb comment = '用户和角色关联表';

-- ----------------------------
-- 初始化-用户和角色关联表数据
-- ----------------------------
insert into sys_user_role values ('1', '1');
insert into sys_user_role values ('2', '2');


-- ----------------------------
-- 7、角色和菜单关联表  角色1-N菜单
-- ----------------------------
drop table if exists sys_role_menu;
create table sys_role_menu (
  role_id   bigint(20) not null comment '角色ID',
  menu_id   bigint(20) not null comment '菜单ID',
  primary key(role_id, menu_id)
) engine=innodb comment = '角色和菜单关联表';

-- ----------------------------
-- 初始化-角色和菜单关联表数据
-- ----------------------------
insert into sys_role_menu values ('2', '1');
insert into sys_role_menu values ('2', '2');
insert into sys_role_menu values ('2', '3');
insert into sys_role_menu values ('2', '4');
insert into sys_role_menu values ('2', '5');
insert into sys_role_menu values ('2', '100');
insert into sys_role_menu values ('2', '101');
insert into sys_role_menu values ('2', '102');
insert into sys_role_menu values ('2', '103');
insert into sys_role_menu values ('2', '104');
insert into sys_role_menu values ('2', '105');
insert into sys_role_menu values ('2', '106');
insert into sys_role_menu values ('2', '107');
insert into sys_role_menu values ('2', '108');
insert into sys_role_menu values ('2', '109');
insert into sys_role_menu values ('2', '111');
insert into sys_role_menu values ('2', '112');
insert into sys_role_menu values ('2', '113');
insert into sys_role_menu values ('2', '114');
insert into sys_role_menu values ('2', '115');
insert into sys_role_menu values ('2', '117');
insert into sys_role_menu values ('2', '118');
insert into sys_role_menu values ('2', '120');
insert into sys_role_menu values ('2', '121');
insert into sys_role_menu values ('2', '122');
insert into sys_role_menu values ('2', '123');
insert into sys_role_menu values ('2', '124');
insert into sys_role_menu values ('2', '125');
insert into sys_role_menu values ('2', '126');
insert into sys_role_menu values ('2', '127');
insert into sys_role_menu values ('2', '128');
insert into sys_role_menu values ('2', '129');
insert into sys_role_menu values ('2', '130');
insert into sys_role_menu values ('2', '500');
insert into sys_role_menu values ('2', '501');
insert into sys_role_menu values ('2', '1001');
insert into sys_role_menu values ('2', '1002');
insert into sys_role_menu values ('2', '1003');
insert into sys_role_menu values ('2', '1004');
insert into sys_role_menu values ('2', '1005');
insert into sys_role_menu values ('2', '1006');
insert into sys_role_menu values ('2', '1007');
insert into sys_role_menu values ('2', '1010');
insert into sys_role_menu values ('2', '1011');
insert into sys_role_menu values ('2', '1012');
insert into sys_role_menu values ('2', '1013');
insert into sys_role_menu values ('2', '1014');
insert into sys_role_menu values ('2', '1020');
insert into sys_role_menu values ('2', '1021');
insert into sys_role_menu values ('2', '1022');
insert into sys_role_menu values ('2', '1023');
insert into sys_role_menu values ('2', '1030');
insert into sys_role_menu values ('2', '1031');
insert into sys_role_menu values ('2', '1032');
insert into sys_role_menu values ('2', '1033');
insert into sys_role_menu values ('2', '1040');
insert into sys_role_menu values ('2', '1041');
insert into sys_role_menu values ('2', '1042');
insert into sys_role_menu values ('2', '1043');
insert into sys_role_menu values ('2', '1044');
insert into sys_role_menu values ('2', '1050');
insert into sys_role_menu values ('2', '1051');
insert into sys_role_menu values ('2', '1052');
insert into sys_role_menu values ('2', '1053');
insert into sys_role_menu values ('2', '1054');
insert into sys_role_menu values ('2', '1060');
insert into sys_role_menu values ('2', '1061');
insert into sys_role_menu values ('2', '1062');
insert into sys_role_menu values ('2', '1063');
insert into sys_role_menu values ('2', '1064');
insert into sys_role_menu values ('2', '1070');
insert into sys_role_menu values ('2', '1071');
insert into sys_role_menu values ('2', '1072');
insert into sys_role_menu values ('2', '1073');
insert into sys_role_menu values ('2', '1080');
insert into sys_role_menu values ('2', '1081');
insert into sys_role_menu values ('2', '1082');
insert into sys_role_menu values ('2', '1090');
insert into sys_role_menu values ('2', '1091');
insert into sys_role_menu values ('2', '1092');
insert into sys_role_menu values ('2', '1093');
insert into sys_role_menu values ('2', '1100');
insert into sys_role_menu values ('2', '1101');
insert into sys_role_menu values ('2', '1102');
insert into sys_role_menu values ('2', '1120');
insert into sys_role_menu values ('2', '1121');
insert into sys_role_menu values ('2', '1122');
insert into sys_role_menu values ('2', '1123');
insert into sys_role_menu values ('2', '1124');
insert into sys_role_menu values ('2', '1125');
insert into sys_role_menu values ('2', '1130');
insert into sys_role_menu values ('2', '1131');
insert into sys_role_menu values ('2', '1132');
insert into sys_role_menu values ('2', '1133');
insert into sys_role_menu values ('2', '1134');
insert into sys_role_menu values ('2', '1135');
insert into sys_role_menu values ('2', '1140');
insert into sys_role_menu values ('2', '1141');
insert into sys_role_menu values ('2', '1142');
insert into sys_role_menu values ('2', '1143');
insert into sys_role_menu values ('2', '1150');
insert into sys_role_menu values ('2', '1151');
insert into sys_role_menu values ('2', '1152');
insert into sys_role_menu values ('2', '1153');
insert into sys_role_menu values ('2', '1154');
insert into sys_role_menu values ('2', '1160');
insert into sys_role_menu values ('2', '1161');
insert into sys_role_menu values ('2', '1162');
insert into sys_role_menu values ('2', '1163');
insert into sys_role_menu values ('2', '1164');
insert into sys_role_menu values ('2', '1165');
insert into sys_role_menu values ('2', '1166');
insert into sys_role_menu values ('2', '1167');
insert into sys_role_menu values ('2', '1168');
insert into sys_role_menu values ('2', '1170');
insert into sys_role_menu values ('2', '1171');
insert into sys_role_menu values ('2', '1172');
insert into sys_role_menu values ('2', '1180');
insert into sys_role_menu values ('2', '1181');
insert into sys_role_menu values ('2', '1190');
insert into sys_role_menu values ('2', '1191');
insert into sys_role_menu values ('2', '1192');
insert into sys_role_menu values ('2', '1193');
insert into sys_role_menu values ('2', '1200');
insert into sys_role_menu values ('2', '1201');
insert into sys_role_menu values ('2', '1210');
insert into sys_role_menu values ('2', '1211');
insert into sys_role_menu values ('2', '1220');
insert into sys_role_menu values ('2', '1221');
insert into sys_role_menu values ('2', '1230');

-- ----------------------------
-- 8、角色和部门关联表  角色1-N部门
-- ----------------------------
drop table if exists sys_role_dept;
create table sys_role_dept (
  role_id   bigint(20) not null comment '角色ID',
  dept_id   bigint(20) not null comment '部门ID',
  primary key(role_id, dept_id)
) engine=innodb comment = '角色和部门关联表';

-- ----------------------------
-- 初始化-角色和部门关联表数据
-- ----------------------------
insert into sys_role_dept values ('2', '100');
insert into sys_role_dept values ('2', '101');
insert into sys_role_dept values ('2', '105');


-- ----------------------------
-- 9、用户与岗位关联表  用户1-N岗位
-- ----------------------------
drop table if exists sys_user_post;
create table sys_user_post
(
  user_id   bigint(20) not null comment '用户ID',
  post_id   bigint(20) not null comment '岗位ID',
  primary key (user_id, post_id)
) engine=innodb comment = '用户与岗位关联表';

-- ----------------------------
-- 初始化-用户与岗位关联表数据
-- ----------------------------
insert into sys_user_post values ('1', '1');
insert into sys_user_post values ('2', '2');


-- ----------------------------
-- 10、操作日志记录
-- ----------------------------
drop table if exists sys_oper_log;
create table sys_oper_log (
  oper_id           bigint(20)      not null                   comment '日志主键',
  title             varchar(50)     default ''                 comment '模块标题',
  business_type     int(2)          default 0                  comment '业务类型（0其它 1新增 2修改 3删除）',
  method            varchar(100)    default ''                 comment '方法名称',
  request_method    varchar(10)     default ''                 comment '请求方式',
  operator_type     int(1)          default 0                  comment '操作类别（0其它 1后台用户 2手机端用户）',
  oper_name         varchar(50)     default ''                 comment '操作人员',
  dept_name         varchar(50)     default ''                 comment '部门名称',
  oper_url          varchar(255)    default ''                 comment '请求URL',
  oper_ip           varchar(128)    default ''                 comment '主机地址',
  oper_location     varchar(255)    default ''                 comment '操作地点',
  oper_param        varchar(2000)   default ''                 comment '请求参数',
  json_result       varchar(2000)   default ''                 comment '返回参数',
  status            int(1)          default 0                  comment '操作状态（0正常 1异常）',
  error_msg         varchar(2000)   default ''                 comment '错误消息',
  oper_time         datetime                                   comment '操作时间',
  primary key (oper_id)
) engine=innodb comment = '操作日志记录';


-- ----------------------------
-- 11、字典类型表
-- ----------------------------
drop table if exists sys_dict_type;
create table sys_dict_type
(
  dict_id          bigint(20)      not null                   comment '字典主键',
  dict_name        varchar(100)    default ''                 comment '字典名称',
  dict_type        varchar(100)    default ''                 comment '字典类型',
  status           char(1)         default '0'                comment '状态（0正常 1停用）',
  create_by        varchar(64)     default ''                 comment '创建者',
  create_time      datetime                                   comment '创建时间',
  update_by        varchar(64)     default ''                 comment '更新者',
  update_time      datetime                                   comment '更新时间',
  remark           varchar(500)    default null               comment '备注',
  primary key (dict_id),
  unique (dict_type)
) engine=innodb comment = '字典类型表';

insert into sys_dict_type values(1,  '用户性别', 'sys_user_sex',        '0', 'admin', sysdate(), '', null, '用户性别列表');
insert into sys_dict_type values(2,  '菜单状态', 'sys_show_hide',       '0', 'admin', sysdate(), '', null, '菜单状态列表');
insert into sys_dict_type values(3,  '系统开关', 'sys_normal_disable',  '0', 'admin', sysdate(), '', null, '系统开关列表');
insert into sys_dict_type values(6,  '系统是否', 'sys_yes_no',          '0', 'admin', sysdate(), '', null, '系统是否列表');
insert into sys_dict_type values(7,  '通知类型', 'sys_notice_type',     '0', 'admin', sysdate(), '', null, '通知类型列表');
insert into sys_dict_type values(8,  '通知状态', 'sys_notice_status',   '0', 'admin', sysdate(), '', null, '通知状态列表');
insert into sys_dict_type values(9,  '操作类型', 'sys_oper_type',       '0', 'admin', sysdate(), '', null, '操作类型列表');
insert into sys_dict_type values(10, '系统状态', 'sys_common_status',   '0', 'admin', sysdate(), '', null, '登录状态列表');
insert into sys_dict_type values(11, '流程状态', 'wf_process_status',   '0', 'admin', sysdate(), '', null, '工作流程状态');


-- ----------------------------
-- 12、字典数据表
-- ----------------------------
drop table if exists sys_dict_data;
create table sys_dict_data
(
  dict_code        bigint(20)      not null                   comment '字典编码',
  dict_sort        int(4)          default 0                  comment '字典排序',
  dict_label       varchar(100)    default ''                 comment '字典标签',
  dict_value       varchar(100)    default ''                 comment '字典键值',
  dict_type        varchar(100)    default ''                 comment '字典类型',
  css_class        varchar(100)    default null               comment '样式属性（其他样式扩展）',
  list_class       varchar(100)    default null               comment '表格回显样式',
  is_default       char(1)         default 'N'                comment '是否默认（Y是 N否）',
  status           char(1)         default '0'                comment '状态（0正常 1停用）',
  create_by        varchar(64)     default ''                 comment '创建者',
  create_time      datetime                                   comment '创建时间',
  update_by        varchar(64)     default ''                 comment '更新者',
  update_time      datetime                                   comment '更新时间',
  remark           varchar(500)    default null               comment '备注',
  primary key (dict_code)
) engine=innodb comment = '字典数据表';

insert into sys_dict_data values(1,  1,  '男',       '0',          'sys_user_sex',        '',   '',        'Y', '0', 'admin', sysdate(), '', null, '性别男');
insert into sys_dict_data values(2,  2,  '女',       '1',          'sys_user_sex',        '',   '',        'N', '0', 'admin', sysdate(), '', null, '性别女');
insert into sys_dict_data values(3,  3,  '未知',     '2',          'sys_user_sex',        '',   '',        'N', '0', 'admin', sysdate(), '', null, '性别未知');
insert into sys_dict_data values(4,  1,  '显示',     '0',          'sys_show_hide',       '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '显示菜单');
insert into sys_dict_data values(5,  2,  '隐藏',     '1',          'sys_show_hide',       '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '隐藏菜单');
insert into sys_dict_data values(6,  1,  '正常',     '0',          'sys_normal_disable',  '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '正常状态');
insert into sys_dict_data values(7,  2,  '停用',     '1',          'sys_normal_disable',  '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '停用状态');
insert into sys_dict_data values(12, 1,  '是',       'Y',          'sys_yes_no',          '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '系统默认是');
insert into sys_dict_data values(13, 2,  '否',       'N',          'sys_yes_no',          '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '系统默认否');
insert into sys_dict_data values(14, 1,  '通知',     '1',          'sys_notice_type',     '',   'warning', 'Y', '0', 'admin', sysdate(), '', null, '通知');
insert into sys_dict_data values(15, 2,  '公告',     '2',          'sys_notice_type',     '',   'success', 'N', '0', 'admin', sysdate(), '', null, '公告');
insert into sys_dict_data values(16, 1,  '正常',     '0',          'sys_notice_status',   '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '正常状态');
insert into sys_dict_data values(17, 2,  '关闭',     '1',          'sys_notice_status',   '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '关闭状态');
insert into sys_dict_data values(29, 99, '其他',     '0',          'sys_oper_type',       '',   'info',    'N', '0', 'admin', sysdate(), '', null, '其他操作');
insert into sys_dict_data values(18, 1,  '新增',     '1',          'sys_oper_type',       '',   'info',    'N', '0', 'admin', sysdate(), '', null, '新增操作');
insert into sys_dict_data values(19, 2,  '修改',     '2',          'sys_oper_type',       '',   'info',    'N', '0', 'admin', sysdate(), '', null, '修改操作');
insert into sys_dict_data values(20, 3,  '删除',     '3',          'sys_oper_type',       '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '删除操作');
insert into sys_dict_data values(21, 4,  '授权',     '4',          'sys_oper_type',       '',   'primary', 'N', '0', 'admin', sysdate(), '', null, '授权操作');
insert into sys_dict_data values(22, 5,  '导出',     '5',          'sys_oper_type',       '',   'warning', 'N', '0', 'admin', sysdate(), '', null, '导出操作');
insert into sys_dict_data values(23, 6,  '导入',     '6',          'sys_oper_type',       '',   'warning', 'N', '0', 'admin', sysdate(), '', null, '导入操作');
insert into sys_dict_data values(24, 7,  '强退',     '7',          'sys_oper_type',       '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '强退操作');
insert into sys_dict_data values(25, 8,  '生成代码', '8',          'sys_oper_type',       '',   'warning', 'N', '0', 'admin', sysdate(), '', null, '生成操作');
insert into sys_dict_data values(26, 9,  '清空数据', '9',          'sys_oper_type',       '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '清空操作');
insert into sys_dict_data values(27, 1,  '成功',     '0',          'sys_common_status',   '',   'primary', 'N', '0', 'admin', sysdate(), '', null, '正常状态');
insert into sys_dict_data values(28, 2,  '失败',     '1',          'sys_common_status',   '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '停用状态');
insert into sys_dict_data values(30, 1,  '进行中',   'running',    'wf_process_status',   '',   'primary',  'N', '0', 'admin', sysdate(), '', null, '进行中状态');
insert into sys_dict_data values(31, 2,  '已终止',   'terminated', 'wf_process_status',   '',   'danger',   'N', '0', 'admin', sysdate(), '', null, '已终止状态');
insert into sys_dict_data values(32, 3,  '已完成',   'completed',  'wf_process_status',   '',   'success',  'N', '0', 'admin', sysdate(), '', null, '已完成状态');
insert into sys_dict_data values(33, 4,  '已取消',   'canceled',   'wf_process_status',   '',   'warning',  'N', '0', 'admin', sysdate(), '', null, '已取消状态');



-- ----------------------------
-- 13、参数配置表
-- ----------------------------
drop table if exists sys_config;
create table sys_config (
  config_id         bigint(20)      not null                   comment '参数主键',
  config_name       varchar(100)    default ''                 comment '参数名称',
  config_key        varchar(100)    default ''                 comment '参数键名',
  config_value      varchar(500)    default ''                 comment '参数键值',
  config_type       char(1)         default 'N'                comment '系统内置（Y是 N否）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (config_id)
) engine=innodb comment = '参数配置表';

insert into sys_config values(1, '主框架页-默认皮肤样式名称',     'sys.index.skinName',            'skin-blue',     'Y', 'admin', sysdate(), '', null, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow' );
insert into sys_config values(2, '用户管理-账号初始密码',        'sys.user.initPassword',         '123456',        'Y', 'admin', sysdate(), '', null, '初始化密码 123456' );
insert into sys_config values(3, '主框架页-侧边栏主题',          'sys.index.sideTheme',           'theme-dark',    'Y', 'admin', sysdate(), '', null, '深色主题theme-dark，浅色主题theme-light' );
insert into sys_config values(4, '账号自助-验证码开关',          'sys.account.captchaEnabled',    'true',          'Y', 'admin', sysdate(), '', null, '是否开启验证码功能（true开启，false关闭）');
insert into sys_config values(5, '账号自助-是否开启用户注册功能',  'sys.account.registerUser',      'false',         'Y', 'admin', sysdate(), '', null, '是否开启注册用户功能（true开启，false关闭）');
insert into sys_config values(11, 'OSS预览列表资源开关',         'sys.oss.previewListResource',   'true',          'Y', 'admin', sysdate(), '', null, 'true:开启, false:关闭');


-- ----------------------------
-- 14、系统访问记录
-- ----------------------------
drop table if exists sys_logininfor;
create table sys_logininfor (
  info_id        bigint(20)     not null                  comment '访问ID',
  user_name      varchar(50)    default ''                comment '用户账号',
  ipaddr         varchar(128)   default ''                comment '登录IP地址',
  login_location varchar(255)   default ''                comment '登录地点',
  browser        varchar(50)    default ''                comment '浏览器类型',
  os             varchar(50)    default ''                comment '操作系统',
  status         char(1)        default '0'               comment '登录状态（0成功 1失败）',
  msg            varchar(255)   default ''                comment '提示消息',
  login_time     datetime                                 comment '访问时间',
  primary key (info_id)
) engine=innodb comment = '系统访问记录';


-- ----------------------------
-- 17、通知公告表
-- ----------------------------
drop table if exists sys_notice;
create table sys_notice (
  notice_id         bigint(20)      not null                   comment '公告ID',
  notice_title      varchar(50)     not null                   comment '公告标题',
  notice_type       char(1)         not null                   comment '公告类型（1通知 2公告）',
  notice_content    longblob        default null               comment '公告内容',
  status            char(1)         default '0'                comment '公告状态（0正常 1关闭）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(255)    default null               comment '备注',
  primary key (notice_id)
) engine=innodb comment = '通知公告表';

-- ----------------------------
-- 初始化-公告信息表数据
-- ----------------------------
insert into sys_notice values('1', '温馨提醒：2018-07-01 新版本发布啦', '2', '新版本内容', '0', 'admin', sysdate(), '', null, '管理员');
insert into sys_notice values('2', '维护通知：2018-07-01 系统凌晨维护', '1', '维护内容',   '0', 'admin', sysdate(), '', null, '管理员');


-- ----------------------------
-- 18、代码生成业务表
-- ----------------------------
drop table if exists gen_table;
create table gen_table (
  table_id          bigint(20)      not null                   comment '编号',
  table_name        varchar(200)    default ''                 comment '表名称',
  table_comment     varchar(500)    default ''                 comment '表描述',
  sub_table_name    varchar(64)     default null               comment '关联子表的表名',
  sub_table_fk_name varchar(64)     default null               comment '子表关联的外键名',
  class_name        varchar(100)    default ''                 comment '实体类名称',
  tpl_category      varchar(200)    default 'crud'             comment '使用的模板（crud单表操作 tree树表操作）',
  package_name      varchar(100)                               comment '生成包路径',
  module_name       varchar(30)                                comment '生成模块名',
  business_name     varchar(30)                                comment '生成业务名',
  function_name     varchar(50)                                comment '生成功能名',
  function_author   varchar(50)                                comment '生成功能作者',
  gen_type          char(1)         default '0'                comment '生成代码方式（0zip压缩包 1自定义路径）',
  gen_path          varchar(200)    default '/'                comment '生成路径（不填默认项目路径）',
  options           varchar(1000)                              comment '其它生成选项',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (table_id)
) engine=innodb comment = '代码生成业务表';


-- ----------------------------
-- 19、代码生成业务表字段
-- ----------------------------
drop table if exists gen_table_column;
create table gen_table_column (
  column_id         bigint(20)      not null                   comment '编号',
  table_id          bigint(20)                                 comment '归属表编号',
  column_name       varchar(200)                               comment '列名称',
  column_comment    varchar(500)                               comment '列描述',
  column_type       varchar(100)                               comment '列类型',
  java_type         varchar(500)                               comment 'JAVA类型',
  java_field        varchar(200)                               comment 'JAVA字段名',
  is_pk             char(1)                                    comment '是否主键（1是）',
  is_increment      char(1)                                    comment '是否自增（1是）',
  is_required       char(1)                                    comment '是否必填（1是）',
  is_insert         char(1)                                    comment '是否为插入字段（1是）',
  is_edit           char(1)                                    comment '是否编辑字段（1是）',
  is_list           char(1)                                    comment '是否列表字段（1是）',
  is_query          char(1)                                    comment '是否查询字段（1是）',
  query_type        varchar(200)    default 'EQ'               comment '查询方式（等于、不等于、大于、小于、范围）',
  html_type         varchar(200)                               comment '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  dict_type         varchar(200)    default ''                 comment '字典类型',
  sort              int                                        comment '排序',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  primary key (column_id)
) engine=innodb comment = '代码生成业务表字段';

-- ----------------------------
-- OSS对象存储表
-- ----------------------------
drop table if exists sys_oss;
create table sys_oss (
  oss_id          bigint(20)   not null                   comment '对象存储主键',
  file_name       varchar(255) not null default ''        comment '文件名',
  original_name   varchar(255) not null default ''        comment '原名',
  file_suffix     varchar(10)  not null default ''        comment '文件后缀名',
  url             varchar(500) not null                   comment 'URL地址',
  create_time     datetime              default null      comment '创建时间',
  create_by       varchar(64)           default ''        comment '上传人',
  update_time     datetime              default null      comment '更新时间',
  update_by       varchar(64)           default ''        comment '更新人',
  service         varchar(20)  not null default 'minio'   comment '服务商',
  primary key (oss_id)
) engine=innodb comment ='OSS对象存储表';

-- ----------------------------
-- OSS对象存储动态配置表
-- ----------------------------
drop table if exists sys_oss_config;
create table sys_oss_config (
  oss_config_id   bigint(20)   not null                   comment '主建',
  config_key      varchar(20)  not null default ''        comment '配置key',
  access_key      varchar(255)            default ''      comment 'accessKey',
  secret_key      varchar(255)            default ''      comment '秘钥',
  bucket_name     varchar(255)            default ''      comment '桶名称',
  prefix           varchar(255)           default ''      comment '前缀',
  endpoint         varchar(255)           default ''      comment '访问站点',
  domain           varchar(255)           default ''      comment '自定义域名',
  is_https         char(1)                default 'N'     comment '是否https（Y=是,N=否）',
  region           varchar(255)           default ''      comment '域',
  access_policy    char(1)     not null   default '1'     comment '桶权限类型(0=private 1=public 2=custom)',
  status           char(1)                default '1'     comment '状态（0=正常,1=停用）',
  ext1             varchar(255)           default ''      comment '扩展字段',
  create_by       varchar(64)             default ''      comment '创建者',
  create_time     datetime                default null    comment '创建时间',
  update_by       varchar(64)             default ''      comment '更新者',
  update_time     datetime                default null    comment '更新时间',
  remark           varchar(500)           default null    comment '备注',
  primary key (oss_config_id)
) engine=innodb comment='对象存储配置表';

insert into sys_oss_config values (1, 'minio',  'ruoyi',            'ruoyi123',        'ruoyi',             '', '127.0.0.1:9000',                '','N', '',             '1' ,'0', '', 'admin', sysdate(), 'admin', sysdate(), NULL);
insert into sys_oss_config values (2, 'qiniu',  'XXXXXXXXXXXXXXX',  'XXXXXXXXXXXXXXX', 'ruoyi',             '', 's3-cn-north-1.qiniucs.com',     '','N', '',             '1' ,'1', '', 'admin', sysdate(), 'admin', sysdate(), NULL);
insert into sys_oss_config values (3, 'aliyun', 'XXXXXXXXXXXXXXX',  'XXXXXXXXXXXXXXX', 'ruoyi',             '', 'oss-cn-beijing.aliyuncs.com',   '','N', '',             '1' ,'1', '', 'admin', sysdate(), 'admin', sysdate(), NULL);
insert into sys_oss_config values (4, 'qcloud', 'XXXXXXXXXXXXXXX',  'XXXXXXXXXXXXXXX', 'ruoyi-1250000000',  '', 'cos.ap-beijing.myqcloud.com',   '','N', 'ap-beijing',   '1' ,'1', '', 'admin', sysdate(), 'admin', sysdate(), NULL);
insert into sys_oss_config values (5, 'image',  'ruoyi',            'ruoyi123',        'ruoyi',             'image', '127.0.0.1:9000',           '','N', '',             '1' ,'1', '', 'admin', sysdate(), 'admin', sysdate(), NULL);

-- ----------------------------
-- wf_form流程表单信息表
-- ----------------------------
drop table if exists `wf_form`;
create table `wf_form` (
   form_id      bigint(20)   not null auto_increment comment '表单主键',
   form_name    varchar(64)           default ''     comment '表单名称',
   content      longtext              default null   comment '表单内容',
   create_by    varchar(64)           default ''     comment '创建者',
   create_time  datetime              default null   comment '创建时间',
   update_by    varchar(64)           default ''     comment '更新者',
   update_time  datetime              default null   comment '更新时间',
   remark       varchar(255)          default null   comment '备注',
   del_flag     char(1)               default '0'    comment '删除标志（0代表存在 2代表删除）',
   primary key (form_id)
) engine = innodb comment = '流程表单信息表';


-- ----------------------------
-- wf_deploy_form流程实例关联表
-- ----------------------------
drop table if exists `wf_deploy_form`;
create table `wf_deploy_form` (
    deploy_id  varchar(64)     not null     comment '流程实例主键',
    form_key   varchar(64)     not null     comment '表单Key',
    node_key   varchar(64)     not null     comment '节点Key',
    form_name  varchar(64)     default ''   comment '表单名称',
    node_name  varchar(255)    default ''   comment '节点名称',
    content    longtext        default null comment '表单内容',
    primary key (deploy_id, form_key, node_key)
) engine = innodb comment = '流程实例关联表单';

-- ----------------------------
-- wf_category流程分类表
-- ----------------------------
drop table if exists `wf_category`;
create table `wf_category` (
    category_id   bigint       not null  auto_increment comment '流程分类id',
    category_name varchar(64)            default ''     comment '流程分类名称',
    code          varchar(64)            default ''     comment '分类编码',
    remark        varchar(500)           default ''     comment '备注',
    create_by     varchar(64)            default ''     comment '创建者',
    create_time   datetime               default null   comment '创建时间',
    update_by     varchar(64)            default ''     comment '更新者',
    update_time   datetime               default null   comment '更新时间',
    del_flag      char(1)                default '0'    comment '删除标志（0代表存在 2代表删除）',
    primary key (category_id)
) engine=innodb comment = '流程分类表';

-- ----------------------------
-- wf_copy流程抄送表
-- ----------------------------
drop table if exists `wf_copy`;
create table `wf_copy` (
   copy_id         bigint        not null  auto_increment   comment '抄送主键',
   title           varchar(255)            default ''       comment '抄送标题',
   process_id      varchar(64)             default ''       comment '流程主键',
   process_name    varchar(255)            default ''       comment '流程名称',
   category_id     varchar(255)            default ''       comment '流程分类主键',
   deployment_id   varchar(64)             default ''       comment '部署主键',
   instance_id     varchar(64)             default ''       comment '流程实例主键',
   task_id         varchar(64)             default ''       comment '任务主键',
   user_id         bigint                  default null     comment '用户主键',
   originator_id   bigint                  default null     comment '发起人主键',
   originator_name varchar(64)             default ''       comment '发起人名称',
   create_by       varchar(64)             default ''       comment '创建者',
   create_time     datetime                default null     comment '创建时间',
   update_by       varchar(64)             default ''       comment '更新者',
   update_time     datetime                default null     comment '更新时间',
   del_flag        char(1)                 default '0'      comment '删除标志（0代表存在 2代表删除）',
   primary key (`copy_id`)
) engine=innodb comment='流程抄送表';
