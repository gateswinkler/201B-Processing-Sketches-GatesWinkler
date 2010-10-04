
class Gnome extends FriendlyMonster {

  PImage gnomeImg = loadImage("gnome.jpg");
  public Gnome() {
    super.gifts.add("the gnome wants to help you get a discount on your travel planning");
  } 

  public void giveGifts() {
    println(super.gifts);
  }

  public void render(int x, int y) {
    super.render(x,y);
    image(gnomeImg, x,y,w,h);
  }
}
