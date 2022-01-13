function solve(...params) {
    let sumOfLengths = 0;
    params.forEach(p => sumOfLengths += p.length)

    let averageLength = Math.floor(sumOfLengths / params.length);

    console.log(sumOfLengths);
    console.log(averageLength);
}

solve('chocolate', 'ice cream', 'cake');
solve('pasta', '5', '22.3');