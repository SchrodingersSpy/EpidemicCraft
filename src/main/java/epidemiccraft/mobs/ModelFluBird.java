
package epidemiccraft.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFluBird extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Head;
    ModelRenderer Wing1;
    ModelRenderer Wing2;
    ModelRenderer Beak;
    ModelRenderer TailL;
    ModelRenderer TailMid;
    ModelRenderer TailR;
  
  public ModelFluBird()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, 0F, 0F, 5, 8, 4);
      Body.setRotationPoint(-3F, 15F, -6F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0.5576792F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 18, 8);
      Leg1.addBox(0F, 0F, 0F, 1, 3, 1);
      Leg1.setRotationPoint(0F, 21F, -2F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, -0.2602503F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 22, 8);
      Leg2.addBox(0F, 0F, 0F, 1, 3, 1);
      Leg2.setRotationPoint(-2F, 21F, -2F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, -0.2602503F, 0F, 0F);
      Head = new ModelRenderer(this, 18, 0);
      Head.addBox(0F, 0F, 0F, 4, 4, 4);
      Head.setRotationPoint(-2.5F, 10.5F, -7F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Wing1 = new ModelRenderer(this, 0, 12);
      Wing1.addBox(0F, 0F, 0F, 1, 6, 3);
      Wing1.setRotationPoint(-4F, 15F, -5F);
      Wing1.setTextureSize(64, 32);
      Wing1.mirror = true;
      setRotation(Wing1, 0.3346075F, 0F, 0F);
      Wing2 = new ModelRenderer(this, 8, 12);
      Wing2.addBox(0F, 0F, 0F, 1, 6, 3);
      Wing2.setRotationPoint(2F, 15F, -5F);
      Wing2.setTextureSize(64, 32);
      Wing2.mirror = true;
      setRotation(Wing2, 0.3346075F, 0F, 0F);
      Beak = new ModelRenderer(this, 16, 12);
      Beak.addBox(0F, 0F, 0F, 2, 1, 3);
      Beak.setRotationPoint(-1.5F, 12.5F, -8.5F);
      Beak.setTextureSize(64, 32);
      Beak.mirror = true;
      setRotation(Beak, 0F, 0F, 0F);
      TailL = new ModelRenderer(this, 14, 16);
      TailL.addBox(0F, 0F, 0F, 1, 1, 4);
      TailL.setRotationPoint(0F, 19F, 1.5F);
      TailL.setTextureSize(64, 32);
      TailL.mirror = true;
      setRotation(TailL, -0.37179F, 0F, 0F);
      TailMid = new ModelRenderer(this, 14, 16);
      TailMid.addBox(0F, 0F, 0F, 1, 1, 4);
      TailMid.setRotationPoint(-2F, 19F, 1.5F);
      TailMid.setTextureSize(64, 32);
      TailMid.mirror = true;
      setRotation(TailMid, -0.37179F, 0F, 0F);
      TailR = new ModelRenderer(this, -1, 15);
      TailR.addBox(0F, 0F, 0F, 1, 1, 5);
      TailR.setRotationPoint(-1F, 19F, 1.5F);
      TailR.setTextureSize(64, 32);
      TailR.mirror = true;
      setRotation(TailR, -0.3717861F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Head.render(f5);
    Wing1.render(f5);
    Wing2.render(f5);
    Beak.render(f5);
    TailL.render(f5);
    TailMid.render(f5);
    TailR.render(f5);
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
    float f6 = (180F / (float)Math.PI);
	this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;

  }

}
