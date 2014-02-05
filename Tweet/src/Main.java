import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String username;
		String message;
		String pin;
		
		TweetHandler getHandler = new TweetHandler(Reference.GET_CONSUMER_KEY, Reference.GET_CONSUMER_SECRET);
		TweetHandler postHandler = new TweetHandler(Reference.POST_CONSUMER_KEY, Reference.POST_CONSUMER_SECRET, Reference.ACCESS_TOKEN, Reference.ACCESS_SECRET);
		
		System.out.println(getHandler.getRequest());
		pin = myScanner.nextLine();
		getHandler.setPin(pin);
		
		username = getHandler.getUserName();
		System.out.println(username);
		
		message = myScanner.nextLine();
		myScanner.close();
		System.out.println(postHandler.tweet(username, message));
	}
}
