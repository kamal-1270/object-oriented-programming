class Book {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; // Default to available
    }

    // Method to borrow a book
    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
            return true;
        } else {
            System.out.println(title + " is not available.");
            return false;
        }
    }

    // Method to return a book
    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Display book details
    public void displayDetails() {
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
        System.out.println("Available : " + (isAvailable ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "James goshling", 299.09);
        book1.displayDetails();
        
        book1.borrowBook();
        book1.displayDetails();
        
        book1.returnBook();
        book1.displayDetails();
    }
}
