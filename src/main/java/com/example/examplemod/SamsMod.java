package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = SamsMod.MODID, version = SamsMod.VERSION)
public class SamsMod
{
	public static final String MODID = "wuppy29_samsmod";
	public static final String VERSION = "1.0";
	
	//Blocks
	public static Block samStone;

	//Items
	public static Item key;
	
	public static Item samdust;
	public static Item samingot;

	public static Item berry;
	
	//tools
	public static Item sampickaxe;
	
	ToolMaterial samium = EnumHelper.addToolMaterial("samium", 3, 1000, 9.5F, 3.5F, 10);
	
	//armor
	public static Item samhelmet;
	public static Item samchest;
	public static Item samleggings;
	public static Item samboots;

	ArmorMaterial samarmor = EnumHelper.addArmorMaterial("samarmor", "samarmor", 20,new int[] { 3, 7, 6, 3 }, 10);

		
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Blocks
		samStone = new BlockSamStone();
		
		//Items
		key = new ItemKey();
		
		//following works
		//GameRegistry.registerItem(key,"key");
 
		samdust = new ItemSamGeneric("samdust");
		samingot = new ItemSamGeneric("samingot");
		
		berry = new ItemBerry(3, 0.3F, true,"berry");
		
		//tools
		sampickaxe = new ItemSamPickaxe(samium, "sampickaxe");
		
		//armor
				samhelmet = new ItemSamArmor(samarmor, 0, "samhelmet");
				samchest = new ItemSamArmor(samarmor, 1, "samchestplate");
				samleggings = new ItemSamArmor(samarmor, 2, "samleggings");
				samboots = new ItemSamArmor(samarmor, 3, "samboots");
		
		
		if(event.getSide() == Side.CLIENT)
		{
			ItemKey.registerVariants();
		}
		
	}
	 
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		System.out.println("hello world");
		// crafting recipes
		GameRegistry.addRecipe(new ItemStack(Items.apple), 
				"XXX", 
				"XXX", 
				"XXX", 
				'X', Blocks.leaves);
		GameRegistry.addRecipe(new ItemStack(Items.arrow), 
				"YZ", 
				"X ", 
				'X', Items.flint, 'Y', Items.stick, 'Z', Blocks.leaves);
		GameRegistry.addRecipe(new ItemStack(Items.dye, 2, 1), 
				"XY", 
				'X', Items.redstone, 'Y', new ItemStack(Items.dye, 1, 1));
		GameRegistry.addRecipe(new ItemStack(key, 1, 0),
				"X",
				"X",
				'X', Items.iron_ingot);
		// shapeless recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 1), Items.redstone, new ItemStack(Items.dye, 1, 1));

		// special recipes
		ItemStack enchantedSwordItemStack = new ItemStack(Items.stone_sword);
		enchantedSwordItemStack.addEnchantment(Enchantment.sharpness, 1);

		GameRegistry.addShapelessRecipe(enchantedSwordItemStack, Items.flint, Items.stone_sword);

		ItemStack knockbackItemStack = new ItemStack(Items.stone_sword);
		knockbackItemStack.addEnchantment(Enchantment.knockback, 1);

		GameRegistry.addShapelessRecipe(knockbackItemStack, Items.gunpowder, Items.stone_sword );

		// smelting
		GameRegistry.addSmelting(Blocks.stone, new ItemStack(Blocks.stonebrick), 0.1F);

		// dungeon changes
		DungeonHooks.removeDungeonMob("Spider");
		DungeonHooks.addDungeonMob("Creeper", 100);
		ChestGenHooks.removeItem(ChestGenHooks.DUNGEON_CHEST, new ItemStack(Items.saddle));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Blocks.cobblestone), 25, 50, 10));
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		if (event.getSide() == Side.CLIENT)
		{

			 RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			 
			 //blocks
			 renderItem.getItemModelMesher().register(Item.getItemFromBlock(samStone), 0, new ModelResourceLocation(MODID + ":" + ((BlockSamStone) samStone).getName(), "inventory"));
			 
			 //items
		 	 //renderItem.getItemModelMesher().register(key, 0, new ModelResourceLocation(MODID + ":" +  "key", "inventory"));
		 	 //renderItem.getItemModelMesher().register(redKey, 0, new ModelResourceLocation(MODID + ":" + "redKey", "inventory"));
		     //following works	 
			 //renderItem.getItemModelMesher().register(samdust, 0, new ModelResourceLocation(MODID + ":" + "samdust", "inventory"));
		 	 renderItem.getItemModelMesher().register(key, 0, new ModelResourceLocation(MODID + ":" + ((ItemKey) key).getNameFromDamage(0), "inventory"));
			 renderItem.getItemModelMesher().register(key, 1, new ModelResourceLocation(MODID + ":" + ((ItemKey) key).getNameFromDamage(1), "inventory"));
 
			 renderItem.getItemModelMesher().register(samdust, 0, new ModelResourceLocation(MODID + ":" + ((ItemSamGeneric) samdust).getName(), "inventory"));
			 renderItem.getItemModelMesher().register(samingot, 0, new ModelResourceLocation(MODID + ":" + ((ItemSamGeneric) samingot).getName(), "inventory"));
				
			 renderItem.getItemModelMesher().register(berry, 0, new ModelResourceLocation(MODID + ":" + ((ItemBerry) berry).getName(), "inventory"));
		 
			 renderItem.getItemModelMesher().register(sampickaxe, 0, new ModelResourceLocation(MODID + ":" + ((ItemSamPickaxe) sampickaxe).getName(), "inventory"));
			 
				renderItem.getItemModelMesher().register(samhelmet, 0, new ModelResourceLocation(MODID + ":" + ((ItemSamArmor) samhelmet).getName(), "inventory"));
				renderItem.getItemModelMesher().register(samchest, 0, new ModelResourceLocation(MODID + ":" + ((ItemSamArmor) samchest).getName(), "inventory"));
				renderItem.getItemModelMesher().register(samleggings, 0, new ModelResourceLocation(MODID + ":" + ((ItemSamArmor) samleggings).getName(), "inventory"));
				renderItem.getItemModelMesher().register(samboots, 0, new ModelResourceLocation(MODID + ":" + ((ItemSamArmor) samboots).getName(), "inventory"));
				
		}
	}
}