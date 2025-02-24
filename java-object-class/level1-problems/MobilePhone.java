public class MobilePhone {
    String brand;
    String model;
    int price;

    MobilePhone(String brand , String model , int price){
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    //display method
    public void display(){
        System.out.println("Mobile brand is : "+brand+"\nMobile model is : "+model+"\nMobile price is : "+price);
    }
    public static void main(String[] args) {
        
        MobilePhone mb = new MobilePhone("Redmi","Mi Note 5 pro",12999);
        MobilePhone mb1 = new MobilePhone("Vivo","Vivo t3 Ultra",32999);

        mb.display();
        System.out.println();
        mb1.display();
    }
}
