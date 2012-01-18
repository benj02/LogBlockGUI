// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;

// Referenced classes of package net.minecraft.src:
//            ISaveHandler, MinecraftException, WorldProviderHell, ChunkLoader, 
//            WorldProviderEnd, CompressedStreamTools, NBTTagCompound, WorldInfo, 
//            WorldProvider, IChunkLoader

public class SaveHandler
    implements ISaveHandler
{

    private static final Logger field_22156_a = Logger.getLogger("Minecraft");
    private final File field_22155_b;
    private final File field_22158_c;
    private final File field_28114_d;
    private final long field_22157_d = System.currentTimeMillis();
    private final String field_40531_f;

    public SaveHandler(File file, String s, boolean flag)
    {
        field_22155_b = new File(file, s);
        field_22155_b.mkdirs();
        field_22158_c = new File(field_22155_b, "players");
        field_28114_d = new File(field_22155_b, "data");
        field_28114_d.mkdirs();
        field_40531_f = s;
        if(flag)
        {
            field_22158_c.mkdirs();
        }
        func_22154_d();
    }

    private void func_22154_d()
    {
        try
        {
            File file = new File(field_22155_b, "session.lock");
            DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file));
            try
            {
                dataoutputstream.writeLong(field_22157_d);
            }
            finally
            {
                dataoutputstream.close();
            }
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
    }

    protected File func_22153_a()
    {
        return field_22155_b;
    }

    public void func_22150_b()
    {
        try
        {
            File file = new File(field_22155_b, "session.lock");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            try
            {
                if(datainputstream.readLong() != field_22157_d)
                {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            }
            finally
            {
                datainputstream.close();
            }
        }
        catch(IOException ioexception)
        {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }

    public IChunkLoader func_22149_a(WorldProvider worldprovider)
    {
        if(worldprovider instanceof WorldProviderHell)
        {
            File file = new File(field_22155_b, "DIM-1");
            file.mkdirs();
            return new ChunkLoader(file, true);
        }
        if(worldprovider instanceof WorldProviderEnd)
        {
            File file1 = new File(field_22155_b, "DIM1");
            file1.mkdirs();
            return new ChunkLoader(file1, true);
        } else
        {
            return new ChunkLoader(field_22155_b, true);
        }
    }

    public WorldInfo func_22151_c()
    {
        File file = new File(field_22155_b, "level.dat");
        if(file.exists())
        {
            try
            {
                NBTTagCompound nbttagcompound = CompressedStreamTools.func_1138_a(new FileInputStream(file));
                NBTTagCompound nbttagcompound2 = nbttagcompound.func_743_k("Data");
                return new WorldInfo(nbttagcompound2);
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        file = new File(field_22155_b, "level.dat_old");
        if(file.exists())
        {
            try
            {
                NBTTagCompound nbttagcompound1 = CompressedStreamTools.func_1138_a(new FileInputStream(file));
                NBTTagCompound nbttagcompound3 = nbttagcompound1.func_743_k("Data");
                return new WorldInfo(nbttagcompound3);
            }
            catch(Exception exception1)
            {
                exception1.printStackTrace();
            }
        }
        return null;
    }

    public void func_22148_a(WorldInfo worldinfo, List list)
    {
        NBTTagCompound nbttagcompound = worldinfo.func_22305_a(list);
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        nbttagcompound1.func_762_a("Data", nbttagcompound);
        try
        {
            File file = new File(field_22155_b, "level.dat_new");
            File file1 = new File(field_22155_b, "level.dat_old");
            File file2 = new File(field_22155_b, "level.dat");
            CompressedStreamTools.func_1143_a(nbttagcompound1, new FileOutputStream(file));
            if(file1.exists())
            {
                file1.delete();
            }
            file2.renameTo(file1);
            if(file2.exists())
            {
                file2.delete();
            }
            file.renameTo(file2);
            if(file.exists())
            {
                file.delete();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void func_22152_a(WorldInfo worldinfo)
    {
        NBTTagCompound nbttagcompound = worldinfo.func_22299_a();
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        nbttagcompound1.func_762_a("Data", nbttagcompound);
        try
        {
            File file = new File(field_22155_b, "level.dat_new");
            File file1 = new File(field_22155_b, "level.dat_old");
            File file2 = new File(field_22155_b, "level.dat");
            CompressedStreamTools.func_1143_a(nbttagcompound1, new FileOutputStream(file));
            if(file1.exists())
            {
                file1.delete();
            }
            file2.renameTo(file1);
            if(file2.exists())
            {
                file2.delete();
            }
            file.renameTo(file2);
            if(file.exists())
            {
                file.delete();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public File func_28113_a(String s)
    {
        return new File(field_28114_d, (new StringBuilder()).append(s).append(".dat").toString());
    }

    public String func_40530_d()
    {
        return field_40531_f;
    }

}
