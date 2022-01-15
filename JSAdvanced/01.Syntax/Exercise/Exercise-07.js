function solve(inputNumber , ...commands){
    let num = Number(inputNumber);

    //•	chop - divide the number by two
    // •	dice - square root of a number
    // •	spice - add 1 to the number
    // •	bake - multiply number by 3
    // •	fillet - subtract 20% from the number
    for (const command of commands) {
        switch (command){
            case 'chop': num /= 2; break;
            case 'dice': num = Math.sqrt(num); break;
            case 'spice': num += 1; break;
            case 'bake': num *= 3; break;
            case 'fillet': num = num * 0.8; break;
        }
        console.log(num);
    }
}

solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');
solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet')