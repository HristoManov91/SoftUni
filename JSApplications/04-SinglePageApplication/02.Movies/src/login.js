import {showView} from './dom.js';
import {showHome} from "./home.js";
import {updateUserNav} from "./app.js";

const homeSection = document.getElementById('form-login');
const form = homeSection.querySelector('form');
form.addEventListener('submit', onLogin);
homeSection.remove();

export function showLogin() {
    showView(homeSection);
}

async function onLogin(ev) {
    ev.preventDefault();
    const formData = new FormData(form);

    const email = formData.get('email').trim();
    const password = formData.get('password').trim();

    try {
        const res = await fetch('http://localhost:3030/users/login)', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({email, password})
        });

        if (res.ok === false) {
            const error = await res.json();
            throw new Error(error.message);
        }

        const data = await res.json();
        sessionStorage.setItem('userData' , JSON.stringify({
            email: data.email,
            id: data._id,
            token: data.accessToken
        }));

        form.reset();
        updateUserNav();
        await showHome();
    } catch (err) {
        alert(err.message);
    }
}

