
package epidemiccraft.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIncubator extends ModelBase
{
  //fields
    ModelRenderer Cube;
  
  public ModelIncubator()
  {
    textureWidth = 65;
    textureHeight = 34;
    
      Cube = new ModelRenderer(this, 0, 0);
      Cube.addBox(0F, 0F, 0F, 16, 16, 16);
      Cube.setRotationPoint(-8F, 8F, -8F);
      Cube.setTextureSize(65, 34);
      Cube.mirror = true;
      setRotation(Cube, 0F, 0F, 0F);
  }
  
  public void renderModel(float f5)
  {
    Cube.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
