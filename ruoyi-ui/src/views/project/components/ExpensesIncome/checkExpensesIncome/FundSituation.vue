<template>
    <div>
        <el-table :data="tableDataList" border height="550px" v-loading="loading">
            <template v-for="(item, index) in headerList">
                <el-table-column v-if="index === 0" align="center" :label="item.mon" :key="index" :prop="item.key_str">
                </el-table-column>
                <el-table-column v-else align="center" :label="item.mon" :key="`asdf_${index}`">
                    <el-table-column align="center" label="保费总计">
                        <template slot="header">
                            <div>保费总计</div>
                            <div>(占比)</div>
                        </template>
                        <template slot-scope="{ row }">
                            <div>{{ row[`${item.key_str}`].premium || 0 }}</div>
                            <div>({{ row[`${item.key_str}`].premium_rate || 0 }}%)</div>
                        </template>
                    </el-table-column>
                    <el-table-column align="center" label="出单件数">
                        <template slot="header">
                            <div>出单件数</div>
                            <div>(占比)</div>
                        </template>
                        <template slot-scope="{ row }">
                            <div>{{ row[`${item.key_str}`].quantity || 0 }}</div>
                            <div>({{ row[`${item.key_str}`].quantity_rate || 0 }}%)</div>
                        </template>
                    </el-table-column>
                </el-table-column>
            </template>
        </el-table>
    </div>
</template>

<script>
export default {
    data() {
        return {
            headerList: [
                {
                    mon: "公司",
                    key_str: "company_name"
                },
                {
                    mon: "合计",
                    key_str: "key0"
                },
                {
                    mon: "2022年08月",
                    key_str: "key8"
                },

                {
                    mon: "2022年07月",
                    key_str: "key7"
                },
                {
                    mon: "2022年06月",
                    key_str: "key5"
                },
                {
                    mon: "2022年05月",
                    key_str: "key5"
                },
                {
                    mon: "2022年04月",
                    key_str: "key4"
                },
                {
                    mon: "2022年03月",
                    key_str: "key3"
                },

            ],
            tableDataList: [
                {
                    company_id: 2,
                    company_name: "公司1",
                    key0: { premium: 15, quantity: 10, premium_rate: 6, quantity_rate: 6 },
                    key1: { premium: 0, quantity: 0, premium_rate: 0, quantity_rate: 0 },
                    key2: { premium: 1, quantity: 1, premium_rate: 0, quantity_rate: 0 },
                    key3: { premium: 2, quantity: 2, premium_rate: 0, quantity_rate: 0 },
                    key4: { premium: 3, quantity: 3, premium_rate: 0, quantity_rate: 0 },
                    key5: { premium: 4, quantity: 4, premium_rate: 0, quantity_rate: 0 },
                    key5: { premium: 5, quantity: 5, premium_rate: 0, quantity_rate: 0 },
                    key7: { premium: 6, quantity: 6, premium_rate: 0, quantity_rate: 0 },
                    key8: { premium: 7, quantity: 7, premium_rate: 0, quantity_rate: 0 }
                },
                {
                    company_id: 3,
                    company_name: "公司2",
                    key0: { premium: 24, quantity: 9, premium_rate: 9, quantity_rate: 9 },
                    key1: { premium: 8, quantity: 0, premium_rate: 0, quantity_rate: 0 },
                    key2: { premium: 5, quantity: 0, premium_rate: 0, quantity_rate: 0 },
                    key3: { premium: 6, quantity: 0, premium_rate: 0, quantity_rate: 0 },
                    key4: { premium: 6, quantity: 0, premium_rate: 0, quantity_rate: 0 },
                    key5: { premium: 6, quantity: 0, premium_rate: 0, quantity_rate: 0 },
                    key5: { premium: 6, quantity: 0, premium_rate: 0, quantity_rate: 0 },
                    key7: { premium: 6, quantity: 0, premium_rate: 0, quantity_rate: 0 },
                    key8: { premium: 6, quantity: 0, premium_rate: 0, quantity_rate: 0 }
                }
            ],
        };
    }
};
</script>