function solve (array){
    let tempArray = [];

    for (const arrayElement of array) {
        let tokens = arrayElement.split(' | ');
        let town = tokens[0];
        let product = tokens[1];
        let price = tokens[2];

        let object = {town: town, product: product, price: price};

        //ToDo fix same object
        tempArray.push(object);
    }

    for (const object of tempArray) {
        console.log(`${object.product} -> ${object.price} (${object.town})`);
    }
}

solve(['Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10']
)