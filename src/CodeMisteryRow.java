import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CodeMisteryRow extends JPanel {
	
	private static int ELEMENTS = 5;
	
	private JButton[] buttons;
	
	private int[] solutions;
	private int tries;
	
	private ActionListener alistener;
	
	public CodeMisteryRow(int[] solutions, ActionListener alistener) {
		
		super(new GridLayout(1, ELEMENTS, 10, 10));
		
		this.buttons = new JButton[ELEMENTS];
		this.alistener = alistener;
		
		this.solutions = solutions;
		
		Random random = new Random();
		
		ButtonListener listener = new ButtonListener();
		
		for (int n = 0; n < ELEMENTS; n++) {
			
			buttons[n] = new JButton(""+(random.nextInt(ELEMENTS)+1));
			buttons[n].setName(""+(n+1));
			buttons[n].addActionListener(listener);
			super.add(buttons[n]);
			
		}
		
	}
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() instanceof JButton) {
				
				JButton button = (JButton) e.getSource();
				int slot = Integer.parseInt(button.getName());
				
				if (slot == solutions[tries]) {
					tries++;
				} else {
					tries = 0;
				}
				
				if (tries == 3) {
					finish();
				}
				
			}
			
		}
		
	}
	
	private void finish() {
		
		for (JButton button : buttons) {
			
			button.setEnabled(false);
			
		}
		
		if (alistener!=null) {
			alistener.actionPerformed(null);
		}
		
	}

	public int[] getSolution() {
		
		int[] solutions = new int[3];
		
		for (int n = 0;n < 3;n++) {
			int slot = this.solutions[n];
			int value = Integer.parseInt(buttons[slot-1].getText());
			solutions[n] = value;
		}
		
		return solutions;
		
	}
	
}
