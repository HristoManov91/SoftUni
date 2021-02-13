package Lab_03_ComparableBook;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle (title);
        this.setYear (year);
        this.setAuthors (authors);
    }

    private void setAuthors(String[] authors) {
        this.authors = Arrays.asList(authors);
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    @Override
    public int compareTo(Book book) {
        int result = this.getTitle().compareTo(book.getTitle());
        if (result == 0){
            result = Integer.compare(this.getYear(), book.getYear());
        }
        return result;
    }
}
