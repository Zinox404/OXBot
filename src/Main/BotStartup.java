package Main;

import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginException;

import Main.Commands.Calculate;
import Main.Events.Test;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class BotStartup {
	
	public BotStartup() throws LoginException {
		
		
		
		JDABuilder jda = JDABuilder.createDefault("OTM4NzMyNDY4NDYxMjQ0NDQ2.YfukvQ.vjpJOmevQFck_brG-O3QRiC_Gt8");
		jda.setActivity(Activity.watching("dir beim Schlafen zu"));
		jda.setStatus(OnlineStatus.ONLINE);
		
		jda.addEventListeners(new Calculate(), new Test());
		
		jda.build();
		System.out.println("Bot online!");		
	}
	
	public static void main(String[] args) {	
		try {
			long enable = System.currentTimeMillis();
			new BotStartup();
			System.out.println("Bot enabled in " + TimeUnit.MILLISECONDS.toSeconds((System.currentTimeMillis() - enable)) + "s!");
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

