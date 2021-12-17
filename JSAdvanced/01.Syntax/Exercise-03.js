function solve (number){
    const numAsString = number.toString();
    let sameDigit = true;
    let sum = parseInt(numAsString[0]);

    for (let i = 1; i < numAsString.length ; i++){
        sum += parseInt(numAsString[i]);
        if (numAsString[i] != numAsString[i - 1] && sameDigit){
            sameDigit = false;
        }
    }

    console.log(sameDigit);
    console.log(sum);
}
solve(222222);
console.log('------');
solve(222324);