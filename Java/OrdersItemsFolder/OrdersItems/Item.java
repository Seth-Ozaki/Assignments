public class Item{
    private String name;
    private double price;
    private int index;
    private static int count = 0;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
        this.index = count;
        count++;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getIndex(){
        return index;
    }
    
}