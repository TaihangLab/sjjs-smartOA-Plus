<template>
    <div>
        <div style="margin-top: 10px;"></div>
        <el-collapse v-if="this.$props.projectfund && Object.keys(this.$props.projectfund).length > 0" v-model="activeNames" @change="handleChange">
            <el-collapse-item name="1">
                <template slot="title">
                    <span>项目经费</span>
                    <span style="font-size: 12px; color: #F56C6C;">（单位：万元）</span>
                </template>
                <div style="margin-top: 10px;"></div>
                <el-descriptions class="margin-top" :column="4" border>
                    <el-descriptions-item labelStyle="font-weight: 550; text-align: center;" :span="4">
                        <template slot="label">
                            项目经费总额
                        </template>
                        {{ this.$props.projectfund.totalFundsAll}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{ width: '10%' }">
                        <template slot="label">
                            专项经费
                        </template>
                        {{ this.$props.projectfund.totalFundsZx}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{ width: '10%' }">
                        <template slot="label">
                            专项设备费
                        </template>
                        {{ this.$props.projectfund.sbfZx}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{ width: '10%' }">
                        <template slot="label">
                            专项直接经费
                        </template>
                        {{ this.$props.projectfund.totalFundsZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{ width: '10%' }">
                        <template slot="label">
                            专项间接经费
                        </template>
                        {{ this.$props.projectfund.totalFundsZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{ width: '10%' }">
                        <template slot="label">
                            自筹经费
                        </template>
                        {{ this.$props.projectfund.totalFundsZc}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{ width: '10%' }">
                        <template slot="label">
                            自筹设备费
                        </template>
                        {{ this.$props.projectfund.sbfZc}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{ width: '10%' }">
                        <template slot="label">
                            自筹直接经费
                        </template>
                        {{ this.$props.projectfund.totalFundsZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{ width: '10%' }">
                        <template slot="label">
                            自筹间接经费
                        </template>
                        {{ this.$props.projectfund.totalFundsZcJj}}
                    </el-descriptions-item>
                </el-descriptions>
            </el-collapse-item>
            <el-collapse-item name="2">
                <template slot="title">
                    <span>专项经费</span>
                    <span style="font-size: 12px; color: #F56C6C;">（单位：万元）</span>
                </template>
                <div style="margin-top: 10px;"></div>
                <el-descriptions class="margin-top" :column="3" border>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            (一) {{ "\xa0\xa0" }} 直接费用
                        </template>
                        {{ this.$props.projectfund.totalFundsZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}1.设备费
                        </template>
                        {{ this.$props.projectfund.sbfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                        contentStyle="width: 12%">
                        <template slot="label">
                            购置设备费
                        </template>
                        {{ this.$props.projectfund.sbfGzsbZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                        contentStyle="width: 12%">
                        <template slot="label">
                            试制设备费
                        </template>
                        {{ this.$props.projectfund.sbfSzsbZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                        contentStyle="width: 12%">
                        <template slot="label">
                            设备升级改造费
                        </template>
                        {{ this.$props.projectfund.sbfSbgzyzlZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          contentStyle="width: 12%">
                        <template slot="label">
                            设备租赁费
                        </template>
                        {{ this.$props.projectfund.sbfSbgzyzlZxZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border>
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}2.材料费
                        </template>
                        {{ this.$props.projectfund.clfZxZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}3.科研活动费
                        </template>
                        {{ this.$props.projectfund.kyhdfZxZj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            资料费
                        </template>
                        {{ this.$props.projectfund.kyhdfZlZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                        contentStyle="width: 12%">
                        <template slot="label">
                            测试化验加工费
                        </template>
                        {{ this.$props.projectfund.kyhdfCshyjgZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                        contentStyle="width: 12%">
                        <template slot="label">
                            数据/样本采集费
                        </template>
                        {{ this.$props.projectfund.kyhdfSjybcjZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                        contentStyle="width: 12%">
                        <template slot="label">
                            印刷/出版费
                        </template>
                        {{ this.$props.projectfund.kyhdfYscbZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                        contentStyle="width: 12%">
                        <template slot="label">
                            知识产权事务费
                        </template>
                        {{ this.$props.projectfund.kyhdfZscqswZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                        contentStyle="width: 12%">
                        <template slot="label">
                            办公费
                        </template>
                        {{ this.$props.projectfund.kyhdfBgZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            燃料动力费
                        </template>
                        {{ this.$props.projectfund.kyhdfRldlZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            车辆使用费
                        </template>
                        {{ this.$props.projectfund.kyhdfClsyZxZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                        </template>
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}4.科研服务费
                        </template>
                        {{ this.$props.projectfund.kyfwfZxZj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          contentStyle="width: 12%">
                        <template slot="label">
                            专家咨询费
                        </template>
                        {{ this.$props.projectfund.kyfwfZjzxZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          contentStyle="width: 12%">
                        <template slot="label">
                            差旅费
                        </template>
                        {{ this.$props.projectfund.kyfwfClZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          contentStyle="width: 12%">
                        <template slot="label">
                            会议/会务费
                        </template>
                        {{ this.$props.projectfund.kyfwfHyhwZxZj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          contentStyle="width: 12%">
                        <template slot="label">
                            国际合作交流费
                        </template>
                        {{ this.$props.projectfund.kyfwfGjhzjlZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          contentStyle="width: 12%">
                        <template slot="label">
                            国内协作费
                        </template>
                        {{ this.$props.projectfund.kyfwfGnxzZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          contentStyle="width: 12%">
                        <template slot="label">
                        </template>
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0" }} 5.人员和劳务补助费
                        </template>
                        {{ this.$props.projectfund.ryhlwbzfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            (二) {{ "\xa0\xa0" }} 间接费用
                        </template>
                        {{ this.$props.projectfund.totalFundsZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}1.设备费
                        </template>
                        {{ this.$props.projectfund.sbfZxJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            购置设备费
                        </template>
                        {{ this.$props.projectfund.sbfGzsbZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            试制设备费
                        </template>
                        {{ this.$props.projectfund.sbfSzsbZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            设备改造与租赁费
                        </template>
                        {{ this.$props.projectfund.sbfSbgzyzlZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}2.材料费
                        </template>
                        {{ this.$props.projectfund.clfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}3.科研活动费
                        </template>
                        {{ this.$props.projectfund.kyhdfZxJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            资料费
                        </template>
                        {{ this.$props.projectfund.kyhdfZlZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            测试化验加工费
                        </template>
                        {{ this.$props.projectfund.kyhdfCshyjgZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            数据/样本采集费
                        </template>
                        {{ this.$props.projectfund.kyhdfSjybcjZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            印刷/出版费
                        </template>
                        {{ this.$props.projectfund.kyhdfYscbZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            知识产权事务费
                        </template>
                        {{ this.$props.projectfund.kyhdfZscqswZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            办公费
                        </template>
                        {{ this.$props.projectfund.kyhdfBgZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            燃料动力费
                        </template>
                        {{ this.$props.projectfund.kyhdfRldlZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                            车辆使用费
                        </template>
                        {{ this.$props.projectfund.kyhdfClsyZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                        contentStyle="width: 12%">
                        <template slot="label">
                        </template>
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}4.科研服务费
                        </template>
                        {{ this.$props.projectfund.kyfwfZxJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          contentStyle="width: 12%">
                        <template slot="label">
                            专家咨询费
                        </template>
                        {{ this.$props.projectfund.kyfwfZjzxZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          contentStyle="width: 12%">
                        <template slot="label">
                            差旅费
                        </template>
                        {{ this.$props.projectfund.kyfwfClZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          contentStyle="width: 12%">
                        <template slot="label">
                            会议/会务费
                        </template>
                        {{ this.$props.projectfund.kyfwfHyhwZxJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          contentStyle="width: 12%">
                        <template slot="label">
                            国际合作交流费
                        </template>
                        {{ this.$props.projectfund.kyfwfGjhzjlZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          contentStyle="width: 12%">
                        <template slot="label">
                            国内协作费
                        </template>
                        {{ this.$props.projectfund.kyfwfGnxzZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          contentStyle="width: 12%">
                        <template slot="label">
                        </template>
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0" }} 5.人员和劳务补助费
                        </template>
                        {{ this.$props.projectfund.ryhlwbzfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0" }} 6.绩效支出
                        </template>
                        {{ this.$props.projectfund.jxzcZx}}
                    </el-descriptions-item>
                </el-descriptions>
            </el-collapse-item>
            <el-collapse-item name="3">
                <template slot="title">
                    <span>自筹经费</span>
                    <span style="font-size: 12px; color: #F56C6C;">（单位：万元）</span>
                </template>
                <div style="margin-top: 10px;"></div>
                <el-descriptions class="margin-top" :column="3" border>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            (一) {{ "\xa0\xa0" }} 直接费用
                        </template>
                        {{ this.$props.projectfund.totalFundsZcZj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}1.设备费
                        </template>
                        {{ this.$props.projectfund.sbfZcZj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            购置设备费
                        </template>
                        {{ this.$props.projectfund.sbfGzsbZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            试制设备费
                        </template>
                        {{ this.$props.projectfund.sbfSzsbZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            设备改造与租赁费
                        </template>
                        {{ this.$props.projectfund.sbfSbgzyzlZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}2.材料费
                        </template>
                        {{ this.$props.projectfund.clfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}3.科研活动费
                        </template>
                        {{ this.$props.projectfund.kyhdfZcZj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            资料费
                        </template>
                        {{ this.$props.projectfund.kyhdfZlZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            测试化验加工费
                        </template>
                        {{ this.$props.projectfund.kyhdfCshyjgZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            数据/样本采集费
                        </template>
                        {{ this.$props.projectfund.kyhdfSjybcjZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            印刷/出版费
                        </template>
                        {{ this.$props.projectfund.kyhdfYscbZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            知识产权事务费
                        </template>
                        {{ this.$props.projectfund.kyhdfZscqswZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            办公费
                        </template>
                        {{ this.$props.projectfund.kyhdfBgZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            燃料动力费
                        </template>
                        {{ this.$props.projectfund.kyhdfRldlZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            车辆使用费
                        </template>
                        {{ this.$props.projectfund.kyhdfClsyZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                        </template>
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}4.科研服务费
                        </template>
                        {{ this.$props.projectfund.kyfwfZcZj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                                          contentStyle="width: 15%">
                        <template slot="label">
                            专家咨询费
                        </template>
                        {{ this.$props.projectfund.kyfwfZjzxZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                                          contentStyle="width: 15%">
                        <template slot="label">
                            差旅费
                        </template>
                        {{ this.$props.projectfund.kyfwfClZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                                          contentStyle="width: 15%">
                        <template slot="label">
                            会议/会务费
                        </template>
                        {{ this.$props.projectfund.kyfwfHyhwZcZj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;"
                                          contentStyle="width: 15%">
                        <template slot="label">
                            国际合作交流费
                        </template>
                        {{ this.$props.projectfund.kyfwfGjhzjlZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;"
                                          contentStyle="width: 15%">
                        <template slot="label">
                            国内协作费
                        </template>
                        {{ this.$props.projectfund.kyfwfGnxzZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;"
                                          contentStyle="width: 15%">
                        <template slot="label">
                        </template>
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0" }} 5.人员和劳务补助费
                        </template>
                        {{ this.$props.projectfund.ryhlwbzfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            (二) {{ "\xa0\xa0" }} 间接费用
                        </template>
                        {{ this.$props.projectfund.totalFundsZcJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}1.设备费
                        </template>
                        {{ this.$props.projectfund.sbfZcJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            购置设备费
                        </template>
                        {{ this.$props.projectfund.sbfGzsbZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            试制设备费
                        </template>
                        {{ this.$props.projectfund.sbfSzsbZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            设备改造与租赁费
                        </template>
                        {{ this.$props.projectfund.sbfSbgzyzlZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}2.材料费
                        </template>
                        {{ this.$props.projectfund.clfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}3.科研活动费
                        </template>
                        {{ this.$props.projectfund.kyhdfZcJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            资料费
                        </template>
                        {{ this.$props.projectfund.kyhdfZlZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            测试化验加工费
                        </template>
                        {{ this.$props.projectfund.kyhdfCshyjgZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            数据/样本采集费
                        </template>
                        {{ this.$props.projectfund.kyhdfSjybcjZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            印刷/出版费
                        </template>
                        {{ this.$props.projectfund.kyhdfYscbZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            知识产权事务费
                        </template>
                        {{ this.$props.projectfund.kyhdfZscqswZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            办公费
                        </template>
                        {{ this.$props.projectfund.kyhdfBgZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            燃料动力费
                        </template>
                        {{ this.$props.projectfund.kyhdfRldlZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            车辆使用费
                        </template>
                        {{ this.$props.projectfund.kyhdfClsyZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                        </template>
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}4.科研服务费
                        </template>
                        {{ this.$props.projectfund.kyfwfZcJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                                          contentStyle="width: 15%">
                        <template slot="label">
                            专家咨询费
                        </template>
                        {{ this.$props.projectfund.kyfwfZjzxZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                                          contentStyle="width: 15%">
                        <template slot="label">
                            差旅费
                        </template>
                        {{ this.$props.projectfund.kyfwfClZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                                          contentStyle="width: 15%">
                        <template slot="label">
                            会议/会务费
                        </template>
                        {{ this.$props.projectfund.kyfwfHyhwZcJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;"
                                          contentStyle="width: 15%">
                        <template slot="label">
                            国际合作交流费
                        </template>
                        {{ this.$props.projectfund.kyfwfGjhzjlZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;"
                                          contentStyle="width: 15%">
                        <template slot="label">
                            国内协作费
                        </template>
                        {{ this.$props.projectfund.kyfwfGnxzZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;"
                                          contentStyle="width: 15%">
                        <template slot="label">
                        </template>
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0" }} 5.人员和劳务补助费
                        </template>
                        {{ this.$props.projectfund.ryhlwbzfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0" }} 6.绩效支出
                        </template>
                        {{ this.$props.projectfund.jxzcZc}}
                    </el-descriptions-item>
                </el-descriptions>
            </el-collapse-item>
            <el-collapse-item name="4">
                <template slot="title">
                    <span>经费来源</span>
                    <span style="font-size: 12px; color: #F56C6C;">（单位：万元）</span>
                </template>
                <div style="margin-top: 10px;"></div>
                <!-- 这里放置专项经费的详细信息 -->
                <el-descriptions class="margin-top" :column="3" border>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0" }}(一) {{ "\xa0\xa0" }} 申请从专项经费获得的资助
                        </template>
                        {{ this.$props.projectfund.jflyZx}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0" }}(二) {{ "\xa0\xa0" }} 自筹经费来源
                        </template>
                        {{ this.$props.projectfund.jflyZc }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            其他财政拨款
                        </template>
                        {{ this.$props.projectfund.jflyQtczbkZc}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            单位自有货币资金
                        </template>
                        {{ this.$props.projectfund.jflyDwzyhbzjZc}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;"
                        contentStyle="width: 15%">
                        <template slot="label">
                            其他资金
                        </template>
                        {{ this.$props.projectfund.jflyQtzjZc}}
                    </el-descriptions-item>
                </el-descriptions>
            </el-collapse-item>
        </el-collapse>
        <div v-else class="no-data-message" style="color: #909399; font-size: 14px; text-align: center;">
            暂无数据
        </div>
    </div>
</template>

<script>
export default {
    props: {
        projectfund: {
            type: Object,
            required: true,
        },
    },
    data() {
        return {
            form: {
                name: '',
                // 其他属性...
            },
            contentStyle: {
                'text-align': 'center',
                'width': '60%',
            },
            //label样式
            activeNames: ['0'],
            labelStyle: { 'color': '#000', 'width': '30%', },
            detailsVisible: false, // 是否显示详细信息
            zcdetailsVisible: false, // 是否显示详细信息
        };
    },

    computed: {
        readOnly() {
            return this.detailsVisible;
        },
        readsOnly() {
            return this.zcdetailsVisible;
        },
    },
    methods: {
        toggleDetails() {
            this.detailsVisible = !this.detailsVisible;
        },
        toggleDetail() {
            this.zcdetailsVisible = !this.zcdetailsVisible;
        },
        handleChange(val) {
            console.log(val);
        },
    },
};
</script>
<style>.el-descriptions .el-descriptions__label {
    width: 300px;
    /* 替换为你希望的宽度值 */
}

.header-row {
    font-size: 15px;
    font-weight: bold;
}</style>
