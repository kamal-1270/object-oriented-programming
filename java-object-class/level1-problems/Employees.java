public class Employees {
    //i am taking a attributes name,id,salary
    String name;
    int id;
    int salary;
    //then create a parameter constructor assgin the instance 
    Employees(String name,int id,int salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }

    //display method
    public void display(){
        System.out.println("Name is : "+name+" \nId is : "+id+"\nSalary is : "+salary);
    }
    public static void main(String[] args) {
        // create a object
        Employees e = new Employees("Raunak",1234 , 45000);
        // then call  the display() method 
        e.display();
    }
}
