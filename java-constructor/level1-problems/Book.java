public class Book {
    // i am take a attributes
    String title;
    String author;
    int price;

    //create a default constructor
    Book(){
        this.title="computer network";
        this.author="Vicky prasad";
        this.price=399;
    }
    //create a parameterized constructor
    Book(String title,String author,int price){
        this.title=title;
        this.author=author;
        this.price=price;
    }

    //display method
    public void display(){
        System.out.println("Booke Title : "+title+"\nBook Author : "+author+"\nBook price : "+price);
    }
    public static void main(String[] args) {
        //create a object
        Book b = new Book("C programming","Dennis Ritchie",499);


        b.display();
        System.out.println();

        // assign the value
        b.title = "java programming";
        b.author = "james goshling";
        b.price = 999;

        //call the method
        b.display();
    }
}
