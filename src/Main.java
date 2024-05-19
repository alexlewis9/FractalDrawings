import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main {

    public static void main(String[] args) {
        FractalDrawing[] choices = {new DragonCurve(2, 30), new SierpinskiTriangle(0, 100, new Coordinates(50, 350), new Coordinates(250, 50), new Coordinates(450, 350)), new HilbertCurve(0, 100), new BoxFractal(0, 100), new KochCurve (1,100), new KochSnowflake (3,100)};


        FractalDrawing input = (FractalDrawing) JOptionPane.showInputDialog(null, "Which fractal would you like to draw?",
                "Which Fractal?", JOptionPane.QUESTION_MESSAGE, null,
                choices, // Array of choices
                choices[0]); // Initial choice

        if (input == null)
            return;


        DrawingSurface drawing = new DrawingSurface(input);
        PApplet.runSketch(new String[]{""}, drawing);
        PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
        PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
        JFrame window = (JFrame) canvas.getFrame();

        window.setSize(800, 600);
        window.setMinimumSize(new Dimension(100, 100));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        window.setVisible(true);
        canvas.requestFocus();
    }

}
