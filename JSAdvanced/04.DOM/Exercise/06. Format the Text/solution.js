function solve() {
    const inputElement = document.getElementById('input');
    const sentences = inputElement.value.split('.').filter(s => s.trim().length > 0);
    let outputElement = document.getElementById('output');

    let result = '';
    let count = 0;
    for (let i = 0; i < sentences.length; i++) {
        if (i % 3 == 0) {
            result += '<p>';
        }
        result += sentences[i] + '.';
        count++;
        if (count == 3){
            count = 0;
            result += '</p>'
        }
    }

    outputElement.innerHTML = result;
}