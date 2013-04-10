package me.drakken.rankplate;

import java.util.Set;





public class PlayerData
{
  private final Set<String> characters = new java.util.HashSet();
  private final Set<String> maps = new java.util.HashSet();
  private boolean vip;
  private boolean minecadePRO;
  private boolean gm;
  
  
  
  

  
  public boolean hasCharacter(String character) {
    return (isVip()) || (this.characters.contains(character));
  } 
  
  public boolean hasMap(String map) {
    return this.maps.contains(map);
  } 
  
  public boolean isGM() {
    return this.gm;
  } 
  
  public boolean isMinecadePRO() {
    return this.minecadePRO;
  } 
  
  public boolean isVip() {
    return (isMinecadePRO()) || (this.vip);
  } 
  
  public void setCharacter(String character, boolean allow) {
    if (allow) {
      this.characters.add(character);
    } 
  } 
  
  public void setGM(boolean gm) {
    this.gm = gm;
  } 
  
  public void setMap(String map, boolean allow) {
    if (allow) {
      this.maps.add(map);
    } 
  } 
  
  public void setMinecadePRO(boolean minecadePRO) {
    this.minecadePRO = minecadePRO;
  } 
  
  public void setVip(boolean vip) {
    this.vip = vip;
  } 
}
  


  
  
  