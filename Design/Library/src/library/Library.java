package library;

import book.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private Address address;
    private List<Book> availableBooks;
    private List<Book> takenBooks;
    private static Library instance;

    private Library(String name, Address address) {
        this.name = name;
        this.address = address;

        this.availableBooks = new ArrayList<>();
        this.takenBooks = new ArrayList<>();
    }

    private Library() {
    }

    public static Library getInstance() {
        if (instance == null) {
            Address address = new Address("CA",
                    "Santa Clara",
                    "San Jose",
                    "1041 Washington Street");

            instance = new Library("Modern Library", address);
        }

        return instance;
    }


    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public List<Book> getTakenBooks() {
        return takenBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}