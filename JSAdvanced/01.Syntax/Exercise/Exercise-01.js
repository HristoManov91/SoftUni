function solve(fruit , weightInGrams , priceForKil){
    const weightInKil = weightInGrams / 1000;
    const price = priceForKil * weightInKil;

    console.log(`I need $${price.toFixed(2)} to buy ${weightInKil.toFixed(2)} kilograms ${fruit}.`)
}

solve('orange', 2500, 1.80);
solve('apple', 1563, 2.35);