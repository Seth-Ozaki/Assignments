
# 'OrderItems' 2 part assignment
###  Use the OrderTest.java to run each assignments code by pasting each respective test code

## **Part 1 - Baristas Challenge**
**Description:**\
**Now that you have made the Order and Item classes,the data isorganized and easier to manipulate, we're going to refactor your business logic even further to be able to perform some of that simulated functionality inside of the Order class by adding methods, constructors, setters and getters.**

**Since we'll be doing the same sorts of actions with every order, we can define methods within the Order class that will work on any order, with distinct customer names, items and totals. Each time a method gets called, it will manipulate only the data stored for that particular order.**

* *Item class* member variables:
    * `String name`
    * `double price`

* *Order class* member variables:
    * `String name`
    * `boolean ready`
    * `ArrayList<Item> items`

* *Item Class* Setup:
  * Set the member variables to `private`.
  * Add a constructor to your *Item class* that takes a `String name` and `double price` as arguments to set the name and price for that object on instantiation.
  * Create getters and setters for all the member variables.
* *Order Class* Setup:
  * Set the member variables to `private`.
  * Add a constructor to your *Order class* that takes no arguments, but sets the name to "Guest" and initializes the items array to an empty `ArrayList<Item>`
  * Add an overloaded constructor for `Order` that takes `String name` as an argument, so you can create an instance with a name.
  * Create getters and setters for all the member variables, using good naming convention for boolean accessors.
* *Order Class* Methods:
  * `addItem()`
    * Create a method called `addItem` that takes an `Item` object as an argument and adds the item to the order's `items` array. No need to return anything.
  * `getReady()`
    * Create a method called `getReady` that returns a String message. If the order is ready, return "Your order is ready.", if not, return "Thank you for waiting. Your order will be ready soon."
  * `getTotal()`
    * Create a method called `getTotal` that sums together each of the item's prices, and returns the total amount.
  * `dispay()`
    * Create a method called `display` that prints out the order information like so:
    ```java 
        Customer Name: Cindhuri
        drip coffee - $1.50
        capuccino - $3.50
        Total: $5.00
    ```
* Checklist:
  * Implement the *Order* and *Item classes* as described above.
  * Create a testing file to complete the test cases for each method.
  * Create 2 orders for unspecified guests. Do not specify a name.
  * Create 3 orders using the overloaded constructor to give each a name for the order.
  * Implement the `addItem`, `getReady`, `getTotal`, and `display` methods within the Order class.
  * Add at least 2 `items` to at least 2 of the `orders` using the `addItem` method.
  * Test your `getReady` method by setting some `orders` to ready and printing the messages for each order.
  * Test the total by printing the return value like so: 'System.out.println(order1.getTotal())'.
  * Finally, call the `display` method on all of your orders.
    


        Test Code:
        Item item1 = new Item("mocha", 4.5);
        Item item2 = new Item("latte", 3.5);
        Item item3 = new Item("drip coffee", 2.5);
        Item item4 = new Item("cappachino", 5.5);

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Cindhuri");
        Order order4 = new Order("Jimmy");
        Order order5 = new Order("Noah");



        order1.addItem(item1);
        order1.addItem(item2);
        order1.addItem(item3);
        System.out.println(order1.getReady());
        order1.setReady();
        System.out.println(order1.getReady());
        System.out.println(order1.getTotal());
        order1.display();

        order3.addItem(item4);
        order3.addItem(item3);
        order3.addItem(item3);
        System.out.println(order3.getReady());
        order3.setReady();
        System.out.println(order3.getReady());
        System.out.println(order3.getTotal());
        order3.display();


## **Part 2 **
**Description:**\
**Now that you've shown the capabilities of your code, the Cafe Java owners want you to make it a full-fledged interactive app. However, they want it to be retro, like an old computer, an Apple II or Commodore 64, where users are shown some text questions in a terminal and can answer or press 'q' to quit.**

**We'll be using the code base we already have but will be adding one member variable to the *Item class*, `int index`. Don't forget to give it a getter and setter. To finally tie it all together and add some interactivity, you will create a new class called `UserOrder`**

* *UserOrder class* member variables:
  * `ArrayList<Item> menu`
  * `ArrayList<Order> orders`
* *UserOrder class* setup:
  * Constructor - no params, initializes items and orders to empty arrays.
* *UserOrder class* methods:
  * `addItem()`
    * The `addItem` method should create a new *Item object* with the given name and price.
    * Add the new *Item object* to the `menu items` array.
    * The new `menu item` itself will also need to be assigned an `index` property. The value should be its position, its `index`, in the `menu` array.
  * `displayMenu()`
    * Now with an array of `items` you can display the `menu` without needing separate arrays of names and prices!
    * The `displayMenu` method should display all of the `items` from the `menu` array like so:
    ```java 
    0 banana -- $2.00 
    1 coffee -- $1.50 
    2 latte -- $4.50 
    3 capuccino -- $3.00 
    4 muffin -- $4.00
    ```

  * `newOrder()`
    * The `newOrder` method will take input from the user in the `terminal` to create a `new order` instance and add it to the `orders` array. We have given you some code to get you started.
  * Bonus Method: `addMenuByInput()`
    * Create a method that lets an admin add `menu items` manually, using what you now know about getting user input.
* Cheklist
  * Add the index member variable to the Item class.
  * Implement the CoffeeKiosk Class as described above.
  * Implement the addMenuItem, displayMenu, and newOrder methods.
  * Using the example provided, test the logic of your application.
  * Bonus: Implement the addMenuItemByInput method.

        Test Codde:
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