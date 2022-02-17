package user;

import book.Book;
import library.Library;

public class Admin extends Customer {
    Admin(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }

    public boolean addBook(Book book) {
        if (Library.getInstance().getAvailableBooks().contains(book)) {
            return false;
        }

        Library.getInstance().getAvailableBooks().add(book);
        return true;
    }

    public boolean removeBook(Book book) {
        if (!Library.getInstance().getAvailableBooks().contains(book)) {
            return false;
        }

        Library.getInstance().getAvailableBooks().remove(book);
        return true;
    }

    public boolean changeCategory(Book book, String category) {
        if (!Library.getInstance().getAvailableBooks().contains(book)) {
            return false;
        }

        book.setCategory(category);
        return true;
    }

    public boolean giveBook(Book book, Customer customer) {
        if (customer.getBooks().contains(book)) {
            return false;
        }

        customer.getBooks().add(book);
        return true;
    }

    public boolean acceptBook(Book book, Customer customer) {
        if (customer.getBooks().contains(book)) {
            return false;
        }

        customer.getBooks().remove(book);
        return true;
    }

    public boolean sendNotification(Customer customer, String message) {
        if (customer.getBooks().size() == 0) {
            return false;
        }

        customer.getNotifications().add(new Notification(message));
        return true;
    }
}