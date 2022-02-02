window.addEventListener('load', solve);

function solve() {
    const modelInputElement = document.getElementById('model');
    const yearInputElement = document.getElementById('year');
    const descriptionInputElement = document.getElementById('description');
    const priceInputElement = document.getElementById('price');
    const addButton = document.getElementById('add');
    addButton.addEventListener('click', addFurniture)
    const furnitureListElement = document.getElementById('furniture-list');

    function addFurniture(ev) {
        ev.preventDefault();
        const model = modelInputElement.value.trim();
        const year = Number(yearInputElement.value);
        const description = descriptionInputElement.value.trim();
        const price = Number(priceInputElement.value);
        if (model && description && price > 0 && year > 0) {
            let trInfoElement = document.createElement('tr');
            trInfoElement.className = 'info';

            let tdModelElement = document.createElement('td');
            tdModelElement.textContent = model;
            trInfoElement.appendChild(tdModelElement);

            let tdPriceElement = document.createElement('td');
            tdPriceElement.textContent = price.toFixed(2);
            trInfoElement.appendChild(tdPriceElement);

            let tdButtonsElement = document.createElement('td');

            let moreBtnElement = document.createElement('button');
            moreBtnElement.className = 'moreBtn'
            moreBtnElement.textContent = 'More Info';
            moreBtnElement.addEventListener('click', moreInfo)
            tdButtonsElement.appendChild(moreBtnElement);

            let buyBtnElement = document.createElement('button');
            buyBtnElement.className = 'buyBtn'
            buyBtnElement.textContent = 'Buy it';
            buyBtnElement.addEventListener('click', buiIt);
            tdButtonsElement.appendChild(buyBtnElement);

            trInfoElement.appendChild(tdButtonsElement);
            furnitureListElement.appendChild(trInfoElement);

            let trHideInfoElement = document.createElement('tr');

            trHideInfoElement.className = 'hide';
            let tdYearElement = document.createElement('td');
            tdYearElement.textContent = `Year: ${year}`;
            trHideInfoElement.appendChild(tdYearElement);

            let tdDescriptionElement = document.createElement('td');
            tdDescriptionElement.colSpan = 3;
            tdDescriptionElement.textContent = `Description: ${description}`;
            trHideInfoElement.appendChild(tdDescriptionElement);

            furnitureListElement.appendChild(trHideInfoElement);

            function moreInfo(ev) {
                if (moreBtnElement.textContent === 'More Info') {
                    moreBtnElement.textContent = 'Less Info';
                    trHideInfoElement.style.display = 'contents';
                } else {
                    moreBtnElement.textContent = 'More Info';
                    trHideInfoElement.style.display = 'none';
                }
            }

            function buiIt(ev) {
                let price = ev.target.parentElement.parentElement.children[1].textContent;
                price = Number(price)
                let totalPriceElement = document.querySelector('.total-price');
                let currentTotalPrice = Number(totalPriceElement.textContent);
                totalPriceElement.textContent = (price + currentTotalPrice);
                ev.target.parentElement.parentElement.nextElementSibling.remove();
                ev.target.parentElement.parentElement.remove();
            }
        }
        modelInputElement.value = '';
        yearInputElement.value = '';
        descriptionInputElement.value = '';
        priceInputElement.value = '';
    }
}
