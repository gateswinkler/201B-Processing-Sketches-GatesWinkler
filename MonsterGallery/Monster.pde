
abstract class Monster {
  int w = 200;
  int h = 200;
  
  boolean isMouseOver = false;

  abstract void render(int x, int y);  
  
  void checkIfMouseOver(int xpos, int ypos, int mX, int mY) {
     if (mX > xpos && mX < xpos + w && mY > ypos && mY < ypos + h) {
       isMouseOver = true;
     }
     else {
       isMouseOver = false;
     }
  }
  
  
    
  
  
}


