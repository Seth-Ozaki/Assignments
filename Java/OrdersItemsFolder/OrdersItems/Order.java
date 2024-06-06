import java.util.ArrayList;
public class Order{
    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Order(){
        this.name = "Guest";
    }

    public Order(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getReady(){
        return ready? String.format("%s, your order is ready.", getName()): String.format("%s, Thank you for waiting. Your order will be ready soon.", getName());
    }

    public void setReady(){
        if(ready){
            ready=false;
        }else{
            ready=true;
        }
    }

    public void addItem(Item item){
        items.add(item);
    }

    public double getTotal(){
        double total = 0;
        for(int i = 0; i<items.size();i++){
        double price = items.get(i).getPrice();
        total += price;
        }
        
        return total;
    }

    public void display(){
        System.out.printf("Customer Name: %s \n", getName());
        System.out.println("Order:");
        for(int i = 0; i<items.size();i++){
        System.out.printf("%s. %s - $%s \n", (i+1), items.get(i).getName(), items.get(i).getPrice() );
        }
        System.out.printf("Total: %s", getTotal());
        
    }

}