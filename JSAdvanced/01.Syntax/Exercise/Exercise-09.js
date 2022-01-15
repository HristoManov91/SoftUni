function solve(input){
    let result = input.toUpperCase()
        .split(/[\W]+/)
        .filter(w => w.length > 0)
        .join(", ");

    console.log(result);
}

solve('Hi, how are you?');
solve('hello');