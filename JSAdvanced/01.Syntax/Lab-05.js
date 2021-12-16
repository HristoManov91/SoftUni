function solve(num1, num2, operator) {
    let result;

    if (operator == '+'){
        result = num1 + num2;
    } else if (operator == '-'){
        result = num1 - num2;
    } else if (operator == '*'){
        result = num1 * num2;
    } else if ( operator == '/'){
        result = num1 / num2;
    } else if ( operator == '**'){
        result = num1 ** num2;
    } else if (operator == '%'){
        result = num1 % num2;
    }

    console.log(result);
}

solve(2 , 3 , '+');
solve(2 , 3 , '-');
solve(2 , 3 , '/');
solve(2 , 3 , '**');
solve(2 , 3 , '*');
solve(2 , 3 , '%');

console.log('------')

function solve2(num1, num2, operator) {
    let result;

    switch (operator) {
        case '+':  result = num1 + num2; break;
        case '*':  result = num1 * num2; break;
        case '-':  result = num1 - num2; break;
        case '/':  result = num1 / num2; break;
        case '**':  result = num1 ** num2; break;
        case '%':  result = num1 % num2; break;
    } 

    console.log(result);
}

solve2(2 , 3 , '+');
solve2(2 , 3 , '-');
solve2(2 , 3 , '/');
solve2(2 , 3 , '**');
solve2(2 , 3 , '*');
solve2(2 , 3 , '%');