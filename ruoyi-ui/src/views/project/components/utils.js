export function fundsAdd(...args) {
    return args.reduce((previousValue, currentValue, currentIndex, array) => {
        return currentValue ? previousValue + currentValue : previousValue
    }, 0)
}
