/**
 * 
 */
package controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Pet;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Feb 26, 2021
 */
public class PetHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebPetsDatabase");

	public void deletePet(Pet toDelete) {

		// create a entity manager object using persistence
		EntityManager em = emfactory.createEntityManager();

		// queries the database for matching search criteria and stores any matches as
		// variables in a list
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery(
				"select p from Pets p where p.name = :selectedName and p.type = :selectedType and p.adoptionDate = :selectedAdoptionDate",
				Pet.class);

		// substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedAdoptionDate", toDelete.getAdoptionDate());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Pet result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Pet> showAllPets() {

		// users entity manager object to query data and puts the data in a list
		EntityManager em = emfactory.createEntityManager();
		List<Pet> allPets = em.createQuery("SELECT p FROM Pet p").getResultList();
		return allPets;
	}
	
	public Pet searchForPetById(int idToEdit) {

		// uses entity manager object to search database for an id
		// and returns it in a variable
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Pet found = em.find(Pet.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updatePet(Pet toEdit) {

		// uses entity object to merge(update) name, type, or adoption date depending on
		// user input and saves it to the database using the id number
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();

	}
	
}
