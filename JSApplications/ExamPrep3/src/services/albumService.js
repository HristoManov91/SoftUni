import * as request from './requester.js';

const baseUrl = 'http://localhost:3030/data/albums';


export const create = (albumData) => request.post(baseUrl , albumData);

export const getAlbum = (albumId) => request.get(`${baseUrl}/${albumId}`);

export const getAll = () => request.get(`${baseUrl}/?sortBy=_createdOn%20desc&distinct=name`);

export const edit = (albumId, albumData) => request.put(`${baseUrl}/${albumId}` , albumData);

export const remove = (albumId) => request.del(`${baseUrl}/${albumId}`);

export const search = (text) => {
    const query = encodeURIComponent(`name LIKE "${text}"`);

    return request.get(`${baseUrl}?where=${query}`);
}