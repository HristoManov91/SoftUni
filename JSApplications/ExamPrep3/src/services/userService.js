import * as request from './requester.js';
import {clearUser, getToken, saveUser} from "./authService.js";

const baseUrl = 'http://localhost:3030/users'


export const register = (email, password) => {
    return request.post(`${baseUrl}/register`, {email, password})
        .then(user => {
            saveUser(user);

            return user;
        });
};

export const login = (email, password) => {
    return request.post(`${baseUrl}/login`, {email, password})
        .then(user => {
            saveUser(user);

            return user;
        });
};

export const logout = () =>
    fetch(`${baseUrl}/logout` , {headers: {'X-Authorization': getToken()}})
        .then(() => {
            clearUser();
        });
