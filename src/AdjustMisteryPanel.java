import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;



public class AdjustMisteryPanel extends JPanel {
	
	private int r = 0;
	private int g = 100;
	private int b = 0;
	
	private JScrollBar scroll1;
	private JScrollBar scroll2;
	private JScrollBar scroll3;
	private JPanel colorresult;
	
	public AdjustMisteryPanel() {
		super(new GridLayout(1, 4, 5, 10));
		
		scroll1 = new JScrollBar(JScrollBar.VERTICAL, 0, 10, 0, 265);
		scroll2 = new JScrollBar(JScrollBar.VERTICAL, 0, 10, 0, 265);
		scroll3 = new JScrollBar(JScrollBar.VERTICAL, 0, 10, 0, 265);
		colorresult = new JPanel(new FlowLayout());
		
		super.add(scroll1);
		super.add(scroll2);
		super.add(scroll3);
		super.add(colorresult);
		
		scroll1.addAdjustmentListener(new ScrollbarListener());
		scroll2.addAdjustmentListener(new ScrollbarListener());
		scroll3.addAdjustmentListener(new ScrollbarListener());
	}

	private class ScrollbarListener implements AdjustmentListener{

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		
		colorresult.setBackground(new Color(r, g, b));

	}
	
}
	

}



