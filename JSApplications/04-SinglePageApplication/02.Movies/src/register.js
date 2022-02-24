import { showView } from './dom.js';

const homeSection = document.getElementById('form-sign-up');
homeSection.remove();

export function showRegister(){
    showView(homeSection);
}

