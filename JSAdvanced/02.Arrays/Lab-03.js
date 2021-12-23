function sumFirstAndLastElementInArray(array){
    let firstElement = Number(array.shift());
    let lastElement = Number(array.pop());

    return firstElement + lastElement;
}

console.log(sumFirstAndLastElementInArray(['20' , '30' , '40']))
console.log(sumFirstAndLastElementInArray(['5' , '10']))

function sumFirstAndLastElementInArray2(array){
    let firstElement = Number([...array].shift());//Така създаваме копие на масива и не го модифицираме директно
    let lastElement = Number([...array].pop());

    return firstElement + lastElement;
}

