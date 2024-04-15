<template>
    <div>
        <el-form ref="form" :rules="rules" :model="form" label-width="120px">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="项目名称" prop="projectName">
                        <el-input v-model="form.projectName" style="width: 520px"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="专项/自筹" prop="zxzc">
                        <el-select v-model="form.zxzc" placeholder="请选择项目类别">
                            <el-option v-for="item in zxzcOptions" :key="item.zxzcId" :label="item.zxzcName"
                                :value="item.zxzcId" :disabled="item.status === 1"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="直接/间接" prop="zjjj">
                        <el-select v-model="form.zjjj" placeholder="请选择项目类别">
                            <el-option v-for="item in zjjjOptions" :key="item.zjjjId" :label="item.zjjjName"
                                :value="item.zjjjId" :disabled="item.status === 1"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="一级科目" prop="firstLevelSubject">
                        <el-select v-model="form.firstLevelSubject" placeholder="请选择一级科目">
                            <el-option v-for="item in firstLevelSubjectOptions" :key="item.firstLevelSubjectId"
                                :label="item.firstLevelSubjectName" :value="item.firstLevelSubjectId"
                                :disabled="item.status === 1"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="凭证号" prop="voucherNo">
                        <el-input v-model="form.voucherNo" style="width: 192px"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="二级科目" prop="secondLevelSubject">
                        <el-select v-model="form.secondLevelSubject" placeholder="请选择二级科目">
                            <el-option v-for="item in secondLevelSubjectOptions" :key="item.secondLevelSubjectId"
                                :label="item.secondLevelSubjectName" :value="item.secondLevelSubjectId"
                                :disabled="item.status === 1"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="日期" prop="expenditureDate">
                        <el-col :span="11">
                            <el-date-picker type="date" placeholder="选择日期" v-model="form.expenditureDate"
                                style="width: 192px" value-format="yyyy-MM-dd"></el-date-picker>
                        </el-col>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="三级科目" prop="thirdLevelSubject">
                        <el-select v-model="form.thirdLevelSubject" placeholder="请选择三级科目">
                            <el-option v-for="item in thirdLevelSubjectOptions" :key="item.thirdLevelSubjectId"
                                :label="item.thirdLevelSubjectName" :value="item.thirdLevelSubjectId"
                                :disabled="item.status === 1"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="金额（万元）" prop="amount">
                        <el-input v-model="form.amount" style="width: 192px"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="摘要">
                <el-input type="textarea" v-model="form.expenditureAbstract"></el-input>
            </el-form-item>
            <el-form-item style="text-align: center;margin-left: -100px;">
                <el-button type="primary" @click="onSubmit">确定</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>

