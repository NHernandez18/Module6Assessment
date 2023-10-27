package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

/**
 * Nicholas Hernandez - NHernandez6
 * CIS175 - Fall 2023
 * Oct 20, 2023
 */
public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Mod6Assessment");
	
	public void insertItem(ListItem	li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public	List<ListItem> showAllItems(){
		EntityManager	em	=	emfactory.createEntityManager();
		List<ListItem> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allItems;
		}
	
	public	void	cleanUp(){
		emfactory.close();
		}
	
	public	void	deleteItem(ListItem	toDelete)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem>	typedQuery	=	em.createQuery("select	li	from ListItem	li	where	li.brand	=	:selectedBrand	and	li.shoe	=	:selectedShoe",	ListItem.class);
		//Substitute	parameter	with	actual	data	from	the	toDelete	item
		typedQuery.setParameter("selectedBrand",	toDelete.getBrand());
		typedQuery.setParameter("selectedShoe",	toDelete.getShoe());
		//we	only	want	one	result
		typedQuery.setMaxResults(1);
		//get	the	result	and	save	it	into	a	new	list	item
		ListItem	result	=	typedQuery.getSingleResult();
		//remove	it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	public ListItem searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, idToEdit);
		em.close();
		return found;
	}

	public ListItem searchForItemByShoe(String shoe) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Mod6Assessment");
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ListItem> query = manager.createQuery("SELECT i FROM ListItem AS i WHERE i.shoe = :shoe", ListItem.class);
		query.setParameter("shoe", shoe);
		ListItem dbEntity = query.getSingleResult();
		manager.close();
		return dbEntity;
	}
	}
