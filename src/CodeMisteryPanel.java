import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CodeMisteryPanel extends JPanel {
	
	private ControlPanel control_panel;
	
	public CodeMisteryPanel(ControlPanel control_panel) {
		super();
		
		Random random = new Random();
		this.control_panel = control_panel;
		
		int[] solutions = new int[3];
		solutions[0] = 1+random.nextInt(5);
		solutions[1] = 1+random.nextInt(5);
		solutions[2] = 1+random.nextInt(5);
		
		JLabel start_code = new JLabel(solutions[0]+" | "+solutions[1]+" | "+solutions[2]);
		start_code.setFont(new Font("Arial", Font.BOLD, 30));
		super.add(start_code);
		CodeMisteryRow row1 = new CodeMisteryRow(solutions, null);
		super.add(row1);
		CodeMisteryRow row2 = new CodeMisteryRow(row1.getSolution(), null);
		super.add(row2);
		CodeMisteryRow row3 = new CodeMisteryRow(row2.getSolution(), new LastRowFinishListener());
		super.add(row3);
		row1.getSolution();
		
	}
	
	private class LastRowFinishListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			control_panel.solveCodeMistery();
			
		}
		
	}

}
