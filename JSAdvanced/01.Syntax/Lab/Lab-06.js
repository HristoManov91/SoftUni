function solve(num1 , num2){
    let result = 0;

    for (let i = Number(num1) ; i <= Number(num2) ; i++){
        result += i;
    }

    return  result;
}

console.log(solve('1', '5' ));
console.log(solve('-8', '20' ));