package epidemiccraft.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import epidemiccraft.inventory.ContainerIncubator;
import epidemiccraft.lib.Constants;
import epidemiccraft.tileentity.TileEntityIncubator;

@SideOnly(Side.CLIENT)
public class GuiIncubator extends GuiContainer{

	private static final ResourceLocation IncubatorGuiTextures = new ResourceLocation(Constants.MODID + ":" + "textures/gui/Autoclave.png");
	private TileEntityIncubator tileIncubator;
	
	public GuiIncubator(InventoryPlayer invPlayer, TileEntityIncubator tile) {
		super(new ContainerIncubator(invPlayer, tile));
		this.tileIncubator = tile;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		String string = this.tileIncubator.hasCustomInventoryName() ? this.tileIncubator.getInventoryName() : I18n.format(this.tileIncubator.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string), 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(IncubatorGuiTextures);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;
		
		if(this.tileIncubator.isBurning()){
			i1 = this.tileIncubator.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
		}
		
		i1 = this.tileIncubator.getCookProgressScaled(24);
				this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	}

}
