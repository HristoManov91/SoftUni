function solve(num){
    let isEqualNumbers = true
    let numToString = num.toString()
    let sumOfNumbers = Number(numToString.charAt(0));

    for (let i = 1; i < numToString.length; i++) {
        sumOfNumbers += Number(numToString.charAt(i));
        if (Number(numToString.charAt(i)) !== Number(numToString.charAt(i - 1)) && isEqualNumbers){
            isEqualNumbers = false;
        }
    }

    console.log(isEqualNumbers);
    console.log(sumOfNumbers);
}

solve(2222222);
solve(1234);