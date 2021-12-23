function solve(array){
    let result = [];

    for (const element of array) {
        if (element < 0){
            result.unshift(element);
        } else {
            result.push(element);
        }
    }

    for (const resultElement of result) {
        console.log(resultElement);
    }
}

solve([7 , -2 , 8 , 9]);
solve([3 , -2 , 0 , -1]);