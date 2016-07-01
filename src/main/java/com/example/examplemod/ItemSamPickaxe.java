package com.example.examplemod;

import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemSamPickaxe extends ItemPickaxe {
private String name;
	
	public ItemSamPickaxe(ToolMaterial material, String itemName)
	{
		super(material);
		name = itemName;
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(SamsMod.MODID + "_" + name);
	}
	
	public String getName()
	{
		return name;
	}
}