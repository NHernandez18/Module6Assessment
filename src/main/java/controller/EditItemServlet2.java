package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem2;

/**
 * Servlet implementation class EditItemServlet2
 */
@WebServlet("/editItemServlet2")
public class EditItemServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListItemHelper2 helper = new ListItemHelper2 ();
		
		String id = request.getParameter("id");
		int bookId = Integer.parseInt(id);
		String title = request.getParameter("title");
		String author = request.getParameter("author");

		ListItem2 bookToUpdate = helper.searchForItemById(bookId);
		bookToUpdate.setTitle(title);
		bookToUpdate.setAuthor(author);
		helper.update(bookToUpdate);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
