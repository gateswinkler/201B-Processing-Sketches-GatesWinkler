

abstract class AngryMonster extends Monster {
  private String warCry;

  public void angryActions()
  {
    println("The " + this.getClass().getSimpleName() + " is being angry:");
    
    yell();
    
    //growl.play(0);

  }

  abstract public void yell();

  public void render(int x, int y)
  {

    if (isMouseOver == true)
      tint(255,0,0);
    else
      tint(255,255,255);
  }
}

