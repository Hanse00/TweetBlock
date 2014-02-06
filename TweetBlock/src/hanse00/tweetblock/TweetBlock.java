package hanse00.tweetblock;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import hanse00.tweetblock.network.PacketHandler;
import hanse00.tweetblock.proxies.CommonProxy;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION)
@NetworkMod(channels = {Reference.CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class TweetBlock {


	@Instance(Reference.ID)
	public static TweetBlock instance;

	@SidedProxy(clientSide = "hanse00.tweetblock.proxies.ClientProxy", serverSide = "hanse00.tweetblock.proxies.CommonProxy")
	public static CommonProxy proxy;

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
	
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	
	}
}
