// Superclass: Book
class Book {
    String title;
    int publicationYear;

    // Constructor
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display book details
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass: Author
class Author extends Book {
    String name;
    String bio;

    // Constructor
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear); // Call Book constructor
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Bio: " + bio);
    }
}

// Main class to test the system
public class LibraryManagement {
    public static void main(String[] args) {
        // Creating an Author object (which includes Book details)
        Author author = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald",
                "American novelist, known for jazz age fiction.");

        // Display book and author details
        author.displayInfo();
    }
}
