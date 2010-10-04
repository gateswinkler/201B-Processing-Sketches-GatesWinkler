import ddf.minim.*;
Minim minim;
AudioSnippet scream;

List monsters;

public void setup() {
  size(1400,200);
  monsters = new ArrayList();

  monsters.add(new Vampire());
  monsters.add(new Unicorn());
  monsters.add(new Wolfman());
  monsters.add(new Gnome());
  monsters.add(new Pixie());
  monsters.add(new Elf());
  monsters.add(new IndifferentUnicorn());
  
  minim = new Minim(this);
  scream = minim.loadSnippet("scream.wav");
  
}

public void draw() {
  for (int i = 0; i < monsters.size(); i++) {
  
    Monster m = (Monster) monsters.get(i);
   
    int xpos = i * 200; int ypos = 0;
   
    m.checkIfMouseOver(xpos, ypos, mouseX, mouseY);
  
    m.render(xpos, ypos);
  }  
}

public void mousePressed()
{
  for (int i = 0; i < monsters.size(); i++) {
    Monster m = (Monster) monsters.get(i);
  
    if (m.isMouseOver == true)
    {
      if (m instanceof FriendlyMonster)
      {
        ((FriendlyMonster)m).friendlyActions();
      }
      
      else if (m instanceof AngryMonster)
      {
        ((AngryMonster)m).angryActions();   
      }
      
      else if (m instanceof ChaoticMonster)
      {
        ((ChaoticMonster)m).chaoticActions();   
      }    
      println("\n");
    }
    
    
  }
}
