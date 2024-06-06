import java.util.ArrayList;
public class OrderTest{

    public static void main(String[] args){
        UserOrder user1 = new UserOrder();
        user1.addItem("mocha", 4.5);
        user1.addItem("latte", 3.5);
        user1.addItem("drip coffee", 2.5);
        user1.addItem("cappachino", 5.5);
        user1.newOrder();

        //BONUS METHOD TEST
        //this will run do all of the methods so comment out above first
        // UserOrder user1 = new UserOrder();
        // user1.newMenuItem();
    }
}