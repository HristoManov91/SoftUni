function solve(input){

    let result = [];

    let [town , latitude , longitude] = input[0].split('|').filter(e => e.length > 1).map(e => e.trim());

    for (let i = 1; i < input.length; i++) {
        let [city , latit , longit] = input[i].split('|').filter(e => e.length > 1).map(e => e.trim());
        latit = Number(Number(latit).toFixed(2));
        longit = Number(Number(longit).toFixed(2));

        result.push({[town]: city , [latitude]: latit, [longitude]: longit});
    }

    return JSON.stringify(result);
}

console.log(solve(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
));

console.log(solve(['| Town | Latitude | Longitude |',
    '| Veliko Turnovo | 43.0757 | 25.6172 |',
    '| Monatevideo | 34.50 | 56.11 |']
));