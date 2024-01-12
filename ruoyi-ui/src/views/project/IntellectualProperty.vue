<template>
    <div>
        <el-form ref="dataForm" :inline="true" class="demo-form-inline" style="margin-left: 30px; margin-top: 20px;">
            <el-form-item label="项目名称">
                <el-cascader v-model="responsibleproject" :options="this.projecttree" clearable :show-all-levels="false"
                             placeholder="请选择项目" @keyup.enter.native="handleQuery"></el-cascader>
            </el-form-item>
            <el-form-item label="知识产权名" >
                <el-input
                    v-model="responsibleIp"
                    clearable
                    placeholder="请输入知识产权名"
                    @keyup.enter.native="handleQuery"
                ></el-input>
            </el-form-item>
            <el-form-item label="知识产权类别">
                <el-select v-model="responsibleType" placeholder="请选择知识产权类别">
                    <el-option v-for="(label, value) in ipType" :label="label" :value="value" :key="value"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="知识产权状态">
                <el-select v-model="responsibleJobTitle" placeholder="请选择知识产权状态">
                    <el-option v-for="(label, value) in ipStatus" :label="label" :value="value" :key="value"></el-option>
                </el-select>
            </el-form-item>
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
            <el-form-item label="获得日期" >
                <el-date-picker
                    v-model="projectEstablishTime"
                    type="daterange"
                    unlink-panels
                    clearable
                    start-placeholder="请输入查询范围"
                    end-placeholder="如：2000-01-01"
                    value-format="yyyy-MM-dd"
                    @change="getList"
                    :picker-options="pickerOptions"
                    @keyup.enter.native="handleQuery"
                ></el-date-picker>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>
        <el-row :gutter="10" class="mb8" style="margin-left: 20px;margin-top: 10px;">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd" v-hasPermi="['project:ip:add']">新增
                </el-button>
            </el-col>
        </el-row>

        <el-card class="box-card" style="margin: auto;">
            <div>
                <el-table ref="multipleTable" :data="iplist" border style="width: 100%" :row-style="{ height: '50px' }"
                          :cell-style="{ padding: '0px' }">
                    <!--                <el-table-column type="selection" :resizable="false" align="center" width="40"></el-table-column>-->
                    <el-table-column label="关联项目名称" :resizable="false" align="center" prop="assignedSubjectName"
                                     width="300">
                    </el-table-column>
                    <el-table-column label="知识产权名" :resizable="false" align="center" prop="ipName"
                                     width="300">
                    </el-table-column>
                    <el-table-column label="知识产权类别" :resizable="false" align="center" prop="ipType" :formatter="allIpType"
                                     width="200">
                    </el-table-column>
                    <el-table-column label="知识产权状态" :resizable="false" align="center" prop="ipStatus" :formatter="allJobTitle" width="200">
                    </el-table-column>
                    <el-table-column label="获得日期" :resizable="false" align="center" prop="ipDate" width="150">
                    </el-table-column>
                    <el-table-column label="操作" :resizable="false" align="center" min-width="200px" fixed="right">
                        <template v-slot="scope">
                            <el-button size="mini" type="text" icon="el-icon-tickets"
                                       @click="lookIntellectual(scope.row.ipId)"
                                       v-hasPermi="['project:ip:getDetails']"
                            >详情</el-button>
                            <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row.ipId)" v-hasPermi="['project:ip:update']">修改
                            </el-button>
                            <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)" v-hasPermi="['project:ip:delete']">删除
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <!-- 详情打开的界面 -->
                <el-dialog :visible.sync="dialogIntellectualLook" width="50%">
                    <CheckIntellectual :ipId="String(ipId)" @close-dialog="closeIntellectualDialogLook"></CheckIntellectual>
                </el-dialog>
                <!--新增知识产权-->
                <el-dialog title="新增知识产权" :visible.sync="intellectualDialogVisibleAdd" width="700px">
                    <AddIntellectual @close-dialog="closeIntellectualDialog"></AddIntellectual>
                </el-dialog>
                <!--修改知识产权-->
                <el-dialog title="修改知识产权" :visible.sync="intellectualDialogVisibleEdit" width="700px">
                    <EditIntellectual :ipId="Number(ipId)" @close-dialog="closeIntellectualDialogs"></EditIntellectual>
                </el-dialog>
            </div>
            <el-pagination  :current-page="queryParam.pageNum" :page-size="queryParam.pageSize"
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
import CheckIntellectual from "@/views/project/components/CheckIntellectual.vue";
import AddIntellectual from "@/views/project/components/AddIntellectual.vue";
import EditIntellectual from "@/views/project/components/EditIntellectual.vue";

