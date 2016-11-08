package epidemiccraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import epidemiccraft.com.EpidemicCraft;
import epidemiccraft.lib.Constants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SpinalTapSyringe extends ItemFood {

private String name = "SpinalTapSyringe";
	
	public SpinalTapSyringe(int heal, float saturation, boolean wolfMeat){
		
		super(heal, saturation, wolfMeat);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(EpidemicCraft.EpidemicCraftTab);
		setContainerItem(ModItems.SpinalTapSyringeUsed);
	}
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.block;
    }
	
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 64;
    }
	
	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
	    {
	        super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
	        return new ItemStack(ModItems.SpinalTapSyringeFull);
	    }

}
