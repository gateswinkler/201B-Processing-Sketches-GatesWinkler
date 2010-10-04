
class Unicorn extends FriendlyMonster {

  PImage unicornImg = loadImage("unicorn.jpeg");
  public Unicorn() {
    super.gifts.add("a magical rainbow");
    super.gifts.add("a gumdrop");
  } 

  public void giveGifts() {
    print("Here are some gifts: ");

    for (int i = 0; i < super.gifts.size(); i++)
    {
      String g = (String) super.gifts.get(i);
      if (i != 0) print(" and ");

      print(g);
    }
  }

  public void render(int x, int y) {
    super.render(x,y);
    image(unicornImg, x,y,w,h);
  }
}

