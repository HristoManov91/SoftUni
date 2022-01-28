function deleteByEmail() {
    const inputElement = document.querySelector('input[name = email]');
    const email = inputElement.value;

    let rows = document.querySelectorAll('tbody tr');
    //let emailCellElements = document.querySelectorAll('tr td:nth-of-type(2)');

    let result = 'Not found.';
    for (const row of rows) {
        if (row.textContent.includes(email)){
            row.remove()
            result = 'Deleted.'
        }
    }

    document.getElementById('result').textContent = result;
    inputElement.value = '';
}