package epidemiccraft.blocks;

import org.lwjgl.opengl.GL11;

import epidemiccraft.lib.Constants;
import epidemiccraft.tileentity.TileEntityAutoclave;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderAutoclave extends TileEntitySpecialRenderer{

	ResourceLocation texture = new ResourceLocation(Constants.MODID + ":" + "textures/blocks/Autoclave.png");
	
	private ModelAutoclave model;
	
	public RenderAutoclave(){
		this.model = new ModelAutoclave();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		GL11.glPushMatrix();
		GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
		GL11.glPopMatrix();
		}
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f) {
		
		GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			TileEntityAutoclave myTile = (TileEntityAutoclave)entity;
			int direction = myTile.direction;
			GL11.glRotatef(direction * 90, 0.0F, 1.0F, 0.0F);
			this.bindTexture(texture);
			GL11.glPushMatrix();
				this.model.renderModel(0.0625F);
			GL11.glPopMatrix();			
		GL11.glPopMatrix();
	}

}
