function solve() {

    const table = document.querySelector('table tbody');
    const [inputTextElement, outputTextElement] = Array.from(document.querySelectorAll('textarea'));
    const [generateBtn, buyBtn] = Array.from(document.querySelectorAll('button'));

    generateBtn.addEventListener('click', generate);
    buyBtn.addEventListener('click', buyItems);

    function generate() {
        const data = JSON.parse(inputTextElement.value);

        for (const item of data) {
            const row = document.createElement('tr')

            const imgCell = document.createElement('td');
            const imgElement = document.createElement('img');
            imgElement.src = item.img;
            imgCell.appendChild(imgElement);

            const nameCell = document.createElement('td');
            const nameElement = document.createElement('p');
            nameElement.textContent = item.name;
            nameCell.appendChild(nameElement);

            const priceCell = document.createElement('td');
            const priceElement = document.createElement('p');
            priceElement.textContent = item.price;
            priceCell.appendChild(priceElement);

            const decFactorCell = document.createElement('td');
            const decFactorElement = document.createElement('p');
            decFactorElement.textContent = item.decFactor;
            decFactorCell.appendChild(decFactorElement);

            const checkCell = document.createElement('td');
            const checkElement = document.createElement('input');
            checkElement.type = 'checkbox';
            checkCell.appendChild(checkElement)

            row.appendChild(imgCell);
            row.appendChild(nameCell);
            row.appendChild(priceCell);
            row.appendChild(decFactorCell);
            row.appendChild(checkCell)

            table.appendChild(row);
        }
    }

    function buyItems() {
        const furniture = Array
            .from(document.querySelectorAll('input[type="checkbox"]:checked'))
            .map(b => b.parentElement.parentElement)
            .map(r => ({
                name: r.children[1].textContent,
                price: Number(r.children[2].textContent),
                decFactor: Number(r.children[3].textContent)
            }));

        let names = [];
        let totalPrice = 0;
        let sumDecFactor = 0;

        for (const item of furniture) {
            names.push(item.name);
            totalPrice += item.price;
            sumDecFactor += item.decFactor;
        }

        outputTextElement.textContent = `Bought furniture: ${names.join(', ')}
Total price: ${totalPrice.toFixed(2)}
Average decoration factor: ${sumDecFactor / furniture.length}`;
    }
}