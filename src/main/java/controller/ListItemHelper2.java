package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem2;


/**
 * Nicholas Hernandez - NHernandez6
 * CIS175 - Fall 2023
 * Oct 21, 2023
 */
public class ListItemHelper2 {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LibraryPartnerProject2");
	
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
		TypedQuery<ListItem2>	typedQuery	=	em.createQuery("select	li	from ListItem2	li	where	li.title	=	:selectedTitle	and	li.author	=	:selectedAuthor",	ListItem2.class);
		//Substitute	parameter	with	actual	data	from	the	toDelete	item
		typedQuery.setParameter("selectedTitle",	toDelete.getTitle());
		typedQuery.setParameter("selectedAuthor",	toDelete.getAuthor());
		//we	only	want	one	result
		typedQuery.setMaxResults(1);
		//get	the	result	and	save	it	into	a	new	list	item
		ListItem2	result	=	typedQuery.getSingleResult();
		//remove	it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	public ListItem2 searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem2 found = em.find(ListItem2.class, idToEdit);
		em.close();
		return found;
	}

	public ListItem2 searchForItemByTitle(String title) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPartnerProject2");
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ListItem2> query = manager.createQuery("SELECT i FROM ListItem2 AS i WHERE i.title = :title", ListItem2.class);
		query.setParameter("title", title);
		ListItem2 dbEntity = query.getSingleResult();
		manager.close();
		return dbEntity;
	}

	public void update(ListItem2 model) {
		EntityManager manager = emfactory.createEntityManager();
		ListItem2 dbEntity = manager.find(ListItem2.class, model.getId());
		manager.getTransaction().begin();
		dbEntity.setTitle(model.getTitle());
		dbEntity.setAuthor(model.getAuthor());
		manager.getTransaction().commit();
		manager.close();
	}
}
