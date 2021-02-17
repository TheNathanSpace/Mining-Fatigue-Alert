package com.thekingelessar.miningfatiguealert;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod (modid = MiningFatigueAlert.MODID, version = MiningFatigueAlert.VERSION)
public class MiningFatigueAlert
{
    public static final String MODID = "miningfatiguealert";
    public static final String VERSION = "1.0";
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);
        
        MinecraftForge.EVENT_BUS.register(new PotionEffectHandler());
    }
    
}
