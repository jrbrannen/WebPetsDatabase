package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Owner;

/**
 * Servlet implementation class OwnerNavServlet
 */
@WebServlet("/ownerNavServlet")
public class OwnerNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OwnerHelper oh	= new OwnerHelper();
		String act = request.getParameter("doThisToOwner");
		
		String path = "/viewOwnersServlet";
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Owner ownerToDelete = oh.searchForOwnerById(tempId);
				oh.deleteOwner(ownerToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an owner");
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Owner ownerToEdit = oh.searchForOwnerById(tempId);
				request.setAttribute("ownerToEdit", ownerToEdit);
				path = "/edit-owner.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select an owner.");
			}
		} else if (act.equals("add")) {
			path = "/index.html";
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
