package DBLayer;

import GeneratedKey;
import IFDBCustomer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class DBCustomer implements IFDBCustomer {
	
	public DBCustomer(){
		
	}
	
	public List<Customer> getAllCutomers(boolean retrieveAssociation) {
		return miscWhere("", retrieveAssociation);
	}
	
	public int createCustomer(Customer c) {
		
		Customer cust = c;
		int res = 0;
		String q = "insert into customer (name, address, customerID, phone, email, city) values ('" + c.getName() + "', " + (cust == null ? "NULL": "'" + c.getId() + "'") + ")";
		System.out.println(q);
		try (Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			res = s.executeUpdate(q, Statement.RETURN_GENERATED_KEYS);
			int id = new GeneratedKey().getGeneratedKey(s);
			c.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
