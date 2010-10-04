class Wolfman extends AngryMonster {
  
   PImage wolfmanImg = loadImage("Lycan.jpg");
 
   public Wolfman() {
   super.warCry = "HOOOOWWWWWWWLLLLLLLL!";
 }
 
   public void yell() {
   println(super.warCry);
   scream.play(0);
 }

 public void render(int x, int y){
     super.render(x,y);
    
     image(wolfmanImg, x,y,w,h);
   
   }


}
