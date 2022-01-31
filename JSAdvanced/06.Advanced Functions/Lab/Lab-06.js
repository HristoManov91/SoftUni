function solve(input){
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