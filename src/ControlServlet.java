import java.io.ByteArrayOutputStream;
import java.util.UUID;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

@MultipartConfig
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDAO userDAO = new userDAO();
	private quoteDAO quoteDAO = new quoteDAO();
	private treeDAO treeDAO = new treeDAO();
	private String currentUser;
	private HttpSession session = null;

	public ControlServlet() {

	}

	public void init() {
		userDAO = new userDAO();
		quoteDAO = new quoteDAO();
		treeDAO = new treeDAO();
		currentUser = "";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		String action = request.getServletPath();
		System.out.println(action);

		try {
			switch (action) {
				case "/insertTree":
					System.out.println("hhhh");
					System.out.println("Tree Request from client being sent!");
					// quoteInsertFromDave(request,response);
					System.out.println("Tree - redirecting");
					quote quoteInsert = new quote(UUID.randomUUID().toString().substring(0, 5),
							"InitialOrder", "0", "Submit initial Quote please");
					quoteDAO.insert(quoteInsert);
					insertTree(request, response);

					System.out.println("Tree request from user sent!");
					break;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		try {
			switch (action) {
				case "/login":
					login(request, response);
					break;
				case "/register":
					register(request, response);
					break;
				case "/initialize":
					userDAO.init();
					System.out.println("Database successfully initialized!");
					rootPage(request, response, "");
					break;
				case "/deleteAllUsers":
					userDAO.deleteAllUsers();
					System.out.println("Database entries deleted!");
					// rootPage(request,response,"");
					rootPage(request, response, "");
					break;
				case "/root":
					System.out.println("root page Launch");
					rootPage(request, response, "");
					break;

				case "/DavesAdminPanel":
					System.out.println("Admin Panel Launch");
					AdminPanel(request, response);
					break;
				case "/reloadQuoteTable":
					System.out.println("Admin Panel Reload");
					AdminPanel(request, response);
					/*
					 * case "/DavesAdminPanel2":
					 * System.out.println("Admin Panel Launch");
					 * System.out.println("root view");
					 * request.setAttribute("listUser", userDAO.listAllUsers());
					 * request.getRequestDispatcher("DavesAdminPanel2.jsp").forward(request,
					 * response);
					 */
				case "/quoteInsertFromDave":
					System.out.println("Quote from dave being sent!");
					quoteInsertFromDave(request, response);
					System.out.println("Quote from dave sent - redirecting");
					AdminPanel(request, response);
					System.out.println("Quote from dave sent!");
					break;

				case "/quoteUpdateFromDave":
					System.out.println("Quote updatefrom dave being sent!");
					quoteUpdateFromDave(request, response);
					System.out.println("Quote update from dave sent - redirecting");
					AdminPanel(request, response);
					System.out.println("Quote updatefrom dave sent!");
					break;
				case "/quoteAcceptFromClient":
					System.out.println("Quote updatefrom dave being sent!");
					quoteAcceptFromClient(request, response);
					System.out.println("Quote update from dave sent - redirecting");
					AdminPanel(request, response);
					System.out.println("Quote updatefrom dave sent!");
					break;
				case "/quoteUpdateFromClient":
					System.out.println("Quote updatefrom dave being sent!");
					quoteUpdateFromClient(request, response);
					System.out.println("Quote update from dave sent - redirecting");
					System.out.println("Quote updatefrom dave sent!");
					break;
				case "/ClientsView":
					System.out.println("Clients View");
					ClientsView(request, response);

				case "/logout":
					logout(request, response);
					break;
				case "/list":
					System.out.println("The action is: list");
					listUser(request, response);
					break;
			}
		} catch (Exception ex) {
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

	private void rootPage(HttpServletRequest request, HttpServletResponse response, String view)
			throws ServletException, IOException, SQLException {
		System.out.println("root view");
		request.setAttribute("listUser", userDAO.listAllUsers());
		request.getRequestDispatcher("rootView.jsp").forward(request, response);
	}

	private void AdminPanel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("CSV-Daves Admin Panel");
		request.setAttribute("listQuote", quoteDAO.listAllQuotes());
		// request.setAttribute("reloadQuoteTable", quoteDAO.listAllQuotes());
		// request.setAttribute('insertInitialQuote', quoteDAO.insert(null));
		System.out.println("CSV-Listed Quotes");
		request.getRequestDispatcher("DavesAdminPanel.jsp").forward(request, response);
	}

	private void ClientsView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("CSV-Daves Admin Panel");
		// request.setAttribute("insertTree", treeDAO.insert(null));
		RequestDispatcher dispatcher = request.getRequestDispatcher("ClientsView.jsp");
		dispatcher.forward(request, response);
	}

	private void insertTree(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		int t = Integer.parseInt (request.getParameter("number of trees"));
		for (int i = 1; i <= t; i++) {
			Part filePart1 = request.getPart("images" + i + "1"); // Retrieving the file from request
			Part filePart2 = request.getPart("images" + i + "2"); // Retrieving the file from request
			Part filePart3 = request.getPart("images" + i + "3"); // Retrieving the file from request

			InputStream fileInputStream = filePart1.getInputStream(); // Getting InputStream from the file
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead;

			// Reading the file content into a ByteArrayOutputStream
			while ((bytesRead = fileInputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			// Converting the file content to a byte array
			byte[] fileBytes = outputStream.toByteArray();

			// Encoding the byte array to a Base64 string
			String photo1 = Base64.getEncoder().encodeToString(fileBytes);

			outputStream.close();
			fileInputStream.close();

			InputStream fileInputStream2 = filePart2.getInputStream(); // Getting InputStream from the file
			ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
			byte[] buffer2 = new byte[4096];
			int bytesRead2;

			// Reading the file content into a ByteArrayOutputStream
			while ((bytesRead2 = fileInputStream2.read(buffer2)) != -1) {
				outputStream2.write(buffer2, 0, bytesRead2);
			}

			// Converting the file content to a byte array
			byte[] fileBytes2 = outputStream2.toByteArray();

			// Encoding the byte array to a Base64 string
			String photo2 = Base64.getEncoder().encodeToString(fileBytes2);

			outputStream2.close();
			fileInputStream2.close();

			InputStream fileInputStream3 = filePart3.getInputStream(); // Getting InputStream from the file
			ByteArrayOutputStream outputStream3 = new ByteArrayOutputStream();
			byte[] buffer3 = new byte[4096];
			int bytesRead3;

			// Reading the file content into a ByteArrayOutputStream
			while ((bytesRead3 = fileInputStream3.read(buffer3)) != -1) {
				outputStream3.write(buffer3, 0, bytesRead3);
			}

			// Converting the file content to a byte array
			byte[] fileBytes3 = outputStream3.toByteArray();

			// Encoding the byte array to a Base64 string
			String photo3 = Base64.getEncoder().encodeToString(fileBytes3);

			outputStream3.close();
			fileInputStream3.close();

			// String treeNum = request.getParameter("size1");
			String treeSize = request.getParameter("size" + i);
			String treeHeight = request.getParameter("height" + i);
			String feetONI = request.getParameter("feetOrNo" + i);
			System.out.print("Tree Size");
			System.out.println(treeSize);
			System.out.print("Tree Height");
			System.out.println(treeHeight);
			System.out.print("Tree ONI");
			System.out.println(feetONI);
			tree trees = new tree(UUID.randomUUID().toString().substring(0, 5), treeSize, treeHeight,
					feetONI,
					photo1, photo2, photo3);

			treeDAO.insert(trees);
		}
		System.out.println("Quote done");
		// response.sendRedirect("login.jsp");
		response.sendRedirect("ClientsView.jsp");
	}

	private void quoteInsertFromDave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("Dave Sent Quote?");
		String orderID = request.getParameter("orderID");
		System.out.println(orderID);
		String quoteStatus = request.getParameter("quoteStatus");
		System.out.println("2");
		String initialPrice = request.getParameter("initialPrice");
		System.out.println("3");
		String note = request.getParameter("note");
		System.out.println("4");
		quote quotes = new quote(orderID, quoteStatus, initialPrice, note);
		System.out.println("5");
		quoteDAO.insert(quotes);
		System.out.println("Quote done");
		// response.sendRedirect("login.jsp");
		response.sendRedirect("DavesAdminPanel.jsp");
		// request.getRequestDispatcher("DavesAdminPanel.jsp").forward(request,
		// response);

	}

	private void quoteUpdateFromClient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("Dave Sent Quote?");
		String orderID = request.getParameter("orderID");
		System.out.println(orderID);
		String initialPrice = request.getParameter("initialPrice");
		System.out.println("3");
		String note = request.getParameter("note");
		System.out.println("4");
		quote quotes = new quote(orderID, "quoteFromClient", initialPrice, note);
		System.out.println("5");
		quoteDAO.update(quotes);
		System.out.println("Quote done");
		// response.sendRedirect("login.jsp");
		response.sendRedirect("ClientsView.jsp");
		// request.getRequestDispatcher("DavesAdminPanel.jsp").forward(request,
		// response);

	}

	private void quoteAcceptFromClient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("Dave Sent Quote?");
		String orderID = request.getParameter("orderID");
		System.out.println(orderID);
		String initialPrice = request.getParameter("initialPrice");
		System.out.println("3");
		String note = request.getParameter("note");
		System.out.println("4");
		quote quotes = new quote(orderID, "Accepted", "DUMMY", note);
		System.out.println("5");
		quoteDAO.updateToAccept(quotes);
		System.out.println("Quote done");
		// response.sendRedirect("login.jsp");
		response.sendRedirect("ClientsView.jsp");
		// request.getRequestDispatcher("DavesAdminPanel.jsp").forward(request,
		// response);

	}

	private void quoteUpdateFromDave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("Dave Update Sent Quote?");
		String orderID = request.getParameter("orderID");
		// System.out.println("1");
		// String quoteStatus = request.getParameter("quoteStatus");
		// System.out.println("2");
		String initialPrice = request.getParameter("initialPrice");
		// System.out.println("3");
		String note = request.getParameter("note");
		System.out.println("4");
		quote quotes = new quote(orderID, "quoteFromContractor", initialPrice, note);
		System.out.println("5");
		quoteDAO.update(quotes);
		System.out.println("Quote done");
		// response.sendRedirect("login.jsp");
		// response.sendRedirect("DavesAdminPanel.jsp");
		request.getRequestDispatcher("DavesAdminPanel.jsp").forward(request, response);

	}

	private void treeRequestInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// System.out.println("Dave Sent Quote?");
		// String orderID = request.getParameter("orderID");
		// String quoteStatus = request.getParameter("quoteStatus");
		// String initialPrice = request.getParameter("initialPrice");
		// String note = request.getParameter("note");
		// quote quotes = new quote(orderID,quoteStatus, initialPrice, note);
		// quoteDAO.insert(quotes);
		System.out.println("Quote done");
		// response.sendRedirect("login.jsp");
		// response.sendRedirect("DavesAdminPanel.jsp");
		// request.getRequestDispatcher("DavesAdminPanel.jsp").forward(request,
		// response);

	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email.equals("root") && password.equals("john1234")) {
			System.out.println("Login Successful! Redirecting to root");
			session = request.getSession();
			session.setAttribute("username", email);
			rootPage(request, response, "");
		} else if (userDAO.isValid(email, password)) {

			currentUser = email;
			System.out.println("Login Successful! Redirecting");
			request.getRequestDispatcher("activitypage.jsp").forward(request, response);

		} else {
			request.setAttribute("loginStr", "Login Failed: Please check your credentials.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
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
				user users = new user(email, firstName, lastName, password, clientID, adress_street_num,
						adress_street, adress_city, adress_state, adress_zip_code, creditCard,
						phoneNum);
				userDAO.insert(users);
				response.sendRedirect("login.jsp");
			} else {
				System.out.println("Username taken, please enter new username");
				request.setAttribute("errorOne",
						"Registration failed: Username taken, please enter a new username.");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} else {
			System.out.println("Password and Password Confirmation do not match");
			request.setAttribute("errorTwo",
					"Registration failed: Password and Password Confirmation do not match.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		currentUser = "";
		response.sendRedirect("login.jsp");
	}

}