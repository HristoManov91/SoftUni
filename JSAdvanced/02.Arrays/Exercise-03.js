function solve (array){
    let number = 1;
    let output = [];

    for (const arrayElement of array) {
        if (arrayElement === 'add'){
            output.push(number)
        } else if (arrayElement === 'remove'){
            output.pop()
        }
        number++;
    }

    if (output.length == 0){
        console.log('Empty')
    } else {
        console.log(output.join('\n'))
    }
}

solve(['add',
    'add',
    'add',
    'add']
)

solve(['add',
    'add',
    'remove',
    'add',
    'add']
)

solve(['remove',
    'remove',
    'remove']
)