function solve(...args) {
    let largestNum = Number.MIN_SAFE_INTEGER;

    for (const arg of args) {
        if (arg > largestNum){
            largestNum = arg;
        }
    }

    console.log(`The largest number is ${largestNum}.`)
}

solve(5, -3, 16);
solve(-3, -5, -22.5);