export default {
    components: { CheckIntellectual, AddIntellectual ,EditIntellectual},
    data() {
        return {
            projecttree: undefined,
            ipStatus: {
                0: '专利受理',
                1: '专利授权',
                2: '软著已获取',
                3: '标准正在申报',
                4: '标准已通过',
                5: '论文已发表',
            },
            ipType: {
                0: '国内发明专利',
                1: '软件著作权',
                2: '论文',
                3: '标准',
            },
            total: 0,
            projectEstablishTime: [],
            responsibleIp: undefined,
            responsibleType: undefined,
            responsibleJobTitle: undefined,
            responsiblePerson: [],
            responsibleproject: [],
            cascaderOptions: [],
            ipId: undefined,
            iplist: undefined,
            dialogIntellectualLook: false,
            intellectualDialogVisibleAdd: false,
            intellectualDialogVisibleEdit:false,
            datas: {
                "projectId": undefined,
                "ipName": undefined,
                "ipType": undefined,
                "ipStatus": undefined,
                "userId": undefined,
                "ipDateSta": undefined,
                "ipDateEnd": undefined,
            },
            queryParam: {
                pageNum: 1,
                pageSize: 10,
            },
            myProjectFrom: {},
            formLook: {},
            pickerOptions: {}
        };
    },
    created() {
        this.checkIp();
    },
    methods: {
        async checkIp(){
            this.getDeptAndUserList();
            this.getProjectTree();
            this.checkmembers();
        },

        // 按项目级别-项目搜索
        getProjectTree(){
            request({
                url: '/ip/getProjectMapping',
                method: 'get',
                params: this.header,
            })
                .then((resp) => {
                    this.projecttree = resp.data;
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                });
        },

        // 按部门-人员搜索
        async getDeptAndUserList() {
            // this.queryParam.pageNum = 1;
            // this.queryParam.pageSize = 10;
            await this.getDeptTree(); // 等待部门数据加载完成
            await this.getList(); // 等待用户数据加载完成
            this.cascaderOptions = this.adaptData(this.deptOptions);
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

        // 处理按钮点击事件搜索
        handleQuery() {
            this.datas.ipName = this.responsibleIp;
            this.datas.projectId = this.responsibleproject[this.responsibleproject.length - 1];
            this.datas.userId = this.responsiblePerson[this.responsiblePerson.length - 1];
            this.datas.ipType = this.responsibleType;
            this.datas.ipStatus = this.responsibleJobTitle;
            if(this.projectEstablishTime){
                this.datas.ipDateSta = this.projectEstablishTime[0];
                this.datas.ipDateEnd = this.projectEstablishTime[1];
            }else {
                this.datas.ipDateSta = undefined;
                this.datas.ipDateEnd = undefined;
            }
            this.checkmembers();
        },
        // 处理按钮点击事件重置
        resetQuery(){
            this.datas = {
                projectId: undefined,
                ipName: undefined,
                ipType: undefined,
                ipStatus: undefined,
                userId: undefined,
                ipDateSta: undefined,
                ipDateEnd: undefined,
            };
            this.projectEstablishTime = [];
            this.responsibleIp = undefined;
            this.responsibleType = undefined;
            this.responsibleJobTitle = undefined;
            this.responsiblePerson = [];
            this.responsibleproject = [];
            this.ipId = undefined;
            this.checkmembers();
        },

        allJobTitle(row, column, cellValue) {
            // 使用映射关系来获取对应的文字描述
            return this.ipStatus[cellValue] || cellValue;
        },
        allIpType(row, column, cellValue) {
            // 使用映射关系来获取对应的文字描述
            return this.ipType[cellValue] || cellValue;
        },
        lookIntellectual(ipId) {
            this.dialogIntellectualLook = true;
            this.ipId = ipId;
        },
        handleAdd() {
            this.intellectualDialogVisibleAdd = true;
        },
        closeIntellectualDialogLook(){
            this.resetQuery();
        },
        // 关闭弹窗的方法
        closeIntellectualDialog() {
            this.intellectualDialogVisibleAdd = false;
            this.intellectualDialogVisibleEdit = false;
            this.resetQuery();
        },
        // 关闭弹窗的方法
        closeIntellectualDialogs() {
            this.intellectualDialogVisibleEdit = false;
            this.resetQuery();
        },
        handleUpdate(ipId){
            this.intellectualDialogVisibleEdit = true;
            this.ipId = ipId;
        },
        // 查看用户列表
        checkmembers() {
            request({
                url: '/ip/list',
                method: 'post',
                data: this.datas,
                params: this.queryParam,
            })
                .then((resp) => {
                    // 处理获取的用户数据
                    this.iplist = resp.rows;
                    this.total = resp.total;
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                });
        },
        handleDelete(row) {
            const ipId = row.ipId;  // 假设属性名为ipId
            this.$confirm('确认删除该数据项？').then(() => {
                return this.deleteIp(ipId);  // 调用deleteIp方法
            }).then(() => {
                this.checkmembers();  // 删除后刷新列表
                this.$message.success("删除成功");
            }).catch(() => {
                console.error('删除失败');
            });
            this.ipId = undefined;
        },
        deleteIp(ipId) {
            return request({
                url: '/ip/delete',
                method: 'get',
                params: {
                    ipId: ipId,  // 传递ipId参数
                },
            });
        },
        sizeChangeHandle(val) {
            this.$set(this.queryParam, 'pageSize', val);
            this.queryParam.pageNum = 1;
            this.fetchData();
        },
        CurrentChangeHandle(val) {
            this.$set(this.queryParam, 'pageNum', val);
            this.fetchData();
        },
        fetchData() {
            this.checkmembers();
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
