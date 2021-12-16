function numDayOfWeek(weekday){
    let result = 'error';
    switch (weekday){
        case 'Monday' : result = 1; break;
        case 'Tuesday' : result = 2; break;
        case 'Wednesday' : result = 3; break;
        case 'Thursday' : result = 4; break;
        case 'Friday' : result = 5; break;
        case 'Saturday' : result = 6; break;
        case 'Sunday' : result = 7; break;
    }

    return result;
}

console.log(numDayOfWeek('Monday'));
console.log(numDayOfWeek('Friday'));
console.log(numDayOfWeek('Mondsadasay'));