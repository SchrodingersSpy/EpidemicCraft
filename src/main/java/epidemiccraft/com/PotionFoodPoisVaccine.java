package epidemiccraft.com;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class PotionFoodPoisVaccine extends Potion {

public PotionFoodPoisVaccine(int par1, boolean par2, int par3) {
super(par1, par2, par3);
}

private static final ResourceLocation FoodPoisVaccineImage = new ResourceLocation("epidemiccraft","textures/gui/inventory.png");

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasStatusIcon(){
		
		Minecraft.getMinecraft().renderEngine.bindTexture(FoodPoisVaccineImage);
		return true;
	}


public Potion setIconIndex(int par1, int par2) {
	
	super.setIconIndex(par1, par2);
	return this;
	}

}