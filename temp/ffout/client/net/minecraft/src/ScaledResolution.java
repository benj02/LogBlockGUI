// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GameSettings

public class ScaledResolution
{

    private int field_1367_b;
    private int field_1369_c;
    public double field_25121_a;
    public double field_25120_b;
    public int field_1368_a;

    public ScaledResolution(GameSettings gamesettings, int i, int j)
    {
        field_1367_b = i;
        field_1369_c = j;
        field_1368_a = 1;
        int k = gamesettings.field_25148_H;
        if(k == 0)
        {
            k = 1000;
        }
        for(; field_1368_a < k && field_1367_b / (field_1368_a + 1) >= 320 && field_1369_c / (field_1368_a + 1) >= 240; field_1368_a++) { }
        field_25121_a = (double)field_1367_b / (double)field_1368_a;
        field_25120_b = (double)field_1369_c / (double)field_1368_a;
        field_1367_b = (int)Math.ceil(field_25121_a);
        field_1369_c = (int)Math.ceil(field_25120_b);
    }

    public int func_903_a()
    {
        return field_1367_b;
    }

    public int func_902_b()
    {
        return field_1369_c;
    }
}
