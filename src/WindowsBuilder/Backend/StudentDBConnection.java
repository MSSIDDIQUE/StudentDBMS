package WindowsBuilder.Backend;

import java.sql.*;

import javax.swing.JOptionPane;

public class StudentDBConnection
{
	Connection conn=null;
	public static Connection dbConnector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:H:\\Users\\M.S.SIDDIQUE\\eclipse-workspace\\StudentDBMS\\src\\WindowsBuilder\\Backend\\StudentDatabase.sqlite");
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
