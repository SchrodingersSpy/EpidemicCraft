package epidemiccraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import epidemiccraft.com.EpidemicCraft;
import epidemiccraft.lib.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PetriDishEColiRaw extends Item {

private String name = "PetriDishEColiRaw";
	
	public PetriDishEColiRaw(){
		
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + "PetriDish");
		GameRegistry.registerItem(this, name);
		setCreativeTab(EpidemicCraft.EpidemicCraftTab);
		setContainerItem(ModItems.PetriDishUsed);
	}
	
	
}
