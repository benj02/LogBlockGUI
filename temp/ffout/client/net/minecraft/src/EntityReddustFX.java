// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, World, Tessellator

public class EntityReddustFX extends EntityFX
{

    float field_673_a;

    public EntityReddustFX(World world, double d, double d1, double d2, 
            float f, float f1, float f2)
    {
        this(world, d, d1, d2, 1.0F, f, f1, f2);
    }

    public EntityReddustFX(World world, double d, double d1, double d2, 
            float f, float f1, float f2, float f3)
    {
        super(world, d, d1, d2, 0.0D, 0.0D, 0.0D);
        field_608_an *= 0.10000000149011612D;
        field_607_ao *= 0.10000000149011612D;
        field_606_ap *= 0.10000000149011612D;
        if(f1 == 0.0F)
        {
            f1 = 1.0F;
        }
        float f4 = (float)Math.random() * 0.4F + 0.6F;
        field_663_i = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * f1 * f4;
        field_662_j = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * f2 * f4;
        field_661_k = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * f3 * f4;
        field_665_g *= 0.75F;
        field_665_g *= f;
        field_673_a = field_665_g;
        field_666_f = (int)(8D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
        field_666_f *= f;
        field_9314_ba = false;
    }

    public void func_406_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = (((float)field_20923_e + f) / (float)field_666_f) * 32F;
        if(f6 < 0.0F)
        {
            f6 = 0.0F;
        }
        if(f6 > 1.0F)
        {
            f6 = 1.0F;
        }
        field_665_g = field_673_a * f6;
        super.func_406_a(tessellator, f, f1, f2, f3, f4, f5);
    }

    public void func_370_e_()
    {
        field_9285_at = field_611_ak;
        field_9284_au = field_610_al;
        field_9283_av = field_609_am;
        if(field_20923_e++ >= field_666_f)
        {
            func_395_F();
        }
        func_40099_c(7 - (field_20923_e * 8) / field_666_f);
        func_349_c(field_608_an, field_607_ao, field_606_ap);
        if(field_610_al == field_9284_au)
        {
            field_608_an *= 1.1000000000000001D;
            field_606_ap *= 1.1000000000000001D;
        }
        field_608_an *= 0.95999997854232788D;
        field_607_ao *= 0.95999997854232788D;
        field_606_ap *= 0.95999997854232788D;
        if(field_9298_aH)
        {
            field_608_an *= 0.69999998807907104D;
            field_606_ap *= 0.69999998807907104D;
        }
    }
}
