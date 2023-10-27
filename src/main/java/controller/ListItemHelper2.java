package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;
import model.ListItem2;


/**
 * Nicholas Hernandez - NHernandez6
 * CIS175 - Fall 2023
 * Oct 21, 2023
 */
public class ListItemHelper2 {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Mod6Assessment");
	
	public void insertItem(ListItem2 li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public	List<ListItem2> showAllItems(){
		EntityManager	em	=	emfactory.createEntityManager();
		List<ListItem2> allItems = em.createQuery("SELECT i FROM ListItem2 i").getResultList();
		return allItems;
		}
	
	public	void	cleanUp(){
		emfactory.close();
		}
	
	public	void	deleteItem(ListItem2	toDelete)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem2>	typedQuery	=	em.createQuery("select	li	from ListItem2	li	where	li.make	=	:selectedMake	and	li.model	=	:selectedModel",	ListItem2.class);
		//Substitute	parameter	with	actual	data	from	the	toDelete	item
		typedQuery.setParameter("selectedMake",	toDelete.getMake());
		typedQuery.setParameter("selectedModel",	toDelete.getModel());
		//we	only	want	one	result
		typedQuery.setMaxResults(1);
		//get	the	result	and	save	it	into	a	new	list	item
		ListItem2	result	=	typedQuery.getSingleResult();
		//remove	it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}

	public ListItem2 searchForItemByMake(String make) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Mod6Assessment");
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ListItem2> query = manager.createQuery("SELECT i FROM ListItem2 AS i WHERE i.make = :make", ListItem2.class);
		query.setParameter("make", make);
		ListItem2 dbEntity = query.getSingleResult();
		manager.close();
		return dbEntity;
	}
}
