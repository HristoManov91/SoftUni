import { showView } from './dom.js';

const homeSection = document.getElementById('edit-movie');
homeSection.remove();

export function showEdit(){
    showView(homeSection);
}

