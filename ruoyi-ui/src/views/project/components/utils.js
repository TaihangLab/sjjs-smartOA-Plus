export function addFunds(...args) {
    return args.reduce((previousValue, currentValue, currentIndex, array) => {
        return currentValue ? previousValue + currentValue : previousValue
    }, 0)
}

export function filterList(list, firstKey='id') {
    let newList = [];
    list.forEach(item => {
        item[firstKey] ? newList.push(item) : 'continue';
    })
    return newList;
}
