package epidemiccraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import epidemiccraft.inventory.ContainerAutoclave;
import epidemiccraft.inventory.ContainerIncubator;
import epidemiccraft.lib.Constants;
import epidemiccraft.tileentity.TileEntityAutoclave;
import epidemiccraft.tileentity.TileEntityIncubator;

public class EpidemicCraftGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == 0){
			TileEntityAutoclave tileEntityAutoclave = (TileEntityAutoclave) world.getTileEntity(x, y, z);
			return new ContainerAutoclave(player.inventory, tileEntityAutoclave);
		}
		else if(ID == 1){
			TileEntityIncubator tileEntityIncubator = (TileEntityIncubator) world.getTileEntity(x, y, z);
			return new ContainerIncubator(player.inventory, tileEntityIncubator);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == 0){
			TileEntityAutoclave tileEntityAutoclave = (TileEntityAutoclave) world.getTileEntity(x, y, z);
			return new GuiAutoclave(player.inventory, tileEntityAutoclave);
		}
		else if(ID == 1){
			TileEntityIncubator tileEntityIncubator = (TileEntityIncubator) world.getTileEntity(x, y, z);
			return new GuiIncubator(player.inventory, tileEntityIncubator);
		}
		return null;
	}

}
