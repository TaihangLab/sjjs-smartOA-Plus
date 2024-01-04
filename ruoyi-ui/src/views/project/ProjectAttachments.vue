<template>
    <div>
        <el-form ref="dataForm" :inline="true" class="demo-form-inline" style="margin-left: 30px; margin-top: 20px;">
            <el-form-item label="项目名称">
                <el-cascader v-model="responsiblePerson" :options="cascaderOptions" clearable :show-all-levels="false"
                    placeholder="请选择项目" @keyup.enter.native="handleQuery"></el-cascader>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
                <el-button type="success" icon="el-icon-download" size="mini" @click="handleBatchDownload">
                    批量下载
                </el-button>
            </el-form-item>
        </el-form>

        <el-card class="box-card" style="margin: auto;">
            <div>
                <el-table ref="multipleTable" :data="attachmentslist" border style="width: 100%"
                    :row-style="{ height: '50px' }" :cell-style="{ padding: '0px' }">
                    <el-table-column type="selection" width="50" align="center" />
                    <el-table-column label="文件名称" :resizable="false" align="center" :show-overflow-tooltip="true"
                        width="300">
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
                    <el-table-column label="上传人" :resizable="false" align="center" prop="createBy" width="120">
                    </el-table-column>
                    <el-table-column label="所属大事记" :resizable="false" align="center" prop="milestoneTitle" width="300">
                    </el-table-column>
                    <el-table-column label="文件上传时间" :resizable="false" align="center" prop="createTime" width="170">
                    </el-table-column>
                    <el-table-column :label="'操作'" :resizable="false" align="center" min-width="100px" fixed="right">
                        <template slot-scope="scope">
                            <el-link :href="scope.row.url" target="_blank" :underline="false">
                                <el-button size="mini" type="text" icon="el-icon-download">下载</el-button>
                            </el-link>
                        </template>
                    </el-table-column>
                </el-table>
            </div>
            <el-pagination :current-page="queryParam.pageNum" :page-size="queryParam.pageSize"
                :page-sizes="[5, 10, 20, 50, 100]" :total="total" layout="total ,sizes,prev,pager,next,jumper"
                style="margin-top: 30px" @size-change="sizeChangeHandle" @current-change="CurrentChangeHandle">
            </el-pagination>
        </el-card>
    </div>
</template>
<script>
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
import request from '@/utils/request';
import JSZip from "jszip";

export default {
    data() {
        return {
            total: 0,
            attachmentsId: undefined,
            attachmentslist: [],
            datas: {
                ossId: undefined,
            },
            queryParam: {
                pageNum: 1,
                pageSize: 10,
            },
            myProjectFrom: {},
            formLook: {},
            zipFileName: "sxctc",
        };
    },
    created() {
        this.getAttachmentsList();
    },
    methods: {
        async getAttachmentsList() {
            this.checkattachments();
        },
        /** 查询项目列表 */
        async getList() {
            const response = await listUser();
            this.attachmentslist = response.rows;
        },
        handleQuery() {
            this.datas.userId = this.responsiblePerson[this.responsiblePerson.length - 1];
            this.checkmembers();
        },
        resetQuery() {
            this.datas.ossId = undefined;
            this.queryParam.pageNum = 1;
            this.queryParam.pageSize = 10;
            this.checkattachments();
        },
        handleQueryRequest(queryParams) {
            // 执行后端查询等操作
            if (queryParams && Object.keys(queryParams).length > 0) {
                this.datas = queryParams;
            }
            this.queryParam.pageNum = 1;
            this.checkattachments();
        },
        // 查看附件列表
        checkattachments() {
            request({
                url: '/milestone/oss/getAllList',
                method: 'post',
                data: {},
                params: this.queryParam,
            })
                .then((resp) => {
                    this.attachmentslist = resp.rows;
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
            this.getAttachmentsList();
        },
        async handleBatchDownload() {
            const selectedAttachments = this.$refs.multipleTable.selection;

            if (selectedAttachments && selectedAttachments.length > 0) {
                const zip = new JSZip();
                const folderName = "";
                selectedAttachments.forEach((attachment, index) => {
                    const fileName = `${folderName}/${this.encodeChineseFileName(attachment.originalName, index, attachment.fileSuffix)}`;
                    zip.file(fileName, this.downloadFile(attachment.url));
                });
                zip.generateAsync({ type: "blob" }).then((content) => {
                    const link = document.createElement("a");
                    const timestamp = new Date().getTime();
                    const chineseFileName = encodeURIComponent(this.zipFileName);
                    const zipFileName = `${folderName}_${chineseFileName}_${timestamp}.zip`;
                    link.href = URL.createObjectURL(content);
                    link.download = zipFileName;
                    link.click();
                });
            } else {
                this.$message.warning("请选择要下载的附件");
            }
            this.handleDialogClose();
        },
        encodeChineseFileName(originalName, index, fileSuffix) {
            const sanitizedFileName = originalName.replace(/[\/\\:*?"<>|]/g, "_");
            return `${sanitizedFileName}_${index}${fileSuffix}`;
        },
        downloadFile(url) {
            return fetch(url).then((response) => response.blob());
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
