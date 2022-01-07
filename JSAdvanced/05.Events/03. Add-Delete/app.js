function addItem() {
    const input = document.getElementById('newItemText');

    const newElement = document.createElement('li');
    newElement.textContent = input.value;

    const deleteButton = document.createElement('a');
    deleteButton.href = '#';
    deleteButton.textContent = '[Delete]';
    newElement.appendChild(deleteButton);

    deleteButton.addEventListener('click' , removeElement);

    let list = document.getElementById('items');
    list.appendChild(newElement);

    input.value = '';

    function removeElement(ev){
        const answer = confirm('Are you sure?');

        if (answer == true){
            ev.target.parentElement.remove();
        }
    }
}