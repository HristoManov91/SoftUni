import {cats} from "./catSeeder.js";
import {html, render} from "../node_modules/lit-html/lit-html.js";

let catsDivElement = document.getElementById('allCats');

const catsTemplate = (data) => html`
    <ul>
        ${data.map(cat => html`
            <li>
                <img src="./images/${cat.imageLocation}.jpg" width="250" height="250" alt="Card image cap">
                <div class="info">
                    <button class="showBtn">Show status code</button>
                    <div class="status" style="display: none" id="${cat.id}">
                        <h4>Status Code: ${cat.statusCode}</h4>
                        <p>${cat.statusMessage}</p>
                    </div>
                </div>
            </li>
        `)}
    </ul>
`
const result = catsTemplate(cats);
render(result, catsDivElement);

let buttons = document.querySelectorAll('.showBtn');
buttons.forEach(b => b.addEventListener('click', (e) => {
    e.preventDefault();
    let divElement = e.target.parentElement.querySelector('div');
    if (divElement.style.display === 'none') {
        b.textContent = 'Hide status code';
        divElement.style.display = '';
    } else {
        b.textContent = 'Show status code';
        divElement.style.display = 'none'
    }
}));