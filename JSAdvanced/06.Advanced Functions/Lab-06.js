function solve(input) {

    let result = [];

    for (const command of input) {
        let split = command.split(' ');
        switch (split[0]) {
            case 'add':
                result.push(split[1])
                break;
            case 'remove':
                result = result.filter(e => e !== split[1])
                break;
            case 'print':
                console.log(result.join(','));
                break;
        }
    }
}

solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);

solve(['add pesho', 'add george', 'add peter', 'remove peter', 'print'])