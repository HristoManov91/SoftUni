function solve(array){
    let output = [];

    for (const element of array){
        if (element < 0){
            output.unshift(element);
        } else {
            output.push(element);
        }
    }

    console.log(output.join('\n'));
}

solve([7, -2, 8, 9]);
solve([3, -2, 0, -1]);