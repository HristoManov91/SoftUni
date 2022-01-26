function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {
        let rowElements = document.querySelectorAll('tbody tr');
        const searchInput = document.getElementById('searchField');
        let searchText = searchInput.value.toLowerCase();

        for (const row of rowElements) {
            let text = row.textContent.toLowerCase();
            if (text.includes(searchText)) {
                row.classList.add('select');
            } else {
                row.classList.remove('select');
            }
        }

        searchInput.value = '';
    }
}