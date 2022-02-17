package user;

import book.Book;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private Set<Book> books;
    private Set<Notification> notifications;
    private ShoppingCart shoppingCart;

    public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.shoppingCart = new ShoppingCart();
        this.books = new HashSet<>();
        this.notifications = new HashSet<>();
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public boolean addToShoppingCart(Book book) {
        if (shoppingCart.getBooks().contains(book)) {
            return false;
        }

        shoppingCart.getBooks().add(book);
        return true;
    }

    public boolean removeNotification(Notification n) {
        if (notifications.contains(n)) {
            return false;
        }

        notifications.remove(n);
        return true;
    }

    public boolean takeBooks() {
        books.addAll(shoppingCart.getBooks());

        return true;
    }

    public boolean returnBook(Book book) {
        if (!books.contains(book)) {
            return false;
        }

        books.remove(book);
        return true;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}