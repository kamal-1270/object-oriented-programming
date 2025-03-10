public class AnimalHierachy{
    public static void main(String[] args) {
        //create a array object
        Animal animal[]={
            new Dog("Hunter",10),
            new Cat("Luna",5),
            new Bird("Sparrow",7)
        };

        //then iterate the animal array
        for(Animal a : animal){
            System.out.println("Name : " + a.name + "\nAge : " + a.age+"\nSound : " + a.makeSound());
            System.out.println();
        }
    }
 }

 //create a class animal
 class Animal{
    //taken attributes
    String name;
    int age;

    //create a constructor
    public Animal(String name,int age){
        this.name=name;
        this.age=age;
    }
    //then taken a method makesound
    public String makeSound(){
        return "Animal Sound";
    }
 }

 //another create a class Dog it's inherit the animal class
 class Dog extends Animal{
    //then create a constructor
    public Dog(String name,int age){
        //call the super method on parent class 
        super(name,age);
    }

    //override the makesound 
    @Override
    public String makeSound(){
        return "Dog Sound Barks";
    }
 }
 //then create a class Cat it's inherit also animal class
 class Cat extends Animal{

    //create a constructor 
    public Cat(String name,int age){
        //call the super method on parent class 
        super(name, age);
    }
    //override the makesound 
    @Override
    public String makeSound(){
        return "Cat Sound Meow Meow";
    }
 }
 //another create a class Bird it's inherit the animal class
 class Bird extends Animal{
    //create a constructor 
    public Bird(String name,int age){
        //call the super method on parent class 
        super(name, age);
    }
    //override the makesound
    @Override
    public String makeSound(){
        return "Birds Sound Chi chi";
    }
 }