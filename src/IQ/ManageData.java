package IQ;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.JTable;

public class ManageData extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageData frame = new ManageData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 237, 735, 225);
		tabbedPane.setBackground(SystemColor.activeCaption);
		contentPane.add(tabbedPane);
		
		JPanel QuestionSet = new JPanel();
		QuestionSet.setToolTipText("Q");
		QuestionSet.setFont(new Font("Serif", Font.BOLD, 12));
		tabbedPane.addTab("New tab", null, QuestionSet, null);
		QuestionSet.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 674, 197);
		QuestionSet.add(table);
		
		JPanel Loging = new JPanel();
		tabbedPane.addTab("New tab", null, Loging, null);
		
		JPanel Admin = new JPanel();
		tabbedPane.addTab("New tab", null, Admin, null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 232, 855, 230);
		panel.setBackground(SystemColor.textHighlight);
		contentPane.add(panel);
	}
}
