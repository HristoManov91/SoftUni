function solve(param){
    let type = typeof param;

    return type === 'number'
        ? (Math.pow(param , 2) * Math.PI).toFixed(2)
        : `We can not calculate the circle area, because we receive a ${type}.`
}

console.log(solve(5));
console.log(solve('name'));