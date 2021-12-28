function solve (array){
    let biggestElement = array[0];

    let output = [array[0]];

    for (let i = 1; i < array.length; i++) {
        if (array[i] >= biggestElement){
            biggestElement = array[i]
            output.push(array[i])
        }
    }

    return output;
}

console.log(solve([1, 3, 8, 4, 10, 12, 3, 2, 24]))

console.log(solve([1, 2, 3, 4]))

console.log(solve([20, 3, 2, 15, 6, 1]))

console.log([])