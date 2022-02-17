package book;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private String category;
    private int dateReleased;
    private BookStatus status;
    private BookCondition condition;
    private Date returnDate;

    public Book(String title, String author, String category, int dateReleased, BookStatus status, BookCondition condition, Date returnDate) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.dateReleased = dateReleased;
        this.status = status;
        this.condition = condition;
        this.returnDate = returnDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(int dateReleased) {
        this.dateReleased = dateReleased;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public BookCondition getCondition() {
        return condition;
    }

    public void setCondition(BookCondition condition) {
        this.condition = condition;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}