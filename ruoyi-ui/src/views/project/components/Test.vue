<template>
    <div>

        <h1>{{ abc.a }}</h1>
        <el-button @click="add">jiajia</el-button>
    </div>
</template>


<script setup>
import {ref} from "vue";

let abc = ref({a:1});

function add() {
    abc.value.a++;
}

</script>

<style scoped lang="scss">

</style>
