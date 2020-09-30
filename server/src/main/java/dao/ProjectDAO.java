package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Project;
import model.User;

public class ProjectDAO {

	private static final Map<Integer, Project> projectMap = new HashMap<Integer, Project>();
	private static int i = 4;

	static {
		initProjects();
	}

	private static void initProjects() {
		Project projeto1 = new Project(1, 1, "BIA", "Projeto BIA", "Bolsa, BIA, Projeto", "BIA");
		Project projeto2 = new Project(2, 2, "WEB", "Projeto WEB", "Disciplina, WEB, Projeto", "WEB");
		Project projeto3 = new Project(3, 3, "NPDS", "Projeto NPDS", "Estágio, NPDS, Projeto", "NPDS");

		projectMap.put(projeto1.getId(), projeto1);
		projectMap.put(projeto2.getId(), projeto2);
		projectMap.put(projeto3.getId(), projeto3);
	}

	public static Project getProject(int id) {
		return projectMap.get(id);
	}

//	public static User getUserByLogin(String login) {
//		List<User> list = getAllUsers();
//
//		for (User user : list) {
//			if (user.getLogin().equals(login)) {
//				return user;
//			}
//		}
//
//		return null;
//	}

//	public static User getUserByLoginAndPassword(String login, String password) {
//		List<User> list = getAllUsers();
//
//		for (User user : list) {
//			if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
//				return user;
//			}
//		}
//
//		return null;
//	}
	public static Project addProject (int userId, String titulo, String descricao, String palavrasChaves, String tipo) {
		Project projeto = new Project(i, userId, titulo, descricao, palavrasChaves, tipo);
		projectMap.put(projeto.getId(), projeto);
		i++;
		return projeto;
	}

	public static Project updateUser(int userId, String titulo, String descricao, String palavrasChaves, String tipo) {
		Project projeto = new Project(i, userId, titulo, descricao, palavrasChaves, tipo);
		projectMap.put(projeto.getId(), projeto);
		return projeto;
	}

	public static void deleteProject(int id) {
		if (projectMap.containsKey(id)) {
			projectMap.remove(id);
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
	
	public static List<Project> getAllUsers() {
		return new ArrayList<Project>(projectMap.values());
	}
}