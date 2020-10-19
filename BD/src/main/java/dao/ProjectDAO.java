package dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Project;

public class ProjectDAO {

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("DivPro");
	static EntityManager manager;

	public static Project addProject(int user_id, String titulo, String descricao, String palavras_chaves,
			String tipo) {

		Project projeto = new Project(user_id, titulo, descricao, palavras_chaves, tipo);
		
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		System.out.println(projeto	);
		manager.persist(projeto);
		manager.getTransaction().commit();
		manager.close();

		return projeto;
	}

	public static Project updateProject(int id, int user_id, String titulo, String descricao, String palavras_chaves,
			String tipo) {
		System.out.println("Entrou no updadte project 1");

		Project projeto = new Project(id, user_id, titulo, descricao, palavras_chaves, tipo);
		System.out.println("Entrou no updadte project 2");
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(projeto);
		System.out.println(projeto);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Entrou no updadte project 3");

		return projeto;

	}

	public static void deleteProject(int id) {

		manager = factory.createEntityManager();

		Project projeto = manager.find(Project.class, id);

		manager.getTransaction().begin();
		manager.remove(projeto);
		manager.getTransaction().commit();
		manager.close();

	}

	public static List<Project> getAllProjects() {
		manager = factory.createEntityManager();
		List<Project> projetos = manager.createQuery("from projects", Project.class).getResultList();
		manager.close();

		return projetos;
	}

	public static Project getProject(int id) {
		manager = factory.createEntityManager();
		Project projeto = manager.find(Project.class, id);
		manager.close();

		return projeto;
	}

	public static Project getProjectByTitulo(String titulo) {
		manager = factory.createEntityManager();
		Project projeto = manager.createQuery("from projects where titulo=?1", Project.class).setParameter(1, titulo)
				.getSingleResult();
		manager.close();

		return projeto;
	}
}