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
	private static DelayedPageRequest getNextPage;
	
	
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
				blockChanges = Integer.parseInt(message.split(ChatColors.Teal)[1].replace(" changes found.", ""));
				mc.ingameGUI.addChatMessage(ChatColors.Gold+"LogBlock says there are "+blockChanges+" within a "+blockArea+" block area.");
				//handlingLogblock=false;
				changes = new ArrayList<String>();
			}
			
			else if(message.startsWith(ChatColors.Gold)) {
				if (message.startsWith(ChatColors.Gold + "(")) {
					if (tempEntry == "")
						tempEntry = message;
					else {
						//System.out.println("[DEBUG] ENTRY: " + tempEntry);
						changes.add(tempEntry.replace(ChatColors.Gold, ""));
						tempEntry = "";
						pageScroll++;
					}
				} else {
					tempEntry = tempEntry + message;
					//System.out.println("[DEBUG] ENTRY: " + tempEntry);
					changes.add(tempEntry.replace(ChatColors.Gold, ""));
					tempEntry = "";
					pageScroll++;
				}
				
				if (pageScroll >= pageLimit) {
					pageScroll = 0;
					sendMessageToServer("/lb next");
					// System.out.println("[DEBUG] Requesting next page in a delayed request.");
					// getNextPage = new DelayedPageRequest();
					// getNextPage.start();
					// mc.thePlayer.sendChatMessage("/nothing");
				}
			}
			
			else if(message.startsWith(ChatColors.Red+"There isn't a page")) {
				handlingLogblock=false;
				//getNextPage.interrupt();
				mc.ingameGUI.addChatMessage("Scraped all pages. Preparing results.");
				for(String i : changes) {
					System.out.println(i);
				}
			}
			
			else
				mc.ingameGUI.addChatMessage(message);
			
			return true;
		}
		else {
			if(message.startsWith(ChatColors.Teal+"Block changes")) {
				handlingLogblock=true;
				blockArea = Integer.parseInt(message.split("within ")[1].split(" blocks of you")[0]);
				
			}
		}
		System.out.println(message);
		return handlingLogblock;
	}
}

class DelayedPageRequest extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			if(ChatMessageHandler.handlingLogblock)
			{
				Thread.sleep(2000);
				System.out.println("Sending /lb next...");
				ChatMessageHandler.sendMessageToServer("/lb next");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
}
