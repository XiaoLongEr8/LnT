package Bridge;

import java.sql.Connection;
import java.sql.DriverManager;

public class databaseConnectionBridge {

	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalprojectlntdatabase?useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "");
		}catch(Exception e) {
			System.out.println("Data tidak connect");
			e.printStackTrace();
		}
		return connection;
	}

}
