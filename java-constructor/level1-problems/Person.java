// package object-oriented-programming.java-constructor.level1-problems;

public class Person {
    String name;
    int age;

    //create a parameterized constructor
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    //create a copy constructor type Person is called copy constructor
    Person(Person p){
        this.name=p.name;
        this.age=p.age;
    }

    //display all attributes
    public void display(){
        System.out.println("Person name : "+name+"\nPerson age : "+age);
    }
    public static void main(String[] args) {
        Person p = new Person("Vicky",21);
        p.display();

        System.out.println();
        Person p1 = new Person(p);
        p.display();

    }
}
