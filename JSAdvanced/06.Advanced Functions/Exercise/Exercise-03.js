function getFibonator(){
    let num1 = 0;
    let num2 = 1;

    return function fib() {
        let token = num2;
        num2 = num1 + num2;
        num1 = token;
        return token;
    }
}

let fib = getFibonator();
console.log(fib()); // 1
console.log(fib()); // 1
console.log(fib()); // 2
console.log(fib()); // 3
console.log(fib()); // 5
console.log(fib()); // 8
console.log(fib()); // 13
