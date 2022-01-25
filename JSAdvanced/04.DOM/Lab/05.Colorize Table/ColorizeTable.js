function colorize() {
    let trElement = document.querySelectorAll('tr:nth-of-type(2n)');

    trElement.forEach((x ) => {
        x.style.backgroundColor = 'teal';
    })

    // for (let i = 1; i < trElement.length; i+=2) {
    //     trElement[i].style.backgroundColor = 'Teal';
    // }
}