function solve(...inputs) {

    let result = {};

    for (const element of inputs) {
        let type = typeof element
        if (!result[type]) {
            result[type] = 0;
        }
        result[type] = result[type] + 1;

        console.log(`${type}: ${element}`)
    }

    Object.keys(result)
        .sort((a, b) => result[b] - result[a])
        .forEach((key) => console.log(`${key} = ${result[key]}`))
}

solve('cat', 42, function () {
    console.log('Hello world!');
})
solve('cat', 'dog', 42, function () {
    console.log('Hello world!');
})