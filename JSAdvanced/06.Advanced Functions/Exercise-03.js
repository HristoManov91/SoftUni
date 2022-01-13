function solve() {
    let n1 = 0;
    let n2 = 1;
    let firstTime = true;

    return function getNumber() {
        if (firstTime) {
            firstTime = false;
            return n2;
        }
        let nextNumber = n1 + n2;
        n1 = n2;
        n2 = nextNumber;
        return nextNumber
    }
}

let fib = solve();
console.log(fib()); // 1
console.log(fib()); // 1
console.log(fib()); // 2
console.log(fib()); // 3
console.log(fib()); // 5
console.log(fib()); // 8
console.log(fib()); // 13
