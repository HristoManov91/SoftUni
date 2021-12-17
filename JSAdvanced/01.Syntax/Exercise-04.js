function previousDate(year, month, day){
    const date = new Date(year, month - 1, day);

    let yesterday = new Date(date);
    yesterday.setDate(yesterday.getDate() - 1);

    console.log(`${yesterday.getFullYear()}-${yesterday.getMonth() + 1}-${yesterday.getDate()}`);
}

previousDate(2016 , 9 , 30);
previousDate(2016 , 10 , 1);
previousDate(2016 , 3 , 1);
previousDate(2017 , 3 , 1);