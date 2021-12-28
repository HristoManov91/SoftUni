function population(towns){
    let townsPopulation = {}


    for (const town of towns) {
        let tokens = town.split(' <-> ');
        let city = tokens[0];
        let population = Number(tokens[1]);

        townsPopulation[city] == undefined ? townsPopulation[city] = population : townsPopulation[city] += population
    }

    for (const town in townsPopulation) {
        console.log(`${town} : ${townsPopulation[town]}`)
    }
}

population(['Sofia <-> 1200000',
    'Montana <-> 20000',
    'New York <-> 10000000',
    'Washington <-> 2345000',
    'Las Vegas <-> 1000000']
)

console.log('-----')

population(['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000']
)