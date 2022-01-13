function printRectangle(size= 5){

    for (let i = 0; i < size; i++) {
        let result = '';
        for (let j = 0; j < size; j++) {
            result += '* ';
        }
        console.log(result.trim())
    }
}

printRectangle(3);
printRectangle(10);
printRectangle();