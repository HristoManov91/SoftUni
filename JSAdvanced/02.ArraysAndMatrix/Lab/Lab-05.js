function solve(array){
    let output = []

    array.sort((a,b) => a - b);
    output.push(array[0]);
    output.push(array[1])

    console.log(output.join(' '));
}

solve([30, 15, 50, 5]);
solve([3, 0, 10, 4, 7, 3]);

