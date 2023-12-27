<template>
    <el-card header="其他附件" shadow="hover">

        <el-row type="flex" justify="center">

        <FileUpload :idList="form.uploadList"></FileUpload>
        </el-row>

    </el-card>

</template>


<script>
import FileUpload from "@/components/FileUpload/index.vue";

export default {
    props     : ['form'],
    components: {
        FileUpload
    },
    data() {
        return {}
    },
    created() {
        this.$props.form.uploadList = [];
    },
    methods: {}
}
</script>
