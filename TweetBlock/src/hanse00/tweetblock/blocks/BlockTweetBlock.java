package hanse00.tweetblock.blocks;

import hanse00.tweetblock.reference.BlockInfo;
import hanse00.tweetblock.tileentities.TileEntityTweetBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTweetBlock extends BlockContainer {
	
	public BlockTweetBlock(int id) {
		super(id, Material.iron);
		setBlockUnbreakable();
		setResistance(6000000.0F);
		setCreativeTab(CreativeTabs.tabRedstone);
		setUnlocalizedName(BlockInfo.TWEETBLOCK_UNLOCALIZED_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.TWEETBLOCK_TEXTURE);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float offsetX, float offsetY, float offsetZ) {
		//TODO: GUI code goes here
		if (!world.isRemote) {
			TileEntity tile = world.getBlockTileEntity(x, y, z);
			
			if (tile != null && tile instanceof TileEntityTweetBlock) {
				TileEntityTweetBlock tweetTile = (TileEntityTweetBlock)tile;
				
				tweetTile.tweet("Hanse00", "Hello from Minecraft!");
			}
		}
		return true;
	}
	
	/*
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
		//TODO: Make sure only to do this if not previously powered
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)) {
			System.out.println("Redstone powered!");
		}
	}
	*/

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTweetBlock();
	}
}
