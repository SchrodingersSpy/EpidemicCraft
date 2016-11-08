package epidemiccraft.mobs;

import epidemiccraft.lib.Constants;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCPoxVillager extends RenderLiving{

	private static final ResourceLocation mobTextures = new ResourceLocation(Constants.MODID + ":textures/mobs/CPoxVillagerModel.png");
	
	public RenderCPoxVillager(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
			
	}

	protected ResourceLocation getEntityTexture(EntityCPoxVillagerMob entity){
		return mobTextures;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((EntityCPoxVillagerMob)entity);
	}
	
}

