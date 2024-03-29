import * as albumService from '../services/albumService.js';

export const deleteView = async (ctx) => {
    try {
        const album = await albumService.getAlbum(ctx.params.albumId);

        let confirmed = confirm(`Do you want to delete the album: ${album.name}`);

        if (confirmed) {
            await albumService.remove(album._id);
            ctx.page.redirect('/catalog');
        }
    } catch (err) {
        alert(err);
    }
};