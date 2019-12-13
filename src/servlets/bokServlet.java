package servlets;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bokServlet
 */
@WebServlet("/bokServlet")
public class bokServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bokServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	 public String getL() 
	    {
	    	String rts = new String();
	    	try
	    	{
	    		Class.forName("com.mysql.jdbc.Driver");
	    		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "password");
	    		java.sql.PreparedStatement st = con.prepareStatement("select model from car;");
	    		java.sql.ResultSet rs = st.executeQuery();
	    		while(rs.next())
	    		{
	    			rts+="<option value=\""+rs.getString("model")+"\">"+rs.getString("model")+"</option>";
	    		}
	    		con.close();
	    	//	System.out.print("\ngetL() ends here "+ rts);
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	return rts;
	    }

}
