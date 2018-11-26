package IQ;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class SQLConnection {
	static Connection conn;

	public static Connection connecrDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iqtest","root", "");
			//JOptionPane.showMessageDialog(null, "Success");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null," Login Faild");
			return null;
		}
	}
	

}
