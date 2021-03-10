package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;
import model.Pet;
import controller.LocalDateAttributeConverter;

/**
 * Servlet implementation class addPetServlet
 */
@WebServlet("/addPetServlet")
public class addPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPetServlet() {
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
		String type = request.getParameter("type");
		LocalDate date = LocalDate.parse(request.getParameter("adoptionDate"));
		
		
		int ownerId = Integer.parseInt(request.getParameter("id"));
		Owner owner = oh.searchForOwnerById(ownerId);
		Pet p = new Pet(name, type, date, owner);
		PetHelper dao = new PetHelper();
		dao.insertItem(p);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
