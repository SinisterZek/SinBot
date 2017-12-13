package me.sinisterzek;



import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

public class Main {
	
	  public static JDA jda = null;
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken("Mzg0MzgxMTcwMDcyMTU4MjE4.DPx-eg.QbWXgzexGBKDAU25v8gcHZBLgOQ");
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);
        
        
        
        
        try {
            jda = builder.buildBlocking();
        } catch (Exception e) {
            e.printStackTrace();
        }

        jda.addEventListener(new DiscordEventHandler());
        jda.getPresence().setGame(Game.of("Prefix: -"));

            
	}

}
