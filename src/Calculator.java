import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

public class Calculator
{
    boolean flag = false;
    static JFrame frame = new JFrame("Calculator");
    static JPanel panelInputOutput = new JPanel(null);
    static JPanel panelButtons = new JPanel(null);
    Buttons buttons;
    InputOutputFrame ioframe;

    // Sound Package
    private Clip clip;

    Picture picture = new Picture();

    // Threads
    Thread tMain = Thread.currentThread();

    Thread tSound = new Thread(new Runnable() {
        @Override
        public void run() {
            File musicFile = new File("assets/SomeSound.wav");
            if (!musicFile.exists())
                System.out.println("File is not exists");
            AudioInputStream audioInputStream = null;
            try {
                audioInputStream = AudioSystem.getAudioInputStream(musicFile);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            }

        }

        void stopMusic() { clip.stop(); }
    });

    Thread tImage = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {

                picture.angle += 3;
                picture.repaint();

                try {
                    Thread.sleep(10);

                } catch (Exception e) {
                    return;
                }
            }
        }

    });



    Calculator() throws InterruptedException {
            initCalculator();
    }

    final private void initCalculator() throws InterruptedException {
        frame.setBackground(new Color(58,58,58,255));
        frame.setSize(720, 528);

        panelInputOutput.setBounds(0,0,320,175);
        panelButtons.setBounds(0,175,320,310);
        panelButtons.setBackground(new Color(58,58,58));
        panelInputOutput.setBackground(new Color(65,65,65));

        ioframe = new InputOutputFrame(panelInputOutput);
        buttons = new Buttons(panelButtons, ioframe);

        picture.setBounds(320,0,  400, 532);
        panelInputOutput.add(picture);

        tSound.start();
        tImage.start();

        frame.setResizable(false);
        frame.add(panelButtons);
        frame.add(panelInputOutput);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
    // w=60 h=36
    // w=320 h=532
    // h = 309
    // h = 225







}
