package Main.Events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Test extends ListenerAdapter {
	
	public String prefix = "!";
	
	public void onMessageReceived(MessageReceivedEvent event)  {
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(prefix + "test")) {
			event.getChannel().sendMessage("This Bot is working as intended").queue();	//event.getchannel(). ... to type in channel without reply
		} 
	}
}
