package hanse00.tweetblock.tileentities;

import hanse00.tweetblock.reference.TweetInfo;
import hanse00.tweetblock.tweet.TweetHandler;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTweetBlock extends TileEntity {

	TweetHandler	postHandler;

	public TileEntityTweetBlock() {
		postHandler = new TweetHandler(TweetInfo.POST_CONSUMER_KEY,
				TweetInfo.POST_CONSUMER_SECRET, TweetInfo.ACCESS_TOKEN,
				TweetInfo.ACCESS_SECRET);
		System.out.println("Tile entity placed");
	}

	public void tweet(String username, String message) {
		postHandler.tweet(username, message);
	}

}
