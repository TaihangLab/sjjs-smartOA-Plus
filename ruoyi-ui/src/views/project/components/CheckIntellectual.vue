<template>
    <div>
        <div style="margin-top: 10px;"></div>
        <el-collapse v-model="activeNames">
            <el-collapse-item name="1">
                <template slot="title">
                    <span>知识产权成员列表</span>
                </template>
                <el-table ref="multipleTable" :data="this.intellectualLook.ipUserVOList" border style="width: 100%"
                    :row-style="{ height: '50px' }" :cell-style="{ padding: '0px' }">
                    <el-table-column label="姓名" :resizable="false" align="center" prop="nickName">
                    </el-table-column>
                    <el-table-column label="职称" :resizable="false" align="center" prop="jobTitle">
                    </el-table-column>
                    <el-table-column label="学历" :resizable="false" align="center" prop="diploma">
                    </el-table-column>
                    <el-table-column label="邮箱" :resizable="false" align="center" prop="email">
                    </el-table-column>
                    <el-table-column label="手机号码" :resizable="false" align="center" prop="phonenumber">
                    </el-table-column>
                    <el-table-column label="部门名称" :resizable="false" align="center" prop="deptName">
                    </el-table-column>
                </el-table>
            </el-collapse-item>
            <el-collapse-item name="2">
                <template slot="title">
                    <span>知识产权附件列表</span>
                </template>
                <el-table ref="multipleTable" :data="this.intellectualLook.sysOssVoList" border style="width: 100%"
                    :row-style="{ height: '50px' }" :cell-style="{ padding: '0px' }">
                    <el-table-column label="文件名称" :resizable="false" align="center" :show-overflow-tooltip="true"
                        width="500">
                        <template slot-scope="scope">
                            {{ scope.row.originalName.replace(/\..+$/, '') }}
                        </template>
                    </el-table-column>
                    <el-table-column :label="'文件格式'" align="center" prop="fileSuffix" :show-overflow-tooltip="true"
                        width="120">
                        <template slot-scope="scope">
                            <div width="120">
                                <el-tag v-if="scope.row.fileSuffix === '.pdf'" type="success" size="mini">{{
                                    scope.row.fileSuffix }}</el-tag>
                                <el-tag v-else-if="scope.row.fileSuffix === '.docx'" type="warning" size="mini">{{
                                    scope.row.fileSuffix }}</el-tag>
                                <el-tag v-else-if="scope.row.fileSuffix === '.doc'" type="warning" size="mini">{{
                                    scope.row.fileSuffix }}</el-tag>
                                <el-tag v-else-if="scope.row.fileSuffix === '.xls'" size="mini">{{ scope.row.fileSuffix
                                }}</el-tag>
                                <el-tag v-else-if="scope.row.fileSuffix === '.xlsx'" size="mini">{{ scope.row.fileSuffix
                                }}</el-tag>
                                <el-tag v-else-if="scope.row.fileSuffix === '.ppt'" type="danger" size="mini">{{
                                    scope.row.fileSuffix }}</el-tag>
                                <el-tag v-else-if="scope.row.fileSuffix === '.pptx'" type="danger" size="mini">{{
                                    scope.row.fileSuffix }}</el-tag>
                                <el-tag v-else type="info" size="mini">{{ scope.row.fileSuffix }}</el-tag>
                            </div>
                        </template>
                    </el-table-column>
                    <el-table-column label="上传人" :resizable="false" align="center" prop="createBy">
                    </el-table-column>
                    <el-table-column :label="'操作'" :resizable="false" align="center" min-width="100px">
                        <template slot-scope="scope">
                            <el-link :href="scope.row.url" target="_blank" :underline="false">
                                <el-button size="mini" type="text" icon="el-icon-download">下载</el-button>
                            </el-link>
                        </template>
                    </el-table-column>
                </el-table>
            </el-collapse-item>
        </el-collapse>
    </div>
</template>

<script>
import request from "@/utils/request";

export default {
    props: {
        ipId: {
            type: String,
            required: true,
        },
    },

    data() {
        return {
            contentStyle: {
                'text-align': 'center',
                'width': '60%',
            },
            activeNames: ['0'],
            labelStyle: { 'color': '#000', 'width': '30%', },
            params: {
                ipId: undefined,
            },
            intellectualLook: [],
        };
    },
    // created() {
    //     console.log('ipId传递过来的值:', this.ipId);
    //     this.cheakIntellectual();
    // },
    watch: {
        ipId: {
            handler(newVal) {
                // 监听到memberid变化时，重新获取项目详情数据
                this.params.ipId = newVal;
                this.activeNames = ['0'];
                this.cheakIntellectual();
            },
            immediate: true, // 立即执行一次
        },
    },
    methods: {
        cheakIntellectual() {
            this.params.ipId = this.$props.ipId;
            console.log('this.params.ipId', this.params.ipId);
            request({
                url: '/ip/getDetails',
                method: 'get',
                params: this.params,
            })
                .then((resp) => {
                    this.intellectualLook = resp.data;
                    console.log('详情数据', this.intellectualLook)
                })
                .catch((error) => {
                    console.error('获取数据时出错：', error);
                });
        },
    },
};
</script>

