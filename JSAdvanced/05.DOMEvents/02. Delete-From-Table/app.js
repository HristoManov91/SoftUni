function deleteByEmail() {
    let rows = document.querySelectorAll('table tbody tr');
    // let rows = [...document.querySelector('tbody').children];
    // let rows = Array.from(document.querySelector('tbody').children);

    const input = document.querySelector('input[name = "email"]').value;

    let isFounded = false;
    for (const row of rows) {
        if (row.children[1].textContent === input){
            row.remove()
            isFounded = true;
            break;
        }
    }

    let result = document.getElementById('result')
    isFounded ? result.textContent = 'Deleted.' : result.textContent = 'Not found.';
}