function solve(speed , area){
    const areaSpeedLimit = getAreaSpeedLimit(area);
    if (speed <= areaSpeedLimit){
        console.log(`Driving ${speed} km/h in a ${areaSpeedLimit} zone`)
    } else {
        const difference = speed - areaSpeedLimit;
        const status = getStatusByDifferent(difference);

        console.log(`The speed is ${difference} km/h faster than the allowed speed of ${areaSpeedLimit} - ${status}`)
    }

    function getAreaSpeedLimit(area){
        switch(area){
            case 'motorway': return 130;
            case 'interstate': return 90;
            case 'city': return 50;
            case 'residential': return 20;
        }
    }

    function getStatusByDifferent(difference){
        if (difference <= 20){
            return 'speeding';
        } else if (difference <= 40){
            return 'excessive speeding';
        } else {
            return 'reckless driving';
        }
    }
}

solve(40, 'city');
solve(21, 'residential');
solve(120, 'interstate');
solve(200, 'motorway');