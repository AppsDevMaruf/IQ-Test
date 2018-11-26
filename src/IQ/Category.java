package IQ;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Category extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox catagotycb;
	private JComboBox dificultycb;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Category frame = new Category();
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
	public Category() {
		design();
		conn = SQLConnection.connecrDb();
	}
	private void SearchData() {
		try {
			String selection = (String) catagotycb.getSelectedItem();
			String query = "Select qCat,qtype FROM question WHERE " + selection
					+ " LIKE '" + dificultycb.getSelectedItem() + "%'";
			pst = conn.prepareStatement(query);
			textPane.setText(rs.getString("Question"));
			// pst.setString(1, SearchTF.getText());
			rs = pst.executeQuery();
			//textPane.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void design()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYour = new JLabel(" Select Your Category");
		lblYour.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblYour.setBounds(108, 16, 247, 14);
		contentPane.add(lblYour);
		
		 catagotycb = new JComboBox();
		catagotycb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		catagotycb.setModel(new DefaultComboBoxModel(new String[] {".....", "Math", "Programming", "Java"}));
		catagotycb.setBounds(41, 167, 117, 20);
		contentPane.add(catagotycb);
		
		 dificultycb = new JComboBox();
		dificultycb.setModel(new DefaultComboBoxModel(new String[] {"...", "Easy ", "Normal", "Hard"}));
		dificultycb.setBounds(199, 167, 96, 20);
		contentPane.add(dificultycb);
		
		JButton btnNext = new JButton("next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchData();
			}
		});
		btnNext.setBounds(335, 213, 89, 23);
		contentPane.add(btnNext);
		
 textPane = new JTextPane();
		textPane.setBounds(10, 35, 414, 116);
		contentPane.add(textPane);
	}
}
