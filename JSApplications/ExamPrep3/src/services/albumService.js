import * as request from './requester.js';

const baseUrl = 'http://localhost:3030/data/albums';

export const create = (albumData) => request.post(baseUrl , albumData);

export const getAlbum = (albumId) => request.get(`${baseUrl}/${albumId}`);

export const getAll = () => request.get(`${baseUrl}/?sortBy=_createdOn%20desc&distinct=name`);
