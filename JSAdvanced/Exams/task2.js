class LibraryCollection {

    constructor(capacity) {
        this.capacity = capacity;
        this.books = [];
    }

    addBook(bookName, bookAuthor) {
        if (typeof bookName !== 'string' || typeof bookAuthor !== 'string') {
            return;
        }
        if (this.capacity === this.books.length) {
            throw new Error('Not enough space in the collection.')
        }
        this.books.push({
            bookName: bookName,
            bookAuthor: bookAuthor,
            payed: false
        })

        return `The ${bookName}, with an author ${bookAuthor}, collect.`
    }

    payBook(bookName) {
        let findBook = this.books.filter(b => b.bookName === bookName)[0];
        if (!findBook) {
            throw new Error(`${bookName} is not in the collection.`)
        }

        if (findBook.payed) {
            throw new Error(`${bookName} has already been paid.`);
        }

        for (const book of this.books) {
            if (book.bookName === bookName) {
                book.payed = true;
                return `${bookName} has been successfully paid.`
            }
        }
    }

    removeBook(bookName) {
        let findBook = this.books.filter(b => b.bookName === bookName)[0];
        if (!findBook) {
            throw new Error("The book, you're looking for, is not found.");
        }

        if (!findBook.payed) {
            throw new Error(`${bookName} need to be paid before removing from the collection.`);
        }

        let bookIndex;
        for (let i = 0; i < this.books.length; i++) {
            if (this.books[i].bookName === bookName) {
                bookIndex = i;
                break;
            }
        }

        this.books.splice(bookIndex, 1);
        return `${bookName} remove from the collection.`
    }

    getStatistics (bookAuthor) {
        let output = [];
        if (!bookAuthor) {
            const emptySlots = this.capacity - this.books.length;
            output.push(`The book collection has ${emptySlots} empty spots left.`);
            this.books
                .sort((b1, b2) => b1.bookName.localeCompare(b2.bookName))
                .forEach(b => output.push(`${b.bookName} == ${b.bookAuthor} - ${b.payed ? 'Has Paid' : 'Not Paid'}.`))
        } else {
            let findBooks = this.books.filter(b => b.bookAuthor === bookAuthor);
            if (findBooks.length > 0) {
                findBooks
                    .forEach(b => output.push(`${b.bookName} == ${b.bookAuthor} - ${b.payed ? 'Has Paid' : 'Not Paid'}.`));
            } else {
                throw new Error(`${bookAuthor} is not in the collection.`)
            }
        }

        return output.join('\n');
    }
}

// const library = new LibraryCollection(5)
// library.addBook('Don Quixote', 'Miguel de Cervantes');
// library.payBook('Don Quixote');
// library.addBook('In Search of Lost Time', 'Marcel Proust');
// library.addBook('Ulysses', 'James Joyce');
// console.log(library.getStatistics());

// let library = new LibraryCollection(2);
// library.addBook("In Search of Lost Time", "Marcel Proust");
// library.addBook('Don Quixote', 'Miguel de Cervantes');
// library.payBook('Don Quixote');
// library.removeBook('Don Quixote');
// library.removeBook('In Search of Lost Time');

const library = new LibraryCollection(2)
console.log(library.addBook('Don Quixote', 'Miguel de Cervantes'));
console.log(library.getStatistics('Miguel de Cervantes'));
