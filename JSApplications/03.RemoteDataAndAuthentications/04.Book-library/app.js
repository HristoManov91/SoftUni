document.getElementById('loadBooks').addEventListener('click', loadBooks);

const createForm = document.getElementById('create-form');
const titleInput = createForm.querySelector('[name="title"]');
const authorInput = createForm.querySelector('[name="author"]');
createForm.addEventListener('submit', onCreate);

const editForm = document.getElementById('edit-form');
editForm.addEventListener('submit', onEdit);
const titleEditInput = editForm.querySelector('[name="title"]');
const authorEditInput = editForm.querySelector('[name="author"]');

const tbodyElement = document.querySelector('tbody');
tbodyElement.addEventListener('click', onTableClick)


async function request(url, options) {
    const response = await fetch(url, options);

    if (response.ok !== true) {
        const error = await response.json();
        alert(error.message);
        throw new Error(error.message);
    }

    return await response.json();
}

async function loadBooks() {
    const url = 'http://localhost:3030/jsonstore/collections/books';
    const books = await request(url);

    tbodyElement.replaceChildren(...Object.values(books).map(createItem))
}

async function loadBookById(id) {
    const url = 'http://localhost:3030/jsonstore/collections/books/' + id;
    const book = await request(url);

    return book;
}

async function onTableClick(ev) {
    if (ev.target.className === 'delete') {

        await deleteBook(ev.target.parentElement.dataset.id);
        ev.target.parentElement.parentElement.remove();

    } else if (ev.target.className === 'edit') {

        createForm.style.display = 'none';
        editForm.style.display = 'block';

        const id = ev.target.parentElement.dataset.id;
        const book = await loadBookById(id);

        editForm.querySelector('[name="id"]').value = id;
        titleEditInput.value = book.title;
        authorEditInput.value = book.author;
    }
}

async function onCreate(e) {
    e.preventDefault();
    const title = titleInput.value;
    const author = authorInput.value;

    const book = {
        title,
        author
    }

    const result = await createBook(book);
    tbodyElement.appendChild(createItem(result));

    titleInput.value = '';
    authorInput.value = '';
}

async function createBook(book) {
    const url = 'http://localhost:3030/jsonstore/collections/books';

    const options = {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(book)
    }

    return await request(url, options);
}

async function onEdit(ev) {
    ev.preventDefault();
    const formData = new FormData (ev.target);
    const id = formData.get('id');
    const author = formData.get('author');
    const title = formData.get('title');

    const book = {
        title,
        author
    }

    const result = await editBook(id , book);
    ev.target.reset();
    createForm.style.display = 'block';
    editForm.style.display = 'none';

    titleEditInput.value = '';
    authorEditInput.value = '';

    await loadBooks();
}

async function editBook(id, book) {
    const url = 'http://localhost:3030/jsonstore/collections/books/' + id;

    const options = {
        method: 'put',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(book)
    }

    return await request(url, options);
}

async function deleteBook(id) {
    const url = 'http://localhost:3030/jsonstore/collections/books/' + id;

    const options = {
        method: 'delete'
    }

    return await request(url, options);
}

function createItem(book) {
    const trElement = document.createElement('tr');

    const titleElement = document.createElement('td');
    titleElement.textContent = book.title;
    trElement.appendChild(titleElement);

    const authorElement = document.createElement('td');
    authorElement.textContent = book.author;
    trElement.appendChild(authorElement);

    const buttonsElement = document.createElement('td');
    buttonsElement.dataset.id = `${book._id}`;

    const editButton = document.createElement('button');
    editButton.textContent = 'Edit';
    editButton.className = 'edit'
    buttonsElement.appendChild(editButton);

    const deleteButton = document.createElement('button')
    deleteButton.textContent = 'Delete';
    deleteButton.className = 'delete';
    buttonsElement.appendChild(deleteButton);

    trElement.appendChild(buttonsElement);

    return trElement;
}