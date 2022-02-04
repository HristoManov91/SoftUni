function sum(arr) {
    let sum = 0;
    for (let num of arr){
        sum += Number(num);
    }
    return sum;
}

console.log(sum(['av' , 1]));
module.exports = {sum};