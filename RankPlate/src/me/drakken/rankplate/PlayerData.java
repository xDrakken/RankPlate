package me.drakken.rankplate;

import java.util.Set;





public class PlayerData
{
  private final Set<String> characters = new java.util.HashSet();
  private final Set<String> maps = new java.util.HashSet();
  private boolean vip;
  private boolean pro;
  private boolean master;
  
  
  
  

  
  public boolean hasCharacter(String character) {
    return (isVip()) || (this.characters.contains(character));
  } 
  
  public boolean hasMap(String map) {
    return this.maps.contains(map);
  } 
  
  public boolean isPro() {
    return this.pro;
  } 
  
  public boolean Master() {
    return this.Master;
  } 
  
  public void setCharacter(String character, boolean allow) {
    if (allow) {
      this.characters.add(character);
    } 
  } 
  
  public void setPro(boolean pro) {
    this.pro = pro;
  } 
  
  public void setMap(String map, boolean allow) {
    if (allow) {
      this.maps.add(map);
    } 
  } 
  
  public void setMaster(boolean Master) {
    this.Master = Master;
  } 
  
  public void setVip(boolean vip) {
    this.vip = vip;
  } 
}
  


  
  
  