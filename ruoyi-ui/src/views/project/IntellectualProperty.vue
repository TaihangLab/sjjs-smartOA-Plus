<template>
    <div>
        <el-card class="box-card" style="margin: auto;">
            <div>
                <el-table ref="multipleTable" :data="iplist" border style="width: 100%" :row-style="{ height: '50px' }"
                          :cell-style="{ padding: '0px' }">
                    <!--                <el-table-column type="selection" :resizable="false" align="center" width="40"></el-table-column>-->
                    <el-table-column label="关联项目名称" :resizable="false" align="center" prop="assignedSubjectName"
                                     width="300">
                    </el-table-column>
                    <el-table-column label="知识产权名" :resizable="false" align="center" prop="ipName" :formatter="jobTitles" width="300">
                    </el-table-column>
                    <el-table-column label="知识产权类别" :resizable="false" align="center" prop="ipType" :formatter="diplomas" width="200">
                    </el-table-column>
                    <el-table-column label="知识产权状态" :resizable="false" align="center" prop="ipStatus" width="200">
                    </el-table-column>
                    <el-table-column label="获得日期" :resizable="false" align="center" prop="ipDate"
                                     width="150">
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
            total: 0,
            responsiblePerson: [],
            cascaderOptions: [],
            memberid: undefined,
            iplist: undefined,
            dialogMembersLook: false,
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
            formLook: {}
        };
    },
    created() {
        this.checkmembers();
    },
    methods: {
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
