
package mp3player;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;

import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Mp3Player {
   
   FileInputStream FIS;
   BufferedInputStream BIS;
   public Player player;
   public long pauseLocation;
   public long songTotalLength;
   public String fileLocation;
   static TrayIcon trayIcon;  
 
   public Mp3Player()
    
   {
       ShowTrayIcon();
   }
   public static void ShowTrayIcon()
   {
       if(!SystemTray.isSupported())
   {
       System.out.println("Your PC Sucks");
       System.exit(0);
       return;
   }
       
       
       
       final PopupMenu popup = new PopupMenu();
       trayIcon = new TrayIcon (CreateIcon("/Images/ikonica.png","Tray Icon"));
       trayIcon.setToolTip("SPleyer-versionBETA");
       final SystemTray tray = SystemTray.getSystemTray();
      
       //Add components// menu items
        MenuItem Open = new MenuItem("Open");
        MenuItem Exit = new MenuItem("Exit");
        
       //Populate
       popup.add(Open);
       popup.addSeparator();
       popup.add(Exit);
       
       trayIcon.setPopupMenu(popup);
        
       Open.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              ImageIcon icon = new ImageIcon ("/Images/Image.jpg");
              JOptionPane.showMessageDialog(null,"Welcome", "SPlayer", JOptionPane.INFORMATION_MESSAGE, icon);
           }
       });
        
       Exit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
             ImageIcon icon = new ImageIcon ("/Images/Image.jpg");
              JOptionPane.showMessageDialog(null,"Thanks For Listening!", "SPlayer", JOptionPane.INFORMATION_MESSAGE, icon);
              tray.remove(trayIcon);
              System.exit(0);
           }
       });
       
       
       try
       {
           tray.add(trayIcon);
       }
       catch(AWTException e)
       {
           
       }
   }
       
   protected static Image CreateIcon(String path, String desc)
   {
       URL ImageURL = Mp3Player.class.getResource(path);
       return (new ImageIcon(ImageURL, desc)).getImage();
       
   }
   
   public void Stop()
   {
       if(player != null)
       {
          player.close(); 
          
          pauseLocation = 0;
          songTotalLength = 0;
          
          Mp3PlayerGUI.Display.setText("");
       }
      
    }
   
     public void Pause()
   {
       if(player != null)
       {
           try {
             pauseLocation = FIS.available();
              player.close(); 
               
           } catch (IOException ex)
           {
        
           }
  
       }
      
    }
     
 public void Resume()
 {
     
 try
     {
    FIS = new FileInputStream(fileLocation);
    BIS = new BufferedInputStream(FIS);
    
     try {
         player = new Player (BIS);
         FIS.skip(songTotalLength - pauseLocation);
         
     }
     catch (JavaLayerException ex) {
        
     } catch (IOException ex) {
         Logger.getLogger(Mp3Player.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
 catch (FileNotFoundException ex) 
 {

 }
 
   new Thread()
    {
        @Override
        public void run()
        {
            try 
            {
                player.play();
            } 
            catch (JavaLayerException ex) 
            {
                
            }
        }
        }.start();
 
    }

   
   
 public void Play(String path)
 {
     
 try
     {
    FIS = new FileInputStream(path);
    BIS = new BufferedInputStream(FIS);
    
    songTotalLength = FIS.available();
    fileLocation = path + "";
     try {
         player = new Player (BIS);
         
     }
     catch (JavaLayerException ex) {
        
     }
 }
 catch (FileNotFoundException ex) 
 {

 }     catch (IOException ex) {
           Logger.getLogger(Mp3Player.class.getName()).log(Level.SEVERE, null, ex);
       }
 
   new Thread()
    {
        @Override
        public void run()
        {
            try 
            {
                player.play();
                if(player.isComplete() && Mp3PlayerGUI.count == 1)
                {
                    Play("fileLocation");
                }
                if (player.isComplete())
                {
                    Mp3PlayerGUI.Display.setText("");
                }
            } 
            catch (JavaLayerException ex) 
            {
                
            }
        }
        }.start();
 
    }
 public String File (String filename)
   {
       String line = null;
       try
       {
           File myFile = new File(filename);
           FileReader filereader = new FileReader (myFile);
           
           BufferedReader reader = new BufferedReader (filereader);
           
           while((line = reader.readLine()) != null)
           {
               System.out.println(line);
           }
       }
       catch (IOException ex)
       {
           
       }
       return line;
   }
}


 