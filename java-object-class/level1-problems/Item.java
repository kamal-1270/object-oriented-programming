public class Item {
    int itemCode;
    String itemName;
    int price;

    //create a method on totalCost()
    public int totalCost(int p){
        price += p;
        return price;
    }

    //create a method on display 
    public void display(){
        System.out.println("Track Inventory of item code : "+itemCode+"\nTrack Inventory of item Name : "+itemName+"\nTrack Inventory of price : "+price);
    }

    public static void main(String[] args) {
        Item i = new Item();
        i.itemCode = 12;
        i.itemName = "Book";
        i.price = 499;

        i.display();
       System.out.println("Total cost : "+i.totalCost(300));
    }
}
