package at.java.events;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
 
	public String prefix = "!OX ";
	
	public void onMessageReceived(MessageReceivedEvent event)  {
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		
		if(args[0].equalsIgnoreCase(prefix + "creator")) {
			EmbedBuilder embed = new EmbedBuilder();
			embed.setColor(Color.WHITE);
			embed.setTitle("Hail my glorious creator Zinox!");
			embed.setFooter("Bot created by: Zinox");
			//embed.setFooter("Watch my creation: ");
			event.getChannel().sendMessageEmbeds(embed.build()).queue();
			embed.clear();
		}
		
		if(args[0].equalsIgnoreCase(prefix + "giverole")) {
			if(event.getMessage().getMentionedUsers().toArray().length == 1) {
				if(event.getMessage().getMentionedUsers().toArray().length == 1) {
					Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
					Role roleToGive = event.getMessage().getMentionedRoles().get(0);
					event.getGuild().addRoleToMember(member, roleToGive).queue();
					event.getMessage().reply("Gave the role " + roleToGive.getAsMention() + " to " + member.getAsMention()).queue();
				} else {
					event.getMessage().reply("Error, only 1 user at a time!").queue();
				}
			} else {
				event.getMessage().reply("Error only 1 role at a time!").queue();
			}
		}
		
		if(args[0].equalsIgnoreCase(prefix + "removerole")) {
			if(event.getMessage().getMentionedUsers().toArray().length == 1) {
				if(event.getMessage().getMentionedUsers().toArray().length == 1) {
					Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
					Role roleToRemove = event.getMessage().getMentionedRoles().get(0);
					event.getGuild().removeRoleFromMember(member, roleToRemove).queue();
					event.getMessage().reply("Removed the role " + roleToRemove.getAsMention() + " to " + member.getAsMention()).queue();
				} else {
					event.getMessage().reply("Error, only 1 user at a time!").queue();
				}
			} else {
				event.getMessage().reply("Error only 1 role at a time!").queue();
			}
		}
		
	}
}
