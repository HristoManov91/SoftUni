let aggregateElements = (array) => {
    // let numbersArray = array.map(Number);
    // let sum = numbersArray.reduce((a, b) => a + b);
    let sum = 0;
    let inverseValuesSum = 0;
    let concat = '';
 
    for (let i = 0; i < array.length; i++) {
        sum += array[i]
        inverseValuesSum += 1 / array[i];
        concat += array[i];
    }
 
    // let stringConcat = numbersArray.join('');
 
    console.log(sum);
    console.log(inverseValuesSum);
    console.log(concat);
}


aggregateElements([2, 4, 8, 16])
console.log('--------')
aggregateElements([1, 2, 3])