function toggle() {
    let buttonElement = document.querySelector('.button');
    let extraTextElement = document.getElementById('extra');

    if (buttonElement.textContent === 'More') {
        buttonElement.textContent = 'Less';
        extraTextElement.style.display = 'block';

    } else {
        buttonElement.textContent = 'More';
        extraTextElement.style.display = 'none';
    }
}