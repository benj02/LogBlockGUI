// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, ItemStack, ItemArmor, Item, 
//            Block, ContainerPlayer, IInventory

class SlotArmor extends Slot
{

    final int field_1124_c; /* synthetic field */
    final ContainerPlayer field_1123_d; /* synthetic field */

    SlotArmor(ContainerPlayer containerplayer, IInventory iinventory, int i, int j, int k, int l)
    {
        field_1123_d = containerplayer;
        field_1124_c = l;
        super(iinventory, i, j, k);
    }

    public int func_4104_e()
    {
        return 1;
    }

    public boolean func_4105_a(ItemStack itemstack)
    {
        if(itemstack.func_1091_a() instanceof ItemArmor)
        {
            return ((ItemArmor)itemstack.func_1091_a()).field_313_aX == field_1124_c;
        }
        if(itemstack.func_1091_a().field_291_aS == Block.field_4055_bb.field_376_bc)
        {
            return field_1124_c == 0;
        } else
        {
            return false;
        }
    }
}
