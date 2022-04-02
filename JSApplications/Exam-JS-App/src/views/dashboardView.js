import {html, nothing} from '../../node_modules/lit-html/lit-html.js';
import * as animalService from '../services/animalService.js';

const animalTemplate = (animal, isLogin = true) => html`
    <div class="animals-board">
        <article class="service-img">
            <img class="animal-image-cover" src="${animal.image}">
        </article>
        <h2 class="name">${animal.name}</h2>
        <h3 class="breed">${animal.breed}</h3>

        ${isLogin
                ? animalDetailsTemplate(animal._id)
                : nothing}
    </div>
`;

const animalDetailsTemplate = (animalId) => html`
    <div class="action">
        <a class="btn" href="/pets/${animalId}">Details</a>
    </div>
`;

const emptyTemplate = () => html`
    <div>
        <p class="no-pets">No pets in dashboard</p>
    </div>
`;

const dashboardTemplate = (animals, user) => html`
    <section id="dashboard">
        <h2 class="dashboard-title">Services for every animal</h2>
        <div class="animals-dashboard">

            ${animals.length > 0
                    ? animals.map(x => animalTemplate(x, Boolean(user)))
                    : emptyTemplate()
            }
        </div>
    </section>
`;

export const dashboardView = (ctx) => {
    animalService.getAll()
        .then(animals => {
            ctx.render(dashboardTemplate(animals, ctx.user));
        })
}