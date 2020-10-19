package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.User;

public class UserDAO {

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("DivPro");
	static EntityManager manager;

	public static User addUser(String login, String password, String curso, String instituicao) {
		User user = new User(login, password, curso, instituicao);

		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(user);
		System.out.println(user);
		manager.getTransaction().commit();
		manager.close();

		return user;
	}

	public static User updateUser(int id, String login, String password, String curso, String instituicao) {
		User user = new User(id, login, password, curso, instituicao);

		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(user);
		manager.getTransaction().commit();
		manager.close();

		return user;
	}

	public static void deleteUser(int id) {
		manager = factory.createEntityManager();

		User user = manager.find(User.class, id);

		manager.getTransaction().begin();
		manager.remove(user);
		manager.getTransaction().commit();
		manager.close();
	}

	public static List<User> getAllUsers() {
		manager = factory.createEntityManager();
		List<User> users = manager.createQuery("from users", User.class).getResultList();
		manager.close();

		return users;
	}

	public static User getUser(int id) {
		manager = factory.createEntityManager();
		User user = manager.find(User.class, id);
		manager.close();

		return user;
	}

	public static User getUserByLogin(String login) {
		 manager = factory.createEntityManager();
	        User user = manager.createQuery("from users where login=?1", User.class).setParameter(1, login).getSingleResult();
	        manager.close();
	        return user;
	}
	public static User getUserByLoginAndPassword(String login, String password) {
		List<User> list = getAllUsers();
		for (User user : list) {
			if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}