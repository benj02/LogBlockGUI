// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeCrossing extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeCrossing(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        func_40022_a((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 2, 0, false);
        func_40019_b((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 0, 2, false);
        func_40016_c((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 0, 2, false);
    }

    public static ComponentNetherBridgeCrossing func_40028_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -2, 0, 0, 7, 9, 7, l);
        if(!func_40021_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeCrossing(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        func_35011_a(world, structureboundingbox, 0, 0, 0, 6, 1, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 2, 0, 6, 7, 6, 0, 0, false);
        func_35011_a(world, structureboundingbox, 0, 2, 0, 1, 6, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 2, 6, 1, 6, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 5, 2, 0, 6, 6, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 5, 2, 6, 6, 6, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 2, 0, 0, 6, 1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 2, 5, 0, 6, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 2, 0, 6, 6, 1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 2, 5, 6, 6, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 6, 0, 4, 6, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 5, 0, 4, 5, 0, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 6, 6, 4, 6, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 5, 6, 4, 5, 6, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 6, 2, 0, 6, 4, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 5, 2, 0, 5, 4, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 6, 2, 6, 6, 4, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 5, 2, 6, 5, 4, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        for(int i = 0; i <= 6; i++)
        {
            for(int j = 0; j <= 6; j++)
            {
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, i, -1, j, structureboundingbox);
            }

        }

        return true;
    }
}
