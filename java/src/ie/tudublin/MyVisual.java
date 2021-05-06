package ie.tudublin;

public class MyVisual extends Visual
{    
    CircleBands cb;

    float x1 = width/2;
    float y1 = height/2;

    public void settings()
    {
        size(1024, 500);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("i9bonsai - funee monkee gif.mp3");

        
        // Call this instead to read audio from the microphone
        //startListening(); 

        cb = new CircleBands(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT();
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands();

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();

        if (mousePressed) {
            x1 = mouseX;
            y1 = mouseY;
        }
        else {
            x1 = width/2;
            y1 = height/2;
        }
        cb.render();
        //wf.render();
        //abv.render();
    }
}
