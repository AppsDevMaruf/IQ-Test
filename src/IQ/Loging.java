package IQ;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import IQ.Signup;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Loging extends JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTextField usernameTF;
	private JPasswordField passField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loging frame = new Loging();
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
	public Loging() {
		design();

		conn = SQLConnection.connecrDb();
	}

	private void login() {
		try {
			String query = "SELECT * FROM login WHERE Email=? AND Password =?";
			pst = (PreparedStatement) conn.prepareStatement(query);
			//pst = conn.prepareStatement(query);
			pst.setString(1, usernameTF.getText());
			pst.setString(2, passField.getText());
			rs = pst.executeQuery();
			if (rs.next()) {

				//JOptionPane.showMessageDialog(null, "Login Successfull");
				QuestionFm Qfm = new QuestionFm();
				Qfm.setVisible(true);
				dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Try again");
			}
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void center() {
		Dimension screenSize, frameSize;
		int x, y;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = getSize();
		x = (screenSize.width - frameSize.width) / 2;
		y = (screenSize.height - frameSize.height) / 2;
		setLocation(x, y);
	}
	private void design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAdminSupport = new JButton("Admin Support ");
		btnAdminSupport.setBounds(515, 148, 129, 23);
		contentPane.add(btnAdminSupport);

		JLabel lblUsername = new JLabel("EMAIL :");
		lblUsername.setBounds(388, 297, 95, 14);
		lblUsername.setFont(new Font("Sitka Text", Font.BOLD, 12));
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(388, 354, 95, 14);
		lblPassword.setFont(new Font("Sitka Text", Font.BOLD, 12));
		contentPane.add(lblPassword);

		JLabel lbpass = new JLabel("");
		lbpass.setBounds(338, 362, 40, 37);
		lbpass.setIcon(new ImageIcon(Loging.class.getResource("/IQ_Folder/icons8-lock-40.png")));
		contentPane.add(lbpass);

		JLabel lbuser = new JLabel("");
		lbuser.setBounds(338, 297, 40, 46);
		lbuser.setIcon(new ImageIcon(Loging.class.getResource("/IQ_Folder/icons8-user-40.png")));
		contentPane.add(lbuser);

		passField = new JPasswordField();
		passField.setBounds(388, 371, 161, 30);
		passField.setForeground(Color.LIGHT_GRAY);
		passField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passField.setBackground(new Color(245, 245, 245));
		contentPane.add(passField);

		usernameTF = new JTextField();
		usernameTF.setBounds(388, 313, 161, 30);
		usernameTF.setForeground(Color.LIGHT_GRAY);
		usernameTF.setFont(new Font("Tahoma", Font.BOLD, 13));
		usernameTF.setColumns(10);
		usernameTF.setBackground(new Color(245, 245, 245));
		contentPane.add(usernameTF);
		
				JButton button_1 = new JButton("Creat new");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
			Signup s = new Signup();
					s.setVisible(true);
					dispose();
						
					}
				});
				
						JLabel blnlabel = new JLabel("Create Account");
						blnlabel.setBounds(162, 410, 144, 38);
						blnlabel.setIcon(new ImageIcon(Loging.class.getResource("/IQ_Folder/create account.png")));
						contentPane.add(blnlabel);
				button_1.setBounds(162, 410, 140, 37);
				button_1.setForeground(new Color(50, 205, 50));
				button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				button_1.setBackground(Color.WHITE);
				contentPane.add(button_1);

		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (usernameTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter UserName");
				} else if (passField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Password");
				} else {
                  login();
				}
				
			}
		});
		button.setBounds(398, 412, 145, 37);
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("Sitka Text", Font.BOLD, 14));
		button.setBackground(Color.WHITE);
		contentPane.add(button);

		JLabel lblIfYouArent = new JLabel("if you aren't registed singup here...");
		lblIfYouArent.setBounds(59, 362, 247, 37);
		lblIfYouArent.setForeground(Color.BLACK);
		lblIfYouArent.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblIfYouArent.setBackground(Color.BLACK);
		contentPane.add(lblIfYouArent);

		JLabel fullbackground = new JLabel("");
		fullbackground.setBounds(-27, -15, 683, 500);
		fullbackground.setIcon(new ImageIcon(Loging.class.getResource("/IQ_Folder/iq-testbackground.jpg")));
		contentPane.add(fullbackground);
	}
}

