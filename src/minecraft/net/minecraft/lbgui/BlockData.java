package net.minecraft.lbgui;

public class BlockData
{
	private int id, x, y, z;
	private String playerName, blockName, date, time, action;
	
	public BlockData(String[] rawdata) {
		id = Integer.parseInt(rawdata[0].replace("(", "").replace(")", ""));
		
		date = rawdata[1];
		time = rawdata[2];
		playerName = rawdata[3];
		action = rawdata[4];
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public String getBlockName() {
		return blockName;
	}
	
}
