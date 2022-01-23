function solve(input) {
    let result = [];

    for (const element of input) {
        let [product , price] = element.split(' : ');
        price = Number(price);

        result.push({product , price})
    }

    result.sort((a,b) => a.product.localeCompare(b.product))

    let firstChar = '';
    for (const resultElement of result) {
        if (firstChar !== resultElement.product.charAt(0)){
            firstChar = resultElement.product.charAt(0);
            console.log(firstChar)
        }
        console.log(`  ${resultElement.product}: ${resultElement.price}`)
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
);

solve(['Banana : 2',
    "Rubic's Cube : 5",
    'Raspberry P : 4999',
    'Rolex : 100000',
    'Rollon : 10',
    'Rali Car : 2000000',
    'Pesho : 0.000001',
    'Barrel : 10']
)