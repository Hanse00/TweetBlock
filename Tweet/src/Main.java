import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String username;
		String message;
		String pin;
		
		TweetHandler getHandler = new TweetHandler(Reference.GET_CONSUMER_KEY, Reference.GET_CONSUMER_SECRET);
		TweetHandler postHandler = new TweetHandler(Reference.POST_CONSUMER_KEY, Reference.POST_CONSUMER_SECRET, Reference.ACCESS_TOKEN, Reference.ACCESS_SECRET);
		
		System.out.println("Open the following link to authenticate:");
		System.out.println(getHandler.getRequest());
		
		System.out.print("Enter PIN: ");
		pin = myScanner.nextLine();
		getHandler.setPin(pin);
		
		username = getHandler.getUserName();
		
		System.out.print("Message to tweet: ");
		message = myScanner.nextLine();
		myScanner.close();
		postHandler.tweet(username, message);
	}
}
