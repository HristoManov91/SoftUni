function orderNamesAndPrint(array){
    let index = 1;
    array.sort((a , b) => a.localeCompare(b))

    for (let i = 0; i < array.length; i++) {
        console.log(index++ + '.' + array[i])
    }
}

orderNamesAndPrint(["John", "Bob", "Christina", "Ema"])