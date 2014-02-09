package hanse00.tweetblock.tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;


public class TweetHandler {
	private Twitter twitter;
	private RequestToken request;
	private AccessToken userAccessToken;
	
	public TweetHandler(String consumerKey, String consumerSecret) {
		this(consumerKey, consumerSecret, null, null);
	}
	
	public TweetHandler(String consumerKey, String consumerSecret, String accessToken, String accessSecret) {
		twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		
		if (accessToken != null && accessSecret != null) {
			twitter.setOAuthAccessToken(new AccessToken(accessToken, accessSecret));
		}
	}
	
	public String getRequest() {
		try {
			request = twitter.getOAuthRequestToken();
			return request.getAuthorizationURL();
		} catch (TwitterException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean setPin(String pin) {
		try {
			userAccessToken = twitter.getOAuthAccessToken(request, pin);
			return true;
		} catch (TwitterException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String getUserName() {
		return userAccessToken.getScreenName();
	}
	
	public boolean tweet(String user, String message) {
		try {
			twitter.updateStatus("@" + user + " " + message);
			return true;
		} catch (TwitterException e) {
			e.printStackTrace();
			return false;
		}
	}
}
