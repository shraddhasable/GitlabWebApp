package abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

	public static String getDataFromDatabase() {
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/denmark", "roger", "roger");
			// here denmark is database name, roger is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while (rs.next()) {
				System.out.println(rs.getString(1));
				String result=rs.getString(1);
				con.close();
				return result;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
