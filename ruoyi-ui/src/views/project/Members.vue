<template>
    <div>
        <el-form
            ref="dataForm"
            :inline="true"
            class="demo-form-inline"
            style="margin-left: 30px; margin-top: 20px;"
        >
            <el-form-item label="项目成员" >
                <el-cascader
                    v-model="responsiblePerson"
                    :options="cascaderOptions"
                    clearable
                    :show-all-levels="false"
                    placeholder="请选择项目成员"
                    @keyup.enter.native="handleQuery"
                ></el-cascader>
            </el-form-item>
            <el-form-item label="项目名称">
                <el-cascader
                    v-model="responsibleproject"
                    :options="this.projecttree"
                    clearable
                    :show-all-levels="false"
                    placeholder="请选择项目"
                    @keyup.enter.native="handleQuery"
                ></el-cascader>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <el-card class="box-card" style="margin: auto;">
            <div>
                <el-table ref="multipleTable" :data="memberslist" border style="width: 100%" :row-style="{ height: '50px' }"
                          :cell-style="{ padding: '0px' }">
                    <!--                <el-table-column type="selection" :resizable="false" align="center" width="40"></el-table-column>-->
                    <el-table-column label="姓名" :resizable="false" align="center" prop="nickName"
                                     width="120">
                    </el-table-column>
                    <el-table-column label="职称" :resizable="false" align="center" prop="jobTitle" :formatter="jobTitles" width="120">
                    </el-table-column>
                    <el-table-column label="学历" :resizable="false" align="center" prop="diploma" :formatter="diplomas" width="120">
                    </el-table-column>
                    <el-table-column label="当前参与项目数" :resizable="false" align="center" prop="userProjectNumNow" width="150">
                    </el-table-column>
                    <el-table-column label="当前参与国家级项目数" :resizable="false" align="center" prop="userNationNumNow"
                                     width="170">
                    </el-table-column>
                    <el-table-column label="当前参与省部级项目数" :resizable="false" align="center" prop="userProvincialNumNow"
                                     width="170">
                    </el-table-column>
                    <el-table-column label="当前参与自研项目数" :resizable="false" align="center" prop="userEnterpriseNumNow"
                                     width="150">
                    </el-table-column>
                    <el-table-column label="参与项目数" :resizable="false" align="center" prop="userProjectNum" width="120">
                    </el-table-column>
                    <el-table-column label="参与国家级项目数" :resizable="false" align="center" prop="userNationNum" width="150">
                    </el-table-column>
                    <el-table-column label="参与省部级项目数" :resizable="false" align="center" prop="userProvincialNum" width="150">
                    </el-table-column>
                    <el-table-column label="参与自研项目数" :resizable="false" align="center" prop="userEnterpriseNum" width="150">
                    </el-table-column>
                    <el-table-column label="操作" :resizable="false" align="center" min-width="100px" fixed="right">
                        <template v-slot="scope">
                            <el-button size="mini" type="text" icon="el-icon-tickets" @click="lookMembers(scope.row.userId)">详情</el-button>
                        </template>
                    </el-table-column>
                </el-table>

                <!-- 详情打开的界面 -->
                <el-dialog :visible.sync="dialogMembersLook" width="50%">
                    <div class="dialog-content">
                        <CheckMembers :memberid="this.memberid"></CheckMembers>
                    </div>
                </el-dialog>
            </div>
            <el-pagination :current-page="queryParam.pageNum" :page-size="queryParam.pageSize"
               :page-sizes="[5, 10, 20, 50, 100]" :total="total" layout="total ,sizes,prev,pager,next,jumper"
               style="margin-top: 30px" @size-change="sizeChangeHandle" @current-change="CurrentChangeHandle">
            </el-pagination>
        </el-card>
    </div>
