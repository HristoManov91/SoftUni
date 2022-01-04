function search() {

    const elements = document.querySelectorAll('ul li');
    const text = document.getElementById('searchText').value;

    let count = 0;
    for (const element of elements) {
        if (element.textContent.includes(text)){
            element.style.fontWeight = 'bold';
            element.style.textDecoration = 'underline';
            count++
        }
    }

    const resultDiv = document.getElementById('result');
    resultDiv.textContent =  `${count} matches found`
}
