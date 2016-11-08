package epidemiccraft.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import epidemiccraft.com.EpidemicCraft;
import epidemiccraft.lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public final class ModBlocks {
	
	public static Block Autoclave;
	public static Block AutoclaveActive;
	public static Block Incubator;
	public static Block IncubatorActive;
	
	public static void init(){
		
		Autoclave = new Autoclave(false).setBlockName("Autoclave").setCreativeTab(EpidemicCraft.EpidemicCraftTab).setBlockTextureName("EpidemicCraft:AutoclaveIcon");
		GameRegistry.registerBlock(Autoclave, Autoclave.getUnlocalizedName());
		AutoclaveActive = new Autoclave(true).setBlockName("AutoclaveActive").setBlockTextureName("EpidemicCraft:AutoclaveIcon");
		GameRegistry.registerBlock(AutoclaveActive, AutoclaveActive.getUnlocalizedName());
		Incubator = new Incubator(false).setBlockName("Incubator").setCreativeTab(EpidemicCraft.EpidemicCraftTab).setBlockTextureName("EpidemicCraft:IncubatorIcon");
		GameRegistry.registerBlock(Incubator, Incubator.getUnlocalizedName());
		IncubatorActive = new Incubator(true).setBlockName("IncubatorActive").setBlockTextureName("EpidemicCraft:IncubatorIcon");
		GameRegistry.registerBlock(IncubatorActive, IncubatorActive.getUnlocalizedName());

	}

}
