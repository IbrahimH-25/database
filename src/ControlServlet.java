import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class ControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private userDAO userDAO = new userDAO();
	    private quoteDAO quoteDAO = new quoteDAO();
	    private treeDAO treeDAO = new treeDAO();
	    private String currentUser;
	    private HttpSession session=null;
	    
	    public ControlServlet()
	    {
	    	
	    }
	    
	    public void init()
	    {
	    	userDAO = new userDAO();
	    	quoteDAO = new quoteDAO();
	    	treeDAO = new treeDAO();
	    	currentUser= "";
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.println(action);
	    
	    try {
        	switch(action) {  
        	case "/login":
        		login(request,response);
        		break;
        	case "/register":
        		register(request, response);
        		break;
        	case "/initialize":
        		userDAO.init();
        		System.out.println("Database successfully initialized!");
        		rootPage(request,response,"");
        		break;
        	case "/deleteAllUsers":
        		userDAO.deleteAllUsers();
        		System.out.println("Database entries deleted!");
        		//rootPage(request,response,"");
        		rootPage(request,response,"");      
        		break;
        	case "/root":
        		rootPage(request,response, "");
        		break;

        	case "/DavesAdminPanel":
        		System.out.println("Admin Panel Launch");
        		AdminPanel(request,response);
        		break;
        	case "/DavesAdminPanel2":
        		System.out.println("Admin Panel Launch");
    	    	System.out.println("root view");
    			request.setAttribute("listUser", userDAO.listAllUsers());
    	    	request.getRequestDispatcher("DavesAdminPanel2.jsp").forward(request, response);
        	case "/quoteInsertFromDave":
        		System.out.println("Quote from dave being sent!");
        		quoteInsertFromDave(request,response);
        		System.out.println("Quote from dave sent - redirecting");
        		AdminPanel(request,response);
        		System.out.println("Quote from dave sent!");
        		break; 
        		
        	case "/quoteUpdateFromDave":
        		System.out.println("Quote updatefrom dave being sent!");
        		quoteUpdateFromDave(request,response);
        		System.out.println("Quote update from dave sent - redirecting");
        		AdminPanel(request,response);
        		System.out.println("Quote updatefrom dave sent!");
        		break; 
        	case "/testSubmitQuote":
        		
        		
        	case  "/insertTree":
        		System.out.println("Tree Request from client being sent!");
        		//quoteInsertFromDave(request,response);
        		System.out.println("Tree - redirecting");
        		insertTree(request,response);
        		System.out.println("Tree request from user sent!");
        		break;      
        	case "/logout":
        		logout(request,response);
        		break;
        	 case "/list": 
                 System.out.println("The action is: list");
                 listUser(request, response);           	
                 break;
	    	}
	    }
	    catch(Exception ex) {
        	System.out.println(ex.getMessage());
	    	}
	    }
        	
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("listUser started: 00000000000000000000000000000000000");

	     
	        List<user> listUser = userDAO.listAllUsers();
	        request.setAttribute("listUser", listUser);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listPeople finished: 111111111111111111111111111111111111");
	    }
	    	        
	    private void rootPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("root view");
			request.setAttribute("listUser", userDAO.listAllUsers());
	    	request.getRequestDispatcher("rootView.jsp").forward(request, response);
	    }
	    
	    private void AdminPanel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	    	System.out.println("CSV-Daves Admin Panel");
			request.setAttribute("listQuote", quoteDAO.listAllQuotes());
			request.setAttribute("reloadQuoteTable", quoteDAO.listAllQuotes());
			//request.setAttribute('insertInitialQuote', quoteDAO.insert(null));
	    	System.out.println("CSV-Listed Quotes");
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("DavesAdminPanel.jsp");
	    	dispatcher.forward(request, response);
	    }
	    
	    private void ClientsView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	    	System.out.println("CSV-Daves Admin Panel");
	    	//request.setAttribute("insertTree", treeDAO.insert(null));
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("ClientsView.jsp");
	    	dispatcher.forward(request, response);
	    }
	    
	    private void insertTree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	    {
	    	System.out.println("Client Sent Tree?");
	    	//String treeNum = request.getParameter("size1");
	    	String treeSize = request.getParameter("size1");
	   	 	String treeHeight = request.getParameter("height1");
	   	 	String feetONI = request.getParameter("feetOrNo1");
	   	 	System.out.print("Tree Size");
	   	 	System.out.println(treeSize);
	   	 	System.out.print("Tree Height");
	   	 	System.out.println(treeHeight);
	   	 	System.out.print("Tree ONI");
	   	 	System.out.println(feetONI);
            tree trees = new tree("00000",treeSize,treeHeight, feetONI);

   	 		treeDAO.insert(trees);
	    	System.out.println("Quote done");
   	 		//response.sendRedirect("login.jsp");
   	 		response.sendRedirect("ClientsView.jsp");
	    }
	    
	    
	    private void quoteInsertFromDave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
    	{
	    	System.out.println("Dave Sent Quote?");
	    	String orderID = request.getParameter("orderID");
	    	System.out.println(orderID);
	   	 	String quoteStatus = request.getParameter("quoteStatus");
	    	System.out.println("2");
	   	 	String initialPrice = request.getParameter("initialPrice");
	    	System.out.println("3");
	   	 	String note = request.getParameter("note");
	    	System.out.println("4");
            quote quotes = new quote(orderID,quoteStatus, initialPrice, note);
	    	System.out.println("5");
   	 		quoteDAO.insert(quotes);
	    	System.out.println("Quote done");
   	 		//response.sendRedirect("login.jsp");
   	 		response.sendRedirect("DavesAdminPanel.jsp");
	    	//request.getRequestDispatcher("DavesAdminPanel.jsp").forward(request, response);


    	}
	    
	    private void quoteUpdateFromDave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
    	{
	    	System.out.println("Dave Update Sent Quote?");
	    	String orderID = request.getParameter("orderID");
	    	//System.out.println("1");
	   	 	//String quoteStatus = request.getParameter("quoteStatus");
	    	//System.out.println("2");
	   	 	String initialPrice = request.getParameter("initialPrice");
	    	//System.out.println("3");
	   	 	String note = request.getParameter("note");
	    	System.out.println("4");
            quote quotes = new quote(orderID,"sent", initialPrice, note);
	    	System.out.println("5");
   	 		quoteDAO.update(quotes);
	    	System.out.println("Quote done");
   	 		//response.sendRedirect("login.jsp");
   	 		//response.sendRedirect("DavesAdminPanel.jsp");
	    	request.getRequestDispatcher("DavesAdminPanel.jsp").forward(request, response);


    	}
	    
	    
	    private void treeRequestInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	    {
	    	//System.out.println("Dave Sent Quote?");
	    	//String orderID = request.getParameter("orderID");
	   	 	//String quoteStatus = request.getParameter("quoteStatus");
	   	 	//String initialPrice = request.getParameter("initialPrice");
	   	 	//String note = request.getParameter("note");
            //quote quotes = new quote(orderID,quoteStatus, initialPrice, note);
   	 		//quoteDAO.insert(quotes);
	    	System.out.println("Quote done");
   	 		//response.sendRedirect("login.jsp");
   	 		//response.sendRedirect("DavesAdminPanel.jsp");
	    	//request.getRequestDispatcher("DavesAdminPanel.jsp").forward(request, response);

	    }
	    
	    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	 String email = request.getParameter("email");
	    	 String password = request.getParameter("password");
	    	 
	    	 if (email.equals("root") && password.equals("pass1234")) {
				 System.out.println("Login Successful! Redirecting to root");
				 session = request.getSession();
				 session.setAttribute("username", email);
				 rootPage(request, response, "");
	    	 }
	    	 else if(userDAO.isValid(email, password)) 
	    	 {
			 	 
			 	 currentUser = email;
				 System.out.println("Login Successful! Redirecting");
				 request.getRequestDispatcher("activitypage.jsp").forward(request, response);
			 			 			 			 
	    	 }
	    	 else {
	    		 request.setAttribute("loginStr","Login Failed: Please check your credentials.");
	    		 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 }
	    }
	           
	    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String email = request.getParameter("email");
	   	 	String firstName = request.getParameter("firstName");
	   	 	String lastName = request.getParameter("lastName");
	   	 	String password = request.getParameter("password");
	   	 	String clientID = request.getParameter("clientID");
	   	 	String adress_street_num = request.getParameter("adress_street_num"); 
	   	 	String adress_street = request.getParameter("adress_street"); 
	   	 	String adress_city = request.getParameter("adress_city"); 
	   	 	String adress_state = request.getParameter("adress_state"); 
	   	 	String adress_zip_code = request.getParameter("adress_zip_code"); 	   	 	
	   	 	String creditCard = request.getParameter("creditCard"); 	   	 	
	   	 	String phoneNum = request.getParameter("phoneNum"); 	   	 	
	   	 	String confirm = request.getParameter("confirmation");
	   	 	
	   	 	if (password.equals(confirm)) {
	   	 		if (!userDAO.checkEmail(email)) {
		   	 		System.out.println("Registration Successful! Added to database");
		            user users = new user(email,firstName, lastName, password, clientID, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, creditCard,phoneNum);
		   	 		userDAO.insert(users);
		   	 		response.sendRedirect("login.jsp");
	   	 		}
		   	 	else {
		   	 		System.out.println("Username taken, please enter new username");
		    		 request.setAttribute("errorOne","Registration failed: Username taken, please enter a new username.");
		    		 request.getRequestDispatcher("register.jsp").forward(request, response);
		   	 	}
	   	 	}
	   	 	else {
	   	 		System.out.println("Password and Password Confirmation do not match");
	   		 request.setAttribute("errorTwo","Registration failed: Password and Password Confirmation do not match.");
	   		 request.getRequestDispatcher("register.jsp").forward(request, response);
	   	 	}
	    }   
	    

	    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	currentUser = "";
        		response.sendRedirect("login.jsp");
        	}
	
	    

	     
        
	    
	    
	    
	    
	    
}
	        
	        
	    
	        
	        
	        
	    


