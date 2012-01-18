// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, TextureOffset, ModelBox, GLAllocation, 
//            Tessellator

public class ModelRenderer
{

    public float field_35971_a;
    public float field_35970_b;
    private int field_1399_l;
    private int field_1398_m;
    public float field_1410_a;
    public float field_1409_b;
    public float field_1408_c;
    public float field_1407_d;
    public float field_1406_e;
    public float field_1405_f;
    private boolean field_1397_n;
    private int field_1396_o;
    public boolean field_1404_g;
    public boolean field_1403_h;
    public boolean field_1402_i;
    public List field_40606_l;
    public List field_40607_m;
    public final String field_40605_n;
    private ModelBase field_40608_s;

    public ModelRenderer(ModelBase modelbase, String s)
    {
        field_35971_a = 64F;
        field_35970_b = 32F;
        field_1397_n = false;
        field_1396_o = 0;
        field_1404_g = false;
        field_1403_h = true;
        field_1402_i = false;
        field_40606_l = new ArrayList();
        field_40608_s = modelbase;
        modelbase.field_35394_j.add(this);
        field_40605_n = s;
        func_35968_a(modelbase.field_40299_l, modelbase.field_40300_m);
    }

    public ModelRenderer(ModelBase modelbase)
    {
        this(modelbase, null);
    }

    public ModelRenderer(ModelBase modelbase, int i, int j)
    {
        this(modelbase);
        func_40602_a(i, j);
    }

    public void func_35969_a(ModelRenderer modelrenderer)
    {
        if(field_40607_m == null)
        {
            field_40607_m = new ArrayList();
        }
        field_40607_m.add(modelrenderer);
    }

    public ModelRenderer func_40602_a(int i, int j)
    {
        field_1399_l = i;
        field_1398_m = j;
        return this;
    }

    public ModelRenderer func_40603_a(String s, float f, float f1, float f2, int i, int j, int k)
    {
        s = (new StringBuilder()).append(field_40605_n).append(".").append(s).toString();
        TextureOffset textureoffset = field_40608_s.func_40297_a(s);
        func_40602_a(textureoffset.field_40734_a, textureoffset.field_40733_b);
        field_40606_l.add((new ModelBox(this, field_1399_l, field_1398_m, f, f1, f2, i, j, k, 0.0F)).func_40671_a(s));
        return this;
    }

    public ModelRenderer func_40604_a(float f, float f1, float f2, int i, int j, int k)
    {
        field_40606_l.add(new ModelBox(this, field_1399_l, field_1398_m, f, f1, f2, i, j, k, 0.0F));
        return this;
    }

    public void func_923_a(float f, float f1, float f2, int i, int j, int k, float f3)
    {
        field_40606_l.add(new ModelBox(this, field_1399_l, field_1398_m, f, f1, f2, i, j, k, f3));
    }

    public void func_925_a(float f, float f1, float f2)
    {
        field_1410_a = f;
        field_1409_b = f1;
        field_1408_c = f2;
    }

    public void func_922_a(float f)
    {
        if(field_1402_i)
        {
            return;
        }
        if(!field_1403_h)
        {
            return;
        }
        if(!field_1397_n)
        {
            func_924_c(f);
        }
        if(field_1407_d != 0.0F || field_1406_e != 0.0F || field_1405_f != 0.0F)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(field_1410_a * f, field_1409_b * f, field_1408_c * f);
            if(field_1405_f != 0.0F)
            {
                GL11.glRotatef(field_1405_f * 57.29578F, 0.0F, 0.0F, 1.0F);
            }
            if(field_1406_e != 0.0F)
            {
                GL11.glRotatef(field_1406_e * 57.29578F, 0.0F, 1.0F, 0.0F);
            }
            if(field_1407_d != 0.0F)
            {
                GL11.glRotatef(field_1407_d * 57.29578F, 1.0F, 0.0F, 0.0F);
            }
            GL11.glCallList(field_1396_o);
            if(field_40607_m != null)
            {
                for(int i = 0; i < field_40607_m.size(); i++)
                {
                    ((ModelRenderer)field_40607_m.get(i)).func_922_a(f);
                }

            }
            GL11.glPopMatrix();
        } else
        if(field_1410_a != 0.0F || field_1409_b != 0.0F || field_1408_c != 0.0F)
        {
            GL11.glTranslatef(field_1410_a * f, field_1409_b * f, field_1408_c * f);
            GL11.glCallList(field_1396_o);
            if(field_40607_m != null)
            {
                for(int j = 0; j < field_40607_m.size(); j++)
                {
                    ((ModelRenderer)field_40607_m.get(j)).func_922_a(f);
                }

            }
            GL11.glTranslatef(-field_1410_a * f, -field_1409_b * f, -field_1408_c * f);
        } else
        {
            GL11.glCallList(field_1396_o);
            if(field_40607_m != null)
            {
                for(int k = 0; k < field_40607_m.size(); k++)
                {
                    ((ModelRenderer)field_40607_m.get(k)).func_922_a(f);
                }

            }
        }
    }

    public void func_25122_b(float f)
    {
        if(field_1402_i)
        {
            return;
        }
        if(!field_1403_h)
        {
            return;
        }
        if(!field_1397_n)
        {
            func_924_c(f);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(field_1410_a * f, field_1409_b * f, field_1408_c * f);
        if(field_1406_e != 0.0F)
        {
            GL11.glRotatef(field_1406_e * 57.29578F, 0.0F, 1.0F, 0.0F);
        }
        if(field_1407_d != 0.0F)
        {
            GL11.glRotatef(field_1407_d * 57.29578F, 1.0F, 0.0F, 0.0F);
        }
        if(field_1405_f != 0.0F)
        {
            GL11.glRotatef(field_1405_f * 57.29578F, 0.0F, 0.0F, 1.0F);
        }
        GL11.glCallList(field_1396_o);
        GL11.glPopMatrix();
    }

    public void func_926_b(float f)
    {
        if(field_1402_i)
        {
            return;
        }
        if(!field_1403_h)
        {
            return;
        }
        if(!field_1397_n)
        {
            func_924_c(f);
        }
        if(field_1407_d != 0.0F || field_1406_e != 0.0F || field_1405_f != 0.0F)
        {
            GL11.glTranslatef(field_1410_a * f, field_1409_b * f, field_1408_c * f);
            if(field_1405_f != 0.0F)
            {
                GL11.glRotatef(field_1405_f * 57.29578F, 0.0F, 0.0F, 1.0F);
            }
            if(field_1406_e != 0.0F)
            {
                GL11.glRotatef(field_1406_e * 57.29578F, 0.0F, 1.0F, 0.0F);
            }
            if(field_1407_d != 0.0F)
            {
                GL11.glRotatef(field_1407_d * 57.29578F, 1.0F, 0.0F, 0.0F);
            }
        } else
        if(field_1410_a != 0.0F || field_1409_b != 0.0F || field_1408_c != 0.0F)
        {
            GL11.glTranslatef(field_1410_a * f, field_1409_b * f, field_1408_c * f);
        }
    }

    private void func_924_c(float f)
    {
        field_1396_o = GLAllocation.func_1124_a(1);
        GL11.glNewList(field_1396_o, 4864);
        Tessellator tessellator = Tessellator.field_1512_a;
        for(int i = 0; i < field_40606_l.size(); i++)
        {
            ((ModelBox)field_40606_l.get(i)).func_40670_a(tessellator, f);
        }

        GL11.glEndList();
        field_1397_n = true;
    }

    public ModelRenderer func_35968_a(int i, int j)
    {
        field_35971_a = i;
        field_35970_b = j;
        return this;
    }
}
