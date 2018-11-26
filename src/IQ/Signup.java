package IQ;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField NameTF;
	private JTextField EmailTF;
	private JTextField UsernameTF;
	private JTextField passwordTF;
	private JTextField AgeTF;
	private JTextField ContractTF;
	private JTextField HightTF;
	private JLabel clocklabel;
	private JRadioButton rdbtnMale, rdbtnFemale;
	private JComboBox AddressCB;
	private JCheckBox chckbxNewCheckBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	String v = "";
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		design();
		center();
		conn = SQLConnection.connecrDb();
		clock();
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

	private void SignUp() {
		try {
			String query = "INSERT INTO Student_info (Name,Email,User_name,Password,Age,Contract,Gender,Hight,Address) VALUES (?,?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, NameTF.getText());
			pst.setString(2, EmailTF.getText());
			pst.setString(3, UsernameTF.getText());
			pst.setString(4, passwordTF.getText());
			pst.setString(5, AgeTF.getText());
			pst.setString(6, ContractTF.getText());
			if (rdbtnMale.isSelected()) {
				v = rdbtnMale.getText().toString();
			} else if (rdbtnFemale.isSelected()) {
				v = rdbtnFemale.getText().toString();
			} else {
				JOptionPane.showMessageDialog(null, "Select Gender");
			}
			pst.setString(7, String.valueOf(v));
			pst.setString(8, HightTF.getText());
			pst.setString(9, AddressCB.getSelectedItem().toString());
			pst.execute();
			pst.close();
			JOptionPane.showMessageDialog(null, "SignUp Successfull");
			Loging fj = new Loging();
			fj.setVisible(true);
			dispose();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					for (;;) {
						Calendar cal = new GregorianCalendar();
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
						Date date = cal.getTime();
						String timeString = formatter.format(date);
						clocklabel.setText(timeString);
						sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

	private void design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 415);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		NameTF = new JTextField();
		NameTF.setBounds(117, 55, 166, 20);
		contentPane.add(NameTF);
		NameTF.setColumns(10);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(20, 58, 46, 14);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblName);

		EmailTF = new JTextField();
		EmailTF.setBounds(117, 83, 166, 20);
		EmailTF.setColumns(10);
		contentPane.add(EmailTF);

		UsernameTF = new JTextField();
		UsernameTF.setBounds(117, 118, 166, 20);
		UsernameTF.setColumns(10);
		contentPane.add(UsernameTF);

		passwordTF = new JTextField();
		passwordTF.setBounds(117, 149, 166, 20);
		passwordTF.setColumns(10);
		contentPane.add(passwordTF);

		AgeTF = new JTextField();
		AgeTF.setBounds(117, 180, 166, 20);
		AgeTF.setColumns(10);
		contentPane.add(AgeTF);

		ContractTF = new JTextField();
		ContractTF.setBounds(117, 211, 166, 20);
		ContractTF.setColumns(10);
		contentPane.add(ContractTF);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(20, 86, 46, 14);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblEmail);

		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(20, 118, 87, 14);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblUserName);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(20, 152, 87, 14);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblPassword);

		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(20, 183, 46, 14);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblAge);

		JLabel lblContract = new JLabel("Contract :");
		lblContract.setBounds(20, 214, 87, 14);
		lblContract.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblContract);

		JLabel lblGander = new JLabel("Gander :");
		lblGander.setBounds(20, 239, 87, 14);
		lblGander.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblGander);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(117, 235, 109, 23);
		rdbtnMale.setFont(new Font("Sitka Text", Font.BOLD, 11));
		buttonGroup.add(rdbtnMale);
		contentPane.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(225, 235, 125, 23);
		rdbtnFemale.setFont(new Font("Sitka Text", Font.BOLD, 11));
		buttonGroup.add(rdbtnFemale);
		contentPane.add(rdbtnFemale);

		JLabel lblSalary = new JLabel("Hight :");
		lblSalary.setBounds(20, 264, 46, 14);
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblSalary);

		HightTF = new JTextField();
		HightTF.setBounds(117, 261, 166, 20);
		contentPane.add(HightTF);
		HightTF.setColumns(10);

		JLabel lblAdderss = new JLabel("Address :");
		lblAdderss.setBounds(20, 289, 76, 14);
		lblAdderss.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblAdderss);

		JList list = new JList();
		list.setBounds(117, 300, 109, -11);
		contentPane.add(list);

		AddressCB = new JComboBox();
		AddressCB.setBounds(117, 288, 166, 17);
		AddressCB.setFont(new Font("Sitka Text", Font.BOLD, 14));
		AddressCB.setModel(
				new DefaultComboBoxModel(new String[] { "Main Campus", "Permanent Campus", "Uttara Campus" }));
		contentPane.add(AddressCB);

		chckbxNewCheckBox = new JCheckBox("I accept All trems and condition");
		chckbxNewCheckBox.setBounds(109, 312, 379, 23);
		chckbxNewCheckBox.setFont(new Font("Sitka Text", Font.BOLD, 11));
		contentPane.add(chckbxNewCheckBox);

		JButton btnSingup = new JButton("SignUp");
		btnSingup.setBounds(119, 342, 89, 23);
		btnSingup.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnSingup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox.isSelected()) {
					SignUp();
				} else {
					JOptionPane.showMessageDialog(null, "Read Carefully");

				}

			}
		});
		contentPane.add(btnSingup);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 0, 345, 42);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\sign-up-button-png-18.png"));
		contentPane.add(lblNewLabel);

		clocklabel = new JLabel("clock");
		clocklabel.setBounds(348, 28, 195, 14);
		contentPane.add(clocklabel);
	}
}
