package dk.philiphansen.tweetblock;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;


public class Main {

	public static void main(String[] args) throws Exception {
		Twitter twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer(Reference.CONSUMER_KEY, Reference.CONSUMER_SECRET);

		RequestToken requestToken = twitter.getOAuthRequestToken();
		AccessToken accessToken = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (accessToken == null) {
			System.out.println("Open the following URL and grant access to your account:");
			System.out.println(requestToken.getAuthorizationURL());
			System.out.print("Enter the PIN (if available) or hit enter:");
			String pin = br.readLine();
			
			try {
				if (pin.length() > 0) {
					accessToken = twitter.getOAuthAccessToken(requestToken, pin);
				}
				else {
					accessToken = twitter.getOAuthAccessToken();
				}
			}
			catch (TwitterException e) {
				if (e.getStatusCode() == 401) {
					System.out.println("Unable to get access token.");
				}
				else {
					e.printStackTrace();
				}
			}
		}
		
		String username = accessToken.getScreenName();
		
		TwitterFactory newFactory = new TwitterFactory();
		
		Twitter tweetBlock = newFactory.getInstance();
		tweetBlock.setOAuthConsumer(Reference.CONSUMER_KEY, Reference.CONSUMER_SECRET);
		tweetBlock.setOAuthAccessToken(new AccessToken(Reference.MINECRAFTTWEETBLOCK_TOKEN, Reference.MINECRAFTTWEETBLOCK_SECRET));
		
		Status status = tweetBlock.updateStatus("@" + username + " Hi!");
		System.out.println("Tweeted: " + status.getText());
	}
}