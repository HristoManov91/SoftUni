import {html , nothing} from '../../node_modules/lit-html/lit-html.js';
import * as albumService from '../services/albumService.js';

const ownerButtonsTemplate = (albumId) => html`
    <div class="actionBtn">
        <a href="/albums/${albumId}/edit" class="edit">Edit</a>
        <a href="/albums/${albumId}/delete" class="remove">Delete</a>
    </div>
`;

const detailsTemplate = (album , user) => html`
    <section id="detailsPage">
        <div class="wrapper">
            <div class="albumCover">
                <img src="${album.imgUrl}">
            </div>
            <div class="albumInfo"> 
                <div class="albumText">

                    <h1>Name: ${album.name}</h1>
                    <h3>Artist: ${album.artist}</h3>
                    <h4>Genre: ${album.genre}</h4>
                    <h4>Price: $${album.price}</h4>
                    <h4>Date: ${album.releaseDate}</h4>
                    <p>${album.description}</p>
                </div>
                ${user._id === album._ownerId ? ownerButtonsTemplate(album._id) : nothing}
            </div>
        </div>
    </section>
`;

export const detailsView = (ctx) => {
    albumService.getAlbum(ctx.params.albumId)
        .then(album => {
            ctx.render(detailsTemplate(album , ctx.user));
        })
};