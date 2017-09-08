import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class ControlPanel extends JPanel {

	private JPanel code_unlock;
	private JPanel adjustment_unlock;
	
	private int time;
	private JLabel time_label;
	private Timer timer;
	private JButton stop_bomb;

	public ControlPanel() {
		super(new BorderLayout());
		
		this.time = 60;
		
		time_label = new JLabel("01:00", SwingConstants.CENTER);
		time_label.setFont(new Font("Comic Sans", Font.BOLD, 40));
		
		JPanel unlockeded = new JPanel(new GridLayout(1, 2, 25, 25));
		
		code_unlock = new JPanel();
		code_unlock.setBackground(Color.RED);
		code_unlock.setBorder(new EmptyBorder(60, 20, 60, 20));
		
		adjustment_unlock = new JPanel();
		adjustment_unlock.setBackground(Color.RED);
		adjustment_unlock.setBorder(new EmptyBorder(60, 20, 60, 20));
		
		unlockeded.add(code_unlock);
		unlockeded.add(adjustment_unlock);
		
		timer = new Timer(1000, new TimerListener());
		timer.start();
		
		stop_bomb = new JButton("STOP THE BOMB!");
		stop_bomb.setEnabled(false);
		stop_bomb.addActionListener(new StopListener());
		super.add(stop_bomb, BorderLayout.NORTH);
		
		super.add(unlockeded, BorderLayout.SOUTH);
		super.add(time_label);
		
	}
	
	private class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			time--;
			
			setTime();
			
			if (time == 0) {
				
				timer.stop();
				JOptionPane.showMessageDialog(null, "Kaaabuuum!!", "Bombe", JOptionPane.WARNING_MESSAGE);
				
			}
			
		}
		
	}
	
	private class StopListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			timer.stop();
			JOptionPane.showMessageDialog(null, "Sie haben die Bombe entschärft!", "Glückwunsch!", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
	
	private void setTime() {
		
		int minutes = time/60;
		int seconds = time%60;
		
		String formatted_minutes = String.format("%02d", minutes);
		String formatted_seconds = String.format("%02d", seconds);
		
		time_label.setText(formatted_minutes+":"+formatted_seconds);
		
	}
	
	private boolean isSolved() {
		
		if (code_unlock.getBackground()==Color.GREEN &&
				adjustment_unlock.getBackground()==Color.GREEN) {
			
			return true;
			
		}
		
		return false;
		
	}

	public void solveCodeMistery() {
		code_unlock.setBackground(Color.GREEN);
		if (isSolved()) {
			stop_bomb.setEnabled(true);
		}
	}

	public void solveAdjustmentMistery() {
		adjustment_unlock.setBackground(Color.GREEN);
		if (isSolved()) {
			stop_bomb.setEnabled(true);
		}
	}
	
}
