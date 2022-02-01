function solve() {
    let [nameInputElement, hallInputElement, ticketPriceInputElement] =
        document.querySelectorAll('#container input');

    let onScreenButtonElement = document.querySelector('#container button');
    onScreenButtonElement.addEventListener('click', addMovie);

    let onScreenUlElement = document.querySelector('#movies ul');
    let archiveUlElement = document.querySelector('#archive ul');
    let clearButton = document.querySelector('#archive button');
    clearButton.addEventListener('click', () => archiveUlElement.innerHTML = '');

    function addMovie(e) {
        e.preventDefault();
        let name = nameInputElement.value.trim();
        let hall = hallInputElement.value.trim();
        let ticketPrice = Number(ticketPriceInputElement.value);

        nameInputElement.value = '';
        hallInputElement.value = '';
        ticketPriceInputElement.value = '';

        if (name && hall && ticketPrice) {
            let liElement = document.createElement('li');
            let spanElement = document.createElement('span');
            spanElement.textContent = name;
            liElement.appendChild(spanElement);

            let strongElement = document.createElement('strong');
            strongElement.textContent = `Hall: ${hall}`;
            liElement.appendChild(strongElement);

            let divElement = document.createElement('div');
            let strongPriceElement = document.createElement('strong');
            strongPriceElement.textContent = ticketPrice.toFixed(2);
            divElement.appendChild(strongPriceElement);

            let inputElement = document.createElement('input');
            inputElement.placeholder = 'Tickets Sold';
            divElement.appendChild(inputElement);

            let archiveButton = document.createElement('button');
            archiveButton.textContent = 'Archive';
            archiveButton.addEventListener('click', archiveMovie);
            divElement.appendChild(archiveButton);

            liElement.appendChild(divElement);
            onScreenUlElement.appendChild(liElement);

            function archiveMovie(e) {
                let price = e.target.parentElement.querySelector('strong').textContent;
                price = Number(price);
                let name = e.target.parentElement.parentElement.querySelector('span').textContent;
                let countTickets = e.target.parentElement.querySelector('input').value;
                countTickets = Number(countTickets);

                if (countTickets) {
                    e.target.parentElement.parentElement.remove();
                    let liElement = document.createElement('li');
                    let spanElement = document.createElement('span');
                    spanElement.textContent = name;
                    liElement.appendChild(spanElement);

                    let strongElement = document.createElement('strong');
                    strongElement.textContent = `Total amount: ${(price * countTickets).toFixed(2)}`;
                    liElement.appendChild(strongElement);

                    let buttonElement = document.createElement('button');
                    buttonElement.textContent = 'Delete';
                    buttonElement.addEventListener('click', deleteMovie);
                    liElement.appendChild(buttonElement);

                    archiveUlElement.appendChild(liElement);
                }

                function deleteMovie(ev) {
                    ev.target.parentElement.remove();
                }
            }
        }
    }
}