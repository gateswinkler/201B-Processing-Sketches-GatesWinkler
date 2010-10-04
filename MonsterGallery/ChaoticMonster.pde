
abstract class ChaoticMonster extends Monster {
  private int chaos;
  
  public void chaoticActions()
  {
    println("The " + this.getClass().getSimpleName() + " is being chaotic:");
    
    randomact();
  }
  
  
  abstract public void randomact();
  
  
    public void render(int x, int y)
  { 
    if (isMouseOver == true)
      tint(255,255,0);
    else
      tint(255,255,255);
  }
}
