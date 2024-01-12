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
                    <el-table-column label="职称" :resizable="false" align="center" prop="jobTitle" :formatter="jobTitles">
                    </el-table-column>
                    <el-table-column label="学历" :resizable="false" align="center" prop="diploma" :formatter="diplomas">
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
            type: Number,
            required: true,
        },
    },

    data() {
        return {
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
            contentStyle: {
                'text-align': 'center',
                'width': '60%',
            },
            activeNames: ['0'],
            labelStyle: { 'color': '#000', 'width': '30%', },
            params: {
                ipId: null,
            },
            intellectualLook: [],
        };
    },
    watch: {
        ipId: {
            handler(newVal) {
                this.params.ipId = newVal;
                this.activeNames = ['0'];
                this.checkIntellectual();
              console.log("newval",newVal);
            },
            immediate: true, // 立即执行一次
        },
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
        checkIntellectual() {
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

