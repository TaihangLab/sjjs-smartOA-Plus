<template>
    <div>
        <div style="margin-top: 10px;"></div>
        <el-table v-loading="loading" :data="transformedfile" style="margin: 0; padding: 0;">
            <!-- el-table-column 改用插值语法传递 label -->
            <el-table-column :label="'文件名称'" align="center" prop="originalName" :show-overflow-tooltip="true" />
            <el-table-column :label="'文件格式'" align="center" prop="fileSuffix" :show-overflow-tooltip="true" >
                <template slot-scope="scope">
                    <div>
                        <el-tag v-if="scope.row.fileSuffix === '.pdf'" type="success" size="mini">{{ scope.row.fileSuffix }}</el-tag>
                        <el-tag v-else-if="scope.row.fileSuffix === '.docx'" type="warning" size="mini">{{ scope.row.fileSuffix }}</el-tag>
                        <el-tag v-else-if="scope.row.fileSuffix === '.doc'" type="warning" size="mini">{{ scope.row.fileSuffix }}</el-tag>
                        <el-tag v-else-if="scope.row.fileSuffix === '.xls'" size="mini">{{ scope.row.fileSuffix }}</el-tag>
                        <el-tag v-else-if="scope.row.fileSuffix === '.xlsx'" size="mini">{{ scope.row.fileSuffix }}</el-tag>
                        <el-tag v-else-if="scope.row.fileSuffix === '.ppt'" type="danger" size="mini">{{ scope.row.fileSuffix }}</el-tag>
                        <el-tag v-else-if="scope.row.fileSuffix === '.pptx'" type="danger" size="mini">{{ scope.row.fileSuffix }}</el-tag>
                        <el-tag v-else type="info" size="mini">{{ scope.row.fileSuffix }}</el-tag>
                    </div>
                </template>
            </el-table-column>
            <el-table-column :label="'上传人'" align="center" prop="createBy" :show-overflow-tooltip="true" />
            <el-table-column :label="'上传时间'" align="center" prop="createTime" :show-overflow-tooltip="true" />
            <el-table-column :label="'操作'" align="center">
                <template slot-scope="scope">
                    <el-link :href="scope.row.url" target="_blank" :underline="false" class="attachment-item">
                        <i class="el-icon-download custom-icon"></i>
                    </el-link>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
import request from '@/utils/request';
import data from "../../../system/dict/data.vue";
export default {
    props: {
        projectfile: {
            type: Object,
            required: true,
        },
    },
    name: "file",
    data() {
        return {

        };
    },
    watch: {
        projectfile: {
            handler() {
                // 在属性变化时调用获取详情的方法
                this.transformedfile();
            },
            deep: true,
        },
    },
    methods: {

    },
    computed: {
        data() {
            return data
        },
        transformedfile() {
            // 对用户列表进行数据重构
            const result = [];
            this.projectfile.forEach((file) => {
                const cleanedName = file.originalName.replace(/\.[^/.]+$/, '');
                // 处理上传时间，只保留到日
                const createTime = new Date(file.createTime).toLocaleDateString();
                result.push({
                    originalName: cleanedName,
                    fileSuffix: file.fileSuffix,
                    createBy: file.createBy,
                    createTime: createTime,
                    url: file.url,
                    ossId: file.ossId,
                    // projectUserRole: file.role,
                });
            });
            return result;
        },
    },
};
</script>

<style scoped>
.custom-icon {
    font-size: 20px; /* 设置图标的字体大小 */
}
</style>
