function solve(num1 , num2){

    if (num1 > num2){
        console.log(greatestDivision(num1 , num2));
    } else {
        console.log(greatestDivision(num2 , num1));
    }

    function greatestDivision(biggestNum , smallestNum){
        for (let i = smallestNum; i >= 1; i--) {
            if (biggestNum % i == 0 && smallestNum % i == 0){
                return i;
            }
        }
    }
}

solve(15, 5);
solve(2154, 458);