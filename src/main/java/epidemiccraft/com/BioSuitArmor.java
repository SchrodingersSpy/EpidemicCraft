package epidemiccraft.com;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BioSuitArmor extends ItemArmor{
	private String [] armourTypes = new String [] {"helmetBioSuit", "chestplateBioSuit", "legBioSuit", "bootsBioSuit"};

	public BioSuitArmor(ArmorMaterial armorMaterial, int renderIndex, int armourType){
		super(armorMaterial, renderIndex, armourType);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		super.onArmorTick(world, player, itemStack);
		ItemStack boots = player.inventory.armorInventory[0];
		ItemStack pants = player.inventory.armorInventory[1];
		ItemStack chest = player.inventory.armorInventory[2];
		ItemStack head = player.inventory.armorInventory[3];

		if(boots != null && pants != null && chest != null && head != null)
			if(boots.getItem() == EpidemicCraft.bootsBioSuit && pants.getItem() == EpidemicCraft.legsBioSuit && chest.getItem() == EpidemicCraft.chestplateBioSuit && head.getItem() == EpidemicCraft.helmetBioSuit)
				player.addPotionEffect(new PotionEffect(EpidemicCraft.potionBiosuit.id, 5, 0));
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer){
		if(stack.getItem().equals(EpidemicCraft.helmetBioSuit)|| stack.getItem().equals(EpidemicCraft.chestplateBioSuit)|| stack.getItem().equals(EpidemicCraft.bootsBioSuit)){
			return "EpidemicCraft:textures/armor/BioSuitTexture1.png";
		}
		if(stack.getItem().equals(EpidemicCraft.legsBioSuit)){
			return "EpidemicCraft:textures/armor/BioSuitTexture2.png";
		}
		else return null;
	}
	
	@Override
	public void registerIcons(IIconRegister reg){
		if(this == EpidemicCraft.helmetBioSuit)
			this.itemIcon = reg.registerIcon("EpidemicCraft:helmetBioSuit");
		if(this == EpidemicCraft.chestplateBioSuit)
			this.itemIcon = reg.registerIcon("EpidemicCraft:chestplateBioSuit");
		if(this == EpidemicCraft.legsBioSuit)
			this.itemIcon = reg.registerIcon("EpidemicCraft:legsBioSuit");
		if(this == EpidemicCraft.bootsBioSuit)
			this.itemIcon = reg.registerIcon("EpidemicCraft:bootsBioSuit");
	}
	
}
