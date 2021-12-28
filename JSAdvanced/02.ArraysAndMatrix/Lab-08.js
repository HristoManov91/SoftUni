function solve(array) {
    let arr = [];

    for (let i = 1; i < array.length; i += 2) {
        arr.push(array[i] * 2);
    }

    return arr.reverse().join(' ');
}

console.log(solve([10, 15, 20, 25]));
console.log(solve([3, 0, 10, 4, 7, 3]));

function solve2(array) {
    return array
        .filter((v, i) => i % 2 == 1)
        .map(x => x * 2)
        .reverse()
        .join(" ");
}

console.log('----')
console.log(solve2([10, 15, 20, 25]));