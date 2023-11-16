import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Objects;

public class Music {
    public Clip clip;
    public AudioInputStream audioInputStream;

    public void music(){
        try{
            audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getResource
                    ("10AM.wav")));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}
