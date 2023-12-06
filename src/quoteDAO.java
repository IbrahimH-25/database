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
/*<body style="background-color:lightgreen">
	<sql:setDataSource
    var="jspSQL"
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://127.0.0.1:3306/DavesTimber"
    user="john" password="john1234"
/>
<sql:query var="list_quotes" dataSource="${jspSQL}">
    SELECT * FROM quotes;
</sql:query>
<sql:query var="list_quotes_client_response" dataSource="${jspSQL}">
    SELECT * FROM quotes where quoteStatus = "quoteFromClient";
</sql:query>*/
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
    
    public List<quote> listQuery(String queryToUse) throws SQLException {
    	System.out.println("Custom Quote Query");
        List<quote> listQuote = new ArrayList<quote>();        
        String sql = queryToUse;      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String orderID = resultSet.getString("orderID");
            System.out.print(orderID);
            String quoteStatus = resultSet.getString("quoteStatus");
            System.out.println(quoteStatus);
            String initialPrice = resultSet.getString("initialPrice");
            System.out.println(initialPrice);
            String note = resultSet.getString("note");

             
            quote quotes = new quote(orderID, quoteStatus, initialPrice, note);
        	
        	
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
        System.out.println("update to accept pre statement");
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(3, quotes.getOrderID());
        preparedStatement.setString(1, quotes.getQuoteStatus());
        preparedStatement.setString(2, quotes.getNote());
      
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public quote getQuote(String orderID) throws SQLException {
        String sql = "SELECT * FROM quotes WHERE orderID = ?";
        quote chosenQuote = null;
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, orderID);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
        	System.out.println("Next Result");
        	//String orderId = resultSet.getString("quoteStatus");
            String quoteStatus = resultSet.getString("quoteStatus");
            String initialPrice = resultSet.getString("initialPrice");
            String note = resultSet.getString("note");

            chosenQuote = new quote(orderID, quoteStatus, initialPrice, note);
        }
        
        resultSet.close();
        statement.close();
         
        return chosenQuote;
    }
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"drop database if exists DavesTimber; ",
					        "create database DavesTimber; ",
					        "use DavesTimber; ",
					        "drop table if exists User; ",
					        ("CREATE TABLE if not exists Quotes( " +
					        	    "orderID VARCHAR(10) NOT NULL," +
					        	    "quoteStatus VARCHAR(50) NOT NULL," + 
					        	    "initialPrice VARCHAR(10) NOT NULL," +
					        		"note VARCHAR(100) NOT NULL," +
					        	    "PRIMARY KEY (orderID) ); " +
					        	    "insert into Quotes(orderID, quoteStatus, initialPrice,note)"+
					        	    "values ('000000', 'notsent', '1','lipsumOrum'),('000009','quoteFromClient','2000','5000 is too much for me'),('000006','quoteFromContractor','6000','Initial Response Fom Contractor for 6000'),('000007','quoteFromContractor','7000','Initial Response Fom Contractor for 7000');")
        					};
        for (int i = 0; i < INITIAL.length; i++) {
        	System.out.println(INITIAL[i]);
        	statement.execute(INITIAL[i]);}
        disconnect();
    }
    
}