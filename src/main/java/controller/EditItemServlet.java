package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListItemHelper helper = new ListItemHelper ();
		
		String id = request.getParameter("id");
		int movieId = Integer.parseInt(id);
		String title = request.getParameter("title");
		String year = request.getParameter("year");

		ListItem movieToUpdate = helper.searchForItemById(movieId);
		movieToUpdate.setTitle(title);
		movieToUpdate.setYear(year);
		helper.update(movieToUpdate);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
