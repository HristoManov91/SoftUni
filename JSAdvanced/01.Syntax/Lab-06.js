function solve(a , b){
    let num1 = Number(a);
    let num2 = Number(b);

    let result = 0;

    for (let i = num1; i <= num2 ; i++){
        result += i;
    }

    return result;
}

console.log(solve('1' , '5'));
console.log(solve('-8' , '20'));