import {html, render} from '../node_modules/lit-html/lit-html.js';

const rootDivElement = document.getElementById('root');
const inputTownsElement = document.getElementById('towns');
document.getElementById('btnLoadTowns').addEventListener('click', loadTowns)

const listTemplate = (data) => html`
    <ul>
        ${data.map(town => html`
            <li>${town}</li>`)}
    </ul>
`

function loadTowns(e) {
    e.preventDefault();
    if (inputTownsElement.value !== '') {

        let towns = inputTownsElement.value.split(', ');

        let result = listTemplate(towns);

        render(result, rootDivElement);

        inputTownsElement.value = '';
    }
}
