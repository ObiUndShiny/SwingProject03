
import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.*;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	public MainFrame() {
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			FrameInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Component initialization.
	 *
	 * @throws java.lang.Exception
	 */
	private void FrameInit() throws Exception {
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(new BorderLayout());
		super.setSize(new Dimension(600, 400));
		super.setTitle("Mistery");
		
		ControlPanel control_panel = new ControlPanel();
		CodeMisteryPanel cpanel = new CodeMisteryPanel();
		AdjustMisteryPanel apanel = new AdjustMisteryPanel();
		
		contentPane.add(control_panel, BorderLayout.CENTER);
		contentPane.add(cpanel, BorderLayout.WEST);
		contentPane.add(apanel, BorderLayout.EAST);

	}

}
