function solve(array) {
    let output = []

    for (const arrayElement of array) {
        let tokens = arrayElement.split(' : ');
        let product = tokens[0];
        let price = Number(tokens[1]);

        let result = {product , price};

        output.push(result)
    }

    output.sort((a,b) => a.product.localeCompare(b.product))

    let letter = output[0].product.charAt(0);
    console.log(letter)
    for (const outputElement of output) {
        if (outputElement.product.charAt(0) !== letter){
            letter = outputElement.product.charAt(0)
            console.log(letter)
        }
        console.log(` ${outputElement.product}: ${outputElement.price}`)
    }
}

solve(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10']
)

// solve(['Banana : 2',
//     'Rubic`s Cube : 5',
//     'Raspberry P : 4999',
//     'Rolex : 100000',
//     'Rollon : 10',
//     'Rali Car : 2000000',
//     'Pesho : 0.000001',
//     'Barrel : 10']
// )