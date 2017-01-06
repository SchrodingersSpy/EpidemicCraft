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
import net.minecraft.entity.passive.EntityCow;
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


public class EntityFluBirdMob extends EntityMob{


	private int conversionTime;

	//What are his priorities?
	public EntityFluBirdMob(World par1World) {
		super(par1World);
		
			this.setSize(0.9F, 1.3F);
			this.tasks.addTask(0, new EntityAIWander(this, 0.25));
			this.tasks.addTask(1, new EntityAIPanic(this, 0.25));
			this.tasks.addTask(2, new EntityAISwimming(this));
			this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		
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
            this.dropItem(Items.feather, 1);
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
                this.dropItem(ModItems.TissueFlu, 1);
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
	public void setCow(boolean p_82229_1_)
    {
        this.getDataWatcher().updateObject(13, Byte.valueOf((byte)(p_82229_1_ ? 1 : 0)));
    }
	
	//When you get attacked by the FluCow, this is activated.
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
                
                if (((EntityLivingBase)p_70652_1_).isPotionActive(EpidemicCraft.potionFluVaccine))
                {	
                	return false;
                }
               
                
                else
                {
                	((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, b0 * 1200, 0));
                    ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.confusion.id, b0 * 1200, 0));
                    ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, b0 * 1200, 0));
                    ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(EpidemicCraft.potionFlu.id, b0 * 1200, 0));
                    
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
	
	//What does the cow say while idling?
	protected String getLivingSound()
    {
        return "mob.bat.hurt";
    }

	//What does the cow say while in pain?
	protected String getHurtSound()
    {
        return "mob.bat.hurt";
    }
	
	//What does the cow say when he dies?
	protected String getDeathSound()
    {
        return "mob.bat.hurt";
    }
	
	
}