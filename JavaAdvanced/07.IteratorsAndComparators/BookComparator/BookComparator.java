package BookComparator;

import Book.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
        int result = first.getTitle().compareTo(second.getTitle());
        if (result == 0){
            result = first.getYear() - second.getYear();
        }
        return result;
    }
}
