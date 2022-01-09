function solution(firstNumber) {

    return function add5(num) {
        return firstNumber + num
    }
}

let add5 = solution(5);
console.log(add5(2));
console.log(add5(3));
