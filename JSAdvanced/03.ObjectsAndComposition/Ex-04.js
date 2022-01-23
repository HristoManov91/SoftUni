function solve(input) {
    let result = [];

    for (const inputElement of input) {
        let tokens = inputElement.split(' / ');
        let hero = {
            name: tokens[0],
            level: Number(tokens[1]),
            items: tokens[2] ? tokens[2].split(', ') : []
        }

        result.push(hero);
    }

    console.log(JSON.stringify(result));
}

solve(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara']
);

solve(['Jake / 1000 / Gauss, HolidayGrenade']);