// Base Book class
class Book {
    public String ISBN; // Public
    protected String title; // Protected
    private String author; // Private

    // Constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Setter method for author (needed since author is private)
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter method for author (needed since author is private)
    public String getAuthor() {
        return author;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass EBook inherits from Book
class EBook extends Book {
    // Constructor
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author); // Call superclass constructor
    }

    // Method to display eBook details
    public void displayEBookDetails() {
        System.out.println("EBook ISBN: " + ISBN); // Accessing public field
        System.out.println("EBook Title: " + title); // Accessing protected field
        // Can't access author directly since it's private in Book class
        System.out.println("EBook Author: " + getAuthor()); 
    }
}

// Main class to test the implementation
public class LibrarySystem {
    public static void main(String[] args) {
        EBook ebook = new EBook("123-456-789", "Java Programming", "James Gosling");
        ebook.displayEBookDetails();

        // Modifying author name using setter method
        ebook.setAuthor("Herbert Schildt");
        System.out.println("\nAfter updating author:");
        ebook.displayEBookDetails();
    }
}
