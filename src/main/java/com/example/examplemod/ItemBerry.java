package com.example.examplemod;

import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemBerry extends ItemFood {
    String name;
	public ItemBerry(int amount, float saturation, boolean isWolfFood, String itemName) {
		super(amount, saturation, isWolfFood);
	     name=itemName;
		 GameRegistry.registerItem(this, itemName);
		 setUnlocalizedName(SamsMod.MODID + "_" + itemName);
		 setPotionEffect(Potion.moveSpeed.id, 15, 0, 1F);
	}

	public String getName() {
 
		return name;
	}
	

}
