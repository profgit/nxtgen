package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemSamArmor extends ItemArmor {
	
private String name;
	
	public ItemSamArmor(ArmorMaterial material, int armorType, String itemName)
	{
		super(material, 0, armorType);
		name = itemName;
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(SamsMod.MODID + "_" + name);
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == SamsMod.samhelmet || stack.getItem() == SamsMod.samchest || stack.getItem() == SamsMod.samboots) 
		{
			return SamsMod.MODID + ":models/armor/samarmor1.png";
		}
		else if(stack.getItem() == SamsMod.samleggings)
		{
			return SamsMod.MODID + ":models/armor/samarmor2.png";
		}
		else
		{
			System.out.println("Invalid Item");
			return null;
		}
	}
	public String getName()
	{
		return name;
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
	 player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 500, 4));
	}

}
