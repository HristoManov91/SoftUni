function solve(carParams) {
    let car = {model: carParams.model};

    car.engine = engine(carParams.power);
    car.carriage = {type: carParams.carriage, color: carParams.color};
    car.wheels = carParams.wheelsize % 2 == 0
        ? new Array(4).fill(carParams.wheelsize - 1 , 0 , 4)
        : new Array(4).fill(carParams.wheelsize , 0 , 4)

    function engine(power) {
        let engine = {};

        if (power <= 90) {
            engine.power = 90;
            engine.volume = 1800;
        } else if (power <= 120) {
            return {power: 120 , volume: 2400}
        } else if (power <= 200) {
            engine.power = 200;
            engine.volume = 3500;
        }

        return engine;
    }

    return car;
}

console.log(solve({
        model: 'VW Golf II',
        power: 90,
        color: 'blue',
        carriage: 'hatchback',
        wheelsize: 14
    }
));

solve({
        model: 'Opel Vectra',
        power: 110,
        color: 'grey',
        carriage: 'coupe',
        wheelsize: 17
    }
);