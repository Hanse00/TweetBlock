package hanse00.tweetblock.tileentities;

import hanse00.tweetblock.reference.TweetInfo;
import hanse00.tweetblock.tweet.TweetHandler;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTweetBlock extends TileEntity {

	private TweetHandler	postHandler;
	private String			username;
	private String			message;
	private boolean			isPowered;

	public TileEntityTweetBlock() {
		postHandler = new TweetHandler(TweetInfo.POST_CONSUMER_KEY,
				TweetInfo.POST_CONSUMER_SECRET, TweetInfo.ACCESS_TOKEN,
				TweetInfo.ACCESS_SECRET);
		username = "Hanse00";
		message = "This is another ingame tweet";
		isPowered = false;
	}

	public void tweet() {
		postHandler.tweet(username, message);
	}

	public void triggerRedstone() {
		if (this.getWorldObj().isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && !isPowered) {
			isPowered = true;
			System.out.println("Redstone triggered!");
		}
		else if (!this.getWorldObj().isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && isPowered) {
			isPowered = false;
		}
	}

	public void openGUI() {
		//TODO: Open the GUI to inster message here
		System.out.println("GUI opened!");
	}
}
