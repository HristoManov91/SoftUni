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

function solve2(input){
    let result = [];

    for (const command of input) {
        let split = command.split(' ');
        switch (split[0]) {
            case 'add':
                add(split[1])
                break;
            case 'remove':
                remove(split[1])
                break;
            case 'print':
                print()
                break;
        }
    }

    function add(str){
        result.push(str);
    }

    function remove(str){
        result = result.filter(e => e !== str)
    }

    function print(){
        console.log(result.join(','));
    }
}

solve2(['add hello', 'add again', 'remove hello', 'add again', 'print']);

solve2(['add pesho', 'add george', 'add peter', 'remove peter', 'print'])