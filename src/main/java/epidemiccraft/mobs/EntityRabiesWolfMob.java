package epidemiccraft.mobs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import epidemiccraft.com.EpidemicCraft;
import epidemiccraft.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;


public class EntityRabiesWolfMob extends EntityMob{


	private int conversionTime;

	//What are his priorities?
	public EntityRabiesWolfMob(World par1World) {
		super(par1World);
		
			this.setSize(0.9F, 1.3F);
			this.tasks.addTask(0, new EntityAIWander(this, 0.25));
			this.tasks.addTask(1, new EntityAIPanic(this, 0.25));
			this.tasks.addTask(2, new EntityAISwimming(this));
			this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
			this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityWolf.class, 1.0D, false));
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWolf.class, 0, true));
		
	}
	
	//Can he update to newer AIs?
	public boolean isAIEnabled(){
		return true;
	}
	
	//Basic entity attributes like health and speed.
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(9.5D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25F);
	}
	
	//What does it drop?
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);
        int k;

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Items.bone, 1);
        }

        j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);

        for (k = 0; k < j; ++k)
        {
            if (this.isBurning())
            {
                this.dropItem(Items.rotten_flesh, 1);
            }
            else
            {
                this.dropItem(ModItems.TissueRabies, 1);
            }
        }
    }
	
	//This adds Objects to the DataWatcher.
	@Override
	protected void entityInit() {
	super.entityInit();
	this.dataWatcher.addObject(13, Byte.valueOf((byte)0));
	this.dataWatcher.addObject(14, Byte.valueOf((byte)0));
	}
	
	//I don't know what this does, but don't delete it.
	public void setWolf(boolean p_82229_1_)
    {
        this.getDataWatcher().updateObject(13, Byte.valueOf((byte)(p_82229_1_ ? 1 : 0)));
    }
	
	//When an RabiesWolf kills a Wolf, this is activated.
	public void onKillEntity(EntityLivingBase p_70074_1_)
    {
        super.onKillEntity(p_70074_1_);

        if ((this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD) && p_70074_1_ instanceof EntityWolf)
        {
            if (this.worldObj.difficultySetting != EnumDifficulty.HARD && this.rand.nextBoolean())
            {
                return;
            }

            EntityRabiesWolfMob entityRabiesWolf = new EntityRabiesWolfMob(this.worldObj);
            entityRabiesWolf.copyLocationAndAnglesFrom(p_70074_1_);
            this.worldObj.removeEntity(p_70074_1_);
            entityRabiesWolf.onSpawnWithEgg((IEntityLivingData)null);
            entityRabiesWolf.setWolf(true);

            this.worldObj.spawnEntityInWorld(entityRabiesWolf);
        }
    }
	
	//When you get attacked by the RabiesWolf, this is activated.
	public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        if (super.attackEntityAsMob(p_70652_1_))
        {
            if (p_70652_1_ instanceof EntityLivingBase)
            {
                byte b0 = 0;
                
                if (this.worldObj.difficultySetting == EnumDifficulty.EASY)
                {
                    b0 = 10;
                }
                if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
                {
                    b0 = 20;
                }
                else if (this.worldObj.difficultySetting == EnumDifficulty.HARD)
                {
                    b0 = 30;
                }

                if (((EntityLivingBase)p_70652_1_).isPotionActive(EpidemicCraft.potionBiosuit))
                {	
                	return false;
                }
                
                if (((EntityLivingBase)p_70652_1_).isPotionActive(EpidemicCraft.potionRabiesVaccine))
                {	
                	return false;
                }
                
                else
                {
                	((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.blindness.id, b0 * 1200, 0));
                    ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.confusion.id, b0 * 1200, 0));
                    ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.damageBoost.id, b0 * 1200, 0));
                    ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, b0 * 1200, 0));
                    ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(EpidemicCraft.potionRabies.id, b0 * 1200, 0));

                    if (((EntityLivingBase)p_70652_1_).getRNG().nextInt(10) > 8)
                	{
                    	
                    	if (((EntityLivingBase)p_70652_1_).isPotionActive(EpidemicCraft.potionMeningitisVaccine))
                        {	
                        	return false;
                        }
                    	
                    	((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(EpidemicCraft.potionMeningitis.id, b0 * 1200, 0));
                    	((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.poison.id, b0 * 1200, 0));
                    	((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.hunger.id, b0 * 1200, 0));
                	}
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }
	
	//Start converting the RabiesWolf into a normal Wolf.
    protected void startConversion(int p_82228_1_)
    {
        this.conversionTime = p_82228_1_;
        this.getDataWatcher().updateObject(14, Byte.valueOf((byte)1));
        this.worldObj.setEntityState(this, (byte)16);
    }

    //What happens when you stick the Wolf with a Syringe?
    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_)
    {
        if (p_70103_1_ == 16)
        {
            this.worldObj.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "mob.wolf.hurt", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
        }
        else
        {
            super.handleHealthUpdate(p_70103_1_);
        }
    }
    
	//What happens when you right click the Wolf with a syringe?
	public boolean interact(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.getCurrentEquippedItem();

        if (itemstack != null && itemstack.getItem() == ModItems.SyringeRabies && itemstack.getItemDamage() == 0)
        {
            if (!p_70085_1_.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }

            if (itemstack.stackSize <= 0)
            {
                p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
            }

            if (!this.worldObj.isRemote)
            {
                this.startConversion(20);

            }

            return true;
        }
        else
        {
            return false;
        }
    }
	
	//Is the Wolf Converting?
	public boolean isConverting()
    {
        return this.getDataWatcher().getWatchableObjectByte(14) == 1;
    }
	
	//How much time do we shorten conversion by?
	protected int getConversionTimeBoost()
    {
        int i = 1;

        if (this.rand.nextFloat() < 0.01F)
        {
            int j = 0;

            for (int k = (int)this.posX - 4; k < (int)this.posX + 4 && j < 14; ++k)
            {
                for (int l = (int)this.posY - 4; l < (int)this.posY + 4 && j < 14; ++l)
                {
                    for (int i1 = (int)this.posZ - 4; i1 < (int)this.posZ + 4 && j < 14; ++i1)
                    {
                        Block block = this.worldObj.getBlock(k, l, i1);

                        if (block == Blocks.iron_bars || block == Blocks.bed)
                        {
                            if (this.rand.nextFloat() < 0.3F)
                            {
                                ++i;
                            }

                            ++j;
                        }
                    }
                }
            }
        }

        return i;
    }
	
	//What happens to the Wolf's AI when the RabiesWolf finishes converting?
	protected void convertToWolf()
    {
        EntityWolf entityWolf = new EntityWolf(this.worldObj);
        entityWolf.copyLocationAndAnglesFrom(this);
        entityWolf.onSpawnWithEgg((IEntityLivingData)null);

        this.worldObj.removeEntity(this);
        this.worldObj.spawnEntityInWorld(entityWolf);
        entityWolf.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0));
    }
	
	//If we run this, the RabiesWolf turns into a Wolf.
	public void onUpdate()

	
	    {
	        if (!this.worldObj.isRemote && this.isConverting())
	        {
	            int i = this.getConversionTimeBoost();
	            this.conversionTime -= i;

	            if (this.conversionTime <= 0)
	            {
	                this.convertToWolf();
	            }
	        }

	        super.onUpdate();
	    }

	//What does the Wolf say while idling?
	protected String getLivingSound()
    {
        return "mob.wolf.hurt";
    }

	//What does the Wolf say while in pain?
	protected String getHurtSound()
    {
        return "mob.wolf.hurt";
    }
	
	//What does the Wolf say when he dies?
	protected String getDeathSound()
    {
        return "mob.wolf.hurt";
    }
	
	
}