window.addEventListener('DOMContentLoaded', () => {
    let form = document.querySelector('form');
    form.addEventListener('click' , onLogin);
});

async function onLogin(event){
    event.preventDefault();
    const formData = new FormData(event.target);

    const email = formData.get('email');
    const password = formData.get('password');

    const url = 'http://localhost:3030/users/login';
    const options = {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({email , password})
    };

    try {
        const response = await fetch(url, options);
        if (response.ok !== true){
            const error = await response.json();
            throw new Error(error.message);
        }

        const data = await response.json()
        const userData = {
            email: data.email,
            id: data._id,
            token: data.accessToken
        }

        sessionStorage.setItem('userData' , JSON.stringify(userData));
        window.location = ('/index.html');

    } catch (err){
        alert(err.message);
    }

}