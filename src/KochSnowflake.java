import processing.core.PApplet;

public class KochSnowflake extends FractalDrawing {
	
	int x = 50;
	int y = 100;
	
	KochCurve one;
	KochCurve two;
	KochCurve three;
	
	public KochSnowflake(int level, int length) {
		super(level, length);
		one = new KochCurve(level, length, 60, x, y);
		two = new KochCurve(level, length, 180, x + length, y);
		three = new KochCurve(level, length, 300, x + (int)((float)length/2), y + length*Math.sqrt(3)/2);
	}

	public void setLevel(int level) {
		super.setLevel(level);
		one.setLevel(level);
		two.setLevel(level);
		three.setLevel(level);
	}

	public void setLength(double length) {
		super.setLength(length);
		one.setLength(length);
		two.setLength(length);
		three.setLength(length);

		two.x = x + length;
		three.x = x + length/2;
		three.y = y + length*Math.sqrt(3)/2;
	}
	
	public void draw(PApplet p) {
		one.draw(p);
		two.draw(p);
		three.draw(p);
	}
}
