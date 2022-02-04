function solve(array, startIndex, endIndex) {
    if (!Array.isArray(array)) {
        return NaN;
    }

    if (startIndex < 0) {
        startIndex = 0;
    }

    return array
        .slice(startIndex, endIndex + 1)
        .map(Number)
        .reduce((a , b) => a + b, 0);
}

console.log(solve([10, 20, 30, 40, 50, 60], 3, 300));
console.log('----')
console.log(solve([1.1, 2.2, 3.3, 4.4, 5.5], -3, 1));
console.log('----')
console.log(solve([10, 'twenty', 30, 40], 0, 2));
console.log('----')
console.log(solve([], 1, 2));
console.log('----')
console.log(solve('text', 0, 2));