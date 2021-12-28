function findBiggestElementInMatrix(matrix){
    let biggestElement = Number.MIN_SAFE_INTEGER;

    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] > biggestElement){
                biggestElement = matrix[row][col];
            }
        }
    }
    return biggestElement;
}

console.log(findBiggestElementInMatrix([[20, 50, 10],
    [8, 33, 145]])
);

console.log(findBiggestElementInMatrix([[3, 5, 7, 12],
    [-1, 4, 33, 2],
    [8, 3, 0, 4]]
));