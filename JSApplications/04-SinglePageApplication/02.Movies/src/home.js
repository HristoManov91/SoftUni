import {e, showView} from "./dom.js";
import {showCreate} from "./create.js";
import {showDetails} from "./details.js";


const homeSection = document.getElementById('home-page');
const catalog = homeSection.querySelector('.card-deck.d-flex.justify-content-center');
homeSection.querySelector('#createLink').addEventListener('click', (ev) => {
    ev.preventDefault();
    showCreate();
});
catalog.addEventListener('click', (ev) => {
    ev.preventDefault();
    let target = ev.target;

    if (target.tagName === 'BUTTON') {
        target = target.parentElement;
    }
    if (target.tagName === 'A') {
        const id = target.dataset.id;
        showDetails(id);
    }
});

homeSection.remove();

export async function showHome() {
    showView(homeSection);
    await getMovies();
}

async function getMovies() {
    catalog.replaceChildren('p' , {} , 'Loading...');
    const res = await fetch('http://localhost:3030/data/movies');
    const data = await res.json();

    catalog.replaceChildren(...data.map(createMovieCard));

    return data;
}

function createMovieCard(movie) {
    const element = e('div', {className: 'card mb-4'});
    element.innerHTML = `
    <img class="card-img-top" src="${movie.img}"
        alt="Card image cap" width="400">
    <div class="card-body">
       <h4 class="card-title">${movie.title}</h4>
    </div>
    <div class="card-footer">
       <a data-id=${movie._id} href="#">
          <button type="button" class="btn btn-info">Details</button>
       </a>
    </div>`
}

window.getMovies = getMovies;