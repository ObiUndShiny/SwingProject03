import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

public class AdjustMisteryPanel extends JPanel {

	private static final float LIMIT = 0.99f;
	
	private int r = 0;
	private int g = 0;
	private int b = 0;
	
	private int tr = 0;
	private int tg = 0;
	private int tb = 0;

	private JScrollBar scroll1;
	private JScrollBar scroll2;
	private JScrollBar scroll3;
	
	private JPanel actualresult;
	private JPanel colorresult;
	
	private ControlPanel control_panel;


	public AdjustMisteryPanel(ControlPanel control_panel) {
		super(new BorderLayout());

		this.control_panel = control_panel;
		
		JPanel bars = new JPanel(new GridLayout(1, 4, 5, 10));
		colorresult = new JPanel(new FlowLayout());
		actualresult = new JPanel(new FlowLayout());
				
		scroll1 = new JScrollBar(JScrollBar.VERTICAL, 255, 10, 0, 265);
		scroll1.setName("r");
		scroll2 = new JScrollBar(JScrollBar.VERTICAL, 255, 10, 0, 265);
		scroll2.setName("g");
		scroll3 = new JScrollBar(JScrollBar.VERTICAL, 255, 10, 0, 265);
		scroll3.setName("b");
		
		bars.add(scroll1);
		bars.add(scroll2);
		bars.add(scroll3);
		
		super.add(bars);
		
		Random random = new Random();
		
		colorresult.setBorder(new EmptyBorder(25, 20, 25, 20));
		tr = random.nextInt(256);
		tg = random.nextInt(256);
		tb = random.nextInt(256);
		colorresult.setBackground(new Color(tr,tg,tb));
		super.add(colorresult, BorderLayout.SOUTH);
		
		actualresult.setBorder(new EmptyBorder(25, 20, 25, 20));
		actualresult.setBackground(new Color(r, g, b));
		super.add(actualresult, BorderLayout.NORTH);

		ScrollbarListener listener = new ScrollbarListener();
		scroll1.addAdjustmentListener(listener);
		scroll2.addAdjustmentListener(listener);
		scroll3.addAdjustmentListener(listener);
		
	}

	private class ScrollbarListener implements AdjustmentListener {

		public void adjustmentValueChanged(AdjustmentEvent e) {
			
			if (e.getSource() instanceof JScrollBar) {
				
				JScrollBar bar = (JScrollBar) e.getSource();
				String color = bar.getName();
				
				switch (color) {
				case "r":
					r = 255-e.getValue();
					break;
				case "g":
					g = 255-e.getValue();
					break;
				case "b":
					b = 255-e.getValue();
					break;
				}
				
				
				actualresult.setBackground(new Color(r, g, b));
			}
			
			if (checkColor()) {
				
				scroll1.setEnabled(false);
				scroll2.setEnabled(false);
				scroll3.setEnabled(false);
				
			}

		}

	}
	
	private boolean checkColor() {
		
		if ((r*1.0)/tr > LIMIT && (g*1.0)/tg > LIMIT && (b*1.0)/tb > LIMIT) {
			control_panel.solveAdjustmentMistery();
			return true;
		}
		
		return false;
	}

}
