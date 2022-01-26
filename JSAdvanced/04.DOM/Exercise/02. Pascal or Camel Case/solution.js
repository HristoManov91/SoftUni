function solve() {
    let inputText = document.getElementById('text').value;
    let convention = document.getElementById('naming-convention').value;

    let textArray = inputText.toLowerCase().split(' ');

    let result = '';
    switch (convention) {
        case 'Camel Case':
        case 'Pascal Case':
            for (let i = 0; i < textArray.length; i++) {
                if (convention === 'Camel Case' && i == 0) {
                    result += textArray[i];
                } else {
                    result += textArray[i].charAt(0).toUpperCase() + textArray[i].slice(1);
                }
            }
            break;
        default:
            result = 'Error!';
    }

    document.getElementById('result').textContent = result;
}