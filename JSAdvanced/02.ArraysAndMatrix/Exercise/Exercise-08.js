function solve(array){
    array.sort((a,b) => {
        let result = a.length - b.length;
        if (result == 0){
            result = a.localeCompare(b);
        }
        return result;
    })

    console.log(array.join('\n'));
}

solve(['alpha',
    'beta',
    'gamma']
);

solve(['Isacc',
    'Theodor',
    'Jack',
    'Harrison',
    'George']
);

solve(['test',
    'Deny',
    'omen',
    'Default']
)