function extractText() {
    const elements = document.querySelectorAll('ul li')
    let resultElement = document.getElementById('result');

    let text = [];
    for (const element of elements) {
        text.push(element.textContent);
    }

    resultElement.textContent = text.join('\n');
}