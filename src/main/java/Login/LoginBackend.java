package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginBackend {

		
		String url = "jdbc:mysql://localhost:3306/Users3311";
		String user = "root";
		String password = "";
		
		public boolean doLogin(String username, String pass) {
			boolean result = false;
			try {
				Connection con = DriverManager.getConnection(url, user, password);

				Statement statement= con.createStatement();
//				Scanner myobj = new Scanner(System.in);
//
//				System.out.println("Enter Username");
//				String Username = myobj.nextLine();

				String query = "select login.password from login where login.Username = ?;";

//
//				System.out.println("Enter password");
//				String pass = myobj.nextLine();

				PreparedStatement  preparedstatement = con.prepareStatement(query);
				preparedstatement.setString(1,username);
				ResultSet rs = preparedstatement.executeQuery();
				rs.next();

				if(rs.getString(1).equals(pass)) {
					result = true;
				}else {
					result = false;
				}

			} 
			catch ( SQLException e ) {
				System.out.println("Error");
			}
			return result;
		}

}
