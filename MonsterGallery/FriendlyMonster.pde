

abstract class FriendlyMonster extends Monster {
  private List gifts = new ArrayList();

  public void friendlyActions()
  {
    println("The " + this.getClass().getSimpleName() + " is being friendly:");
    
    giveGifts(); 
    
  }

  abstract public void giveGifts();

  public void render(int x, int y)
  { 
    if (isMouseOver == true)
      tint(0,255,0);
    else
      tint(255,255,255);
  }
}

