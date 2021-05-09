# Music Visualiser Project

Name: Chak Ngai Wan

Student Number: C19514293

# Description of the assignment
For creating my own version of a music visualizer, I was inspired by many Youtube channels such as Trap Nation, who have a smooth audio visualiser that intensifies when the music does. I planned to recreate that in Java.

# Instructions
To start/restart, press the space button. The circle can also be dragged by your cursor by holding left click.

# How it works
In setup, the CircleBands class is initialised.
```Java
public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("i9bonsai - funee monkee gif.mp3");

        
        // Call this instead to read audio from the microphone
        //startListening(); 

        cb = new CircleBands(this);
    }
```

## CircleBands
In the CircleBands class, the circle is coloured in rainbow before it is drawn. The size of the circle is dependant on its diameter, which is calculated using the average amplitude. After it is drawn, I declared variables to use in a for loop. This loop generates the x and y coordinates of an imaginary nonagon and plots the bar charts on those x, y coordinates. These bar charts then rotate.
```Java
public void render()
    {
        // rainbow colour
        mv.colorMode(PApplet.HSB);
        mv.fill(mv.frameCount % 255, 255, 255);

        // drawing circle
        mv.circle(mv.x1, mv.y1, mv.getSmoothedAmplitude() * 1000);
        mv.fill(0, 0, 0);
        mv.circle(mv.x1, mv.y1, mv.getSmoothedAmplitude() * 800);

        // rotating the bar charts to fit around circle
        float r = (mv.getSmoothedAmplitude() * 1000) / 2;
        float gap = (float) (2 * r * Math.sin(Math.PI / mv.getBands().length));
        float angle = 320;
        float angles[] = {70, 110, 150, 190, 230, 270, 310, 350, 390};

        // no border
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
```

I added the small addition of the circle following the cursor when left click is held.
```Java
if (mousePressed) {
            x1 = mouseX;
            y1 = mouseY;
        }
        else {
            x1 = width/2;
            y1 = height/2;
        }
```
# What I am most proud of in the assignment
My favourite part of the assignment was toying with the circle. I enjoyed figuring how to plot the bar charts on the circle and fiddling with the colours and shape. Although it is not as cool as some of the audio visualisers I see on Youtube, I am proud of what I am capable of making in Java.

[Link to video](https://youtu.be/JUFhzqAlEII)