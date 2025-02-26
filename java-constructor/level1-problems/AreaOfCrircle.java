import java.util.Scanner;

public class AreaOfCrircle {
    double radius;

    //default constructor
    AreaOfCrircle(){
        this.radius=2.4;
    }
    //parameterized constructor
    AreaOfCrircle(double radius){
        this.radius=radius;
    }

    //create a method of type float an Area of circle
    public static double AreaOfCir(double radius){
        //calculate the area of circle and return
        return (double)(3.14 * radius * radius);
    }
    public static void main(String[] args) {
        //create a object 
        Scanner sc = new Scanner(System.in);
        //take a variable on type float user defined values
        System.out.print("Enter a radius : ");
        float radius = sc.nextFloat();

        //create parameterized constructor
        AreaOfCrircle a = new AreaOfCrircle(3.4);
        AreaOfCrircle a1 = new AreaOfCrircle();
        System.out.println("Area of Circle : "+a1.AreaOfCir(3.4));

        //then call the method and display
        System.out.println("Area of Circle : "+AreaOfCir(radius));

        sc.close();
    }
}
