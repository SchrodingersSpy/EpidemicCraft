package epidemiccraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import epidemiccraft.com.EpidemicCraft;
import epidemiccraft.lib.Constants;
import net.minecraft.item.Item;

public class SyringePlungerUsed extends Item {
private String name = "SyringePlungerUsed";
	
	public SyringePlungerUsed(){
		
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(EpidemicCraft.EpidemicCraftTab);
	}
	
	
}
