package hanse00.tweetblock.config;

import hanse00.tweetblock.reference.BlockInfo;
import java.io.File;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	public static void init(File file) {
		Configuration config = new Configuration(file);

		config.load();

		BlockInfo.TWEETBLOCK_ID = config.getBlock(BlockInfo.TWEETBLOCK_KEY,
				BlockInfo.TWEETBLOCK_DEFAULT).getInt();

		config.save();
	}
}
