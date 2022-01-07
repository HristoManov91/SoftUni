function create(words) {
    let content = document.getElementById('content');

    for (const word of words) {
        let divElement = document.createElement('div')
        let pElement = document.createElement('p');
        pElement.textContent = word;
        pElement.style.display = 'none';

        divElement.appendChild(pElement)
        content.appendChild(divElement)

        divElement.addEventListener('click', onClick)
    }

    function onClick(ev) {
        ev.target.children[0].style.display = '';
    }
}