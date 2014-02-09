package hanse00.tweetblock;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import hanse00.tweetblock.blocks.Blocks;
import hanse00.tweetblock.config.ConfigHandler;
import hanse00.tweetblock.network.PacketHandler;
import hanse00.tweetblock.proxies.CommonProxy;
import hanse00.tweetblock.reference.ModInfo;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(channels = {ModInfo.CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class TweetBlock {


	@Instance(ModInfo.ID)
	public static TweetBlock instance;

	@SidedProxy(clientSide = "hanse00.tweetblock.proxies.ClientProxy", serverSide = "hanse00.tweetblock.proxies.CommonProxy")
	public static CommonProxy proxy;

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		Blocks.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Blocks.initLang();
		Blocks.registerTileEntities();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	
	}
}
