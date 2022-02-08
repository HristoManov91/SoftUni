function solve(input) {
    let listArr = input.shift().split(' ');
    while (input.length > 0) {
        let commands = input.shift().split(' ');
        let singleCommand = commands[0];
        switch (singleCommand) {
            case 'Remove':
                let index = +commands[1];
                if (index >= 0 && index < listArr.length) {
                    listArr.splice(index, 1);
                }
                break;
            case 'Add':
                let name = commands[1];
                let index2 = +commands[2];
                if (listArr.indexOf(name) === -1) {
                    listArr.push(name);
                } else if (index2 >= 0 && index2 <= listArr.length) {
                    listArr.splice(index2, 0, name);
                }
                break;
            case 'Export':
                let startIndex = +commands[1];
                let count = +commands[2];
                if (startIndex < listArr.length) {
                    console.log(`${listArr.slice(startIndex, startIndex + count).join(' ')}`);
                }
                break;
            case 'Print':
                let command = commands[1];
                if (command === 'Reversed') {
                    listArr.reverse();
                }
                console.log(`Contacts: ${listArr.join(' ')}`);
                return;
        }
    }
}