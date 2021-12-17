function solve (fruit , weightInGrams , pricePerKilogram){
    let kilograms = (weightInGrams / 1000);
    let totalPrise = (pricePerKilogram * kilograms);

    console.log(`I need $${totalPrise.toFixed(2)} to buy ${kilograms.toFixed(2)} kilograms ${fruit}.`)
}

solve('orange', 2500, 1.80);
solve('apple', 1563, 2.35);