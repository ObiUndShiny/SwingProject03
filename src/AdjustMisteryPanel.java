import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;



public class AdjustMisteryPanel extends JPanel {
	
	private int red;
	private int green;
	private int blue;
	
	public AdjustMisteryPanel() {
		super(new GridLayout(1, 3, 5, 10));
		
		JScrollBar scroll1 = new JScrollBar(JScrollBar.VERTICAL, 0, 10, 0, 265);
		JScrollBar scroll2 = new JScrollBar(JScrollBar.VERTICAL, 0, 10, 0, 265);
		JScrollBar scroll3 = new JScrollBar(JScrollBar.VERTICAL, 0, 10, 0, 265);
		
		super.add(scroll1);
		super.add(scroll2);
		super.add(scroll3);
		
		scroll1.addAdjustmentListener(new ScrollbarListener());
		scroll2.addAdjustmentListener(new ScrollbarListener());
		scroll3.addAdjustmentListener(new ScrollbarListener());
	}

	private class ScrollbarListener implements AdjustmentListener{

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		
		
		
	}
	
	
}

}



