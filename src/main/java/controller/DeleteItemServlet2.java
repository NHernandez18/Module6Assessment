package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;
import model.ListItem2;

/**
 * Servlet implementation class DeleteItemServlet2
 */
@WebServlet("/deleteItemServlet2")
public class DeleteItemServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItemServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		
		ListItemHelper2 dao = new ListItemHelper2();
		
		ListItem2 itemToDelete = dao.searchForItemByTitle(title);
		dao.deleteItem(itemToDelete);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
