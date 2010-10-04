class Elf extends ChaoticMonster {
 
 //PImage elfImg = createImage(200,200,000);
 
 public Elf() {
 }
 
 public void randomact() {
   float f = random(0,2);
   println(f);
   super.chaos = int(f);
   if (super.chaos == 1)
   {
     println("The elf offers you a bag of magic beans");
   }
  else if (super.chaos == 0)
  {
    println("The elf shoots you with an arrow!");
  }
 }
 
 public void render(int x, int y){
     
    if (isMouseOver == true)
    {
      fill(255,255,0);
    }
    else
    {
      fill(255,255,255);
    }
    
     rectMode(CENTER);
     rect (x+100, y+100, 200, 200);
     rect(x+100,y+100,20,100);
     ellipse(x+100,y+70,60,60);
     line(x+130, y+65, x+140, y+55);
     line(x+70, y+65, x+60, y+55);
     ellipse(x+85,y+65,16,16); 
     ellipse(x+115,y+65,16,16); 
     line(x+90,y+150,x+80,y+180);
     line(x+110,y+150,x+120,y+180);
     fill(0);
     text("ELF", x+90, y+35);
   }
  
}
