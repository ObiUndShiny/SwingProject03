import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ControlPanel extends JPanel {

	private JPanel code_unlock;
	private JPanel adjustment_unlock;

	public ControlPanel() {
		super(new BorderLayout());
		
		JLabel time = new JLabel("01:00", SwingConstants.CENTER);
		time.setFont(new Font("Comic Sans", Font.BOLD, 40));
		
		JPanel unlockeded = new JPanel(new GridLayout(1, 2, 25, 25));
		
		code_unlock = new JPanel();
		code_unlock.setBackground(Color.RED);
		code_unlock.setBorder(new EmptyBorder(80, 20, 80, 20));
		
		adjustment_unlock = new JPanel();
		adjustment_unlock.setBackground(Color.RED);
		adjustment_unlock.setBorder(new EmptyBorder(80, 20, 80, 20));
		
		unlockeded.add(code_unlock);
		unlockeded.add(adjustment_unlock);
		
		super.add(unlockeded, BorderLayout.SOUTH);
		
		super.add(time);
		
	}

	public JPanel getCodeUnlock() {
		return code_unlock;
	}

	public JPanel getAdjustmentUnlock() {
		return adjustment_unlock;
	}
	
}
