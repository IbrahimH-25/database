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
import java.util.Random;


class numGenerator
{
	public String returnRandom6DigID() {
		
		// create instance of Random class
        Random rand = new Random();
   
        // Generate random integers in range 0 to 999999
        int rand_int1 = rand.nextInt(1000000);
        return String.format("%06d", Integer.parseInt(String.valueOf(rand_int1)));
        
	}
	
	
}