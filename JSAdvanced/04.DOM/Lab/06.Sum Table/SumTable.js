function sumTable() {
    let rows = document.querySelectorAll('table tr');

    let result = 0;

    for (let i = 1; i < rows.length - 1; i++) {
        let num = Number(rows[i].lastElementChild.textContent);
        result += num;
    }

    document.getElementById('sum').textContent = result.toFixed(2);
}