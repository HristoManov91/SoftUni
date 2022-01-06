function addItem() {
    const input = document.getElementById('newItemText');
    const newElement = document.createElement('li');
    newElement.textContent = input.value;

    let list = document.getElementById('items');
    list.appendChild(newElement);

    input.value = '';
}