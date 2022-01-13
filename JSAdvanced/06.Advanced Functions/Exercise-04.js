function solve() {

    const recipes = {
        apple: {carbohydrate: 1, flavour: 2},
        lemonade: {carbohydrate: 10, flavour: 20},
        burger: {carbohydrate: 5, fat: 7, flavour: 3},
        eggs: {protein: 5, fat: 1, flavour: 1},
        turkey: {protein: 10, carbohydrate: 10, fat: 10, flavour: 10}
    }

    const storage = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    }

    function restock(microelement, quantity) {
        storage[microelement] = storage[microelement] += quantity;
        return 'Success'
    }

    function prepare(recipe, quantity) {
        let remaining = {};

        for (const element in recipes[recipe]){
            remaining[element] = storage[element] - recipes[recipe][element] * quantity;
            if (remaining[element] < 0){
                return `Error: not enough ${element} in stock`
            }
        }

        Object.assign(storage , remaining);
        return 'Success';
    }

    function report() {
        return `protein=${storage.protein} carbohydrate=${storage.carbohydrate} fat=${storage.fat} flavour=${storage.flavour}`
    }

    return function manager(input){
        let tokens = input.split(' ');

        if (tokens[0] == 'restock'){
            return restock(tokens[1] , Number(tokens[2]))
        } else if (tokens[0] == 'prepare'){
            return prepare(tokens[1] , Number(tokens[2]))
        } else if (tokens[0] == 'report'){
            return report();
        }
    }
}

let manager = solve();
// console.log (manager("restock flavour 50")); // Success
// console.log (manager("prepare lemonade 4")); // Error: not enough carbohydrate in stock

console.log(manager('restock flavour 50'))
console.log(manager('prepare lemonade 4'))
console.log(manager('restock carbohydrate 10'))
console.log(manager('restock flavour 10'))
console.log(manager('prepare apple 1'))
console.log(manager('restock fat 10'))
console.log(manager('prepare burger 1'))
console.log(manager('report'))
