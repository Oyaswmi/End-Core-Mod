package com.oyaswmi.endcore.mixin;


import com.oyaswmi.endcore.CoreBiomeTags;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;


import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.BiomeTags;
import net.minecraft.tag.TagEntry;
import net.minecraft.tag.TagKey;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.swing.text.html.Option;

import java.util.OptionalLong;

import static com.oyaswmi.endcore.CoreBiomeTags.IS_FREEZING;
import static com.oyaswmi.endcore.enchantments.CoreEnchants.FROST_PROTECTION;
import static com.oyaswmi.endcore.world.dimension.CoreDim.CORE_DIMENSION_KEY;


@Mixin(PlayerEntity.class)
public abstract class CoreDimFreezeMix  {
    @Shadow public abstract boolean isPushedByFluids();

    private static final Logger LOGGER = LoggerFactory.getLogger("endcore");
    private int i = 0;
    private boolean isFrozen = false;
    @Inject(method = "tick()V", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {

        PlayerEntity self = (PlayerEntity) (Object) this;
        World world = self.getWorld();
        ItemStack chest = self.getEquippedStack(EquipmentSlot.CHEST);


            if (world.getBiome(self.getBlockPos()).isIn(CoreBiomeTags.IS_FREEZING) & !self.isCreative() && EnchantmentHelper.getLevel(FROST_PROTECTION, chest) != 1) {



                    isFrozen = true;
                    self.setInPowderSnow(true);
                    self.stopFallFlying();
                    self.setFrozenTicks(200);

            } else if (isFrozen) {
                isFrozen = false;
                self.setInPowderSnow(false);

            }


    }




}
