function printElementByEventPosition(arr){
    let result = '';
    for (let i = 0; i < arr.length; i++) {
        if ( i % 2 === 0){
           result = result.concat(arr[i] + ' ');
        }
    }
    console.log(result.trim())
}

printElementByEventPosition(['20' , '30' , '40' , '50' , '60'])
printElementByEventPosition(['5' , '10'])

function printElementByEventPosition2(arr){
    let result = [];
    for (let i = 0; i < arr.length; i+=2) {
            result[result.length] = arr[i];
    }
    console.log(result.join(' '));
}

printElementByEventPosition2(['20' , '30' , '40' , '50' , '60'])
printElementByEventPosition2(['5' , '10'])