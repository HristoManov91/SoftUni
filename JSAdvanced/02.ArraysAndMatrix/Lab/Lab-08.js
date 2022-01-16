function solve(array){
    let output = [];

    for (let i = 1; i < array.length; i+=2) {
        output.unshift(array[i] * 2)
    }

    return output.join(' ');
}

console.log(solve([10, 15, 20, 25]));
console.log(solve([3, 0, 10, 4, 7, 3]));