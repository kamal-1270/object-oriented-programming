public class Book {
    // i am take a attributes
    String title;
    String author;
    int price;

    //display method
    public void display(){
        System.out.println("Booke Title : "+title+"\nBook Author : "+author+"\nBook price : "+price);
    }
    public static void main(String[] args) {
        //create a object
        Book b = new Book();
        // assign the value
        b.title = "my love";
        b.author = "Raunak";
        b.price = 10000000;

        //call the method
        b.display();
    }
}