export default {
    props: ['projectId'],
    data() {
        return {
            props: { multiple: true },
            // 专项自筹
            zxzcOptions: [{
                zxzcId: '0',
                zxzcName: '专项'
            }, {
                zxzcId: '1',
                zxzcName: '自筹'
            },],
            // 直接间接
            zjjjOptions: [{
                zjjjId: '0',
                zjjjName: '直接'
            }, {
                zjjjId: '1',
                zjjjName: '间接'
            },],
            // 一级科目
            firstLevelSubjectOptions: [{
                firstLevelSubjectId: '0',
                firstLevelSubjectName: '设备费'
            }, {
                firstLevelSubjectId: '1',
                firstLevelSubjectName: '业务费'
            }, {
                firstLevelSubjectId: '2',
                firstLevelSubjectName: '劳务费'
            }, {
                firstLevelSubjectId: '3',
                firstLevelSubjectName: '材料费'
            }, {
                firstLevelSubjectId: '4',
                firstLevelSubjectName: '科研活动费'
            }, {
                firstLevelSubjectId: '5',
                firstLevelSubjectName: '科研服务费'
            }, {
                firstLevelSubjectId: '6',
                firstLevelSubjectName: '人员和劳务补助费'
            }, {
                firstLevelSubjectId: '7',
                firstLevelSubjectName: '绩效支出'
            }, {
                firstLevelSubjectId: '8',
                firstLevelSubjectName: '管理费'
            }, {
                firstLevelSubjectId: '9',
                firstLevelSubjectName: '房屋租赁费'
            }, {
                firstLevelSubjectId: '10',
                firstLevelSubjectName: '日常水电暖费'
            }, {
                firstLevelSubjectId: '11',
                firstLevelSubjectName: '差旅费'
            }, {
                firstLevelSubjectId: '12',
                firstLevelSubjectName: '数据样本采集费'
            }, {
                firstLevelSubjectId: '13',
                firstLevelSubjectName: '测试化验加工费'
            }, {
                firstLevelSubjectId: '14',
                firstLevelSubjectName: '燃料动力费'
            }, {
                firstLevelSubjectId: '15',
                firstLevelSubjectName: '办公费'
            }, {
                firstLevelSubjectId: '16',
                firstLevelSubjectName: '印刷/出版费'
            }, {
                firstLevelSubjectId: '17',
                firstLevelSubjectName: '知识产权事务费'
            }, {
                firstLevelSubjectId: '18',
                firstLevelSubjectName: '车辆使用费'
            }, {
                firstLevelSubjectId: '19',
                firstLevelSubjectName: '差旅费'
            }, {
                firstLevelSubjectId: '20',
                firstLevelSubjectName: '会议/会务费'
            }, {
                firstLevelSubjectId: '21',
                firstLevelSubjectName: '专家咨询费'
            }, {
                firstLevelSubjectId: '22',
                firstLevelSubjectName: '其他费用'
            }],
            // 二级科目
            secondLevelSubjectOptions: [{
                secondLevelSubjectId: '0',
                secondLevelSubjectName: '购置设备费'
            }, {
                secondLevelSubjectId: '1',
                secondLevelSubjectName: '试制设备费'
            }, {
                secondLevelSubjectId: '2',
                secondLevelSubjectName: '设备升级改造费'
            }, {
                secondLevelSubjectId: '3',
                secondLevelSubjectName: '设备租赁费'
            }, {
                secondLevelSubjectId: '4',
                secondLevelSubjectName: '材料费'
            }, {
                secondLevelSubjectId: '5',
                secondLevelSubjectName: '资料费'
            }, {
                secondLevelSubjectId: '6',
                secondLevelSubjectName: '数据/样本采集费'
            }, {
                secondLevelSubjectId: '7',
                secondLevelSubjectName: '测试化验加工费'
            }, {
                secondLevelSubjectId: '8',
                secondLevelSubjectName: '燃料动力费'
            }, {
                secondLevelSubjectId: '9',
                secondLevelSubjectName: '办公费'
            }, {
                secondLevelSubjectId: '10',
                secondLevelSubjectName: '印刷/出版费'
            }, {
                secondLevelSubjectId: '11',
                secondLevelSubjectName: '知识产权事务费'
            }, {
                secondLevelSubjectId: '12',
                secondLevelSubjectName: '车辆使用费'
            }, {
                secondLevelSubjectId: '13',
                secondLevelSubjectName: '出版/文献/信息传播/知识产权事务费'
            }, {
                secondLevelSubjectId: '14',
                secondLevelSubjectName: '差旅费'
            },
            {
                secondLevelSubjectId: '15',
                secondLevelSubjectName: '会议/会务费'
            }, {
                secondLevelSubjectId: '16',
                secondLevelSubjectName: '国内协作费'
            }, {
                secondLevelSubjectId: '17',
                secondLevelSubjectName: '国际合作交流费'
            }, {
                secondLevelSubjectId: '18',
                secondLevelSubjectName: '专家咨询费'
            }, {
                secondLevelSubjectId: '19',
                secondLevelSubjectName: '人员劳务费'
            }, {
                secondLevelSubjectId: '20',
                secondLevelSubjectName: '会议/差旅/国际合作与交流费'
            },{
                secondLevelSubjectId: '21',
                secondLevelSubjectName: '无'
            }],
            // 三级科目
            thirdLevelSubjectOptions: [{
                thirdLevelSubjectId: '0',
                thirdLevelSubjectName: '无'
            }, {
                thirdLevelSubjectId: '1',
                thirdLevelSubjectName: '知识产权事务费'
            }, {
                thirdLevelSubjectId: '2',
                thirdLevelSubjectName: '印刷打印制作费'
            }, {
                thirdLevelSubjectId: '3',
                thirdLevelSubjectName: '文献数据库费'
            }, {
                thirdLevelSubjectId: '4',
                thirdLevelSubjectName: '信息传播费'
            }, {
                thirdLevelSubjectId: '5',
                thirdLevelSubjectName: '会议费'
            }, {
                thirdLevelSubjectId: '6',
                thirdLevelSubjectName: '差旅费'
            }, {
                thirdLevelSubjectId: '7',
                thirdLevelSubjectName: '国际合作费'
            }],
            value: '',
            form: {
                amount: '',
                zxzc: '',
                zjjj: '',
                projectName: '',
                voucherNo: '',
                expenditureAbstract: '',
                expenditureDate: '',
                firstLevelSubject: '',
                secondLevelSubject: '',
                thirdLevelSubject: '',
            },
            rules: {
                projectName: [
                    { required: true, message: '请输入项目名称', trigger: 'blur' }
                ],
            },
        };
    },
    methods: {
        onSubmit() {
            // 创建一个数组来存储表单数据
            let formDataArray = [];
            // 将表单数据推入数组中
            formDataArray.push({
                amount: this.form.amount,
                zxzc: this.form.zxzc,
                zjjj: this.form.zjjj,
                projectName: this.form.projectName,
                voucherNo: this.form.voucherNo,
                expenditureAbstract: this.form.expenditureAbstract,
                expenditureDate: this.form.expenditureDate,
                firstLevelSubject: this.form.firstLevelSubject,
                secondLevelSubject: this.form.secondLevelSubject,
                thirdLevelSubject: this.form.thirdLevelSubject,
            });
            // 将包含表单数据的数组作为自定义事件进行发射
            this.$emit('new-data', formDataArray);
            // 重置表单
            this.reset();
        },
        // 表单重置
        reset() {
            this.form = {
                amount: '',
                zxzc: '',
                zjjj: '',
                projectName: '',
                voucherNo: '',
                expenditureAbstract: '',
                expenditureDate: '',
                firstLevelSubject: '',
                secondLevelSubject: '',
                thirdLevelSubject: '',
            };
        },
    },
};
</script>
