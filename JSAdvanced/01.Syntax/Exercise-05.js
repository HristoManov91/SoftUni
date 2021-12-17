function timeToWalk(steps , length , speed){
    const distance = steps * length;
    // console.log(distance)

    let secondsFromDistance = Math.floor(distance / 500) * 60;
    // console.log(secondsFromDistance);

    let totalSeconds = (distance / (((speed * 1000) / 60) / 60)) + (secondsFromDistance);
    // console.log(totalSeconds)
    let hours = Math.floor(totalSeconds / 3600)
    let minutes = Math.floor(totalSeconds / 60)
    let seconds = Math.round(totalSeconds % 60)

    console.log(`${(hours < 10 ? '0' : '') + hours}:${(minutes < 10 ? '0' : '') + minutes}:${(seconds < 10 ? '0' : '') + seconds}`)
}

timeToWalk(4000, 0.60, 5);
timeToWalk(2564, 0.70, 5.5)