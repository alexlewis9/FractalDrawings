import processing.core.PApplet;
import shapes.Line;


public class KochCurve extends FractalDrawing{

	double x = 100;
	double y = 100;
	double angle = 0;
	double endx;
	double endy;

    public KochCurve(int level, int length) {
		super(level, length);
    }
    
    public KochCurve(int level, int length, double angle, double x, double y) {
		super(level, length);
    	this.angle = angle;
    	this.x = x;
    	this.y = y;
    }
    
    public void draw(PApplet marker) {
    	drawKochCurve(marker, length, angle, x, y, level);
    }

    private void drawKochCurve(PApplet p, double length, double angle, double x, double y, int level) {
    	if (level < 1) {
    		endx = x + length * Math.cos(angle * Math.PI / 180);
    		endy =  y + length * Math.sin(angle * Math.PI / 180);
    		Line line = new Line(x, y, endx, endy);
        	line.draw(p);
    	} else {
    		drawKochCurve(p, length/3, angle, x, y, level-1);
       	 	drawKochCurve(p, length/3, angle + 60, endx, endy, level-1);
       	 	drawKochCurve(p, length/3, angle - 60, endx, endy, level-1);
       	 	drawKochCurve(p, length/3, angle, endx, endy, level-1);
    	}
    }

}
