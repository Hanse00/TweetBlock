package hanse00.tweetblock.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import hanse00.tweetblock.reference.BlockInfo;
import hanse00.tweetblock.tileentities.TileEntityTweetBlock;
import net.minecraft.block.Block;

public class Blocks {
	
	public static Block tweetBlock;
	
	public static void init() {
		tweetBlock = new BlockTweetBlock(BlockInfo.TWEETBLOCK_ID);
		
		GameRegistry.registerBlock(tweetBlock, BlockInfo.TWEETBLOCK_KEY);
	}
	
	public static void initLang() {
		LanguageRegistry.addName(tweetBlock, BlockInfo.TWEETBLOCK_NAME);
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityTweetBlock.class, BlockInfo.TWEETBLOCK_TILE_KEY);
	}
 }
