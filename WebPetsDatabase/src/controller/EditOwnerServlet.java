package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;

/**
 * Servlet implementation class EditOwnerServlet
 */
@WebServlet("/editOwnerServlet")
public class EditOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OwnerHelper oh = new OwnerHelper();
		
		String name = request.getParameter("name");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Owner ownerToUpdate = oh.searchForOwnerById(tempId);
		ownerToUpdate.setName(name);
		
		oh.updateOwner(ownerToUpdate);
		
		getServletContext().getRequestDispatcher("/viewOwnersServlet").forward(request, response);
	}

}
