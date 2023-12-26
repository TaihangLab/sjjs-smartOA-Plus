<template>
    <div class="app-container home">
        <div id="curtain">

            <h1 data-heading="数">数据技术</h1>
        </div>

    </div>
</template>

<script>
export default {
    name: "Index",
    data() {
        return {
            // 版本号
            version: "0.8.3",
        };
    },
    methods: {
        goTarget(href) {
            window.open(href, "_blank");
        },
    },
};
</script>

<style scoped lang="scss">

$h1: rgba(49, 48, 48, 0.8);
$blue: #98b5cc;
$yellow: #f63e3e;
$outline: rgba(#fff, .4);
$shadow: rgba($yellow, .5);
#curtain {

    background: linear-gradient(45deg, #e1efff 9%, #409EFF 100%);
    width: 100%;
    height: 15vh;
    border-radius: 30px;
}

h1 {
    font-family: '阿里妈妈东方大楷 Regular', sans-serif;
    font-size: 5vw;
    text-align: center;
    line-height: 1;
    margin: 0;
    top: 12%;
    left: 50%;
    transform: translate(-50%, -50%);
    position: absolute;
    color: $h1;
    letter-spacing: 1rem;

    &:before {
        content: attr(data-heading);
        position: absolute;
        overflow: hidden;
        color: $yellow;
        width: 100%;
        z-index: 5;
        text-shadow: none;
        left: 0%;
        text-align: left;
        animation: flicker 3s linear infinite;
    }
}

@keyframes flicker {
    0%, 19.999%, 22%, 62.999%, 64%, 64.999%, 70%, 100% {
        opacity: .99;
        text-shadow: -1px -1px 0 $outline, 1px -1px 0 $outline,
        -1px 1px 0 $outline, 1px 1px 0 $outline,
        0 -2px 8px, 0 0 2px, 0 0 5px #ff7e00,
        0 0 5px #ff4444, 0 0 2px #ff7e00, 0 2px 3px #000;
    }
    20%, 21.999%, 63%, 63.999%, 65%, 69.999% {
        opacity: 0.4;
        text-shadow: none;
    }
}

@font-face {
    font-family: "阿里妈妈东方大楷 Regular";
    font-weight: 400;
    src: url("../assets/fonts/AlimamaDongFangDaKai-Regular.woff2") format("woff2"),
    url("../assets/fonts/AlimamaDongFangDaKai-Regular.woff") format("woff");
    font-display: swap;
}


</style>

