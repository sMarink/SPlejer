
package mp3player;
   
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Mp3PlayerGUI extends java.awt.Dialog {
Mp3Player DTI = new Mp3Player();
Mp3Player MP = new Mp3Player();
    
    public static int count;
    int xMouse;
    int yMouse;

    int width = (Toolkit.getDefaultToolkit().getScreenSize().width /2) -185;
    int height = Toolkit.getDefaultToolkit() .getScreenSize().height -180;

    public Mp3PlayerGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(960-240, 240);
        setResizable(false);
        setBackground(Color.CYAN);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoopCounter = new javax.swing.JLabel();
        Display = new javax.swing.JLabel();
        pause = new javax.swing.JLabel();
        stop = new javax.swing.JLabel();
        play = new javax.swing.JLabel();
        add = new javax.swing.JLabel();
        loop = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoopCounter.setBackground(new java.awt.Color(102, 102, 102));
        LoopCounter.setForeground(new java.awt.Color(0, 204, 204));
        add(LoopCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 80, 30));

        Display.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        Display.setForeground(new java.awt.Color(0, 255, 255));
        Display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Display, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 30));

        pause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pauseMouseReleased(evt);
            }
        });
        add(pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 50, 50));

        stop.setToolTipText("");
        stop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                stopMouseReleased(evt);
            }
        });
        add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 50, 50));

        play.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playMouseReleased(evt);
            }
        });
        add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 50, 60));

        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addMouseReleased(evt);
            }
        });
        add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 30, 30));

        loop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loopMouseReleased(evt);
            }
        });
        add(loop, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 30, 30));

        background.setBackground(new java.awt.Color(51, 0, 51));
        background.setForeground(new java.awt.Color(0, 0, 0));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp3player/background.png"))); // NOI18N
        background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                backgroundMouseDragged(evt);
            }
        });
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backgroundMousePressed(evt);
            }
        });
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 370, 150));

        getAccessibleContext().setAccessibleName("Mp3Player");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void stopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseReleased
       MP.Stop();
    }//GEN-LAST:event_stopMouseReleased

    private void backgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_backgroundMousePressed

    private void backgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseDragged
       int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();
       
       this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_backgroundMouseDragged

    private void playMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseReleased
      
      MP.Resume();
    }//GEN-LAST:event_playMouseReleased

    private void pauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseMouseReleased
     MP.Pause();
    }//GEN-LAST:event_pauseMouseReleased

    private void addMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseReleased
       
        FileFilter filter = new FileNameExtensionFilter ("MP3 Files","mp3","mpeg3");
        
        JFileChooser chooser = new JFileChooser ("D:\\Music");
        chooser.addChoosableFileFilter(filter);
        
            int returnVal = chooser.showOpenDialog(null);
            
                if (returnVal == JFileChooser.APPROVE_OPTION)
                {
                    MP.Stop();
                    
                    File myFile = chooser.getSelectedFile();
                    String song = myFile + "";
                    
                    String name = chooser.getSelectedFile() .getName();
                    Display.setText (name);
              
                    MP.Play(song);
                }
               
   
    }//GEN-LAST:event_addMouseReleased

    private void loopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loopMouseReleased
       switch(count)
       {
               case 0:
               count=1;
               LoopCounter.setText("Loop On");
               break;
               
               case 1 :
               count =0;
               LoopCounter.setText("Loop Off");   
               break;
       }
    }//GEN-LAST:event_loopMouseReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() 
            {
                Mp3PlayerGUI dialog = new Mp3PlayerGUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() 
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) 
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Display;
    private javax.swing.JLabel LoopCounter;
    private javax.swing.JLabel add;
    private javax.swing.JLabel background;
    private javax.swing.JLabel loop;
    private javax.swing.JLabel pause;
    private javax.swing.JLabel play;
    private javax.swing.JLabel stop;
    // End of variables declaration//GEN-END:variables

  
}