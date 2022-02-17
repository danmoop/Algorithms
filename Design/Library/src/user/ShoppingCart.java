package user;

import book.Book;

import java.util.HashSet;
import java.util.Set;

public class ShoppingCart {
    private Set<Book> books;

    ShoppingCart() {
        this.books = new HashSet<>();
    }

    public Set<Book> getBooks() {
        return books;
    }
}