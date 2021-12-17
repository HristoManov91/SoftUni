function solve(speed, row) {
    const speedInt = parseInt(speed);

    const motorwaySpeedLimit = 130;
    const interstateSpeedLimit = 90;
    const citySpeedLimit = 50;
    const residentialSpeedLimit = 20;

    let difference = 0;
    let speedLimit = 0;

    function calculateDifference(speedInt , rowSpeedLimit) {
        if (speedInt > rowSpeedLimit) {
            difference = speedInt - rowSpeedLimit;
            speedLimit = rowSpeedLimit;
        } else {
            console.log(`Driving ${speedInt} km/h in a ${rowSpeedLimit} zone`);
        }
    }

    switch (row) {
        case 'motorway':
            calculateDifference(speedInt , motorwaySpeedLimit);
            break;
        case 'interstate':
            calculateDifference(speedInt , interstateSpeedLimit);
            break;
        case 'city':
            calculateDifference(speedInt , citySpeedLimit);
            break;
        case 'residential':
            calculateDifference(speedInt , residentialSpeedLimit);
            break;
    }

    if (difference <= 20 && difference > 0) {
        console.log(`The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - speeding`)
    } else if (difference <= 40 && difference > 0){
        console.log(`The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - excessive speeding`)
    } else if (difference > 40){
        console.log(`The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - reckless driving`)
    }
}

solve(40, 'city');
solve(21, 'residential');
solve(120, 'interstate');
solve(200, 'motorway');