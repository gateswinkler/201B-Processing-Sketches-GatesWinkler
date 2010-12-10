import java.io.File;

import processing.core.*;
import controlP5.*;
import ddf.minim.*;
import ddf.minim.Controller;
import ddf.minim.analysis.*;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.net.*;
import java.nio.*;

import processing.opengl.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;


public class final_project extends PApplet{
	public static void main(String args[]) {
		PApplet.main(new String[] {"final_project"});
	}
	ControlP5 controlP5;
	DropdownList p1;
	Minim minim;
	AudioPlayer song1;
	public BeatDetect beat;
	Button button;
	float Volume = (float)0.5;//100000;
	CheckBox cbox;	
	boolean hasVolume;
	String SongLocation = "";
	String MyText = "";
	String Directory = "";
	public String[] songs = {""};
	public float kickTop, snareTop, hatTop, kickBottom, snareBottom, hatBottom, spin;
	float eRadius;
	int back1, back2, back3;
	GL gl;
	GLU glu;

	//BeatListener bl;
	
	public void setup(){
		size(800, 500, OPENGL);
		  gl=((PGraphicsOpenGL)g).gl;
		  glu=((PGraphicsOpenGL)g).glu;
		  back1 = back2 = back3 = 0;
		for(int i = 0; i<1; i++){
			songs[i] = "";
		}
		//hasVolume = song1.hasControl(Controller.VOLUME);
		controlP5 = new ControlP5(this);
		

		Textfield myTextfield = controlP5.addTextfield("Directory", 25, 425, 500, 25);
		myTextfield.setFocus(true);
		
		
		p1 = controlP5.addDropdownList("myList-p1",24,475,500,120);
		customize(p1);

		//controlP5.addTextfield("SongLocation", 100, 200, 200, 20);
		myTextfield.setAutoClear(false);
		MyText = myTextfield.getText();
		System.out.println(myTextfield.getText());
		//System.out.println(SongLocation);

		minim = new Minim(this);
		
		controlP5.addButton("Play", 0,550,425,100,50);
		controlP5.addButton("Pause", 0,675,425,100,50);
		
		kickTop = snareTop = hatTop = -175;
		kickBottom = snareBottom = hatBottom = 75;
	}
	
	public void draw(){
		background(100,100,100);
		fill(back1, back2, back3);
		rect(0,0,800, 400);
		fill(255, 0, 0);
		rect(775, 375, 15, 15);
		fill(0, 255, 0);
		rect(775, 350, 15, 15);
		fill(0, 0, 255);
		rect(775, 325, 15, 15);
		fill(255, 255, 0);
		rect(775, 300, 15, 15);
		fill(255, 255, 255);
		rect(775, 275, 15, 15);
		fill(0, 0, 0);
		rect(775, 250, 15, 15);
		
		if(beat != null){
			beat.detect(song1.mix);
			fill(60, 255, 0);
			if (beat.isRange(0, 5, 0)){
				spin = (float) (spin +0.1);
			}
			
	  fill(255, 255, 255);
		  beat.isOnset(5);
		if ( beat.isKick() ){
			System.out.println("kick");
			kickTop = -250;
			kickBottom = 150;
		}
		if ( beat.isSnare() ){
			System.out.println("snare");
			snareTop = -250;
			snareBottom = 150;
		}
		if ( beat.isHat() ){
			System.out.println("hat");
			hatTop = -250;
			hatBottom = 150;
		}

		kickTop = constrain((int) (kickTop * 0.95), -250, -175);
		snareTop = constrain((int) (snareTop * 0.95), -250, -175);
		hatTop = constrain((int) (hatTop * 0.95), -250, -175);
		kickBottom = constrain((int) (kickBottom * 0.95), 75, 150);
		snareBottom = constrain((int) (snareBottom * 0.95), 75, 150);
		hatBottom = constrain((int) (hatBottom * 0.95), 75, 150);
		
		pushMatrix();
		translate(width/2, height/2, 0);
		//rotateY((float)Math.toRadians(mouseX));
		rotateY(spin);
	    fill(153, 0, 102);
	    stroke(0);
	    //directionalLight(255, 255, 255, -100, 50, 100);

	    
	    beginShape(TRIANGLES);
	    	vertex(0,snareBottom, 0);
	    	vertex(75, -50, 75);
	    	vertex(-75, -50, 75);
	    	
	    	vertex(-75, -50, 75);
	    	vertex(0, snareTop, 0);
	    	vertex(75, -50, 75);
	    	
	    	vertex(75, -50, 75);
	    	vertex(0, snareTop, 0);
	    	vertex(75, -50, -75);
	    	
	    	vertex(75, -50, 75);
	    	vertex(0, snareBottom, 0);
	    	vertex(75, -50, -75);
	    	
	    	vertex(0, snareBottom, 0);
	    	vertex(75, -50, -75);
	    	vertex(-75, -50, -75);
	    	
	    	vertex(-75, -50, -75);
	    	vertex(0, snareTop, 0);
	    	vertex(75, -50, -75);
	    	
	    	vertex(-75, -50, 75);
	    	vertex(0, snareTop, 0);
	    	vertex(-75, -50, -75);
	    	
	    	vertex(-75, -50, 75);
	    	vertex(0, snareBottom, 0);
	    	vertex(-75, -50, -75);

	    endShape();
	    popMatrix();
	    
	    pushMatrix();
	    translate(width/5, height/2, 0);
	    rotateY(-spin);
	    beginShape(TRIANGLES);
	    
    	vertex(0,kickBottom, 0);
    	vertex(75, -50, 75);
    	vertex(-75, -50, 75);
    	
    	vertex(-75, -50, 75);
    	vertex(0, kickTop, 0);
    	vertex(75, -50, 75);
    	
    	vertex(75, -50, 75);
    	vertex(0, kickTop, 0);
    	vertex(75, -50, -75);
    	
    	vertex(75, -50, 75);
    	vertex(0, kickBottom, 0);
    	vertex(75, -50, -75);
    	
    	vertex(0,kickBottom, 0);
    	vertex(75, -50, -75);
    	vertex(-75, -50, -75);
    	
    	vertex(-75, -50, -75);
    	vertex(0, kickTop, 0);
    	vertex(75, -50, -75);
    	
    	vertex(-75, -50, 75);
    	vertex(0, kickTop, 0);
    	vertex(-75, -50, -75);
    	
    	vertex(-75, -50, 75);
    	vertex(0, kickBottom, 0);
    	vertex(-75, -50, -75);
	    
    endShape();
	    		    
	popMatrix();
	
    pushMatrix();
    translate(width*4/5, height/2, 0);
    rotateY(-spin);
    beginShape(TRIANGLES);
    
	vertex(0, hatBottom, 0);
	vertex(75, -50, 75);
	vertex(-75, -50, 75);
	
	vertex(-75, -50, 75);
	vertex(0, hatTop, 0);
	vertex(75, -50, 75);
	
	vertex(75, -50, 75);
	vertex(0, hatTop, 0);
	vertex(75, -50, -75);
	
	vertex(75, -50, 75);
	vertex(0, hatBottom, 0);
	vertex(75, -50, -75);
	
	vertex(0,hatBottom, 0);
	vertex(75, -50, -75);
	vertex(-75, -50, -75);
	
	vertex(-75, -50, -75);
	vertex(0, hatTop, 0);
	vertex(75, -50, -75);
	
	vertex(-75, -50, 75);
	vertex(0, hatTop, 0);
	vertex(-75, -50, -75);
	
	vertex(-75, -50, 75);
	vertex(0, hatBottom, 0);
	vertex(-75, -50, -75);
    
endShape();
    		    
  popMatrix();
		}
	}
	
