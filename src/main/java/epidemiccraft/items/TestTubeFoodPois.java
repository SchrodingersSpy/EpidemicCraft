package epidemiccraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import epidemiccraft.com.EpidemicCraft;
import epidemiccraft.lib.Constants;
import net.minecraft.item.Item;

public class TestTubeFoodPois extends Item {

private String name = "TestTubeFoodPois";
	
	public TestTubeFoodPois(){
		
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(EpidemicCraft.EpidemicCraftTab);
		setContainerItem(ModItems.TestTubeUsed);
	}
	
	
}
