function solve(array){
    const result = [];

    const [param1 , param2 , param3] = array[0].split('|').filter(e => e.length > 1);

    for (let i = 1; i < array.length; i++) {
        let tokens = array[i].split('|').filter(a => a.length > 1);

        let object = {[param1.trim()]: tokens[0].trim() ,
            [param2.trim()]: Number(Number(tokens[1]).toFixed(2)) ,
            [param3.trim()]: Number(Number(tokens[2]).toFixed(2))};

        result.push(object)
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
