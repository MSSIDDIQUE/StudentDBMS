package WindowsBuilder.Backend;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import java.sql.*;
public class EmployeeDBConnection {

	Connection conn=null;
	public static Connection dbConnector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:H:\\Users\\M.S.SIDDIQUE\\eclipse-workspace\\StudentDBMS\\src\\WindowsBuilder\\Backend\\Employee Info.sqlite");
			JOptionPane.showMessageDialog(null, "The connection is successfull");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
