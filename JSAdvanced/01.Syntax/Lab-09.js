function printSquare(num = 5){
    for (let index = 0; index < num; index++) {
        let line = '';
        for (let index = 0; index < num; index++) {
            line += '* '
        }
        console.log(line);
    }
}

printSquare(1)
console.log('--------------')
printSquare(3)
console.log('--------------')
printSquare();