function search() {
   let townsElements = Array.from(document.getElementById('towns').children);
   const inputTextElement = document.getElementById('searchText').value;

   let matches = 0;

    for (const town of townsElements) {
        if (town.textContent.includes(inputTextElement)){
            matches++;
            town.style.fontWeight = 'bold';
            town.style.textDecoration = 'underline';
        } else {
            town.style.fontWeight = '';
            town.style.textDecoration = '';
        }
    }

    document.getElementById('result').textContent = `${matches} matches found`;
}
