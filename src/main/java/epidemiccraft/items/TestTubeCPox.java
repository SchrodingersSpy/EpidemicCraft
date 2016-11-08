package epidemiccraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import epidemiccraft.com.EpidemicCraft;
import epidemiccraft.lib.Constants;
import net.minecraft.item.Item;

public class TestTubeCPox extends Item {

private String name = "TestTubeCPox";
	
	public TestTubeCPox(){
		
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(EpidemicCraft.EpidemicCraftTab);
		setContainerItem(ModItems.TestTubeUsed);
	}
	
	
}
