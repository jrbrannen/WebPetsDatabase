package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	
}
