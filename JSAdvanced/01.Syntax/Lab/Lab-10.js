function solve(array) {
    console.log(array.reduce((a, b) => a + b));
    let result = 0;
    for (const num of array) {
        result += 1 / num;
    }
    console.log(result);
    console.log(array.join(''));
}

solve([1, 2, 3]);
solve([2, 4, 8, 16]);