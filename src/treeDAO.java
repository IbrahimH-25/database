import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

//import javax.servlet.ServletException;
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

@WebServlet("/treeDAO")

public class treeDAO{
	
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public treeDAO(){}
	
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
    
    public void deleteAllTree() throws SQLException {
    	String sql = "DELETE FROM tree";
        connect_func();      
        statement = (Statement) connect.createStatement();
        statement.execute(sql);

        disconnect();    
    }
    
    public List<tree> listAllTrees() throws SQLException {
    	System.out.println("Listing Trees");
        List<tree> listTree = new ArrayList<tree>();        
        String sql = "SELECT * FROM tree";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String treeID = resultSet.getString("treeID");
            String size = resultSet.getString("size");
            String height = resultSet.getString("height");
            String location = resultSet.getString("location");
            

             
            tree tree = new tree(treeID, size, height, location);
        	System.out.print(treeID);
        	System.out.println(size);
            listTree.add(tree);
        }        
        resultSet.close();
        disconnect();    
    	System.out.println("Done Listing Trees");
    	
        return listTree;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(tree trees) throws SQLException {
    	connect_func();         
		String sql = "insert into Tree(treeID, size, height, location) values (?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, trees.getTreeID());
			preparedStatement.setString(2, trees.getSize());
			preparedStatement.setString(3, trees.getHeight());	
			preparedStatement.setString(4, trees.getLocation());

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(String email) throws SQLException {
        String sql = "DELETE FROM tree WHERE email = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(tree tree) throws SQLException {
        String sql = "update tree set size =?,height = ? , location=?, where treeID = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, tree.getTreeID());
        preparedStatement.setString(2, tree.getSize());
        preparedStatement.setString(3, tree.getHeight());
        preparedStatement.setString(4, tree.getLocation());
      
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public tree getTree(String treeID) throws SQLException {
    	tree tree = null;
        String sql = "SELECT * FROM tree WHERE treeID = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, treeID);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String size = resultSet.getString("size");
            String height = resultSet.getString("height");
            String location = resultSet.getString("location");

            tree = new tree(treeID, size, height, location);
        }
         
        resultSet.close();
        statement.close();
         
        return tree;
    }
    
    public boolean checkEmail(String email) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE email = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkPassword(String password) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE password = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
       	return checks;
    }
    
    
    
    public boolean isValid(String email, String password) throws SQLException
    {
    	String sql = "SELECT * FROM User";
    	connect_func();
    	statement = (Statement) connect.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	resultSet.last();
    	
    	int setSize = resultSet.getRow();
    	resultSet.beforeFirst();
    	
    	for(int i = 0; i < setSize; i++)
    	{
    		resultSet.next();
    		if(resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
    			return true;
    		}		
    	}
    	return false;
    }
    
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"drop database if exists DavesTimber; ",
					        "create database DavesTimber; ",
					        "use DavesTimber; ",
					        "drop table if exists User; ",
					        ("CREATE TABLE if not exists User( " +
					            "email VARCHAR(50) NOT NULL, " + 
					            "firstName VARCHAR(10) NOT NULL, " +
					            "lastName VARCHAR(10) NOT NULL, " +
					            "password VARCHAR(20) NOT NULL, " +
					            "clientID VARCHAR(30) NOT NULL, " +
					            "adress_street_num VARCHAR(4) , "+ 
					            "adress_street VARCHAR(30) , "+ 
					            "adress_city VARCHAR(20)," + 
					            "adress_state VARCHAR(2),"+ 
					            "adress_zip_code VARCHAR(5),"+ 
					            "creditCard VARCHAR(30) NOT NULL,"+ 
					            "phoneNum VARCHAR(30) NOT NULL,"+
					            "PRIMARY KEY (email) "+"); ")
        					};
        String[] TUPLES = {
            ("insert into User(email, firstName, lastName, password, clientID, creditCard, phoneNum ,adress_street_num, adress_street, adress_city, adress_state, adress_zip_code)"+
            "values ('susie@gmail.com', 'Susie ', 'Guzman', 'susie1234', '000001', '4740076302131963','5554801283' ,'1234','whatever street', 'detroit', 'MI', '48202'),"+
                    "('sophie@gmail.com', 'Sophie', 'Pierce','sophie1234', '000002', '4715394634405687', '5554801232','4321','yolos street', 'ides', 'CM', '24680'),"+
                    "('angelo@gmail.com', 'Angelo', 'Francis','angelo1234', '000003', '4182884872690531', '5554809582' ,'2643','egypt street', 'lolas', 'DT', '13579'),"+
                    "('rudy@gmail.com', 'Rudy', 'Smith','rudy1234', '000004', '4423945702309771','5554809184' ,'1231','sign street', 'samo ne tu','MH', '09876'),"+
                    "('jeannette@gmail.com', 'Jeannette ', 'Stone','jeannette1234', '000005', '4981967026437975', '5554808461','0183','snoop street', 'kojik', 'HW', '87654'),"+
                    "('root', 'default', 'default','pass1234', '000000', '0000000000000000', '5554807492','0000','Default', 'Default', '0', '00000');")};
//        			"values ('susie@gmail.com', 'Susie ', 'Guzman', 'susie1234', '2000-06-27', '1234', 'whatever street', 'detroit', 'MI', '48202','1000', '0'),"+
//			    		 	"('don@gmail.com', 'Don', 'Cummings','don123', '1969-03-20', '1000', 'hi street', 'mama', 'MO', '12345','1000', '0'),"+
//			    	 	 	"('margarita@gmail.com', 'Margarita', 'Lawson','margarita1234', '1980-02-02', '1234', 'ivan street', 'tata','CO','12561','1000', '0'),"+
//			    		 	"('jo@gmail.com', 'Jo', 'Brady','jo1234', '2002-02-02', '3214','marko street', 'brat', 'DU', '54321','1000', '0'),"+
//			    		 	"('wallace@gmail.com', 'Wallace', 'Moore','wallace1234', '1971-06-15', '4500', 'frey street', 'sestra', 'MI', '48202','1000', '0'),"+
//			    		 	"('amelia@gmail.com', 'Amelia', 'Phillips','amelia1234', '2000-03-14', '1245', 'm8s street', 'baka', 'IL', '48000','1000', '0'),"+
//			    			"('sophie@gmail.com', 'Sophie', 'Pierce','sophie1234', '1999-06-15', '2468', 'yolos street', 'ides', 'CM', '24680','1000', '0'),"+
//			    			"('angelo@gmail.com', 'Angelo', 'Francis','angelo1234', '2021-06-14', '4680', 'egypt street', 'lolas', 'DT', '13579','1000', '0'),"+
//			    			"('rudy@gmail.com', 'Rudy', 'Smith','rudy1234', '1706-06-05', '1234', 'sign street', 'samo ne tu','MH', '09876','1000', '0'),"+
//			    			"('jeannette@gmail.com', 'Jeannette ', 'Stone','jeannette1234', '2001-04-24', '0981', 'snoop street', 'kojik', 'HW', '87654','1000', '0'),"+
//			    			"('root', 'default', 'default','pass1234', '0000-00-00', '0000', 'Default', 'Default', '0', '00000','1000','1000000000');")
//			    			};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        disconnect();
    }

	
}