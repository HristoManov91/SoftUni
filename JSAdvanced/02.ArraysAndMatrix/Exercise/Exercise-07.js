function solve(array){
    let result = [];
    array.sort((a,b) => a - b);

    let count = array.length;
    for (let i = 0; i < count; i++) {
        if ( i % 2 == 0){
            result.push(array.shift())
        } else {
            result.push(array.pop())
        }
    }

    return result;
}

console.log(solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));