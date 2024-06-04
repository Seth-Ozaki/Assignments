import java.util.ArrayList;
public class CafeUtil {

    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for(int i = 0; i<=numWeeks;i++){
            sum += i;
        }
        return (sum);
    }

    public double getOrderTotal(double[] amounts){
        double total = 0;
        for(int i = 0; i<amounts.length;i++){
            total += amounts[i];
        }
        return total;
    }

    public static void displayMenu(ArrayList<String>menuItems){
        for(int i = 0; i<menuItems.size();i++){
            System.out.println(i +" "+ menuItems.get(i));
        }
        }

    public static void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name");
        String userName = System.console().readLine();
        customers.add(userName);
        int index = customers.indexOf(userName);
        if(index == 0){
        System.out.printf("Hello %s! There is no one ahead of you.", userName);
        }else{
        System.out.printf("Hello %s! There is %s ahead of you.", userName, index);

        }
        System.out.println(customers);
    }
}