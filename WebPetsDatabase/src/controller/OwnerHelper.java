package controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Owner;



/**
 * @author Corry Burton - codabu
 *CIS175
 * Mar 5 2021
 */


public class OwnerHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebPetsDatabase"); 
	
	
	public List<Owner> showAllOwners() {
		EntityManager em = emfactory.createEntityManager();
		List<Owner> allOwners = em.createQuery("SELECT i FROM Owner i").getResultList();
		return allOwners;
	}
	
	public void deleteOwner(Owner toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select i from Owner i where i.id = :selectedId and i.name = :selectedName", Owner.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setParameter("selectedName", toDelete.getName());
		
		typedQuery.setMaxResults(1);
		
		Owner result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void insertItem(Owner o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
		}

	//cleanUp method closes off the connection to the db
		public void cleanUp() {
			emfactory.close();
		}

		/**
		 * @param tempId
		 * @return
		 */
		public Owner searchForOwnerById(Integer idToEdit) {
			// uses entity manager object to search database for an id
			// and returns it in a variable
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			Owner found = em.find(Owner.class, idToEdit);
			em.close();
			return found;
		}

		/**
		 * @param ownerToUpdate
		 */
		public void updateOwner(Owner ownerToUpdate) {
			// uses entity object to merge(update) either the store or item depending on
			// user input and save it to the database using the same id number
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(ownerToUpdate);
			em.getTransaction().commit();
			em.close();
			
		}
	
}