	public void Directory(String Song){
		File Dir = new File(Song);
		Directory = Song;
		System.out.println(Dir);
		songs = Dir.list();
		for(int i = 0; i<songs.length; i++){

			System.out.println(songs[i]);
		}

		customize(p1);
	}
	public void customize(DropdownList dd1){
		dd1.clear();
		dd1.setHeight(30);
		for(int i = 0; i<songs.length; i++){
			if(songs[i].length()>3){
				System.out.println(songs[i].substring(songs[i].length()-3, songs[i].length()));
			if (songs[i].substring(songs[i].length()-3, songs[i].length()).equals("mp3")){
			//if (temp[0].equals(".")){
				dd1.addItem(songs[i], i);
			//}
			}
			}
		}
	}
	public void p1(String Name){
		//SongLocation = Name;
		System.out.println(Name);
	}
	
	public void Play(){
		SongLocation = Directory + "\\"+ p1.stringValue();
		System.out.println(SongLocation);
		song1 = minim.loadFile(SongLocation);
		song1.play();
		beat = new BeatDetect(song1.bufferSize(), song1.sampleRate());
		//bl = new BeatListener(beat, song1);
		beat.setSensitivity(100);  
	}
	public void Pause(){
		song1.pause();
	}
	public void mousePressed() {
		  float[] mpix=getMouse3D();
		  //println(round(mpix[0]) + "/" + round(mpix[1]) + "/" + round(mpix[2]));

//		  if (mpix[0] > b1x && mpix[0] < b1x + b1w && mpix[1] > b1y && mpix[1] < b1y + b1h) {
		  if (mpix[0] > 775 && mpix[0] < 790 && mpix[1] > 375 && mpix[1] < 390) {
			  back1 = 255;
			  back2 = 0;
			  back3 = 0;
		  }
		  if (mpix[0] > 775 && mpix[0] < 790 && mpix[1] > 350 && mpix[1] < 365) {
			  back1 = 0;
			  back2 = 255;
			  back3 = 0;
		  }
		  if (mpix[0] > 775 && mpix[0] < 790 && mpix[1] > 325 && mpix[1] < 340) {
			  back1 = 0;
			  back2 = 0;
			  back3 = 255;
		  }
		  if (mpix[0] > 775 && mpix[0] < 790 && mpix[1] > 300 && mpix[1] < 315) {
			  back1 = 255;
			  back2 = 255;
			  back3 = 0;
		  }
		  if (mpix[0] > 775 && mpix[0] < 790 && mpix[1] > 275 && mpix[1] < 290) {
			  back1 = 255;
			  back2 = 255;
			  back3 = 255;
		  }
		  if (mpix[0] > 775 && mpix[0] < 790 && mpix[1] > 250 && mpix[1] < 265) {
			  back1 = 0;
			  back2 = 0;
			  back3 = 0;
		  }
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

}

