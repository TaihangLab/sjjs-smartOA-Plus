<template>
    <div>
        <CheckProject @query-request="handleQueryRequest"/>
        <div>
            <Project :projectListLook="projectListLook" :total="total" :queryParam="queryParam" @update-query-param="updateQueryParam"/>
        </div>
    </div>
</template>

<script>
import request from '@/utils/request';
import Project from "@/views/project/Project.vue";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
import CheckProject from "./CheckProject.vue";

export default {
    name: "ProjectList",
    components: {CheckProject, Project },
    data() {
        return {
            queryParam: {
                pageNum: 2,
                pageSize: 5,
            },
            queryPara: {
                pageNum: 2,
                pageSize: 5,
            },
            projectListLook: {},
            total: 0,
        };
    },
    created() {
        this.getprojectList();
    },
    methods: {
        handleQueryRequest(queryParams) {
            // 执行后端查询等操作
            if (queryParams && Object.keys(queryParams).length > 0) {
                this.queryParam = queryParams;
            }
            console.log('projectlistquery', this.queryParam);
            this.getprojectList();
        },
        getprojectList() {
            console.log('参数', this.queryParam);
            request({
                url: '/project/list/getAllList',
                method: 'post',
                data: this.queryParam,
                // params: this.queryPara,
            })
                .then((resp) => {
                    this.projectListLook = resp.rows;
                    this.total = resp.total;
                    console.log('项目', this.projectListLook);
                })
                .catch((error) => {
                    console.error('获取数据时出错：', error);
                });
        },
        updateQueryParam(newQueryParam) {
            this.queryPara = newQueryParam;
        },
    },
}
</script>

