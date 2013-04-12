package me.drakken.rankplate;

 
// Coded by Drakken for people in need of awesome plugins! Thanks for your interest in the source! 

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class RankPlate extends JavaPlugin implements Listener

{

	@Override 
    public void onDisable() {       
        System.out.println("[RankPlate] disabled.");
    } 	
		
    @Override 
    public void onEnable() {     
       
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("[RankPlate] version " + this.getDescription().getVersion() + " is enabled. -Made by Drakken!"); 
    }   
	    
    
    @EventHandler
    
public void onPlayerLogin(PlayerLoginEvent event) {
    int onlinePlayers = getServer().getOnlinePlayers().length;
    
      
    
       

    PlayerData data = (PlayerData) event.getPlayer();
    
    if (event.getPlayer().isOp()) {
      ScoreboardManager.overlap(event.getPlayer().getName(), new StringBuilder().append("[").append(ChatColor.RED).append("OP").append(ChatColor.WHITE).append("] ").toString(), "");
    }
    else if (data.isPro()) {
      ScoreboardManager.overlap(event.getPlayer().getName(), new StringBuilder().append("[").append(ChatColor.AQUA).append("PRO").append(ChatColor.WHITE).append("] ").toString(), "");
    }
    else if (data.isVip()) {
      ScoreboardManager.overlap(event.getPlayer().getName(), new StringBuilder().append("[").append(ChatColor.GOLD).append("VIP").append(ChatColor.WHITE).append("] ").toString(), "");
    }
    else {
      ScoreboardManager.clear(event.getPlayer().getName());
    } 
    
  }
  
  
  

}

