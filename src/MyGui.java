import javax.swing.*;

@SuppressWarnings("serial")
class MyGui extends JFrame{
	MyGui(){
		MyContentPane myContentPane = new MyContentPane();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
		this.setContentPane(myContentPane);
		this.pack();
		this.setVisible(true);
	}
}