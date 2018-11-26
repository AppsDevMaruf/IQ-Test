package IQ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import IQ.SQLConnection;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addinfo extends JFrame {

	private JPanel contentPane;
	private JTextField QuestionTF;
	private JLabel lblOptionA;
	private JTextField OptionATF;
	private JLabel lblOptionB;
	private JTextField OptionBTF;
	private JLabel lblOptionC;
	private JTextField OptionCTF;
	private JLabel lblOptionD;
	private JTextField OptionDTF;
	private JLabel lblCorrectAnswer;
	private JTextField CorrectAnswerTF;
	private JLabel QuestionCategorieslebel;
	private JLabel lblQuestiontype;
	private JComboBox QuestionTypeCB,QuestionCategoriesCB;
	private JButton  btnRestart,btnAdd;
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
					Addinfo frame = new Addinfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	private void Reset() {
		QuestionTF.setText(null);
		OptionATF.setText(null);
		OptionBTF.setText(null);
		OptionCTF.setText(null);
		OptionDTF.setText(null);
		CorrectAnswerTF.setText(null);
		QuestionCategoriesCB.setSelectedItem(null);
		QuestionTypeCB.setSelectedItem(null);
	}
	public void Addinfom() {
		conn = SQLConnection.connecrDb();
		AddData();
		//Reset();
		
	}
	
	private void AddData() {
		try {
			String query = "INSERT INTO question (Question,op1,op2,op3,op4,CorAns,,qcat,qtype) VALUES (?,?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, QuestionTF.getText());
			pst.setString(2, OptionATF.getText());
			pst.setString(3,OptionBTF.getText());
			pst.setString(4, OptionCTF.getText());
			pst.setString(5, OptionDTF.getText());
			pst.setString(6, CorrectAnswerTF.getText());
			pst.setString(9, QuestionCategoriesCB.getSelectedItem().toString());
			pst.setString(9, QuestionTypeCB.getSelectedItem().toString());
			pst.execute();
			pst.close();
			JOptionPane.showMessageDialog(null, "Add new information");
			Reset();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public Addinfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		QuestionTF = new JTextField();
		QuestionTF.setBounds(83, 26, 373, 59);
		contentPane.add(QuestionTF);
		QuestionTF.setColumns(10);
		
		JLabel lblQuestion = new JLabel("Question:");
		lblQuestion.setFont(new Font("Serif", Font.BOLD, 12));
		lblQuestion.setBounds(10, 32, 111, 14);
		contentPane.add(lblQuestion);
		
		lblOptionA = new JLabel("Option A:");
		lblOptionA.setFont(new Font("Serif", Font.BOLD, 12));
		lblOptionA.setBounds(10, 117, 111, 14);
		contentPane.add(lblOptionA);
		
		OptionATF = new JTextField();
		OptionATF.setBounds(83, 108, 373, 27);
		contentPane.add(OptionATF);
		OptionATF.setColumns(10);
		
		lblOptionB = new JLabel("Option B:");
		lblOptionB.setFont(new Font("Serif", Font.BOLD, 12));
		lblOptionB.setBounds(10, 154, 111, 14);
		contentPane.add(lblOptionB);
		
		OptionBTF = new JTextField();
		OptionBTF.setColumns(10);
		OptionBTF.setBounds(83, 145, 373, 27);
		contentPane.add(OptionBTF);
		
		lblOptionC = new JLabel("Option C:");
		lblOptionC.setFont(new Font("Serif", Font.BOLD, 12));
		lblOptionC.setBounds(10, 196, 111, 14);
		contentPane.add(lblOptionC);
		
		OptionCTF = new JTextField();
		OptionCTF.setColumns(10);
		OptionCTF.setBounds(83, 187, 373, 27);
		contentPane.add(OptionCTF);
		
		lblOptionD = new JLabel("Option D:");
		lblOptionD.setFont(new Font("Serif", Font.BOLD, 12));
		lblOptionD.setBounds(10, 234, 111, 14);
		contentPane.add(lblOptionD);
		
		OptionDTF = new JTextField();
		OptionDTF.setColumns(10);
		OptionDTF.setBounds(83, 225, 373, 27);
		contentPane.add(OptionDTF);
		
		lblCorrectAnswer = new JLabel("Correct Answer:");
		lblCorrectAnswer.setFont(new Font("Serif", Font.BOLD, 12));
		lblCorrectAnswer.setBounds(10, 268, 111, 14);
		contentPane.add(lblCorrectAnswer);
		
		CorrectAnswerTF = new JTextField();
		CorrectAnswerTF.setColumns(10);
		CorrectAnswerTF.setBounds(114, 259, 342, 27);
		contentPane.add(CorrectAnswerTF);
		
		QuestionCategorieslebel = new JLabel("Question Categories:");
		QuestionCategorieslebel.setFont(new Font("Serif", Font.BOLD, 12));
		QuestionCategorieslebel.setBounds(10, 297, 131, 27);
		contentPane.add(QuestionCategorieslebel);
		
		lblQuestiontype = new JLabel("QuestionType:");
		lblQuestiontype.setFont(new Font("Serif", Font.BOLD, 12));
		lblQuestiontype.setBounds(10, 335, 131, 27);
		contentPane.add(lblQuestiontype);
		
		 
		QuestionCategoriesCB = new JComboBox();
		QuestionCategoriesCB.setFont(new Font("Serif", Font.BOLD, 12));
		QuestionCategoriesCB.setModel(new DefaultComboBoxModel(new String[] {"...", "Math", "Programming", "Others"}));
		QuestionCategoriesCB.setBounds(137, 300, 180, 20);
		contentPane.add(QuestionCategoriesCB);
		
		QuestionTypeCB = new JComboBox();
		QuestionTypeCB.setModel(new DefaultComboBoxModel(new String[] {"....", "Easy", "Normal", "Difficile", "Others"}));
		QuestionTypeCB.setFont(new Font("Serif", Font.BOLD, 12));
		QuestionTypeCB.setBounds(103, 339, 180, 20);
		contentPane.add(QuestionTypeCB);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddData();
			}
		});
		btnAdd.setBounds(20, 379, 89, 23);
		contentPane.add(btnAdd);
		
	 btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reset();
				
			}
		});
		btnRestart.setBounds(128, 379, 89, 23);
		contentPane.add(btnRestart);
	}
}
