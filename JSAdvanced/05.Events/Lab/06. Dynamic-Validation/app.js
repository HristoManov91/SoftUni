function validate() {
    let inputElement = document.getElementById('email');
    inputElement.addEventListener('change', validate)

    function validate(ev) {
        const pattern = /^[a-z]+@[a-z]+\.[a-z]+$/;

        if (pattern.test(ev.target.value)) {
            ev.target.classList.remove('error');
        } else {
            ev.target.classList.add('error');
        }
    }
}