import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/billDAO")
public class billDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public billDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DavesTimber?allowPublicKeyRetrieval=true&useSSL=false&user=john&password=john1234");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String email, String password) throws SQLException{
    	try {
    		connect_func("root","pass1234");
    		String sql = "select * from user where email = ?";
    		preparedStatement = connect.prepareStatement(sql);
    		preparedStatement.setString(1, email);
    		ResultSet rs = preparedStatement.executeQuery();
    		return rs.next();
    	}
    	catch(SQLException e) {
    		System.out.println("failed login");
    		return false;
    	}
    }
	//connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/DavesTimber?"
  			          + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }

    
    public List<bill> listAllBills() throws SQLException {
    	System.out.println("Listing bills");
        List<bill> listBill = new ArrayList<bill>();        
        String sql = "SELECT * FROM bills";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String billID = resultSet.getString("billID");
            String billPaid = resultSet.getString("billPaid");
            String billStatus = resultSet.getString("billStatus");

             
            bill bills = new bill(billID, billPaid, billStatus);
            listBill.add(bills);
        }        
        resultSet.close();
        disconnect();    
    	System.out.println("Done Listing Quotes");
    	
    	//System.out.println(listQuote);
        return listBill;
    }
    
    public List<bill> listFullQueryForBills(String query) throws SQLException {
    	//List a full query for bill (meaning it will list the bill id, bill paid, and bill status
    	
    	System.out.println("Listing bills");
        List<bill> listBill = new ArrayList<bill>();        
        String sql = query;      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String billID = resultSet.getString("billID");
            String billPaid = resultSet.getString("billPaid");
            String billStatus = resultSet.getString("billStatus");

             
            bill bills = new bill(billID, billPaid, billStatus);
            listBill.add(bills);
        }        
        resultSet.close();
        disconnect();    
    	System.out.println("Done Listing Quotes");
    	
    	//System.out.println(listQuote);
        return listBill;
    }

    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(bill bills) throws SQLException {
    	connect_func("root","pass1234");   
		String sql = "insert into bill(id, paid, status) values( ? ,? ,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, bills.getBillId());
			preparedStatement.setString(2, bills.getBillPaid());
			preparedStatement.setString(3, bills.getBillStatus());	

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(String email) throws SQLException {
        String sql = "DELETE FROM User WHERE email = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(bill bills) throws SQLException {
        String sql = "update bill set paid=?,status=? where id=?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, bills.getBillPaid());
        preparedStatement.setString(2, bills.getBillStatus());	
        preparedStatement.setString(2, bills.getBillId());
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }

    
    
    
    
    
	
	

}
