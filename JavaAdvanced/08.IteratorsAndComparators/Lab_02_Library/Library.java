package Lab_02_Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {

    //когато пишем неснат трябва да е static (в редки случаи може да го правим не static)
    private class LibraryIterator implements Iterator<Book> { //ако е static няма да вижда books

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
//        Iterator<Book> bookIterator = new Iterator<Book>() {
//
//            private int index = 0;
//
//            @Override
//            public boolean hasNext() {
//                return index < books.length;
//            }
//
//            @Override
//            public Book next() {
//                return books[index++];
//            }
//        };
        return new LibraryIterator();
    }
}
