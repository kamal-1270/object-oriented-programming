// package object-oriented-programming.java-object-class.level2-problems;

import java.util.Scanner;

public class MovieTicket {
    String movieName;
    int seatNumber;
    int price;
    boolean isBooked;

    //take a constructor
    MovieTicket(String movieName,int seatNumber,int price){
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = false;
    }
    //create a method book ticket
    public void BookTicket(){
        if(!isBooked){
            isBooked = true;
            System.out.println("Ticket booked successfully for "+movieName+" at seat "+seatNumber);
        }else{
            System.out.println("seat : "+seatNumber+" is already booked");
        }
    }

    //display the ticket
    public void displayTicket(){
        System.out.println("Movie : "+movieName);
        System.out.println("Seat Number : "+seatNumber);
        System.out.println("Price : "+price);
        System.out.println("Status : "+(isBooked ? "Booked" : "Available"));
    }
    public static void main(String[] args) {
        //create a object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Movie Name : ");
        String movieName = sc.next();
        System.out.print("Enter Seat No : ");
        int seatNumber = sc.nextInt();
        System.out.print("Enter Price : ");
        int price = sc.nextInt();

        MovieTicket ticket = new MovieTicket(movieName,seatNumber,price);

        //call the method on display ticket
        System.out.println();
        ticket.displayTicket();
        System.out.println();
        //call the method book ticket
        ticket.BookTicket();
        System.out.println();
        //call the method display ticket
        ticket.displayTicket();
    }
}
