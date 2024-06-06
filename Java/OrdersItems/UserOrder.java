import java.util.ArrayList;
public class UserOrder{
    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    public UserOrder(){}

    public ArrayList<Item> getMenu(){
        return menu;
    }

    public void addItem(String name, double price){
        Item option = new Item(name, price);
        menu.add(option);
    }

    public void displayMenu(){
        System.out.println("Menu:");
        for(int i = 0; i<menu.size();i++){
        System.out.printf("%s. %s -- $%s \n", i, menu.get(i).getName(), menu.get(i).getPrice() );
        }
        
    }

    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Order user = new Order(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            // Get the item object from the menu, and add the item to the order
            user.addItem(menu.get(Integer.parseInt(itemNumber)));
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
        user.display();
        
    }


    //BONUS METHODS
    public void newMenuItem() {
        
        System.out.println("Please enter Item name:");
        String name = System.console().readLine();

        System.out.println("Please enter Item price:");
        String price = System.console().readLine();
        addItem(name, Double.parseDouble(price));
        userChoice();
    }

    public void userChoice(){
        System.out.println("1 for new item 2 to make an order:");
        String choice = System.console().readLine();

        if(choice.equals("1")){
            newMenuItem();
        }
        else if(choice.equals("2")){
            newOrder();
        }
        else{
            userChoice();
        }
    }
    }

