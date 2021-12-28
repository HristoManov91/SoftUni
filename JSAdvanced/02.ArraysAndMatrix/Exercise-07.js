function sortNums(array){
    array.sort((a,b) => a - b);
    let size = array.length;

    let result = [];

    for (let i = 0; i < size; i++) {
        if (i % 2 == 0){
            result.push(array.shift())
        } else {
            result.push(array.pop())
        }
    }

    return result;
}

console.log(sortNums([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]))