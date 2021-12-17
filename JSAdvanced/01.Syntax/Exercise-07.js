function solve(number , com1 , com2 , com3 , com4 , com5){
    let result = Number(number);

    let array = [com1 , com2 , com3 , com4 , com5];

    for (let i = 0; i < array.length; i++) {
        let command = array[i];
        switch (command){
            case 'chop': result = result / 2; break;
            case 'dice': result = Math.sqrt(result); break;
            case 'spice': result = result + 1; break;
            case 'bake': result = result * 3; break;
            case 'fillet': result = result * 0.8; break;
        }
        console.log(result);
    }
}

solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');
solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet');