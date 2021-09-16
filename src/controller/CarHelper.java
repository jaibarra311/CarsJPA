package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Car;




/**
 * @author jaiba - jaibarra
 * CIS175 - Fall 2021
 * Sep 15, 2021
 */
public class CarHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Cars");

	public void insertCar(Car c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();

	}

	public static List<Car> showAllCars() {
		EntityManager em = emfactory.createEntityManager();
		List<Car> allItems = em.createQuery("SELECT i FROM Car i").getResultList();
		return allItems;
	}

	public void deleteACar(Car toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select ch from Car ch where ch.model = :selectedModel and ch.color = :selectedColor and ch.year = :selectedYear", Car.class);


		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedColor", toDelete.getColor());
		typedQuery.setParameter("selectedYear", toDelete.getYear());


		typedQuery.setMaxResults(1);

		Car result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}


	public List<Car> searchForItemByModel(String model) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.model = :selectedModel", Car.class);
		typedQuery.setParameter("selectedModel", model);
		List<Car> foundItems = typedQuery.getResultList();
		em.close();

		return foundItems;
	}


	public List<Car> searchForItemByColor(String color) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.color = :selectedColor", Car.class);
		typedQuery.setParameter("selectedColor", color);
		List<Car> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}


	public Car searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Car found = em.find(Car.class, idToEdit);
		em.close();
		return found;
	}

	public void updateCar(Car toEdit) {
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


