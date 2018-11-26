package IQ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import IQ.SQLConnection;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.SystemColor;

public class QuestionFm extends JFrame {
	private JTextPane QtextPane;
	private JRadioButton btnA, btnB, btnC, btnD;
	private final ButtonGroup ButtonGroup = new ButtonGroup();
	private JPanel contentPane;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int Qnumber = 1;
	int Qnumber2 = 1;
	
	ArrayList<question_template> allQuestion = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionFm frame = new QuestionFm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public QuestionFm() {
		design();
		conn = SQLConnection.connecrDb();
		loadTable();

	}
	/*private void correctAnswer(){
		int mark = 0;
		
		if(corAns == inputAns) {
			mark++;
		}
		System.out.println(mark);
	}*/
	private void design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnnext = new JButton("Next");
		btnnext.setFont(new Font("Sitka Text", Font.BOLD, 12));
		btnnext.setBounds(388, 345, 64, 23);
		btnnext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadTable();
				int[] myIntArray = { 1, 2, 3};
				Qnumber = new Random().nextInt(myIntArray.length);
				Random rand = new Random();
				
				Qnumber2 = rand.nextInt(10) + 1;
				
				//if()
				System.out.println(Qnumber);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnnext);

		btnA = new JRadioButton("A");
		btnA.setBounds(12, 232, 438, 23);
		btnA.setFont(new Font("Sitka Text", Font.BOLD, 12));
		ButtonGroup.add(btnA);
		contentPane.add(btnA);

		btnB = new JRadioButton("B");
		btnB.setBounds(12, 259, 438, 23);
		btnB.setFont(new Font("Sitka Text", Font.BOLD, 12));
		ButtonGroup.add(btnB);
		contentPane.add(btnB);

		btnC = new JRadioButton("C");
		btnC.setBounds(12, 287, 438, 23);
		btnC.setFont(new Font("Sitka Text", Font.BOLD, 12));
		ButtonGroup.add(btnC);
		contentPane.add(btnC);

		btnD = new JRadioButton("D");
		btnD.setBounds(12, 313, 438, 23);
		btnD.setFont(new Font("Sitka Text", Font.BOLD, 12));
		ButtonGroup.add(btnD);
		contentPane.add(btnD);
		
		QtextPane = new JTextPane();
		QtextPane.setBounds(0, 0, 438, 225);
		contentPane.add(QtextPane);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loging LG = new Loging();
				LG.setVisible(true);
				dispose();
				//System.exit(0);
			}
		});
		btnNewButton.setBounds(289, 345, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(450, 0, 2, 2);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(450, 232, -15, -219);
		contentPane.add(scrollPane_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setForeground(SystemColor.controlText);
		scrollBar.setBackground(SystemColor.text);
		scrollBar.setBounds(445, 0, 17, 225);
		contentPane.add(scrollBar);
		conn = SQLConnection.connecrDb();
		loadTable();
	}

	private void loadTable() {
		try {
			String query = "SELECT * FROM question where Qset =1 ";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("Question"));
//				QtextPane.setText(rs.getString("Question"));
//				btnA.setText(rs.getString("op1"));
//				btnB.setText(rs.getString("op2"));
//				btnC.setText(rs.getString("op3"));
//				btnD.setText(rs.getString("op4"));
				// System.out.println(rs.getString("corAns"));
				// System.out.println(rs.getString("Question"));
				
				question_template qt = new question_template(rs.getString("Question"),
						rs.getString("op1"), rs.getString("op2"),
						rs.getString("op3"), rs.getString("op4"),
						rs.getString("corAns"));
				
				allQuestion.add(qt);
				

			}
			pst.close();
			rs.close();
			
			int index  = randdi(0, allQuestion.size());
			
			question_template tmp;
			
			tmp = allQuestion.get(index);
			
			
			QtextPane.setText(tmp.getQuestion());
			btnA.setText(tmp.getOp1());
			btnB.setText(tmp.getOp2());
			btnC.setText(tmp.getOp3());
			btnD.setText(tmp.getOp4());
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int randdi(int x,int y) {
		
		return (int) (Math.random() * (y - x)) + x;
		
		
	}
}
