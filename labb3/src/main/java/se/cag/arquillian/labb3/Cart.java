package se.cag.arquillian.labb3;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Book> bookList;

    @PostConstruct
    public void initialize() {
        bookList = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public int getTotalPrice() {
        int total = 0;
        for (Book book : bookList) {
            total += book.getPrice();
        }
        return total;
    }

    public void clear() {
        bookList.clear();
    }
}
