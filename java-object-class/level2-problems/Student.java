// package object-oriented-programming.java-object-class.level2-problems;

public class Student {
    //taken a attributes
    String name;
    int rollNo;
    int marks;

    //create a constructor 
    Student(String name , int rollNo , int marks){
        this.name=name;
        this.rollNo=rollNo;
        this.marks=marks;
    }

    // calculate and check the grade
    public void checkGrade(){
        // check marks greater then 90 then return Grade A
        if(marks > 90){
            System.out.println("Student Grade is : A");
        }
        //Check marks greater then 80 then return Grade A
        else if(marks > 80){
            System.out.println("Student Grade is : B");
        }
        //check marks greater then 60 then return Grade A
        else if(marks > 60){
            System.out.println("Student Grade is : C");
        }
        else{
            System.out.println("Fail");
        }
    }

    //method display
    public void display(){
        System.out.println("Student Name : "+name+"\nStudent RollNo : "+rollNo+"\nStudent Marks : "+marks);
    }
    public static void main(String[] args) {
        //create a object
        Student s = new Student("Vicky",1261 , 86);

        // then call the display() method
        s.display();
        System.out.println();
        //then call the checkGrade() method
        s.checkGrade();

    }
}
