const categoryOptions1 = [
    {
        label: '设备费',
        value: 'sbfZxZj',
        children: [
            {
                label: '购置设备费',
                value: 'sbfGzsbZxZj',
            },
            {
                label: '试制设备费',
                value: 'sbfSzsbZxZj',
            },
            {
                label: '设备升级改造费',
                value: 'sbfSbsjgzZxZj',
            },
            {
                label: '设备租赁费',
                value: 'sbfSbzlZxZj',
            },
        ]
    },
    {
        label: '业务费',
        value: 'ywfZxZj',
        children: [
            {
                label: '材料费',
                value: 'ywfClfZxZj',
            },
            {
                label: '资料费',
                value: 'ywfZlfZxZj',
            },
            {
                label: '数据/样本采集费',
                value: 'ywfSjybcjfZxZj',
            },
            {
                label: '测试化验加工费',
                value: 'ywfCshyjgfZxZj',
            },
            {
                label: '燃料动力费',
                value: 'ywfRldlfZxZj',
            },
            {
                label: '办公费',
                value: 'ywfBgfZxZj',
            },
            {
                label: '印刷/出版费',
                value: 'ywfYscbfZxZj',
            },
            {
                label: '知识产权事务费',
                value: 'ywfZscqswfZxZj',
            },
            {
                label: '车辆使用费',
                value: 'ywfClsyfZxZj',
            },
            {
                label: '出版/文献/信息传播/知识产权事务费',
                value: 'ywfCbwxxxcbzscqswfZxZj',
                children: [
                    {
                        label: '知识产权事务费',
                        value: 'ywfCbwxxxcbzscqswfZscqswfZxZj',
                    },
                    {
                        label: '印刷打印制作费',
                        value: 'ywfCbwxxxcbzscqswfYsdyzzfZxZj',
                    },
                    {
                        label: '文献数据库费',
                        value: 'ywfCbwxxxcbzscqswfWxsjkfZxZj',
                    },
                    {
                        label: '信息传播费',
                        value: 'ywfCbwxxxcbzscqswfXxcbfZxZj',
                    },
                ]
            },
            {
                label: '差旅费',
                value: 'ywfChlfZxZj',
            },
            {
                label: '会议/会务费',
                value: 'ywfHyhwfZxZj',
            },
            {
                label: '国内协作费',
                value: 'ywfGnxzfZxZj',
            },
            {
                label: '国际合作交流费',
                value: 'ywfGjhzjlfZxZj',
            },
            {
                label: '会议/差旅/国际合作与交流费',
                value: 'ywfHyclgjhzyjlfZxZj',
                children: [
                    {
                        label: '会议费',
                        value: 'ywfHyclgjhzyjlfHyfZxZj',
                    },
                    {
                        label: '差旅费',
                        value: 'ywfHyclgjhzyjlfClfZxZj',
                    },
                    {
                        label: '国际合作费',
                        value: 'ywfHyclgjhzyjlfGjhzfZxZj',
                    },
                ]
            },
        ]
    },
    {
        label: '劳务费',
        value: 'lwfZxZj',
        children: [
            {
                label: '专家咨询费',
                value: 'lwfZjzxfZxZj',
            },
            {
                label: '人员劳务费',
                value: 'lwfRylwfZxZj',
            },
        ]
    },
    {
        label: '材料费',
        value: 'clfZxZj',
        children: [
            {
                label: '材料费',
                value: 'clfClfZxZj',
            },
        ]
    },
    {
        label: '科研活动费',
        value: 'kyhdfZxZj',
        children: [
            {
                label: '资料费',
                value: 'kyhdfZlZxZj',
            },
            {
                label: '数据/样本采集费',
                value: 'kyhdfSjybcjZxZj',
            },
            {
                label: '测试化验加工费',
                value: 'kyhdfCshyjgZxZj',
            },
            {
                label: '燃料动力费',
                value: 'kyhdfRldlZxZj',
            },
            {
                label: '办公费',
                value: 'kyhdfBgZxZj',
            },
            {
                label: '印刷/出版费',
                value: 'kyhdfYscbZxZj',
            },
            {
                label: '知识产权事务费',
                value: 'kyhdfZscqswZxZj',
            },
            {
                label: '车辆使用费',
                value: 'kyhdfClsyZxZj',
            },
        ]
    },
    {
        label: '科研服务费',
        value: 'kyfwfZxZj',
        children: [
            {
                label: '会议/会务费',
                value: 'kyfwfHyhwZxZj',
            },
            {
                label: '差旅费',
                value: 'kyfwfClZxZj',
            },
            {
                label: '国内协作费',
                value: 'kyfwfGnxzZxZj',
            },
            {
                label: '国际合作交流费',
                value: 'kyfwfGjhzjlZxZj',
            },
            {
                label: '专家咨询费',
                value: 'kyfwfZjzxZxZj',
            },
        ]
    },
    {
        label: '人员和劳务补助费',
        value: 'ryhlwbzfZxZj',
        children: [
            {
                label: '人员劳务费',
                value: 'ryhlwbzfRylwZxZ',
            },
        ]
    },
    {
        label: '绩效支出',
        value: 'jxzcZxZj',
    },
];
export default categoryOptions1;

// 将金额字段加入到categories中
export function dealData(categories, fundsData) {
    console.log("categories", categories);
    console.log("fundsData1",fundsData[0]);
    categories.forEach(category => {
        console.log("category.value:", category.value);
        // 查找与 category.value 匹配的项
        const item = fundsData.find(item => item.key === category.value);
        if (item) {
            console.log("Match found for:", category.value, "with value:", item.value);
            category.content = item.value;
        }
        // 递归处理子类别
        if (category.children && category.children.length > 0) {
            dealData(category.children, fundsData);
        }
    });
}
export function continueDealData(categories, cards1Form, cards2Form, tableDataForm) {
    categories.forEach(item => {
        if (item.content && item.content !== "0") {
            cards1Form.push({value: item.value, content: item.content});
            // 初始化当前项在tableDataForm中的子数组
            let currentTableDataFormItem = [];
            // 初始化当前项在cards2Form中的子数组
            let currentCards2Item = [];
            // 检查是否存在children属性
            if (item.children && item.children.length > 0) {
                // 遍历children，选取content非0的子项
                item.children.forEach(child => {
                    if (child.content && child.content !== "0") {
                        currentCards2Item.push({value: child.value, content: child.content});
                        // 初始化当前二级子项在tableDataForm中的子数组
                        let currentTableDataFormChildItem = [];
                        // 检查二级子项是否存在children属性
                        if (child.children && child.children.length > 0) {
                            // 遍历三级children，选取content非0的子项
                            child.children.forEach(grandChild => {
                                if (grandChild.content && grandChild.content !== "0") {
                                    currentTableDataFormChildItem.push({value: grandChild.value, content: grandChild.content});
                                }
                            });
                        }
                        // 如果当前二级子项有符合条件的三级子项，则将这些子项添加到对应的tableDataForm子数组中
                        currentTableDataFormItem.push(currentTableDataFormChildItem);
                    }
                });
            }
            // 将处理后的children（如果有）添加到cards2Form
            cards2Form.push(currentCards2Item);
            // 将处理后的三级子菜单（如果有）添加到tableDataForm
            tableDataForm.push(currentTableDataFormItem.length > 0 ? currentTableDataFormItem : [[]]);
        }
    });
}
export function reorganizeData(categories, fundsData, cards1Form, cards2Form, tableDataForm){
    dealData(categories, fundsData);
    continueDealData(categories, cards1Form, cards2Form, tableDataForm);
}


