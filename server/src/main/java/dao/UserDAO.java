package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Project;
import model.User;

public class UserDAO {

	private static final Map<Integer, User> userMap = new HashMap<Integer, User>();
	private static int i = 4;

	static {
		initUsers();
	}

	private static void initUsers() {
		User user1 = new User(1, "almada", "123", "UFC", "CC");
		User user2 = new User(2, "anderson", "456","UFC", "CC");
		User user3 = new User(3, "alex", "789","UFC", "CC");

		userMap.put(user1.getId(), user1);
		userMap.put(user2.getId(), user2);
		userMap.put(user3.getId(), user3);
	}

	public static User getUser(int id) {
		return userMap.get(id);
	}

	public static User getUserByLogin(String login) {
		List<User> list = getAllUsers();

		for (User user : list) {
			if (user.getLogin().equals(login)) {
				return user;
			}
		}

		return null;
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
	public static User addUser(String login, String password, String instituicao, String curso) {
		User user = new User(i, login, password,instituicao, curso);
		userMap.put(user.getId(), user);
		i++;
		return user;
	}

	public static User updateUser(int id, String login, String password,String instituicao, String curso) {
		User user = new User(i, login, password,instituicao, curso);
		userMap.put(user.getId(), user);
		return user;
	}

	public static void deleteUser(int id) {
		if (userMap.containsKey(id)) {
			userMap.remove(id);
		}
	}
	
//	@SuppressWarnings("unchecked")
//	public static User addProject(int id, String titulo, String descricao, String palavrasChaves, String tipo) {
//		Project projeto = new Project(titulo, descricao, palavrasChaves, tipo);
//		User user = getUser(id);
//		user.getProjetos().add(projeto);
//		return user;
//		
//	}
	
	public static List<User> getAllUsers() {
		return new ArrayList<User>(userMap.values());
	}
	
	
}