</template>
<script>
import { listUser, deptTreeSelect } from "@/api/system/user";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
import request from '@/utils/request';
import CheckProject from "./CheckProject.vue";
import CheckMembers from "@/views/project/components/ViewMember/CheckMembers.vue";
export default {
    components: {CheckMembers, CheckProject},
    data(){
        return {
            responsibleproject: [],
            projecttree: undefined,
            jobTitle: {
                0: '正高级工程师',
                1: '副高级工程师',
                2: '中级工程师',
                3: '初级工程师',
                4: '研究员',
                5: '副研究员',
                6: '助理研究员',
                7: '研究实习员',
            },
            diploma: {
                0: '博士研究生',
                1: '硕士研究生',
                2: '本科',
                3: '专科',
            },
            total: 0,
            responsiblePerson: [],
            cascaderOptions: [],
            memberid: undefined,
            memberslist: undefined,
            dialogMembersLook: false,
            datas: {
                userId: undefined,
                projectId: undefined,
            },
            queryParam: {
                pageNum: 1,
                pageSize: 10,
            },
            myProjectFrom: {},
            formLook: {}
        };
    },
    created() {
        this.getDeptAndUserList();
    },
    methods: {
        jobTitles(row, column, cellValue) {
            // 使用映射关系来获取对应的文字描述
            return this.jobTitle[cellValue] || cellValue;
        },
        diplomas(row, column, cellValue) {
            // 使用映射关系来获取对应的文字描述
            return this.diploma[cellValue] || cellValue;
        },
        async getDeptAndUserList() {
            // this.queryParam.pageNum = 1;
            // this.queryParam.pageSize = 10;
            await this.getDeptTree(); // 等待部门数据加载完成
            await this.getList(); // 等待用户数据加载完成
            this.cascaderOptions = this.adaptData(this.deptOptions);
            this.getProjectTree();
            this.checkmembers();
        },
        /** 查询部门下拉树结构 */
        async getDeptTree() {
            const response = await deptTreeSelect();
            this.deptOptions = response.data;
        },
        /** 查询用户列表 */
        async getList() {
            const response = await listUser();
            this.userList = response.rows;
        },
        // 适配数据的方法
        adaptData(data) {
            return data.map(item => {
                const newItem = {
                    value: item.id,
                    label: item.label,
                    children: []
                };
                if (item.children && item.children.length > 0) {
                    newItem.children = this.adaptData(item.children);
                } else {
                    const usersInDept = this.userList.filter(user => user.deptId === item.id);
                    newItem.children = this.adaptUserData(usersInDept);
                }
                return newItem;
            });
        },
        adaptUserData(data) {
            return data.map(item => {
                const newItem = {
                    value: item.userId,
                    label: item.nickName,
                };
                return newItem;
            });
        },
        // 处理按钮点击事件
        handleQuery() {
            this.datas.projectId = this.responsibleproject[this.responsibleproject.length - 1];
            this.datas.userId = this.responsiblePerson[this.responsiblePerson.length - 1];
            this.checkmembers();
        },
        resetQuery(){
            this.responsibleproject = [];
            this.responsiblePerson = [];
            this.datas.userId = undefined;
            this.datas.projectId = undefined;
            this.queryParam.pageNum = 1;
            this.queryParam.pageSize = 10;
            this.checkmembers();
        },
        handleQueryRequest(queryParams) {
            // 执行后端查询等操作
            if (queryParams && Object.keys(queryParams).length > 0) {
                this.datas = queryParams;
            }
            this.queryParam.pageNum = 1;
            this.checkmembers();
        },
        //详情按钮
        lookMembers(userId) {
            this.dialogMembersLook = true;
            this.memberid = userId;
        },
        // 查看用户列表
        checkmembers() {
            request({
                url: '/project/user/getAllList',
                method: 'post',
                data: this.datas,
                params: this.queryParam,
            })
                .then((resp) => {
                    // 处理获取的用户数据
                    this.memberslist = resp.rows;
                    this.total = resp.total;
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                });
        },
        getProjectTree(){
            request({
                url: '/ip/getProjectTree',
                method: 'get',
                params: this.header,
            })
                .then((resp) => {
                    this.projecttree = resp.data;
                    console.log('项目树：', this.projecttree);
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                });
        },
        sizeChangeHandle(val) {
            this.$set(this.queryParam, 'pageSize', val);
            this.fetchData();
        },
        CurrentChangeHandle(val) {
            this.$set(this.queryParam, 'pageNum', val);
            this.fetchData();
        },
        fetchData() {
            this.getDeptAndUserList();
        },
    },

};
</script>
<style>
.box-card {
    width: 100%;
    margin-bottom: 20px;
}
</style>
