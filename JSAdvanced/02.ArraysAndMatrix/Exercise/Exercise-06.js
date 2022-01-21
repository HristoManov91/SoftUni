function solve(array){
    array.sort((a,b) => a.localeCompare(b));

    let index = 1;
    for (const arrayElement of array) {
        console.log(`${index++}.${arrayElement}`)
    }
}

solve(["John", "Bob", "Christina", "Ema"]);