import processing.core.*;
import controlP5.*;
import ddf.minim.*;

public class GUI extends PApplet{
	public static void main(String args[]) {
		PApplet.main(new String[] {"GUI"});
	}
	ControlP5 controlP5;
	Minim minim;
	AudioPlayer song1;
	AudioPlayer song2;
	AudioPlayer song3;
	AudioPlayer song4;
	AudioPlayer song5;
	Button button;
	float Volume = (float)100000;
	CheckBox cbox;	

	public void setup(){
		size(400, 200);
		
		controlP5 = new ControlP5(this);

		minim = new Minim(this);
		song1 = minim.loadFile("19 - Threshold (8 Bit).mp3");
		song2 = minim.loadFile("binotheelephant.mp3");
		song3 = minim.loadFile("06 The Riddle.mp3");
		song4 = minim.loadFile("01 Pharrell Williams - Despicable Me.mp3");
		song5 = minim.loadFile("Doctorin the Tardis.mp3");
		
		controlP5.addSlider("Volume", 0,100000,100000, 100,130,200, 50);
		controlP5.addButton("Play", 0,50,100,50,20);
		controlP5.addButton("Pause", 0,120,100,50,20);

		cbox = controlP5.addCheckBox("cbox", 20, 20);
		cbox.addItem("Song1", 0);
		cbox.addItem("Song2", 0);
		cbox.addItem("Song3", 0);
		cbox.addItem("Song4", 0);
		cbox.addItem("Song5", 0);
		

	}
	
	public void draw(){
		background(100,100,100);	
	}
	
	public void Play(){
		if (cbox.getState("Song1")){
			song1.setVolume(Volume);
			song1.play();
		}
		if (cbox.getState("Song2")){
			song2.setVolume(Volume);
			song2.play();
		}
		if (cbox.getState("Song3")){
			song3.setVolume(Volume);
			song3.play();
		}
		if (cbox.getState("Song4")){
			song4.setVolume(Volume);
			song4.play();
		}
		if (cbox.getState("Song5")){
			song5.setVolume(Volume);
			song5.play();
		}
	}
	public void Pause(){
		song1.pause();
		song2.pause();
		song3.pause();
		song4.pause();
		song5.pause();
	}
	public void stop(){
		song1.close();
		song2.close();
		song3.close();
		song4.close();
		song5.close();
		minim.stop();

		super.stop();
	}
}
