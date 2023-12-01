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

@WebServlet("/quoteDAO")

public class quoteDAO{
	
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public quoteDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
    	System.out.println("Connecting");
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
    
	//connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            System.out.println("Connecting");
            System.out.println(password);
            System.out.println(username);
            username = "john";
            password = "john1234";
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/DavesTimber?allowPublicKeyRetrieval=true&"
  			          + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }
    
    public void deleteAllQuotes() throws SQLException {
    	String sql = "DELETE FROM quote";
        connect_func();      
        statement = (Statement) connect.createStatement();
        statement.execute(sql);

        disconnect();    
    }
    
    public List<quote> listAllQuotes() throws SQLException {
    	System.out.println("Listing Quotes");
        List<quote> listQuote = new ArrayList<quote>();        
        String sql = "SELECT * FROM Quotes";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String orderID = resultSet.getString("orderID");
            String quoteStatus = resultSet.getString("quoteStatus");
            String initialPrice = resultSet.getString("initialPrice");
            String note = resultSet.getString("note");

             
            quote quotes = new quote(orderID, quoteStatus, initialPrice, note);
        	System.out.print(orderID);
        	System.out.println(quoteStatus);
            listQuote.add(quotes);
        }        
        resultSet.close();
        disconnect();    
    	System.out.println("Done Listing Quotes");
    	
    	System.out.println(listQuote);
        return listQuote;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(quote quotes) throws SQLException {
    	connect_func("root","john1234");         
		String sql = "insert into Quotes(orderID, quoteStatus, initialPrice, note) values (?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, quotes.getOrderID());
			preparedStatement.setString(2, quotes.getQuoteStatus());
			preparedStatement.setString(3, quotes.getInitialPrice());	
			preparedStatement.setString(4, quotes.getNote());

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    

     
    public boolean update(quote quotes) throws SQLException {
        String sql = "update quotes set quoteStatus =?,initialPrice = ? , note=? where orderID = ?";
        System.out.print("SQL STATEMENT:");
        System.out.println(sql);
        connect_func();
        System.out.println(quotes.getOrderID());
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(4, quotes.getOrderID());
        preparedStatement.setString(1, quotes.getQuoteStatus());
        preparedStatement.setString(2, quotes.getInitialPrice());
        preparedStatement.setString(3, quotes.getNote());
      
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public boolean updateToAccept(quote quotes) throws SQLException {
        String sql = "update quotes set quoteStatus =?, note=? where orderID = ?";
        System.out.print("SQL STATEMENT:");
        System.out.println(sql);
        connect_func();
        System.out.println(quotes.getOrderID());
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(3, quotes.getOrderID());
        preparedStatement.setString(1, quotes.getQuoteStatus());
        preparedStatement.setString(2, quotes.getNote());
      
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public quote getQuote(String orderID) throws SQLException {
    	quote quote = null;
        String sql = "SELECT * FROM quote WHERE orderID = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, orderID);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String quoteStatus = resultSet.getString("quoteStatus");
            String initialPrice = resultSet.getString("initialPrice");
            String note = resultSet.getString("note");

            quote = new quote(orderID, quoteStatus, initialPrice, note);
        }
         
        resultSet.close();
        statement.close();
         
        return quote;
    }
    
  
}