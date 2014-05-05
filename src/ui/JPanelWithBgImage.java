package ui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class JPanelWithBgImage extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon bgImage;
 
	public JPanelWithBgImage(ImageIcon ii) {
         super();
         this.bgImage = ii;
         setOpaque(true);
      }

	public void paintComponent(Graphics g) {
         super.paintComponent(g);
         if (bgImage != null) {
            Dimension size = this.getSize();
            g.drawImage(bgImage.getImage(), 0,0, size.width, size.height, this);
         }
      }
   }