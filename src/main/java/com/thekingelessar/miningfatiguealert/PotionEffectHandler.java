package com.thekingelessar.miningfatiguealert;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionEffectHandler {
    private static boolean hasMiningFatigue = false;
    
    @SideOnly (Side.CLIENT)
    @SubscribeEvent (priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(TickEvent.ClientTickEvent tickEvent) {
        Minecraft minecraft = Minecraft.getMinecraft();
        EntityPlayerSP player = minecraft.thePlayer;
        
        if (player == null) {
            return;
        }
        
        PotionEffect potionEffect = player.getActivePotionEffect(Potion.digSlowdown);
        
        if (potionEffect != null) {
            if (hasMiningFatigue) {
                return;
            }
            
            player.playSound("minecraft:mob.ghast.charge", 5.0f, 1.0f);
            player.addChatMessage(new ChatComponentText("You have received the " + ChatFormatting.GOLD + ChatFormatting.BOLD + "mining fatigue " + ChatFormatting.RESET + "effect!"));
            Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 5, 20, 5);
            Minecraft.getMinecraft().ingameGUI.displayTitle(null, "You have " + ChatFormatting.GOLD + "mining fatigue" + ChatFormatting.RESET + "!", 0, 10, 0);
            Minecraft.getMinecraft().ingameGUI.displayTitle("", "", 0, 0, 0);
    
            hasMiningFatigue = true;
            return;
        }

        hasMiningFatigue = false;
    }
    
}
