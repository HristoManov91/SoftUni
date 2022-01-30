function solve() {
    const [nameElement, ageElement, kindElement, ownerElement, addButton] =
        Array.from(document.getElementById('container').children);

    let adoptionSectionElement = document.querySelector('#adoption ul')
    let adoptedSectionElement = document.querySelector('#adopted ul');

    addButton.addEventListener('click', addAnimal);

    function addAnimal(event) {
        event.preventDefault();
        const name = nameElement.value.trim();
        const age = Number(ageElement.value);
        const kind = kindElement.value.trim();
        const owner = ownerElement.value.trim();

        nameElement.value = '';
        ageElement.value = '';
        kindElement.value = '';
        ownerElement.value = '';

        if (name && age && kind && owner) {
            let liElement = document.createElement('li');
            let pElement = document.createElement('p');
            pElement.innerHTML = `<strong>${name}</strong> is a <strong>${age}</strong> year old <strong>${kind}</strong`;
            liElement.appendChild(pElement);

            let spanElement = document.createElement('span');
            spanElement.textContent = `Owner: ${owner}`;
            liElement.appendChild(spanElement);

            let buttonElement = document.createElement('button');
            buttonElement.textContent = `Contact with owner`
            buttonElement.addEventListener('click', () => {
                buttonElement.remove()
                buttonElement.textContent = 'Yes! I take it!';
                let divElement = document.createElement('div');
                let inputElement = document.createElement('input');
                inputElement.placeholder = 'Enter your names'
                divElement.appendChild(inputElement);
                divElement.appendChild(buttonElement);
                liElement.appendChild(divElement);
                buttonElement.addEventListener('click', () => {
                    liElement.remove();
                    let name = inputElement.value;
                    if (name){
                        let adoptLiElement = document.createElement('li')
                        adoptLiElement.appendChild(pElement);
                        spanElement.textContent = `New Owner: ${name}`
                        adoptLiElement.appendChild(spanElement)
                        let button = document.createElement('button');
                        button.textContent = 'Checked';
                        button.addEventListener('click' , () => {
                            adoptLiElement.remove()
                        })
                        adoptLiElement.appendChild(button);
                        adoptedSectionElement.appendChild(adoptLiElement);
                    }
                })
            })
            liElement.appendChild(buttonElement);

            adoptionSectionElement.appendChild(liElement);
        }
    }
}

