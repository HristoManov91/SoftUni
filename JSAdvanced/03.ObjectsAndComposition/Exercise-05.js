function solve(array) {
    let products = new Map();

    for (let tokens of array) {
        let [town, product, price] = tokens.split(" | ");
        if (!products.has(product)) {
            products.set(product, new Map());
        }
        products.get(product).set(town, Number(price));
    }

    for (let [key, value] of products) {
        let lowest = ([...value].reduce(function (a, b) {
            if (a[1] <= b[1]) {
                return a;
            }
            return b;
        }));
        console.log(`${key} -> ${lowest[1]} (${lowest[0]})`);
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