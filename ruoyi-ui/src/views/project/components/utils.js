export function addFunds(...args) {
    return args.reduce((previousValue, currentValue, currentIndex, array) => {
        return currentValue ? previousValue + currentValue : previousValue
    }, 0)
}
