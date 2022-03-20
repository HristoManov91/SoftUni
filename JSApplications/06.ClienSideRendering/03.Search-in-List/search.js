import {html, render} from '../node_modules/lit-html/lit-html.js';
import {towns} from './towns.js';

let townsContainer = document.getElementById('towns');

const townsTemplate = (data) => html`
    <ul>
        ${data.map(town => html`
            <li>${town}</li>
        `)}
    </ul>
`

let result = townsTemplate(towns);
render(result, townsContainer);

search();

function search() {
    const searchTextElement = document.getElementById('searchText');
    const resultElement = document.getElementById('result');
    resultElement.textContent = '';

    document.querySelector('button').addEventListener('click', searchMatches);

    function searchMatches() {
        let count = 0;
        let towns = townsContainer.querySelectorAll('li');
        towns.forEach(t => {
            if (t.textContent.toLowerCase().includes(searchTextElement.value.toLowerCase())) {
                t.className = 'active';
                count++;
            } else {
                t.className = '';
            }
        })
        resultElement.textContent = `${count} matches found`
    }
}
