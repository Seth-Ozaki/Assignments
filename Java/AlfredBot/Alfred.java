import java.util.Date;
public class Alfred {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String output = String.format("Hello, %s. Lovely to see you.", name);
        return output;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        String output = String.format("It is currently %s", date);
        return output;
    }
    
    public String respondBeforeAlexis(String conversation) {
        String convo = conversation;
        int alexis = convo.indexOf("Alexis");
        int alfred = convo.indexOf("Alfred");
        if(alexis > -1){
            return  "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        if(alfred > -1){
            return "At your service. As you wish, naturally.";
        }
        else{
            return"Right. And with that I shall retire.";
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
        // SENSEI BONUS
        // Write your own AlfredQuote method using any of the String methods you have learned!
}

