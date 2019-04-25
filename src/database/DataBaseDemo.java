package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseDemo {

	public static void main(String[] args) throws Exception {
		/*
		 * Load the driver class related to the DB technology dynamically using
		 * forName() method of Class class
		 */
		Class.forName("com.mysql.jdbc.Driver");

		/*
		 * Create connection to the required database by calling getConnection() method
		 * of DriverManager class and storing reference in Connection class object
		 */
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world", "surya", "password");

		/*
		 * Create Statement class object by calling createStatement() method of
		 * Connection class so that we can execute SQL queries
		 */
		Statement statement = con.createStatement();

		/*
		 * Execute SQL queries using executeQuery() method of Statement class and store
		 * the results in ResultSet class object
		 */
		ResultSet rs = statement.executeQuery("SELECT * FROM city where CountryCode = 'GBR' and Name = 'London' ");

		/* Iterate over the results using next() method of ResultSet class */
		while(rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("Name");
			String cCode = rs.getString("CountryCode");
			String district = rs.getString("District");
			long population = rs.getLong("Population");
			System.out.println("population of "+name+"  is "+population);
//			System.out.println(id+"\t"+name+"\t"+cCode+"\t"+district+"\t"+population);
		}

		/* Close the data base connection using close() method of Connection class */
		con.close();
	}

}
