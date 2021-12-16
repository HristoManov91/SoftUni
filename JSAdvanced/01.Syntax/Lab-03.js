function largestNum(num1 , num2 , num3){
    let result;
    
    if (num1 > num2){
        if (num1 > num3){
            result = num1;
        } else {
            result = num3;
        }
    } else {
        if (num2 > num3){
            result = num2;
        } else {
            result = num3;
        }
    }

    console.log('The largest number is ' + result + '.');
}

largestNum(1 , 3 , 5);

function largestNum2(num1 , num2 , num3){
    console.log('The largest number is ' + Math.max(num1 , num2 , num3) + '.')
}

largestNum2(1 , 3 , 5);

function largestNum3(num1 , num2 , num3){
    let result = Math.max(num1 , num2 , num3);
    console.log(`The largest number is ${result}.`)
}

largestNum3(1 , 3 , 5);

function largestNum4(...params){
    console.log(`The largest number is ${Math.max(...params)}.`)
}

largestNum4(1 , 2 , 3 , 4, 5);




