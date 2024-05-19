import java.awt.event.KeyEvent;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {

    private final FractalDrawing curve;

    public DrawingSurface(FractalDrawing curve) {
        this.curve = curve;

    }

    public void setup() {

    }

    public void draw() {
        background(255);   // Clear the screen with a white background

        textSize(12);
        fill(0);
        text("Use the mouse wheel to change length, use UP/DOWN keys to change level.", 20, 15);

        stroke(0);
        curve.draw(this);
    }


    public void mouseWheel(MouseEvent event) {
        int num = event.getCount();
        double length = curve.getLength() - num * 10;
        curve.setLength(length);
    }

    public void keyPressed() {
        if (keyCode == KeyEvent.VK_UP) {
            curve.setLevel(curve.getLevel() + 1);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            curve.setLevel(curve.getLevel() - 1);
        }
    }

}










