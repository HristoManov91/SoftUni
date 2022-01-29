function create(words) {
   let contentElement = document.getElementById('content');

   for (const word of words) {
      let divElement = document.createElement('div');
      let pElement = document.createElement('p');
      pElement.textContent = word;
      pElement.style.display = 'none';

      divElement.appendChild(pElement);
      contentElement.appendChild(divElement);

      divElement.addEventListener('click' , (ev) => {
         ev.target.children[0].style.display = '';
      })
   }
}