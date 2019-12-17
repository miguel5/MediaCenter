package client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */

import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;


public class PlayMedia implements Runnable {
    
    private String path;
    private final String dir = System.getProperty("user.dir") + "/content/";
    
    
    public PlayMedia(String path){
        this.path = path;
    }
    
    @Override
    public void run() {
        EmbeddedMediaPlayerComponent c = new EmbeddedMediaPlayerComponent();
        
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setContentPane(c);
        f.setBounds(new Rectangle(200,200,800,600));
        f.addWindowListener(new WindowAdapter() {
        
            @Override
            public void windowClosing(WindowEvent e){
                c.release();
            }
        });
        
        f.setVisible(true);
        
        c.mediaPlayer().media().play(this.dir + this.path);
    }
}
