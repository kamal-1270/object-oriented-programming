

// Main class
import java.util.*;
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        
        Book book = new Book("B123", "The Great Gatsby", "F. Scott Fitzgerald", true);
        Magazine magazine = new Magazine("M456", "Time Magazine", "Time Inc.");
        DVD dvd = new DVD("D789", "Inception", "Christopher Nolan", true);
        
        items.add(book);
        items.add(magazine);
        items.add(dvd);
        
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            
            if (item instanceof Reservable) {
                System.out.println("Availability: " + ((Reservable) item).checkAvailability());
                ((Reservable) item).reserveItem();
            }
            System.out.println("---------------------------");
        }
    }
}

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    
    public String getItemId() {
        return itemId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
    
    public abstract int getLoanDuration();
}

// Interface Reservable
interface Reservable {
    boolean reserveItem();
    boolean checkAvailability();
}

// Book class
class Book extends LibraryItem implements Reservable {
    private boolean isAvailable;
    
    public Book(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }
    
    @Override
    public int getLoanDuration() {
        return 14; // 14 days loan period for books
    }
    
    @Override
    public boolean reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book reserved successfully.");
            return true;
        } else {
            System.out.println("Book is not available for reservation.");
            return false;
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Magazine class
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 7; // 7 days loan period for magazines
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable;
    
    public DVD(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }
    
    @Override
    public int getLoanDuration() {
        return 5; // 5 days loan period for DVDs
    }
    
    @Override
    public boolean reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD reserved successfully.");
            return true;
        } else {
            System.out.println("DVD is not available for reservation.");
            return false;
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}
