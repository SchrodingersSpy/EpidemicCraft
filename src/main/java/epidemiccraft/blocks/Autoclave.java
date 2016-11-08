package epidemiccraft.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import epidemiccraft.lib.Constants;
import epidemiccraft.tileentity.TileEntityAutoclave;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Autoclave extends BlockContainer {
	
	private static boolean isBurning;
	private final boolean isBurning2;
	private final Random random = new Random();
	
	public int getRenderType(){
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	protected Autoclave(boolean isActive) {
		super(Material.iron);
		isBurning2 = isActive;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		player.openGui(Constants.MODID, 0, world, x, y, z);
		return true;
	}
	
	public Item getItemDropped(int par1, Random random, int par3){
		return Item.getItemFromBlock(ModBlocks.Autoclave);
	}
	
	public Item getItem(World world, int par2, int par3, int par4){
		return Item.getItemFromBlock(ModBlocks.Autoclave);
	}

	public static void updateBlockState(boolean bool, World world, int x, int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z);

		TileEntity tileentity = world.getTileEntity(x, y, z);
		isBurning = true;

		if (bool)
		{
			world.setBlock(x, y, z, ModBlocks.AutoclaveActive);
		}
		else
		{
			world.setBlock(x, y, z, ModBlocks.Autoclave);
		}

		isBurning = false;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);

		if (tileentity != null)
		{
			tileentity.validate();
			world.setTileEntity(x, y, z, (TileEntityAutoclave) tileentity);
  		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block block, int meta){
		if(!isBurning){
			TileEntityAutoclave tileentityautoclave = (TileEntityAutoclave) world.getTileEntity(x, y, z);
			if(tileentityautoclave != null){
				for(int i = 0; i < tileentityautoclave.getSizeInventory(); ++i){
					ItemStack itemstack = tileentityautoclave.getStackInSlot(i);
					
					if(itemstack != null){
						float f = this.random.nextFloat() * 0.6F * 0.1F;
						float f1 = this.random.nextFloat() * 0.6F * 0.1F;
						float f2 = this.random.nextFloat() * 0.6F * 0.1F;
						
						while(itemstack.stackSize > 0){
							int j = this.random.nextInt(21) + 10;
							
							if(j > itemstack.stackSize){
								j = itemstack.stackSize;
							}
							
							itemstack.stackSize -= j;
							EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float)z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));		
							
							if(itemstack.hasTagCompound()){
								entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}
							
							float f3 = 0.025F;
							entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
							entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
							world.spawnEntityInWorld(entityitem);
						}	
					}
				}
				world.func_147453_f(x, y, z, block);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random){
		if(this.isBurning2){
			world.spawnParticle("explode", x, y+0.5, z, 0.0F, 0.0F, 0.0F);
			world.spawnParticle("explode", x, y+0.5, z+1, 0.0F, 0.0F, 0.0F);
			world.spawnParticle("explode", x+1, y+0.5, z, 0.0F, 0.0F, 0.0F);
			world.spawnParticle("explode", x+1, y+0.5, z+1, 0.0F, 0.0F, 0.0F);
			

			}
		}
	
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack){
		int l = MathHelper.floor_double((double) (entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if (l == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if (l == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if (l == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}
	
	private void func_149930_e(World world, int x, int y, int z){
		if (!world.isRemote){
			Block block = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);
			byte b0 = 3;

		if (block.func_149730_j() && !block1.func_149730_j()){
			b0 = 3;
		}

		if (block1.func_149730_j() && !block.func_149730_j()){
			b0 = 2;
		}

		if (block2.func_149730_j() && !block3.func_149730_j()){
			b0 = 5;
		}

		if (block3.func_149730_j() && !block2.func_149730_j()){
			b0 = 4;
		}

		world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityAutoclave();
	}
	
	
	
}



