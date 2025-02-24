import java.util.Scanner;

public class AreaOfCrircle {

    //create a method of type float an Area of circle
    public static float AreaOfCir(float radius){
        //calculate the area of circle and return
        return (float)(3.14 * radius * radius);
    }
    public static void main(String[] args) {
        //create a object 
        Scanner sc = new Scanner(System.in);
        //take a variable on type float
        System.out.print("Enter a radius : ");
        float radius = sc.nextFloat();

        //then call the method and display
        System.out.println("Area of Circle : "+AreaOfCir(radius));

        sc.close();
    }
}
