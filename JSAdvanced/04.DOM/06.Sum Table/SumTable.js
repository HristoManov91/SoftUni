function sumTable() {
    const rows = document.querySelectorAll('table tr');

    let result = 0;

    for (let i = 1; i < rows.length; i++) {
        const cell = rows[i].lastElementChild;
        result += Number(cell.textContent);
    }

    document.getElementById('sum').textContent = result;
}