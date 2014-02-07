package hanse00.tweetblock.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hanse00.tweetblock.reference.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTweetBlock extends Block {
	
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

}
