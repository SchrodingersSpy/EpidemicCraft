package epidemiccraft.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import epidemiccraft.blocks.ModBlocks;
import epidemiccraft.blocks.RenderAutoclave;
import epidemiccraft.blocks.RenderIncubator;
import epidemiccraft.mobs.ModelCPoxVillager;
import epidemiccraft.mobs.RenderCPoxVillager;
import epidemiccraft.mobs.ModelEColiChicken;
import epidemiccraft.mobs.RenderEColiChicken;
import epidemiccraft.mobs.EntityCPoxVillagerMob;
import epidemiccraft.mobs.EntityEColiChickenMob;
import epidemiccraft.mobs.EntityFluBirdMob;
import epidemiccraft.mobs.EntityPolioVillagerMob;
import epidemiccraft.mobs.EntityRabiesWolfMob;
import epidemiccraft.mobs.ModelFluBird;
import epidemiccraft.mobs.RenderFluBird;
import epidemiccraft.mobs.ModelGiardiaCow;
import epidemiccraft.mobs.RenderGiardiaCow;
import epidemiccraft.mobs.EntityGiardiaCowMob;
import epidemiccraft.mobs.ModelPolioVillager;
import epidemiccraft.mobs.RenderPolioVillager;
import epidemiccraft.mobs.ModelRabiesWolf;
import epidemiccraft.mobs.RenderRabiesWolf;
import epidemiccraft.tileentity.TileEntityAutoclave;
import epidemiccraft.tileentity.TileEntityIncubator;

public class ClientProxy  extends CommonProxy{

	@SideOnly(Side.CLIENT)
	public void preInit(){
		RenderingRegistry.addNewArmourRendererPrefix("5");
	}
	
	public void init(){
		this.registerRenders();
	}
	
	
	public void registerRenders(){
		RenderingRegistry.registerEntityRenderingHandler(EntityFluBirdMob.class, new RenderFluBird(new ModelFluBird(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityCPoxVillagerMob.class, new RenderCPoxVillager(new ModelCPoxVillager(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityPolioVillagerMob.class, new RenderPolioVillager(new ModelPolioVillager(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityRabiesWolfMob.class, new RenderRabiesWolf(new ModelRabiesWolf(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityEColiChickenMob.class, new RenderEColiChicken(new ModelEColiChicken(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityGiardiaCowMob.class, new RenderGiardiaCow(new ModelGiardiaCow(), 0));
		TileEntitySpecialRenderer renderAutoclave = new RenderAutoclave();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAutoclave.class, renderAutoclave);
		TileEntitySpecialRenderer renderIncubator = new RenderIncubator();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIncubator.class, renderIncubator);
		
	}
	
		
}
