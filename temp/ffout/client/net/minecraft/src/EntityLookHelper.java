// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Entity, EntityLiving, AxisAlignedBB, MathHelper

public class EntityLookHelper
{

    private EntityLiving field_46151_a;
    private float field_46149_b;
    private float field_46150_c;
    private boolean field_46147_d;
    private double field_46148_e;
    private double field_46145_f;
    private double field_46146_g;

    public EntityLookHelper(EntityLiving entityliving)
    {
        field_46147_d = false;
        field_46151_a = entityliving;
    }

    public void func_46141_a(Entity entity, float f, float f1)
    {
        field_46148_e = entity.field_611_ak;
        if(entity instanceof EntityLiving)
        {
            field_46145_f = entity.field_610_al + (double)((EntityLiving)entity).func_373_s();
        } else
        {
            field_46145_f = (entity.field_601_au.field_1697_b + entity.field_601_au.field_1702_e) / 2D;
        }
        field_46146_g = entity.field_609_am;
        field_46149_b = f;
        field_46150_c = f1;
        field_46147_d = true;
    }

    public void func_46143_a(double d, double d1, double d2, float f, 
            float f1)
    {
        field_46148_e = d;
        field_46145_f = d1;
        field_46146_g = d2;
        field_46149_b = f;
        field_46150_c = f1;
        field_46147_d = true;
    }

    public void func_46142_a()
    {
        field_46151_a.field_604_ar = 0.0F;
        if(!field_46147_d)
        {
            return;
        } else
        {
            field_46147_d = false;
            double d = field_46148_e - field_46151_a.field_611_ak;
            double d1 = field_46145_f - (field_46151_a.field_610_al + (double)field_46151_a.func_373_s());
            double d2 = field_46146_g - field_46151_a.field_609_am;
            double d3 = MathHelper.func_1109_a(d * d + d2 * d2);
            float f = (float)((Math.atan2(d2, d) * 180D) / 3.1415927410125732D) - 90F;
            float f1 = (float)(-((Math.atan2(d1, d3) * 180D) / 3.1415927410125732D));
            field_46151_a.field_604_ar = func_46144_a(field_46151_a.field_604_ar, f1, field_46150_c);
            field_46151_a.field_605_aq = func_46144_a(field_46151_a.field_605_aq, f, field_46149_b);
            return;
        }
    }

    private float func_46144_a(float f, float f1, float f2)
    {
        float f3;
        for(f3 = f1 - f; f3 < -180F; f3 += 360F) { }
        for(; f3 >= 180F; f3 -= 360F) { }
        if(f3 > f2)
        {
            f3 = f2;
        }
        if(f3 < -f2)
        {
            f3 = -f2;
        }
        return f + f3;
    }
}
