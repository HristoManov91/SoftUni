import {showHome} from './home.js';
import {showLogin} from './login.js';
import {showRegister} from './register.js';

const views = {
    'homeLink': showHome,
    'loginLink': showLogin,
    'registerLink': showRegister
}

const nav = document.querySelector('nav');

document.getElementById('logoutBtn').addEventListener('click' , onLogout);
nav.addEventListener('click', (ev) => {
    const view = views[ev.target.id];
    if (view === 'function') {
        ev.preventDefault();
        view();
    }
});

updateUserNav();
showHome();

export function updateUserNav(){
    const userData = JSON.parse(sessionStorage.getItem('userData'));

    if (userData != null){
        nav.querySelector('#welcomeMsg').textContent = `Welcome ${userData.email}`;
        [...nav.querySelector('.user')].forEach(e => e.style.display = 'block');
        [...nav.querySelector('.guest')].forEach(e => e.style.display = 'none');
    } else {
        [...nav.querySelector('.user')].forEach(e => e.style.display = 'none');
        [...nav.querySelector('.guest')].forEach(e => e.style.display = 'block');
    }
}

async function onLogout(ev){
    ev.preventDefault();
    ev.stopImmediatePropagation();

    const token = JSON.parse(sessionStorage.getItem('userData'));

    await fetch('http://localhost:3030/users/logout' , {
        headers: {
            'X-Authorization': token
        }
    });

    sessionStorage.removeItem('userData');
    updateUserNav();
    showLogin();
}
