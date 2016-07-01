package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemSamGeneric extends Item
{
	private String name;
	
	public ItemSamGeneric(String itemName)
	{
		name = itemName;
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(SamsMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public String getName()
	{
		return name;
	}
}
