function solve(array , criteria){

    if (criteria == 'asc'){
        return array.sort((a,b) => {
            return a - b;
        })
    } else {
        return array.sort((a,b) => {
            return b - a;
        })
    }
}

console.log(solve([14, 7, 17, 6, 8], 'asc'));
console.log(solve([14, 7, 17, 6, 8], 'desc'));