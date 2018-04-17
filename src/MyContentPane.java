import java.awt.BorderLayout;
import javax.swing.JPanel;
@SuppressWarnings("serial")
class MyContentPane extends JPanel{
	MyContentPane(){
		DrawPanel myDrawPanel = new DrawPanel();
		ControlPanel myRBPanel = new ControlPanel(myDrawPanel);
		this.setLayout(new BorderLayout());
		this.add(myDrawPanel, BorderLayout.CENTER);
		this.add(myRBPanel, BorderLayout.LINE_END);
	} }