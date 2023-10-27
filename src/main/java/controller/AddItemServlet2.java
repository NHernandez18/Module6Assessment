package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem2;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addItemServlet2")
public class AddItemServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		
		ListItem2 li = new ListItem2(make, model);
		ListItemHelper2 dao = new ListItemHelper2();
		dao.insertItem(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
