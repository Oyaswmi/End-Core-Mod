package com.oyaswmi.endcore.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static com.oyaswmi.endcore.CoreInit.ModID;
import static com.oyaswmi.endcore.blocks.CoreBlocks.*;

public class CoreItems {

    //creates the group for the mod's items
    public static final ItemGroup ENDCORE_GROUP = FabricItemGroupBuilder.build(
            new Identifier(ModID, "general"),
            () -> new ItemStack(SNOWY_ENDSTONE));



    public static final EndSnowball END_SNOWBALL = new EndSnowball(new FabricItemSettings().group(ENDCORE_GROUP).maxCount(16));
    public static final RuneEngravedBook SHARPNESS_RUNE = new RuneEngravedBook(new FabricItemSettings().group(ENDCORE_GROUP).maxCount(1));
    public static final RuneEngravedBook PROTECTION_RUNE = new RuneEngravedBook(new FabricItemSettings().group(ENDCORE_GROUP).maxCount(1));
    //snow cones for all!
    public static final Item EMPTY_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP));
    public static final Item WHITE_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item LIGHT_GRAY_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item GRAY_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item BLACK_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item BROWN_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item RED_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item ORANGE_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item YELLOW_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item LIME_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item GREEN_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item CYAN_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item LIGHT_BLUE_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item BLUE_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item PURPLE_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item MAGENTA_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));
    public static final Item PINK_SNOWCONE = new Item(new FabricItemSettings().group(ENDCORE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));



    public static void RegisterCoreItems() {
        Registry.register(Registry.ITEM, new Identifier(ModID, "protection_rune"), PROTECTION_RUNE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "sharpness_rune"), SHARPNESS_RUNE);
        //snow cones for all!
        Registry.register(Registry.ITEM, new Identifier(ModID, "empty_snowcone"), EMPTY_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "white_snowcone"), WHITE_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "light_gray_snowcone"), LIGHT_GRAY_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "gray_snowcone"), GRAY_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "black_snowcone"), BLACK_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "brown_snowcone"), BROWN_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "red_snowcone"), RED_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "orange_snowcone"), ORANGE_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "yellow_snowcone"), YELLOW_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "lime_snowcone"), LIME_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "green_snowcone"), GREEN_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "cyan_snowcone"), CYAN_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "light_blue_snowcone"), LIGHT_BLUE_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "blue_snowcone"), BLUE_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "purple_snowcone"), PURPLE_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "magenta_snowcone"), MAGENTA_SNOWCONE);
        Registry.register(Registry.ITEM, new Identifier(ModID, "pink_snowcone"), PINK_SNOWCONE);



        //misc items
        Registry.register(Registry.ITEM, new Identifier(ModID, "carved_rune"), new BlockItem(CARVED_RUNE, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(ModID, "amethyst_dust"), new BlockItem(AMETHYST_DUST, new FabricItemSettings().group(ENDCORE_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ModID, "rune_altar"), new BlockItem(RUNE_ALTAR, new FabricItemSettings().group(ENDCORE_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ModID, "snowy_endstone"), new BlockItem(SNOWY_ENDSTONE, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(ModID, "end_snow_layer"), new BlockItem(END_SNOW_LAYER, new FabricItemSettings().group(ENDCORE_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ModID, "end_snowball"), END_SNOWBALL);
    }
}
