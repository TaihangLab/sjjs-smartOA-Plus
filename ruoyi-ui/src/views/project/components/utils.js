import Vue from "vue";

export function addFunds(...args) {
    return args.reduce((previousValue, currentValue, currentIndex, array) => {
        return currentValue ? previousValue + currentValue : previousValue
    }, 0)
}

export function filterList(list, firstKey='id') {
    let newList = [];
    if (list.length > 0) {
        list.forEach(item => {
            item[firstKey] ? newList.push(item) : 'continue';
        });
    }
    return newList;
}


export function resetObject(obj, value="") {
    for (const key in obj) {
        Vue.set(obj, key, value);
    }
    console.log("已经重置完成");
}
