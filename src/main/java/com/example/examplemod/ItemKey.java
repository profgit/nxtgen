package com.example.examplemod;

import java.util.List;

import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKey extends Item
{
	private static String name="key";
	private static String[] metaNames = { "grey", "red" };

	public ItemKey()
	{
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(SamsMod.MODID + "_" + name);
		setHasSubtypes(true);
	 	setCreativeTab(CreativeTabs.tabMisc);
	}
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		return super.getUnlocalizedName() + "." + metaNames[par1ItemStack.getItemDamage()];
	}
	
	public static String getNameFromDamage(int damage)
	{
		return name + metaNames[damage];
	}

	@SuppressWarnings("deprecation")
	public static void registerVariants()
	{
		String[] variantNames = new String[metaNames.length];
		for (int i = 0; i < metaNames.length; i++)
		{
			variantNames[i] = SamsMod.MODID + ":" + getNameFromDamage(i);
		}
		ModelBakery.addVariantName(SamsMod.key, variantNames);
	}
	@SuppressWarnings({"unchecked","rawtypes"})
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems)
	{
		for (int i = 0; i < metaNames.length; ++i)
		{
			subItems.add(new ItemStack(itemIn, 1, i));
		}
	}
 
	
}