function solve(...args) {
    const result = new Map();

    for (const arg of args) {
        let type = typeof arg;
        console.log(`${type}: ${arg}`)
        result.has(type)
            ? result.set(type, result.get(type) + 1)
            : result.set(type, 1);
    }
    new Map([...result.entries()].sort((a, b) => b[1] - a[1]))
        .forEach((value, key) => {
            console.log(`${key} = ${value}`)
        })
}

solve('cat', 42, 54 , 'dog' , function () {
    console.log('Hello world!');
})

solve({name: 'bob'}, 3.333, 9.999)