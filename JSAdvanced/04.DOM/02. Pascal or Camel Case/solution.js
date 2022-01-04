function solve() {
    const text = document.getElementById('text').value;
    const conventional = document.getElementById('naming-convention').value;

    let output = '';
    if (conventional !== 'Camel Case' && conventional !== 'Pascal Case') {
        output = 'Error!'
    } else {
        let array = text.toLowerCase().split(' ');
        for (let i = 0; i < array.length; i++) {
            if (i == 0 && conventional === 'Camel Case') {
                output += array[i]
            } else {
                output += array[i].charAt(0).toUpperCase() + array[i].slice(1);
            }
        }
    }

    let result = document.getElementById('result');
    result.textContent = output;
}