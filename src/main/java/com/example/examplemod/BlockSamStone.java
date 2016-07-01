package com.example.examplemod;



import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockSamStone extends Block {

	String name = "samStone";
	
	public BlockSamStone()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(SamsMod.MODID + "_" + name);
		
		setCreativeTab(CreativeTabs.tabBlock);
	}
	public String getName()
	{
		return name;
	}
	
	
}
