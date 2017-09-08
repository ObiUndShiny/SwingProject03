
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	public MainFrame() {
		try {
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		contentPane.setLayout(new GridLayout(1, 3, 50, 10));
		super.setSize(new Dimension(900, 400));
		super.setTitle("Mistery");
		super.setResizable(false);
		
		ControlPanel control_panel = new ControlPanel();
		
		CodeMisteryPanel cpanel = new CodeMisteryPanel(control_panel);
		AdjustMisteryPanel apanel = new AdjustMisteryPanel(control_panel);
		
		contentPane.add(cpanel);
		contentPane.add(control_panel);
		contentPane.add(apanel);

	}

}
