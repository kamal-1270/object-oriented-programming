
import java.util.*;

//book class to represent books 
class Book {
    private String title;
    private String author;

    // Constructor to initialize book attributes
    public Book(String title, String author) {
        this.title = title;
        this.author = author;

    }

    // Getter methods to retrieve book details
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Overriding toString() method to return a readable book representation
    @Override
    public String toString() {
        return "Book{Title: '" + title + "', author: '" + author + "' }";
    }

}

//library class to represent collection of books
class Library {
    private String name;
    private final List<Book> books; // List to store books in the library

    // Constructor to initialize library name and book list
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display books available in the library
    public void showBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            System.out.println(book);
        }
    }

}


 // Main class to demonstrate the aggregation relationship
public class LibrarySystem {
    public static void main(String[] args) {
        // Creating independent book objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");
        
        // Creating libraries
        Library library1 = new Library("City Library");
        Library library2 = new Library("Community Library");

        // Adding books to libraries (Aggregation relationship)
        library1.addBook(book1);
        library1.addBook(book2);
        
        library2.addBook(book2);
        library2.addBook(book3);

        // Display books in each library
        System.out.println("\n----------------------------");
        library1.showBooks();
        System.out.println("\n----------------------------");
        library2.showBooks();
    }

}