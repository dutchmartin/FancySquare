import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class DrawPanel extends JPanel {
	private Color myColor = Color.WHITE;
	private double scaling = 1.0;
	DrawPanel(){
		this.setPreferredSize(new Dimension(300, 300));
		this.setBackground(Color.WHITE);
	}
	void setColor(Color c){
		myColor = c;
	}
	void setScaling(int scale){
		scaling = 1.0 + ((double)scale)/100;
	}
	public void paintComponent(Graphics g){
		super.paintComponent( g );
		int height = (int) Math.round( 180 * scaling );
		int width = (int) Math.round( 180 * scaling );
		int x = this.getHeight() / 2 - ( width / 2 );
		int y = this.getWidth() / 2 - ( height / 2 );
		g.setColor( myColor );
		g.fillRect( x, y, width, height );
		g.setColor( Color.BLACK );
		g.drawRect( x, y, width, height );
	} }