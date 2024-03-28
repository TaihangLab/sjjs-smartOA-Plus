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
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            (一) {{ "\xa0\xa0" }} 直接费用
                        </template>
                        {{ this.$props.projectfund.totalFundsZxZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.sbfZxZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}设备费
                        </template>
                        {{ this.$props.projectfund.sbfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 20%; text-align: center; "
                        v-if="this.$props.projectfund.sbfGzsbZxZj !== 0">
                        <template slot="label">
                            购置设备费
                        </template>
                        {{ this.$props.projectfund.sbfGzsbZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 20%; text-align: center; "
                        v-if="this.$props.projectfund.sbfSzsbZxZj !== 0">
                        <template slot="label">
                            试制设备费
                        </template>
                        {{ this.$props.projectfund.sbfSzsbZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 20%; text-align: center; "
                        v-if="this.$props.projectfund.sbfSbsjgzZxZj !== 0">
                        <template slot="label">
                            设备升级改造费
                        </template>
                        {{ this.$props.projectfund.sbfSbsjgzZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 20%; text-align: center; "
                                          v-if="this.$props.projectfund.sbfSbzlZxZj !== 0">
                        <template slot="label">
                            设备租赁费
                        </template>
                        {{ this.$props.projectfund.sbfSbzlZxZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.ywfZxZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}业务费
                        </template>
                        {{ this.$props.projectfund.ywfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                           v-if="this.$props.projectfund.ywfClfZxZj !== 0">
                        <template slot="label">
                            材料费
                        </template>
                        {{ this.$props.projectfund.ywfClfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfZlfZxZj !== 0">
                        <template slot="label">
                            资料费
                        </template>
                        {{ this.$props.projectfund.ywfZlfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfSjybcjfZxZj !== 0">
                        <template slot="label">
                            数据/样本采集费
                        </template>
                        {{ this.$props.projectfund.ywfSjybcjfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfCshyjgfZxZj !== 0">
                        <template slot="label">
                            测试化验加工费
                        </template>
                        {{ this.$props.projectfund.ywfCshyjgfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfRldlfZxZj !== 0">
                        <template slot="label">
                            燃料动力费
                        </template>
                        {{ this.$props.projectfund.ywfRldlfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfBgfZxZj !== 0">
                        <template slot="label">
                            办公费
                        </template>
                        {{ this.$props.projectfund.ywfBgfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfYscbfZxZj !== 0">
                        <template slot="label">
                            印刷/出版费
                        </template>
                        {{ this.$props.projectfund.ywfYscbfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfZscqswfZxZj !== 0">
                        <template slot="label">
                            知识产权事务费
                        </template>
                        {{ this.$props.projectfund.ywfZscqswfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfClsyfZxZj !== 0">
                        <template slot="label">
                            车辆使用费
                        </template>
                        {{ this.$props.projectfund.ywfClsyfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfChlfZxZj !== 0">
                        <template slot="label">
                            差旅费
                        </template>
                        {{ this.$props.projectfund.ywfChlfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfHyhwfZxZj !== 0">
                        <template slot="label">
                            会议/会务费
                        </template>
                        {{ this.$props.projectfund.ywfHyhwfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfGnxzfZxZj !== 0">
                        <template slot="label">
                            国内协作费
                        </template>
                        {{ this.$props.projectfund.ywfGnxzfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfGjhzjlfZxZj !== 0">
                        <template slot="label">
                            国际合作交流费
                        </template>
                        {{ this.$props.projectfund.ywfGjhzjlfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfHyclgjhzyjlfZxZj !== 0">
                        <template slot="label">
                            会议/差旅/国际合作与交流费
                        </template>
                        {{ this.$props.projectfund.ywfHyclgjhzyjlfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfCbwxxxcbzscqswfZxZj !== 0">
                        <template slot="label">
                            出版/文献/信息传播/知识产权事务费
                        </template>
                        {{ this.$props.projectfund.ywfCbwxxxcbzscqswfZxZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.lwfZxZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}劳务费
                        </template>
                        {{ this.$props.projectfund.lwfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; " v-if="this.$props.projectfund.lwfZjzxfZxZj !== 0">
                        <template slot="label" >
                            专家咨询费
                        </template>
                        {{ this.$props.projectfund.lwfZjzxfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; " v-if="this.$props.projectfund.lwfRylwfZxZj !== 0">
                        <template slot="label" >
                            人员劳务费
                        </template>
                        {{ this.$props.projectfund.lwfRylwfZxZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.clfZxZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}材料费
                        </template>
                        {{ this.$props.projectfund.clfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.clfClfZxZj !== 0">
                        <template slot="label">
                            材料费
                        </template>
                        {{ this.$props.projectfund.clfClfZxZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.kyhdfZxZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}科研活动费
                        </template>
                        {{ this.$props.projectfund.kyhdfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyhdfZlZxZj !== 0">
                        <template slot="label">
                            资料费
                        </template>
                        {{ this.$props.projectfund.kyhdfZlZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.kyhdfSjybcjZxZj !== 0">
                        <template slot="label">
                            数据/样本采集费
                        </template>
                        {{ this.$props.projectfund.kyhdfSjybcjZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.kyhdfCshyjgZxZj !== 0">
                        <template slot="label">
                            测试化验加工费
                        </template>
                        {{ this.$props.projectfund.kyhdfCshyjgZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.kyhdfRldlZxZj !== 0">
                        <template slot="label">
                            燃料动力费
                        </template>
                        {{ this.$props.projectfund.kyhdfRldlZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.kyhdfBgZxZj !== 0">
                        <template slot="label">
                            办公费
                        </template>
                        {{ this.$props.projectfund.kyhdfBgZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.kyhdfYscbZxZj !== 0">
                        <template slot="label">
                            印刷/出版费
                        </template>
                        {{ this.$props.projectfund.kyhdfYscbZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyhdfZscqswZxZj !== 0">
                        <template slot="label">
                            知识产权事务费
                        </template>
                        {{ this.$props.projectfund.kyhdfZscqswZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyhdfClsyZxZj !== 0">
                        <template slot="label">
                            车辆使用费
                        </template>
                        {{ this.$props.projectfund.kyhdfClsyZxZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.kyfwfZxZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}科研服务费
                        </template>
                        {{ this.$props.projectfund.kyfwfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyfwfHyhwZxZj !== 0">
                        <template slot="label">
                            会议/会务费
                        </template>
                        {{ this.$props.projectfund.kyfwfHyhwZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyfwfClZxZj !== 0">
                        <template slot="label">
                            差旅费
                        </template>
                        {{ this.$props.projectfund.kyfwfClZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                         v-if="this.$props.projectfund.kyfwfGnxzZxZj !== 0">
                        <template slot="label">
                            国内协作费
                        </template>
                        {{ this.$props.projectfund.kyfwfGnxzZxZj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyfwfGjhzjlZxZj !== 0">
                        <template slot="label">
                            国际合作交流费
                        </template>
                        {{ this.$props.projectfund.kyfwfGjhzjlZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                         v-if="this.$props.projectfund.kyfwfZjzxZxZj !== 0">
                        <template slot="label">
                            专家咨询费
                        </template>
                        {{ this.$props.projectfund.kyfwfZjzxZxZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.ryhlwbzfZxZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}人员和劳务补助费
                        </template>
                        {{ this.$props.projectfund.ryhlwbzfZxZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.ryhlwbzfRylwZxZj !== 0">
                        <template slot="label">
                            人员劳务费
                        </template>
                        {{ this.$props.projectfund.ryhlwbzfRylwZxZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border>
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            (二) {{ "\xa0\xa0" }} 间接费用
                        </template>
                        {{ this.$props.projectfund.totalFundsZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.jxzcZxJj !== 0">
                        <template slot="label">
                            绩效支出
                        </template>
                        {{ this.$props.projectfund.jxzcZxJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.glfZxJj !== 0">
                        <template slot="label">
                            管理费
                        </template>
                        {{ this.$props.projectfund.glfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.fwzjfZxJj !== 0">
                        <template slot="label">
                            房屋租赁费
                        </template>
                        {{ this.$props.projectfund.fwzjfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.rcsdnfZxJj !== 0">
                        <template slot="label">
                            日常水、电、暖费
                        </template>
                        {{ this.$props.projectfund.rcsdnfZxJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.sbfZxJj !== 0">
                        <template slot="label">
                            设备费
                        </template>
                        {{ this.$props.projectfund.sbfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.clfZxJj !== 0">
                        <template slot="label">
                            材料费
                        </template>
                        {{ this.$props.projectfund.clfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.zlfZxJj !== 0">
                        <template slot="label">
                            资料费
                        </template>
                        {{ this.$props.projectfund.zlfZxJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.sjybcjfZxJj !== 0">
                        <template slot="label">
                            数据/样本采集费
                        </template>
                        {{ this.$props.projectfund.sjybcjfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.cshyjgfZxJj !== 0">
                        <template slot="label">
                            测试化验加工费
                        </template>
                        {{ this.$props.projectfund.cshyjgfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.rldlfZxJj !== 0">
                        <template slot="label">
                            燃料动力费
                        </template>
                        {{ this.$props.projectfund.rldlfZxJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.bgfZxJj !== 0">
                        <template slot="label">
                            办公费
                        </template>
                        {{ this.$props.projectfund.bgfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.yscbfZxJj !== 0">
                        <template slot="label">
                            印刷/出版费
                        </template>
                        {{ this.$props.projectfund.yscbfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                           v-if="this.$props.projectfund.zscqswfZxJj !== 0">
                        <template slot="label">
                            知识产权事务费
                        </template>
                        {{ this.$props.projectfund.zscqswfZxJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                           v-if="this.$props.projectfund.clsyfZxJj !== 0">
                        <template slot="label">
                            车辆使用费
                        </template>
                        {{ this.$props.projectfund.clsyfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                           v-if="this.$props.projectfund.chlfZxJj !== 0">
                        <template slot="label">
                            差旅费
                        </template>
                        {{ this.$props.projectfund.chlfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.hyhwfZxJj !== 0">
                        <template slot="label">
                            会议/会务费
                        </template>
                        {{ this.$props.projectfund.hyhwfZxJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                           v-if="this.$props.projectfund.zjzxfZxJj !== 0">
                        <template slot="label">
                            专家咨询费
                        </template>
                        {{ this.$props.projectfund.zjzxfZxJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                           v-if="this.$props.projectfund.othersZxJj !== 0">
                        <template slot="label">
                            其他
                        </template>
                        {{ this.$props.projectfund.othersZxJj}}
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
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            (一) {{ "\xa0\xa0" }} 直接费用
                        </template>
                        {{ this.$props.projectfund.totalFundsZcZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.sbfZcZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}设备费
                        </template>
                        {{ this.$props.projectfund.sbfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 20%; text-align: center; "
                                          v-if="this.$props.projectfund.sbfGzsbZcZj !== 0">
                        <template slot="label">
                            购置设备费
                        </template>
                        {{ this.$props.projectfund.sbfGzsbZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 20%; text-align: center; "
                                          v-if="this.$props.projectfund.sbfSzsbZcZj !== 0">
                        <template slot="label">
                            试制设备费
                        </template>
                        {{ this.$props.projectfund.sbfSzsbZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 20%; text-align: center; "
                                          v-if="this.$props.projectfund.sbfSbsjgzZcZj !== 0">
                        <template slot="label">
                            设备升级改造费
                        </template>
                        {{ this.$props.projectfund.sbfSbsjgzZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 20%; text-align: center; "
                                          v-if="this.$props.projectfund.sbfSbzlZcZj !== 0">
                        <template slot="label">
                            设备租赁费
                        </template>
                        {{ this.$props.projectfund.sbfSbzlZcZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.ywfZcZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}业务费
                        </template>
                        {{ this.$props.projectfund.ywfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfClfZcZj !== 0">
                        <template slot="label">
                            材料费
                        </template>
                        {{ this.$props.projectfund.ywfClfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfZlfZcZj !== 0">
                        <template slot="label">
                            资料费
                        </template>
                        {{ this.$props.projectfund.ywfZlfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfSjybcjfZcZj !== 0">
                        <template slot="label">
                            数据/样本采集费
                        </template>
                        {{ this.$props.projectfund.ywfSjybcjfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfCshyjgfZcZj !== 0">
                        <template slot="label">
                            测试化验加工费
                        </template>
                        {{ this.$props.projectfund.ywfCshyjgfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfRldlfZcZj !== 0">
                        <template slot="label">
                            燃料动力费
                        </template>
                        {{ this.$props.projectfund.ywfRldlfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfBgfZcZj !== 0">
                        <template slot="label">
                            办公费
                        </template>
                        {{ this.$props.projectfund.ywfBgfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfYscbfZcZj !== 0">
                        <template slot="label">
                            印刷/出版费
                        </template>
                        {{ this.$props.projectfund.ywfYscbfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfZscqswfZcZj !== 0">
                        <template slot="label">
                            知识产权事务费
                        </template>
                        {{ this.$props.projectfund.ywfZscqswfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfClsyfZcZj !== 0">
                        <template slot="label">
                            车辆使用费
                        </template>
                        {{ this.$props.projectfund.ywfClsyfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfChlfZcZj !== 0">
                        <template slot="label">
                            差旅费
                        </template>
                        {{ this.$props.projectfund.ywfChlfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfHyhwfZcZj !== 0">
                        <template slot="label">
                            会议/会务费
                        </template>
                        {{ this.$props.projectfund.ywfHyhwfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfGnxzfZcZj !== 0">
                        <template slot="label">
                            国内协作费
                        </template>
                        {{ this.$props.projectfund.ywfGnxzfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfGjhzjlfZcZj !== 0">
                        <template slot="label">
                            国际合作交流费
                        </template>
                        {{ this.$props.projectfund.ywfGjhzjlfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfHyclgjhzyjlfZcZj !== 0">
                        <template slot="label">
                            会议/差旅/国际合作与交流费
                        </template>
                        {{ this.$props.projectfund.ywfHyclgjhzyjlfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.ywfCbwxxxcbzscqswfZcZj !== 0">
                        <template slot="label">
                            出版/文献/信息传播/知识产权事务费
                        </template>
                        {{ this.$props.projectfund.ywfCbwxxxcbzscqswfZcZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.lwfZcZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}劳务费
                        </template>
                        {{ this.$props.projectfund.lwfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; " v-if="this.$props.projectfund.lwfZjzxfZcZj !== 0">
                        <template slot="label" >
                            专家咨询费
                        </template>
                        {{ this.$props.projectfund.lwfZjzxfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; " v-if="this.$props.projectfund.lwfRylwfZcZj !== 0">
                        <template slot="label" >
                            人员劳务费
                        </template>
                        {{ this.$props.projectfund.lwfRylwfZcZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.clfZcZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}材料费
                        </template>
                        {{ this.$props.projectfund.clfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.clfClfZcZj !== 0">
                        <template slot="label">
                            材料费
                        </template>
                        {{ this.$props.projectfund.clfClfZcZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.kyhdfZcZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}科研活动费
                        </template>
                        {{ this.$props.projectfund.kyhdfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyhdfZlZcZj !== 0">
                        <template slot="label">
                            资料费
                        </template>
                        {{ this.$props.projectfund.kyhdfZlZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.kyhdfSjybcjZcZj !== 0">
                        <template slot="label">
                            数据/样本采集费
                        </template>
                        {{ this.$props.projectfund.kyhdfSjybcjZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.kyhdfCshyjgZcZj !== 0">
                        <template slot="label">
                            测试化验加工费
                        </template>
                        {{ this.$props.projectfund.kyhdfCshyjgZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.kyhdfRldlZcZj !== 0">
                        <template slot="label">
                            燃料动力费
                        </template>
                        {{ this.$props.projectfund.kyhdfRldlZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.kyhdfBgZcZj !== 0">
                        <template slot="label">
                            办公费
                        </template>
                        {{ this.$props.projectfund.kyhdfBgZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center; "
                                          v-if="this.$props.projectfund.kyhdfYscbZcZj !== 0">
                        <template slot="label">
                            印刷/出版费
                        </template>
                        {{ this.$props.projectfund.kyhdfYscbZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyhdfZscqswZcZj !== 0">
                        <template slot="label">
                            知识产权事务费
                        </template>
                        {{ this.$props.projectfund.kyhdfZscqswZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyhdfClsyZcZj !== 0">
                        <template slot="label">
                            车辆使用费
                        </template>
                        {{ this.$props.projectfund.kyhdfClsyZcZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.kyfwfZcZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}科研服务费
                        </template>
                        {{ this.$props.projectfund.kyfwfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyfwfHyhwZcZj !== 0">
                        <template slot="label">
                            会议/会务费
                        </template>
                        {{ this.$props.projectfund.kyfwfHyhwZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyfwfClZcZj !== 0">
                        <template slot="label">
                            差旅费
                        </template>
                        {{ this.$props.projectfund.kyfwfClZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyfwfGnxzZcZj !== 0">
                        <template slot="label">
                            国内协作费
                        </template>
                        {{ this.$props.projectfund.kyfwfGnxzZcZj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyfwfGjhzjlZcZj !== 0">
                        <template slot="label">
                            国际合作交流费
                        </template>
                        {{ this.$props.projectfund.kyfwfGjhzjlZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.kyfwfZjzxZcZj !== 0">
                        <template slot="label">
                            专家咨询费
                        </template>
                        {{ this.$props.projectfund.kyfwfZjzxZcZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border v-if="this.$props.projectfund.ryhlwbzfZcZj !== 0">
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            {{ "\xa0\xa0\xa0" }}人员和劳务补助费
                        </template>
                        {{ this.$props.projectfund.ryhlwbzfZcZj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.ryhlwbzfRylwZcZj !== 0">
                        <template slot="label">
                            人员劳务费
                        </template>
                        {{ this.$props.projectfund.ryhlwbzfRylwZcZj}}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions class="margin-top" :column="3" border>
                    <el-descriptions-item labelStyle="font-weight: 550; width: 18%;" contentStyle="width: 72%" :span="3">
                        <template slot="label">
                            (二) {{ "\xa0\xa0" }} 间接费用
                        </template>
                        {{ this.$props.projectfund.totalFundsZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.jxzcZcJj !== 0">
                        <template slot="label">
                            绩效支出
                        </template>
                        {{ this.$props.projectfund.jxzcZcJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.glfZcJj !== 0">
                        <template slot="label">
                            管理费
                        </template>
                        {{ this.$props.projectfund.glfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.fwzjfZcJj !== 0">
                        <template slot="label">
                            房屋租赁费
                        </template>
                        {{ this.$props.projectfund.fwzjfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.rcsdnfZcJj !== 0">
                        <template slot="label">
                            日常水、电、暖费
                        </template>
                        {{ this.$props.projectfund.rcsdnfZcJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.sbfZcJj !== 0">
                        <template slot="label">
                            设备费
                        </template>
                        {{ this.$props.projectfund.sbfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.clfZcJj !== 0">
                        <template slot="label">
                            材料费
                        </template>
                        {{ this.$props.projectfund.clfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.zlfZcJj !== 0">
                        <template slot="label">
                            资料费
                        </template>
                        {{ this.$props.projectfund.zlfZcJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.sjybcjfZcJj !== 0">
                        <template slot="label">
                            数据/样本采集费
                        </template>
                        {{ this.$props.projectfund.sjybcjfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.cshyjgfZcJj !== 0">
                        <template slot="label">
                            测试化验加工费
                        </template>
                        {{ this.$props.projectfund.cshyjgfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.rldlfZcJj !== 0">
                        <template slot="label">
                            燃料动力费
                        </template>
                        {{ this.$props.projectfund.rldlfZcJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.bgfZcJj !== 0">
                        <template slot="label">
                            办公费
                        </template>
                        {{ this.$props.projectfund.bgfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.yscbfZcJj !== 0">
                        <template slot="label">
                            印刷/出版费
                        </template>
                        {{ this.$props.projectfund.yscbfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.zscqswfZcJj !== 0">
                        <template slot="label">
                            知识产权事务费
                        </template>
                        {{ this.$props.projectfund.zscqswfZcJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.clsyfZcJj !== 0">
                        <template slot="label">
                            车辆使用费
                        </template>
                        {{ this.$props.projectfund.clsyfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.chlfZcJj !== 0">
                        <template slot="label">
                            差旅费
                        </template>
                        {{ this.$props.projectfund.chlfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.hyhwfZcJj !== 0">
                        <template slot="label">
                            会议/会务费
                        </template>
                        {{ this.$props.projectfund.hyhwfZcJj }}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.zjzxfZcJj !== 0">
                        <template slot="label">
                            专家咨询费
                        </template>
                        {{ this.$props.projectfund.zjzxfZcJj}}
                    </el-descriptions-item>
                    <el-descriptions-item labelStyle="width: 18%; text-align: center;"
                                          v-if="this.$props.projectfund.othersZcJj !== 0">
                        <template slot="label">
                            其他
                        </template>
                        {{ this.$props.projectfund.othersZcJj}}
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
