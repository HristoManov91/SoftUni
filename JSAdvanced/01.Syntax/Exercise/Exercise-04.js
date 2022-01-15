function solve(year, month, day){
    let date = new Date(year, month - 1, day);
    let yesterday = new Date(date);
    yesterday.setDate(yesterday.getDate() - 1);

    return `${yesterday.getFullYear()}-${yesterday.getMonth() + 1}-${yesterday.getDate()}`
}

console.log(solve(2016, 9, 30));
console.log(solve(2016, 10, 1));