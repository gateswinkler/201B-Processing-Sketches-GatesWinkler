import processing.opengl.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import java.nio.*;

GL gl;
GLU glu;

int offX = 0;
int offY = 0;
int numSel = 0;

boolean b1Selected = false;
float b1Depth = 0;

int sw = 450;
int sh = 500;

String[] cards = new String[12];
String[] select = new String[3];

void setup()
{
  size(sw, sh, OPENGL); 
  noStroke();
  gl=((PGraphicsOpenGL)g).gl;
  glu=((PGraphicsOpenGL)g).glu;
  String temp = "";
  
  int i = 0;
  while (i < 12){
    int col = int(random(0,3));
    int num = int(random(0,3));
    int shpe = int(random(0,3));
    int fil = int(random(0,3));
    
    switch(col){
      case 0:
        temp = temp + "R:";
        break;
      case 1:
        temp = temp + "G:";
        break;
      case 2:
        temp = temp + "B:";
        break;
    }
    switch(num){
      case 0:
        temp = temp + "1:";
        break;
      case 1:
        temp = temp + "2:";
        break;
      case 2:
        temp = temp + "3:";
        break;
    }
    
    switch(shpe){
      case 0:
        temp = temp + "S:";
        break;
      case 1:
        temp = temp + "D:";
        break;
      case 2:
        temp = temp + "P:";
        break;
    }
    
    switch(fil){
      case 0:
        temp = temp + "E:";
        break;
      case 1:
        temp = temp + "H:";
        break;
      case 2:
        temp = temp + "F:";
        break;
    }
    //println(temp);
    for(int j = 0; j < i; j++){
      if(cards[j].equals(temp)){
        temp = "";
      }
    }
    if(!(temp.equals(""))){
      cards[i] = temp;
      i++;
      temp = "";
    }
  }
  /*for(i = 0; i<12; i++){
    println(cards[i]);
  }*/
}


void draw()
{
  String[] card = new String[12];
  background(0);

  //fill(255,255,255);
  //rect(b1x, b1y, b1w, b1h);
  for(int i  = 0; i < 12; i++){
    card[i] = "";
    String temp[] = split(cards[i], ":");
    for(int j = 0; j<4; j++){
      card[i] = card[i]+temp[j];
    }
  }
  image((loadImage(card[0] + ".jpg")), 50, 50);
  image((loadImage(card[1] + ".jpg")), 150, 50);
  image((loadImage(card[2] + ".jpg")), 250, 50);
  image((loadImage(card[3] + ".jpg")), 350, 50);
  
  image((loadImage(card[4] + ".jpg")), 50, 200);
  image((loadImage(card[5] + ".jpg")), 150, 200);
  image((loadImage(card[6] + ".jpg")), 250, 200);
  image((loadImage(card[7] + ".jpg")), 350, 200);
  
  image((loadImage(card[8] + ".jpg")), 50, 350);
  image((loadImage(card[9] + ".jpg")), 150, 350);
  image((loadImage(card[10] + ".jpg")), 250, 350);
  image((loadImage(card[11] + ".jpg")), 350, 350);
  /*rect(50, 50, 50, 100);
  texture(loadImage(cards[1] + ".jpg"));
  rect(150, 50, 50, 100);
  texture(loadImage(cards[2] + ".jpg"));
  rect(250, 50, 50, 100);
  texture(loadImage(cards[3] + ".jpg"));
  rect(350, 50, 50, 100);

  texture(loadImage(cards[4] + ".jpg"));
  rect(50, 200, 50, 100);
  texture(loadImage(cards[5] + ".jpg"));
  rect(150, 200, 50, 100);
  texture(loadImage(cards[6] + ".jpg"));
  rect(250, 200, 50, 100);
  texture(loadImage(cards[7] + ".jpg"));
  rect(350, 200, 50, 100);

  texture(loadImage(cards[8] + ".jpg"));
  rect(50, 350, 50, 100);
  texture(loadImage(cards[9] + ".jpg"));
  rect(150, 350, 50, 100);
  texture(loadImage(cards[10] + ".jpg"));
  rect(250, 350, 50, 100);
  texture(loadImage(cards[11] + ".jpg"));
  rect(350, 350, 50, 100); */
}

