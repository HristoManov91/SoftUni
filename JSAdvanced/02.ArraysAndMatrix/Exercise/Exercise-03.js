function solve(commands){
    let output = [];
    let number = 1;

    for (const command of commands) {
        switch (command){
            case 'add':
                output.push(number)
                break;
            case 'remove':
                output.pop()
                break;
        }
        number++;
    }

    console.log(output.length == 0 ? 'Empty' : output.join('\n'));
}

solve(['add',
    'add',
    'add',
    'add']
);

solve(['add',
    'add',
    'remove',
    'add',
    'add']
);

solve(['remove',
    'remove',
    'remove']
);