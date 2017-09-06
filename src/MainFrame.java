
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
		super.setSize(new Dimension(300, 400));
		super.setTitle("123");

	}

}
