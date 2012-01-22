package net.minecraft.lbgui.parser;

import java.util.ArrayList;

import net.minecraft.lbgui.BlockData;

public class BlockDataParser
{
	public ArrayList<BlockData> blockQueue;
	public BlockData getData(String entry)
	{
		String[] raw = entry.split(" "); //This should yield at least a 5 count array
		if(raw.length > 5) {
			//We are ready to parse it
			BlockData bd = new BlockData(raw);
		}
		return null;
	}
}
