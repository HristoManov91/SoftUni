import {html} from '../../node_modules/lit-html/lit-html.js';
import * as animalService from '../services/animalService.js';

const ownerButtonsTemplate = (animalId) => html`
    <div class="actionBtn">
        <a href="/pets/${animalId}/edit" class="edit">Edit</a>
        <a href="/pets/${animalId}/delete" class="remove">Delete</a>
    </div>
`;

const donateButtonsTemplate = (animalId) => html`
    <div class="actionBtn">
        <a href="#" className="donate">Donate</a>
    </div>
`;

const detailsTemplate = (animal, user) => html`
    <section id="detailsPage">
        <div class="details">
            <div class="animalPic">
                <img src="${animal.image}">
            </div>
            <div>
                <div class="animalInfo">
                    <h1>Name: ${animal.name}</h1>
                    <h3>Breed: ${animal.breed}</h3>
                    <h4>Age: ${animal.age}</h4>
                    <h4>Weight: ${animal.weight}</h4>
                    <h4 class="donation">Donation: 0$</h4>
                </div>
                ${user._id === animal._ownerId
                        ? ownerButtonsTemplate(animal._id)
                        : donateButtonsTemplate(animal._id)
                }
            </div>
        </div>
    </section>
`;


export const detailsView = (ctx) => {
    animalService.getAnimal(ctx.params.animalId)
        .then(animal => {
            console.log(animal)
            console.log(ctx.user)
            ctx.render(detailsTemplate(animal, ctx.user))
        })
}