function solve(car) {
    let smallEngine = {power: 90, volume: 1800}
    let normalEngine = {power: 120, volume: 2400}
    let monsterEngine = {power: 200, volume: 3500}

    return {
        model: car.model,
        engine: engine(),
        carriage: {
            type: car.carriage,
            color: car.color
        },
        wheels: wheelSize()
    }

    function engine(){
        if (car.power <= 90){
            return smallEngine;
        } else if (car.power <= 120){
            return normalEngine;
        } else {
            return monsterEngine;
        }
    }

    function wheelSize(){
        let size = car.wheelsize;
        if (size % 2 == 0) {
            size -= 1;
        }
        return [size, size, size, size];
    }
}

console.log(solve({
        model: 'VW Golf II',
        power: 90,
        color: 'blue',
        carriage: 'hatchback',
        wheelsize: 14
    }
));

console.log(solve({
        model: 'Opel Vectra',
        power: 110,
        color: 'grey',
        carriage: 'coupe',
        wheelsize: 17
    }
));