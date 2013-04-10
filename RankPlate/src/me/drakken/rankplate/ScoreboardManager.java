package me.drakken.rankplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.server.v1_5_R2.Scoreboard;
import net.minecraft.server.v1_5_R2.ScoreboardTeam;
import net.minecraft.server.v1_5_R2.World;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_5_R2.CraftWorld;

public class ScoreboardManager
{
  static List<Integer> list = new ArrayList();
  
  @SuppressWarnings("unchecked")
public static void load()
  {
    World mcWorld = ((CraftWorld)Bukkit.getWorlds().get(0)).getHandle();
    for (String str : (String[])mcWorld.getScoreboard().getTeamNames().toArray(new String[mcWorld.getScoreboard().getTeamNames().size()])) {
      int entry = -1;
      try {
        entry = Integer.parseInt(str);
      }
      catch (Exception localException) {}
      if (entry != -1) {
        list.add(Integer.valueOf(entry));
      } 
    } 
  } 
  
  public static void update(String player, String prefix, String suffix)
  {
    World mcWorld = ((CraftWorld)Bukkit.getWorlds().get(0)).getHandle();
    
    if ((prefix == null) || (prefix.isEmpty()))
      prefix = getPrefix(player, mcWorld); 
    if ((suffix == null) || (suffix.isEmpty())) {
      suffix = getSuffix(player, mcWorld);
    } 
    ScoreboardTeam s = get(prefix, suffix);
    
    mcWorld.getScoreboard().addPlayerToTeam(player, s);
  } 
  
  public static void overlap(String player, String prefix, String suffix)
  {
    World mcWorld = ((CraftWorld)Bukkit.getWorlds().get(0)).getHandle();
    
    if (prefix == null)
      prefix = ""; 
    if (suffix == null) {
      suffix = "";
    } 
    ScoreboardTeam s = get(prefix, suffix);
    
    mcWorld.getScoreboard().addPlayerToTeam(player, s);
  } 
  
  public static void clear(String player)
  {
    World mcWorld = ((CraftWorld)Bukkit.getWorlds().get(0)).getHandle();
    
    ScoreboardTeam s = getTeam(player, mcWorld);
    
    if (s != null) {
      mcWorld.getScoreboard().removePlayerFromTeam(player, s);
    } 
  } 
  

  @SuppressWarnings("unchecked")
public static String getPrefix(String player, World mcWorld)
  {
    for (ScoreboardTeam team : (ScoreboardTeam[])mcWorld.getScoreboard().getTeams().toArray(new ScoreboardTeam[mcWorld.getScoreboard().getTeams().size()]))
      if (team.getPlayerNameSet().contains(player)) {
        return team.getPrefix();
      }  
    return "";
  } 
  

  @SuppressWarnings("unchecked")
public static String getSuffix(String player, World mcWorld)
  {
    for (ScoreboardTeam team : (ScoreboardTeam[])mcWorld.getScoreboard().getTeams().toArray(new ScoreboardTeam[mcWorld.getScoreboard().getTeams().size()]))
      if (team.getPlayerNameSet().contains(player)) {
        return team.getSuffix();
      }  
    return "";
  } 
  
  public static String getSuffix(String player)
  {
    World mcWorld = ((CraftWorld)Bukkit.getWorlds().get(0)).getHandle();
    return getPrefix(player, mcWorld);
  } 

  public static String getPrefix(String player)
  {
    World mcWorld = ((CraftWorld)Bukkit.getWorlds().get(0)).getHandle();
    return getPrefix(player, mcWorld);
  } 
  
  public static String getFormattedName(String player)
  {
    World mcWorld = ((CraftWorld)Bukkit.getWorlds().get(0)).getHandle();
    return getPrefix(player, mcWorld) + player + getSuffix(player, mcWorld);
  } 
  

  @SuppressWarnings("unchecked")
private static ScoreboardTeam getTeam(String player, World mcWorld)
  {
    for (ScoreboardTeam team : (ScoreboardTeam[])mcWorld.getScoreboard().getTeams().toArray(new ScoreboardTeam[mcWorld.getScoreboard().getTeams().size()]))
      if (team.getPlayerNameSet().contains(player)) {
        return team;
      }  
    return null;
  } 
  
  private static ScoreboardTeam declareTeam(World mcWorld, String name, String prefix, String suffix)
  {
    if (mcWorld.getScoreboard().getTeam(name) != null) {
      mcWorld.getScoreboard().removeTeam(mcWorld.getScoreboard().getTeam(name));
    } 
    mcWorld.getScoreboard().createTeam(name);
    mcWorld.getScoreboard().getTeam(name).setPrefix(prefix);
    mcWorld.getScoreboard().getTeam(name).setSuffix(suffix);
    return mcWorld.getScoreboard().getTeam(name);
  } 
 
  private static ScoreboardTeam get(String prefix, String suffix)
  {
    World mcWorld = ((CraftWorld)Bukkit.getWorlds().get(0)).getHandle();
    
    update(mcWorld);
    Integer[] arrayOfInteger;
    int j = (arrayOfInteger = (Integer[])list.toArray(new Integer[list.size()])).length; for (int i = 0; i < j; i++) { String t = arrayOfInteger[i].intValue();
      
      if (mcWorld.getScoreboard().getTeam(t) != null) {
        ScoreboardTeam s = mcWorld.getScoreboard().getTeam(t);
        if ((s.getSuffix().equals(suffix)) && (s.getPrefix().equals(prefix))) {
          return s;
        } 
      } 
    } 
    return declareTeam(mcWorld, nextName(), prefix, suffix);
  } 
  
  private static int nextName()
  {
    int at = 0;
    boolean cont = true;
    int j; int i; for (; cont; 
        
        i < j) { cont = false;
      Integer[] arrayOfInteger; j = (arrayOfInteger = (Integer[])list.toArray(new Integer[list.size()])).length;i = 0;continue;int t = arrayOfInteger[i].intValue();
      if (t == at) {
        at++;
        cont = true; }  i++;
    } 
    





    list.add(Integer.valueOf(at));
    return at;
  } 
  
@SuppressWarnings("unchecked")
private static void update(World mcWorld)
  {
    for (ScoreboardTeam team : (ScoreboardTeam[])mcWorld.getScoreboard().getTeams().toArray(new ScoreboardTeam[mcWorld.getScoreboard().getTeams().size()])) {
      int entry = -1;
      try {
        entry = Integer.parseInt(team.getName());
      }
      catch (Exception localException) {}
      if ((entry != -1) && 
        (team.getPlayerNameSet().size() == 0)) {
        mcWorld.getScoreboard().removeTeam(team);
        list.remove(new Integer(entry));
      } 
    } 
  } 
} 