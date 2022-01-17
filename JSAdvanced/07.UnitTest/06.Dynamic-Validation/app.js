function validate() {
    const inputField = document.getElementById('email');
    const validateEmail = /(^[a-z]+@[a-z]+\.[a-z]+$)/;

    inputField.addEventListener('change' , () => {
        if(!validateEmail.test(inputField.value)){
            inputField.classList.add('error');
        } else {
            inputField.classList.remove('error');
        }
    });
}