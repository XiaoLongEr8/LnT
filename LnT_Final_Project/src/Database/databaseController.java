package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import Bridge.databaseConnectionBridge;

public class databaseController {

	Connection connection;

	public databaseController() {
		try {
			initConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void initConnection() throws SQLException {
		connection = databaseConnectionBridge.connect();
		if (connection == null) {
			throw new SQLException("Connection");
		}
	}

	public Vector<Vector<String>> getMenuData() {
		Vector<Vector<String>> data = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from datamenu";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Vector<String> rows = new Vector<>();
				rows.add(rs.getString(1));
				rows.add(rs.getString(2));
				rows.add(rs.getString(3));
				rows.add(rs.getString(4));
				data.add(rows);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public void createNewElementDatabase(String codeMenu, String namaMenu, String hargaMenu, String stokMenu) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "INSERT INTO datamenu " + "VALUES ('" + codeMenu + "', '" + namaMenu + "', '" + hargaMenu
					+ "', '" + stokMenu + "')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Success insert data");
			System.out.println("Insert succes. Please check you database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteElementDatabase(String codeMenu) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "DELETE FROM datamenu " + 
					"WHERE KodeMenu = '"+codeMenu+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Success delete data");
			System.out.println("Delete succes. Please check you database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateElementDatabase(String codeMenu, String namaMenu, String hargaMenu, String stokMenu) {
		try {
			Statement stmt = connection.createStatement();
//			String sql = "UPDATE datamenu " + 
//					"SET NamaMenu = '" + namaMenu + "', HargaMenu = '" + hargaMenu + "', StokMenu = '" + stokMenu + "' WHERE KodeMenu = '"+codeMenu+"'";
			String sql = "UPDATE datamenu " + 
					"SET NamaMenu = '" + "Jus Semangka" + "', HargaMenu = '" + "6000" + "', StokMenu = '" + "5" + "' WHERE KodeMenu = '"+"JU-824"+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Success update data");
			System.out.println("Update succes. Please check you database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
