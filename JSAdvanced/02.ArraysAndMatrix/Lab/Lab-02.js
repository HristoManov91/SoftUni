function solve(length, num2) {
    let array = [1];

    for (let i = 1; i < length; i++) {
        let sum = 0;
        for (let j = 1; j <= num2; j++) {
            let index = i - j;
            if (index >= 0) {
                sum += array[index];
            }
        }
        array.push(sum);
    }

    return array;
}