void mousePressed() {
  float[] mpix=getMouse3D();
  //println(round(mpix[0]) + "/" + round(mpix[1]) + "/" + round(mpix[2]));

  if (mpix[0] > 50 && mpix[0] < 50 + 50 && mpix[1] > 50 && mpix[1] < 50 + 100) { 
    println("card1:  " + cards[0]);
    select[numSel] = cards[0];
    numSel++;
  } 

  if (mpix[0] > 150 && mpix[0] < 150 + 50 && mpix[1] > 50 && mpix[1] < 50 + 100) { 
    println("card2:  " + cards[1]);
    select[numSel] = cards[1];
    numSel++;
  } 
  
  if (mpix[0] > 250 && mpix[0] < 250 + 50 && mpix[1] > 50 && mpix[1] < 50 + 100) { 
    println("card3:  " + cards[2]);
    select[numSel] = cards[2];
    numSel++;  
} 
  
  if (mpix[0] > 350 && mpix[0] < 350 + 50 && mpix[1] > 50 && mpix[1] < 50 + 100) { 
    println("card4:  " + cards[3]);
    select[numSel] = cards[3];
    numSel++;  
} 

  if (mpix[0] > 50 && mpix[0] < 50 + 50 && mpix[1] > 200 && mpix[1] < 200 + 100) { 
    println("card5:  " + cards[4]);
    select[numSel] = cards[4];
    numSel++;  
} 

  if (mpix[0] > 150 && mpix[0] < 150 + 50 && mpix[1] > 200 && mpix[1] < 200 + 100) { 
    println("card6:  " + cards[5]);
    select[numSel] = cards[5];
    numSel++;  
} 
  
  if (mpix[0] > 250 && mpix[0] < 250 + 50 && mpix[1] > 200 && mpix[1] < 200 + 100) { 
    println("card7:  " + cards[6]);
    select[numSel] = cards[6];
    numSel++;  
} 
  
  if (mpix[0] > 350 && mpix[0] < 350 + 50 && mpix[1] > 200 && mpix[1] < 200 + 100) { 
    println("card8:  " + cards[7]);
    select[numSel] = cards[7];
    numSel++;
  } 

  if (mpix[0] > 50 && mpix[0] < 50 + 50 && mpix[1] > 350 && mpix[1] < 350 + 100) { 
    println("card9:  " + cards[8]);
    select[numSel] = cards[8];
    numSel++;
  } 

  if (mpix[0] > 150 && mpix[0] < 150 + 50 && mpix[1] > 350 && mpix[1] < 350 + 100) { 
    println("card10:  " + cards[9]);
    select[numSel] = cards[9];
    numSel++;
  } 
  
  if (mpix[0] > 250 && mpix[0] < 250 + 50 && mpix[1] > 350 && mpix[1] < 350 + 100) { 
    println("card11:  " + cards[10]);
    select[numSel] = cards[10];
    numSel++;
  } 
  
  if (mpix[0] > 350 && mpix[0] < 350 + 50 && mpix[1] > 350 && mpix[1] < 350 + 100) { 
    println("card12:  " + cards[11]);
    select[numSel] = cards[11];
    numSel++;
  }
  if(numSel == 3){
    //println(split(select[0],":"));
    String[] tempA = split(select[0],":");
    String[] tempB = split(select[1],":");
    String[] tempC = split(select[2],":");
    String Acolor = tempA[0];
    String Bcolor = tempB[0];
    String Ccolor = tempC[0];
    String Anum = tempA[1];
    String Bnum = tempB[1];
    String Cnum = tempC[1];
    String Ashape = tempA[2];
    String Bshape = tempB[2];
    String Cshape = tempC[2];
    String Afill = tempA[3];
    String Bfill = tempB[3];
    String Cfill = tempC[3];
 
    boolean legalcolor =  EQorDIFF(Acolor,Bcolor,Ccolor);
    boolean legalnum = EQorDIFF(Anum,Bnum,Cnum);
    boolean legalshape = EQorDIFF(Ashape,Bshape,Cshape);
    boolean legalfill = EQorDIFF(Afill,Bfill,Cfill);
    
    if (legalcolor && legalnum && legalshape && legalfill){
      println( "A SET!" );
    }
    else{
      println( "NOT A SET!" );
    }
    numSel = 0;
  }
}

	boolean EQorDIFF(String a, String b, String c) {
		  boolean c1 = a.equals(b);
		  boolean c2 = a.equals(c);
		  boolean c3 = b.equals(c);
		  if(!c1 && !c2 && !c3) {
			  return true;
		  }
		  else if(c1 && c2){
			  return true;
		  }
		  else{
			  return false;
		  } 
		}

float getDepth(int x, int y) {
  FloatBuffer fb=ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  gl.glReadPixels(x, height-y, 1, 1, GL.GL_DEPTH_COMPONENT, GL.GL_FLOAT, fb);
  fb.rewind();
  return fb.get(0);
}

float[] getMouse3D(float depth)
{
  double[] mousePosArr = new double[4];
  int viewport[] = new int[4];
  double[] proj=new double[16];
  double[] model=new double[16];

  ((PGraphicsOpenGL)g).beginGL(); 
  {
    gl.glGetIntegerv(GL.GL_VIEWPORT, viewport, 0);
    gl.glGetDoublev(GL.GL_PROJECTION_MATRIX,proj,0);
    gl.glGetDoublev(GL.GL_MODELVIEW_MATRIX,model,0);
    glu.gluUnProject(mouseX, height-mouseY, depth, model, 0, proj, 0, viewport, 0, mousePosArr, 0);
  }
  ((PGraphicsOpenGL)g).endGL();

  return new float[] {
    (float)mousePosArr[0], (float)mousePosArr[1], (float)mousePosArr[2], depth
  };
} 

float[] getMouse3D()
{
  FloatBuffer fb=ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  gl.glReadPixels(mouseX, height-mouseY, 1, 1, GL.GL_DEPTH_COMPONENT, GL.GL_FLOAT, fb);
  fb.rewind();

  return getMouse3D(fb.get(0));
}

