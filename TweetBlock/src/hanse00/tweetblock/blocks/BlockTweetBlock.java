package hanse00.tweetblock.blocks;

import hanse00.tweetblock.reference.BlockInfo;
import hanse00.tweetblock.tileentities.TileEntityTweetBlock;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
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
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTweetBlock();
	}
	
	@Override
	public int idDropped(int meta, Random random, int fortune) {
		return -1;
	}

}
