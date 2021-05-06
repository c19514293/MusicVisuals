package ie.tudublin;

import processing.core.*;
import java.lang.Math;

// This is an example of a visual that uses the audio bands
public class CircleBands
{
    MyVisual mv;

    public CircleBands(MyVisual mv)
    {
        this.mv = mv; 
    }

    public void render()
    {
        mv.colorMode(PApplet.HSB);
        mv.fill(mv.frameCount % 255, 255, 255);
        mv.circle(mv.x1, mv.y1, mv.getSmoothedAmplitude() * 1000);
        mv.fill(0, 0, 0);
        mv.circle(mv.x1, mv.y1, mv.getSmoothedAmplitude() * 300);

        float r = (mv.getSmoothedAmplitude() * 1000) / 2;
        float gap = (float) (2 * r * Math.sin(Math.PI / mv.getBands().length));
        float angle = 320;
        float angles[] = {70, 110, 150, 190, 230, 270, 310, 350, 390};

        mv.noStroke();

        for (int i = 0; i < mv.getBands().length ; i++, angle += 40)
        {
            float x1 = (float) (Math.cos(Math.toRadians(angle)) * r);
            float y1 = (float) (Math.sin(Math.toRadians(angle)) * r);

            mv.pushMatrix();

            mv.translate(x1 + mv.x1, y1 + mv.y1);
            mv.rotate((float) Math.toRadians(angles[i]));
            mv.fill(PApplet.map(i, 0, mv.getBands().length, 255, 0), 255, 255);
            mv.rect(0, 0, gap, -mv.getSmoothedBands()[i] * 0.3f, r/10);

            mv.popMatrix();
        }
    }
}