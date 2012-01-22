package net.minecraft.lbgui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;

public class ChatMessageHandler {
	public static boolean handlingLogblock;
	private static int blockArea = 0;
	private static int blockChanges = 0;
	
	private static int pageLimit = 14;
	private static int pageScroll = 0;
	
	private static ArrayList<String> changes = new ArrayList<String>();
	private static String tempEntry = "";
	private static Minecraft mcInstance;
	
	
	public static void sendMessageToServer(final String message) {
		Runnable r1 = new Runnable() {
			  public void run() {
			    try {
			        Thread.sleep(100);
			        if(mcInstance != null)
						mcInstance.thePlayer.sendChatMessage(message);
					else
						System.out.println("mcInstance isnt defined, what the fuck are you doing?");
			    } catch (InterruptedException iex) {}
			  }
			};
			System.out.println("Sending a new page request message.");
		Thread msgQueue = new Thread(r1);
		msgQueue.start();
	}
	
	public static boolean handleChatMessage(Minecraft mc, String message) {
		mcInstance = mc;
		if(handlingLogblock)
		{
			//System.out.println("[DEBUG] "+message);
			if(message.endsWith(" changes found.")) {
				blockChanges = Integer.parseInt(message.split(ChatColors.Blue)[1].replace(" changes found.", ""));
				mc.ingameGUI.addChatMessage(ChatColors.Gold+"LogBlock says there are "+blockChanges+" changes within a "+blockArea+" block area.");
				//handlingLogblock=false;
				changes = new ArrayList<String>();
			}
			
			else if(message.startsWith(ChatColors.Gold)) {
				//mc.ingameGUI.addChatMessage(message);
				if (message.startsWith(ChatColors.Gold + "(")) {
					if(tempEntry != "") {
						System.out.println("Adding full data ("+tempEntry+") to list.");
						changes.add(tempEntry.replace(ChatColors.Gold, ""));
						tempEntry = message;
						pageScroll++;
					} else {
						System.out.println("Entry ("+message+") only took up one line");
						changes.add(message.replace(ChatColors.Gold, ""));
						tempEntry = "";
						pageScroll++;
					}
				} else {
					System.out.println("Adding "+message+" to"+tempEntry);
					tempEntry = tempEntry + message;
				}
				
				
				if(pageScroll>=pageLimit) {
					pageScroll=0;
					sendMessageToServer("/lb next");
				}
			}
			
			else if(message.startsWith(ChatColors.Red+"There isn't a page")) {
				if(tempEntry!="") 
					changes.add(tempEntry.replace(ChatColors.Gold, ""));
				handlingLogblock=false;
				//getNextPage.interrupt();
				mc.ingameGUI.addChatMessage("Scraped all pages. Preparing results.");
				mc.ingameGUI.addChatMessage(ChatColors.Pink+"Results collected: "+changes.size()+". If this number isnt "+blockChanges+" tell a dev.");
				for(String i : changes) {
					
					System.out.println("Entry: '"+i+"'");
				}
			}
			
			else
				mc.ingameGUI.addChatMessage(message);
			
			return true;
		}
		else {
			if(message.startsWith(ChatColors.Blue+"Block changes")) {
				handlingLogblock=true;
				blockArea = Integer.parseInt(message.split("within ")[1].split(" blocks of you")[0]);
				
			}
		}
		System.out.println(message);
		return handlingLogblock;
	}
}
