function createHeroAndParseToJson(array){
    let heroes = []

    for (const arrayElement of array) {
        let tokens = arrayElement.split(' / ');
        let name = tokens[0];
        let level = Number(tokens[1])
        let items = tokens[2] ? tokens[2].split(', ') : [];
        let hero = {name: name, level: level, items: items};
        heroes.push(hero)
    }

    console.log(JSON.stringify(heroes));
}

createHeroAndParseToJson(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara']
)

createHeroAndParseToJson(['Jake / 1000 / Gauss, HolidayGrenade'])