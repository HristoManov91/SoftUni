function solve(steps , lengthOfStep , speed){
    const distance = steps * lengthOfStep;
    const overtimeInSeconds = Math.floor(distance / 500) * 60;

    const speedInMetric = speed * 1000;

    const time = Math.round((distance / speedInMetric) * 3600) + overtimeInSeconds;

    const hours = Math.floor(time / 3600);
    const minutes = Math.floor(time / 60);
    const seconds = Math.floor(time % 60);

    console.log(`${hours.toString().padStart(2 , '0')}:${(minutes < 10 ? '0' : '') + minutes}:${(seconds < 10 ? '0' : '') + seconds}`);
}

solve(4000, 0.60, 5);
solve(2564, 0.70, 5.5);