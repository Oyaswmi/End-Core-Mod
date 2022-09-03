package com.oyaswmi.endcore.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.oyaswmi.endcore.CoreInit.ModID;

public class CoreEnchants {
    public static Enchantment FROST_PROTECTION = new FrostProtectionEnch();

    public static void RegisterCoreEnchants() {
        Registry.register(Registry.ENCHANTMENT, new Identifier(ModID, "frost_protection"), FROST_PROTECTION);
    }

}
