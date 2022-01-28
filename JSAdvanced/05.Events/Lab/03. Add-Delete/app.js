function addItem() {
    let ulElement = document.getElementById('items');

    let inputElement = document.getElementById('newItemText');
    let inputText = inputElement.value;

    let liElement = document.createElement('li');
    liElement.textContent = inputText;

    let deleteButton = document.createElement('a');
    deleteButton.href = '#';
    deleteButton.textContent = '[Delete]';
    deleteButton.addEventListener('click' , deleteElement)
    liElement.appendChild(deleteButton);

    ulElement.appendChild(liElement);

    inputElement.value = '';

    function deleteElement(ev){
        // const answer = confirm('Are you sure you want to delete?')

        // if (answer){
            ev.target.parentElement.remove()
        // }
    }
}