function gcd(a , b){
    while (b != 0){
        const temp = b;
        b = a % b;
        a = temp
    }

    return a;
}

console.log(gcd(15 , 5));
console.log(gcd(2154 , 458));