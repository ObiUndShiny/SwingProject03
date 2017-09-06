import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class AdjustMisteryPanel extends JPanel {
	
	public AdjustMisteryPanel() {
		super(new GridLayout(1, 3, 5, 10));
		
		JScrollBar scroll1 = new JScrollBar(JScrollBar.VERTICAL, 50, 10, 0, 110);
		JScrollBar scroll2 = new JScrollBar(JScrollBar.VERTICAL, 50, 10, 0, 110);
		JScrollBar scroll3 = new JScrollBar(JScrollBar.VERTICAL, 50, 10, 0, 110);
		
		super.add(scroll1);
		super.add(scroll2);
		super.add(scroll3);
		
	}
	
}
