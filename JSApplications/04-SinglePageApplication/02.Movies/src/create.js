import { showView } from './dom.js';

const homeSection = document.getElementById('add-movie');
homeSection.remove();

export function showCreate(){
    showView(homeSection);
}

