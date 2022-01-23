function solve(input){
    let result = new Map();

    for (const inputElement of input) {
        let [town , product , price ] = inputElement.split(' | ');
        price = Number(price);

        if (result.has(product)){
            if (result.get(product).price > price){
                result.set(product , {town , price})
            }
        } else {
            result.set(product , {town , price})
        }
    }

    for (let [key, value] of result) {
        console.log(`${key} -> ${value.price} (${value.town})`)
    }
}

solve(['Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10']
);