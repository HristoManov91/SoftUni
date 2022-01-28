function addItem() {
    let liElement = document.createElement('li');
    let newElementText = document.getElementById('newItemText');
    liElement.textContent = newElementText.value;

    document.getElementById('items').appendChild(liElement);
    newElementText.value = '';
}