function solve() {
    const text = document.getElementById('input').value;
    const splintedText = text.split('.').filter(a => a.trim().length > 0);

    const output = document.getElementById('output');

    let result = '';
    let count = 0;

    for (let i = 0; i < splintedText.length; i++) {
        if (count == 0) {
            result += '<p>'
        }
        result += splintedText[i] + '.';
        count++;
        if (count == 3 || i == splintedText.length - 1) {
            result += '</p>'
            count = 0;
        }
    }

    output.innerHTML = result;
}