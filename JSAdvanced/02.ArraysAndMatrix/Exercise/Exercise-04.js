function solve(array , countRotation){

    for (let i = 0; i < countRotation; i++) {
        array.unshift(array.pop());
    }

    console.log(array.join(' '));
}

solve(['1',
        '2',
        '3',
        '4'],
    2
);

solve(['Banana',
        'Orange',
        'Coconut',
        'Apple'],
    15
)