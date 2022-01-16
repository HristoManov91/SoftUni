function solve(matrix){
    let biggestElement = Number.MIN_SAFE_INTEGER;

    for (const array of matrix) {
        let max = Math.max(...array);
        if (max > biggestElement){
            biggestElement = max;
        }
    }

    return biggestElement;
}

console.log(solve([[20, 50, 10],
    [8, 33, 145]]
))

console.log(solve([[3, 5, 7, 12],
    [-1, 4, 33, 2],
    [8, 3, 0, 4]]
))