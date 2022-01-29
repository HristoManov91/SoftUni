function addItem() {
    const textInputElement = document.getElementById('newItemText');
    const valueInputElement = document.getElementById('newItemValue');
    const selectMenuElement = document.getElementById('menu');

    let optionElement = document.createElement("option");
    optionElement.text = textInputElement.value;
    optionElement.value = valueInputElement.value;

    selectMenuElement.appendChild(optionElement);

    textInputElement.value = '';
    valueInputElement.value = '';

}