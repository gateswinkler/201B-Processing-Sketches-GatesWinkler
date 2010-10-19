import java.util.*;
import processing.core.*;
import controlP5.*;

public class PS4 extends PApplet{
	ControlP5 controlP5;
	float number = 5;
	int numShapes = 5;
	double area = 0;
	Button butt;
	Slider nums;
	int wide=400;
	int tall=500;

	Map<String, List<GeometricShape>> shapeMap = new HashMap<String, List<GeometricShape>>();

	List<GeometricShape> pentagons = new ArrayList<GeometricShape>();
	List<GeometricShape> hexagons = new ArrayList<GeometricShape>();
	List<GeometricShape> circles = new ArrayList<GeometricShape>();
	List<GeometricShape> polylist = new ArrayList<GeometricShape>();

	public static void main(String args[]) {
		PApplet.main(new String[] {"PS4"});
	}
	
	public void setup(){
		background(0,0,0);
		size(400, 600);
		controlP5 = new ControlP5(this);

		nums = controlP5.addSlider("Number", 0,10,5, 100,540,250, 20);
		controlP5.addButton("Circle", 0,20,510,50,20);
		controlP5.addButton("Pentagon", 0,20,540,50,20);
		controlP5.addButton("Hexagon", 0,20,570,50,20);

		shapeMap.put("circles", circles);
		shapeMap.put("pentagons", pentagons);
		shapeMap.put("hexagons", hexagons);

	}

	public void draw(){
		fill(255, 255, 255);
		stroke(0);
	}

	public interface AreaInformation {
		public double calculateArea();
	}

	public interface RenderingAlgorithm {
		public void render();
	}
	
	public abstract class GeometricShape implements AreaInformation, RenderingAlgorithm {
		double area;
		public double getArea() { return area; }
		public void setArea(double area) {
			this.area = area;
		}
	}

	void polygon(int n, float cx, float cy, float r){
		float angle = (float)(360.0 / n);

		beginShape();
		for (int i = 0; i < n; i++){
			vertex(cx + r * cos(radians(angle * i)),
			cy + r * sin(radians(angle * i)));
		}
		endShape(CLOSE);
	}

	public class Circle extends GeometricShape {
		float diam;
		int x;
		int y;

		Circle(){
			diam = random(wide);
			x = (int)random(wide);
			y = (int)random(tall);
		}

		public double calculateArea(){
			area = PI*pow((diam/2),2);
			return area;
		}
		public void render(){
			ellipse(x, y, diam, diam);
		}

	}

	public class Pentagon extends GeometricShape{
		float side;
		int x;
		int y;

		Pentagon(){
			side = random(wide/2);
			x = (int)random(wide);
			y = (int)random(tall);
		}

		public double calculateArea(){
			area = side*side*1.72;
			return area;
		}
		public void render(){
			polygon(5, x, y, side);
		}
	}

	public class Hexagon extends GeometricShape{
		float side;
		int x;
		int y;

		Hexagon(){
			side = random(wide/2);
			x = (int)random(wide);
			y = (int)random(tall);
		}

		public double calculateArea(){
			area = side*side*2.6;
			return area;
		}
		public void render(){
			polygon(6, x, y, side);
		}
	}

	public void Circle() {
		int num = (int)nums.value();
		circles.clear();
		for (int i=0; i<num; i++){
			circles.add(new Circle());
		}
		shapeMap.put("Circles", circles);
		
		background(0,0,0);
		area = 0;
		polylist = shapeMap.get("Circles");
		for (int i = 0; i < num; i++) {
			polylist.get(i).render();
			area = area + polylist.get(i).calculateArea();
		}
		print("Area = ");
		println(area);

	} 

	public void Pentagon() {
		int num = (int)nums.value();
		pentagons.clear();
		for (int i=0; i<num; i++){
			pentagons.add(new Pentagon());
		}
		shapeMap.put("Pentagons", pentagons);
		
		background(0,0,0);
		area = 0;
		polylist = shapeMap.get("Pentagons");
		for (int i = 0; i < num; i++) {
			polylist.get(i).render();
			area = area + polylist.get(i).calculateArea();
		}
		print("Area = ");
		println(area);

	} 

	public void Hexagon() {
		int num = (int)nums.value();
		hexagons.clear();
		for (int i=0; i<num; i++){
			hexagons.add(new Hexagon());
		}
		shapeMap.put("Hexagons", hexagons);
		
		background(0,0,0);
		area = 0;
		polylist = shapeMap.get("Hexagons");
		for (int i = 0; i < num; i++) {
			polylist.get(i).render();
			area = area + polylist.get(i).calculateArea();
		}
		print("Area = ");
		println(area);

	} 
}
