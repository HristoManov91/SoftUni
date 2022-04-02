import * as request from './requester.js';

const baseUrl = 'http://localhost:3030/data/pets';

export const create = (animalData) => request.post(baseUrl , animalData);

export const getAnimal = (animalId) => request.get(`${baseUrl}/${animalId}`);

export const getAll = () => request.get(`${baseUrl}?sortBy=_createdOn%20desc&distinct=name`);

export const edit = (animalId , animalData) => request.put(`${baseUrl}/${animalId}` , animalData);

export const remove = (animalId) => request.del(`${baseUrl}/${animalId}`);