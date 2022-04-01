import {html, nothing} from '../../node_modules/lit-html/lit-html.js';
import * as albumService from '../services/albumService.js';

const albumTemplate = (album, withDetails = true) => html`
    <div class="card-box">
        <img src="${album.imgUrl}">
        <div>
            <div class="text-center">
                <p class="name">Name: ${album.name}</p>
                <p class="artist">Artist: ${album.artist}</p>
                <p class="genre">Genre: ${album.genre}</p>
                <p class="price">Price: $${album.price}</p>
                <p class="date">Release Date: ${album.releaseDate}</p>
            </div>
            ${withDetails
                    ? albumDetailsTemplate(album._id)
                    : nothing
            }
        </div>
    </div>
`;

const albumDetailsTemplate = (albumId) => html`
    <div class="btn-group">
        <a href="/albums/${albumId}" id="details">Details</a>
    </div>
`;

const searchTemplate = (searchHandler, albums, user) => html`
    <section id="searchPage">
        <h1>Search by Name</h1>

        <div class="search">
            <input id="search-input" type="text" name="search" placeholder="Enter desired albums's name">
            <button class="button-list" @click=${searchHandler}>Search</button>
        </div>

        <h2>Results:</h2>

        <!--Show after click Search button-->
        <div class="search-result">
            ${albums.length > 0
                    ? albums.map(x => albumTemplate(x, Boolean(user)))
                    : html`<p class="no-result">No result.</p>`}
        </div>
    </section>
`;

export const searchView = (ctx) => {
    const searchHandler = (e) => {
        e.preventDefault();
        let searchElement = document.getElementById('search-input');

        albumService.search(searchElement.value)
            .then(albums => {
                ctx.render(searchTemplate(searchHandler, albums, ctx.user));
            })
    };

    ctx.render(searchTemplate(searchHandler, [], ctx.user));
}