
 class IndifferentUnicorn extends Unicorn{
   
   public void giveGifts(){
    float f = random (0,2);
    if (int(f) == 0) {
      println("The unicorn is ignoing you.");
    }
    else
    {
      super.giveGifts();
    }
   }
   
    public void render(int x, int y) {
    super.render(x,y);
    image(unicornImg, x,y,w,h);
  }
 }
