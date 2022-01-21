function magicMatrix(matrix){
    let isMagic = true;

    let magicSum = matrix[0].reduce(function(acc , curr){return acc + curr}, 0);

    for (const array of matrix) {
        let sumArray = array.reduce(function(acc , curr){return acc + curr}, 0);
        if (sumArray != magicSum){
            isMagic = false
            break;
        }
    }

    if (isMagic){
        for (let col = 0; col < matrix[0].length; col++) {
            let array = []
            for (let row = 0; row < matrix.length; row++) {
                array.push(matrix[row][col])
            }
            let sumArray = array.reduce(function(acc , curr){return acc + curr}, 0);
            if (sumArray != magicSum){
                isMagic = false
                break
            }
        }
    }

    return isMagic;
}

console.log(magicMatrix([[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]
))
console.log(magicMatrix([[11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]]
))
console.log(magicMatrix([[1, 0, 0],
    [0, 0, 1],
    [0, 1, 0]]
))