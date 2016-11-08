package epidemiccraft.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import epidemiccraft.com.EpidemicCraft;
import epidemiccraft.lib.Constants;

public class ModEntities {
	
	public static void preInit(){
				
		EntityRegistry.registerGlobalEntityID(EntityFluBirdMob.class, "EntityFluBird", EntityRegistry.findGlobalUniqueEntityId(), 0xBF8040, 0x660000);
		EntityRegistry.addSpawn(EntityFluBirdMob.class, 15, 4, 5, EnumCreatureType.monster, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.jungle);

		EntityRegistry.registerGlobalEntityID(EntityCPoxVillagerMob.class, "EntityCPoxVillager", EntityRegistry.findGlobalUniqueEntityId(), 0x604020, 0x660000);
		EntityRegistry.addSpawn(EntityCPoxVillagerMob.class, 15, 4, 5, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.desert);

		EntityRegistry.registerGlobalEntityID(EntityPolioVillagerMob.class, "EntityPolioVillager", EntityRegistry.findGlobalUniqueEntityId(), 0x392613, 0x660000);
		EntityRegistry.addSpawn(EntityPolioVillagerMob.class, 15, 4, 5, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.desert);

		EntityRegistry.registerGlobalEntityID(EntityRabiesWolfMob.class, "EntityRabiesWolf", EntityRegistry.findGlobalUniqueEntityId(), 0xCCCCCC, 0x660000);
		EntityRegistry.addSpawn(EntityRabiesWolfMob.class, 15, 4, 5, EnumCreatureType.monster, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaiga);

		EntityRegistry.registerGlobalEntityID(EntityEColiChickenMob.class, "EntityEColiChicken", EntityRegistry.findGlobalUniqueEntityId(), 0x737373, 0x660000);
		EntityRegistry.addSpawn(EntityEColiChickenMob.class, 15, 4, 5, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.desert);

		EntityRegistry.registerGlobalEntityID(EntityGiardiaCowMob.class, "EntityGiardiaCow", EntityRegistry.findGlobalUniqueEntityId(), 0x3D1F00, 0x660000);
		EntityRegistry.addSpawn(EntityGiardiaCowMob.class, 15, 4, 5, EnumCreatureType.monster, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forest, BiomeGenBase.savanna, BiomeGenBase.extremeHillsEdge);

	}
	
}
