import com.sun.tools.javac.code.Attribute;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.function.Function;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
@SuppressWarnings( "serial" )
class ControlPanel extends JPanel {
	private String[] colors = {"Red", "Yellow", "Blue"};
	private DrawPanel drawPanel;
	private JSlider slider;

	ControlPanel( DrawPanel drawPanel ) {
		ArrayList<JRadioButton> radioButtons = new ArrayList<>();
		Hashtable<Integer, JLabel> labelHashTable = new Hashtable<Integer, JLabel>();
		this.drawPanel = drawPanel;
		this.slider = new JSlider( SwingConstants.VERTICAL,-50, 50, 0 );
		this.slider.setLabelTable( slider.createStandardLabels(50 ) );
		this.slider.addChangeListener( change -> stateChanged() );
		this.add( slider );
		ButtonGroup buttonGroup = new ButtonGroup();
		for ( String s: colors ) {
			JRadioButton rb = new JRadioButton( s );
			radioButtons.add( rb );
			buttonGroup.add( rb );
			rb.addActionListener( e -> this.setDrawPanelColor( switchColor( rb.getText() ) ) );
		}
		radioButtons.forEach( this::add );
		this.setLayout(new BoxLayout(this , BoxLayout.Y_AXIS ) );
		Arrays.stream( this.getComponents() )
				.filter( c -> c instanceof JRadioButton )
				.findFirst()
				.map( c -> ( JRadioButton ) c )
				.ifPresent( JRadioButton::doClick );
	}
	private void setDrawPanelColor( Color color ) {
		drawPanel.setColor(color);
		drawPanel.repaint();
	}

	private void setDrawPanelScaling(int size) {
		drawPanel.setScaling(size);
		drawPanel.repaint();
	}

	/**
	* Convert a color name to a java swing Color object.
	*
	* @param color The string you want the color object of.
	*
	* @return The java Color object.
	*/
	private Color switchColor( String color ){
		switch ( color ){
			case "Red": return Color.RED;
			case "Yellow": return Color.YELLOW;
			case "Blue": return Color.BLUE;
			default: return Color.white;
		}
	}

	private void stateChanged(){
		setDrawPanelScaling( slider.getValue() );
	}
}