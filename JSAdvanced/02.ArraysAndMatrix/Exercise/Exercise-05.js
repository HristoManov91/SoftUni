function solve(array){
    let currentBiggest = Number.MIN_SAFE_INTEGER;
    let output = [];

    for (const arrayElement of array) {
        if (arrayElement >= currentBiggest){
            output.push(arrayElement);
            currentBiggest = arrayElement;
        }
    }

    return output;
}

console.log(solve([1,
    3,
    8,
    4,
    10,
    12,
    3,
    2,
    24]
))

console.log(solve([1,
    2,
    3,
    4]
))

console.log(solve([20,
    3,
    2,
    15,
    6,
    1]
))