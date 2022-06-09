package webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {
	
	public static boolean createTable() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/societal?characterEncoding=latin1&useConfigs=maxPerformance","root","SuryaTeja@9192");
			Statement st = con.createStatement();
			boolean res = st.execute("create table persons(personid int primary key, firstname varchar(255), lastname varchar(255), address varchar(255), city varchar(255))");
			return !res;
		} catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public static int insertPerson(Person person) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/societal?characterEncoding=latin1&useConfigs=maxPerformance","root","SuryaTeja@9192");
			PreparedStatement ps = con.prepareStatement("insert into persons values(?, ?, ?, ?, ?)");
			ps.setInt(1, person.getPersonId());
			ps.setString(2, person.firstName());
			ps.setString(3, person.getLastName());
			ps.setString(4, person.getAddress());
			ps.setString(5, person.getCity());
			int count = ps.executeUpdate();
			return count;
		} catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public static List<Person> getPersons() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/societal?characterEncoding=latin1&useConfigs=maxPerformance","root","SuryaTeja@9192");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from persons");
			List<Person> personList = new ArrayList<Person>();
			while(rs.next()) {
				personList.add(new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			return personList;
		} catch(Exception e) {
			System.out.println(e);
		}
		return new ArrayList<Person>();
	}
	
	public static Person getPersonByPersonId(int personId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/societal?characterEncoding=latin1&useConfigs=maxPerformance","root","SuryaTeja@9192");
			PreparedStatement st = con.prepareStatement("select * from persons where personid=?");
			st.setInt(1, personId);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			return null;
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static boolean deletePersonById(int personId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/societal?characterEncoding=latin1&useConfigs=maxPerformance","root","SuryaTeja@9192");
			PreparedStatement ps = con.prepareStatement("delete from persons where personid=?");
			ps.setInt(1, personId);
			int count = ps.executeUpdate();
			if(count == 0) {
				return false;
			}
			return true;
		} catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public static int updatePersonById(int oldPersonId, int newPersonId, String firstName, String lastName, String address, String city) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/societal?characterEncoding=latin1&useConfigs=maxPerformance","root","SuryaTeja@9192");
			PreparedStatement st = con.prepareStatement("update persons set personid=?, firstname=?, lastname=?, address=?, city=? where personid=?");
			st.setInt(1, newPersonId);
			st.setString(2, firstName);
			st.setString(3, lastName);
			st.setString(4, address);
			st.setString(5, city);
			st.setInt(6,oldPersonId);
			int count = st.executeUpdate();
			return count;
		} catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
}
