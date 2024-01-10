<template>
    <el-card header="项目申报附件" shadow="hover">

        <el-row type="flex" justify="center">

            <FileUpload :idList="form.uploadList" :value="form.value"></FileUpload>
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
        this.$set(this.$props.form, "uploadList", []);
        this.$set(this.$props.form, "value", []);
    },
    methods: {}
}
</script>
