class Pixie extends ChaoticMonster {
 
 PImage pixieImg = loadImage("pixie.jpg");
  
 public Pixie() {
 }
 
 public void randomact() {
   float f = random(0,2);
   println(f);
   super.chaos = int(f);
   if (super.chaos == 1)
   {
     println("The pixie gives you a magic hug");
   }
  else if (super.chaos == 0)
  {
    println("The pixie eats your face!");
  }
 }
 
 public void render(int x, int y){
     super.render(x,y);
    
     image(pixieImg, x,y,w,h);
   
   }
  
}
