function sumOfDiagonals(matrix) {
    let mainDiagonalSum = 0;
    let secondDiagonalSum = 0;

    let index = 0;

    for (let i = 0; i < matrix.length; i++) {
        mainDiagonalSum += matrix[index][index];
        secondDiagonalSum += matrix[index][matrix.length - 1 - index]
        index++;
    }

    console.log(mainDiagonalSum + ' ' + secondDiagonalSum);
}

sumOfDiagonals([[20, 40],
    [10, 60]]
);

sumOfDiagonals([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]
)