package hanse00.tweetblock.tileentities;

import hanse00.tweetblock.reference.TweetInfo;
import hanse00.tweetblock.tweet.TweetHandler;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTweetBlock extends TileEntity {

	private TweetHandler	postHandler;
	private String			username;
	private String			message;

	public TileEntityTweetBlock() {
		postHandler = new TweetHandler(TweetInfo.POST_CONSUMER_KEY,
				TweetInfo.POST_CONSUMER_SECRET, TweetInfo.ACCESS_TOKEN,
				TweetInfo.ACCESS_SECRET);
		username = "Hanse00";
		message = "This is another ingame tweet";
	}

	public void tweet() {
		postHandler.tweet(username, message);
	}

	public void triggerRedstone() {
		//TODO: Check if redstone state has changed, then tweet
		System.out.println("Redstone triggered!");
	}

	public void openGUI() {
		//TODO: Open the GUI to inster message here
		System.out.println("GUI opened!");
	}
}
