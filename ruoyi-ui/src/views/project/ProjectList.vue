<template>
    <div>
        <CheckProject @query-request="handleQueryRequest" />
        <div>
            <Project :projectListLook="projectListLook" :myProjectLook="myProjectLook" :total="total"
                :queryParam="queryParam" @update-query-param="updateQueryParam" @reloadProjectList="getprojectList" />
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
    components: { CheckProject, Project },
    data() {
        return {
            queryParams: {
                pageNum: 2,
                pageSize: 5,
            },
            queryParam: {
                pageNum: 1,
                pageSize: 10,
            },
            projectListLook: [],
            total: 0,
            myProjectFrom: {},
            myProjectLook: [],
            projectListKey: 1,
        };
    },
    created() {
        this.getprojectList();
    },
    methods: {
        reloadProjectList(queryParam) {
            this.queryParam = queryParam;
            this.getprojectList(); // 调用原来的获取数据方法
            this.projectListKey += 1; // 修改 key 强制组件重新加载
        },
        handleQueryRequest(queryParams) {
            // 执行后端查询等操作
            if (queryParams && Object.keys(queryParams).length > 0) {
                this.queryParams = queryParams;
            }
            this.queryParam.pageNum = 1;
            this.getprojectList();
        },
        getprojectList() {
            request({
                url: '/project/list/getAllList',
                method: 'post',
                data: this.queryParams,
                params: this.queryParam,
            })
                .then((resp) => {
                    this.projectListLook = resp.rows;
                    this.total = resp.total;
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

