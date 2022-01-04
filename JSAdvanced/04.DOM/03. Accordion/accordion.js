function toggle() {
    const button = document.querySelector('.button');
    const textDIV = document.getElementById('extra');

    button.textContent = button.textContent == 'More' ? 'Less' : 'More';

    if (button.textContent == 'More') {
        textDIV.style.display = 'none';
    } else {
        textDIV.style.display = 'block';
    }
}