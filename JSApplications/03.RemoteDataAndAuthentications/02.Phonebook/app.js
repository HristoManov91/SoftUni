function attachEvents() {
    document.getElementById('btnLoad').addEventListener('click', loadContacts);
    document.getElementById('btnCreate').addEventListener('click', onCreate);

    list.addEventListener('click', onDelete);
}

const list = document.getElementById('phonebook');
const personEl = document.getElementById('person');
const phoneEl = document.getElementById('phone');

async function loadContacts() {
    const url = `http://localhost:3030/jsonstore/phonebook`;

    const response = await fetch(url);
    const data = await response.json();

    list.replaceChildren(...Object.values(data).map(createItem));
}

function createItem(contact) {
    const liElement = document.createElement('li');
    liElement.innerHTML = `${contact.person}: ${contact.phone} <button data-id="${contact._id}">Delete</button>`
    return liElement;
}

async function onCreate() {
    const contact = {
        person: personEl.value,
        phone: phoneEl.value
    }

    const result = await createContact(contact);

    list.appendChild(createItem(result));

    personEl.value = '';
    phoneEl.value = '';
}

async function createContact(contact) {
    const url = `http://localhost:3030/jsonstore/phonebook`;
    const options = {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(contact)
    }

    const response = await fetch(url, options);
    const result = await response.json();

    return result;
}

async function onDelete(e) {
    const id = e.target.dataset.id;
    if (id) {
        await deleteContact(id);
        e.target.parentElement.remove();
    }
}

async function deleteContact(id) {
    const url = 'http://localhost:3030/jsonstore/phonebook/' + id;
    const options = {
        method: 'delete'
    }

    const response = await fetch(url, options);
    const result = await response.json();

    return result;
}

attachEvents();