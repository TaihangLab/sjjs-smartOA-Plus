import Vue from "vue";

/**
 * 在金额相加时处理undefined的情况
 * @param args
 * @returns {*}
 */
export function addFunds(...args) {
    return args.reduce((previousValue, currentValue, currentIndex, array) => {
        return currentValue ? previousValue + currentValue : previousValue
    }, 0)
}

/**
 * 过滤掉list中firstKey属性为undefined的对象，firstKey默认为id
 * @param list
 * @param firstKey
 * @returns {*[]}
 */
export function filterList(list, firstKey='id') {
    let newList = [];
    if (list.length > 0) {
        list.forEach(item => {
            item[firstKey] ? newList.push(item) : 'continue';
        });
    }
    return newList;
}

/**
 * 重置对象中的属性值
 * @param obj
 * @param value
 */
export function resetObject(obj, value=null) {
    for (const key in obj) {
        Vue.set(obj, key, value);
    }
    console.log("已经重置完成");
}
