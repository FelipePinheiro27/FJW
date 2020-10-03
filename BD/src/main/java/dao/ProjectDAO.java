package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import util.DbUtil;

public class ProjectDAO {

	private static Connection connection = DbUtil.getConnection();

	public static Project addProject(int user_id, String titulo, String descricao, String palavras_chaves,
			String tipo) {
		System.out.println("AddProject --> Entrou no addProject");
		try {
			System.out.println("AddProject --> Entrou no Try do addProject");
			PreparedStatement pStmt = connection.prepareStatement(
					"insert into projetos(user_id, titulo, descricao, palavras_chaves, tipo) values (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setInt(1, user_id);
			pStmt.setString(2, titulo);
			pStmt.setString(3, descricao);
			pStmt.setString(4, palavras_chaves);
			pStmt.setString(5, tipo);

			pStmt.executeUpdate();

			ResultSet rs = pStmt.getGeneratedKeys();
			System.out.println("AddProject --> Printando rs: " + rs);
			if (rs.next()) {
				System.out.println("AddProject --> Retornou Corretamente");
				return new Project(rs.getInt("id"), rs.getInt("user_id"), rs.getString("titulo"),
						rs.getString("descricao"), rs.getString("palavras_chaves"), rs.getString("tipo"));

			}
		} catch (SQLException e) {
			System.out.println("AddProject --> Foi pra SQLException");
			e.printStackTrace();
		}
		System.out.println("AddProject --> Retounou nulo");
		return null;
	}

	public static Project updateProject(int id, int user_id, String titulo, String descricao, String palavras_chaves,
			String tipo) {
		try {
			PreparedStatement pStmt = connection.prepareStatement(
					"update users set user_id=?, titulo=? where id=?, descricao=?, palavras_chaves=?, tipo=?",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setInt(1, user_id);
			pStmt.setString(2, titulo);
			pStmt.setInt(3, id);
			pStmt.setString(4, descricao);
			pStmt.setString(5, palavras_chaves);
			pStmt.setString(6, tipo);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				return new Project(rs.getInt("id"), rs.getInt("user_id"), rs.getString("titulo"),
						rs.getString("descricao"), rs.getString("palavras_chaves"), rs.getString("tipo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void deleteProject(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("delete from projetos where id=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Project> getAllProjects() {
		List<Project> projetos = new ArrayList<Project>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from projetos order by id");
			while (rs.next()) {
				Project projeto = new Project(rs.getInt("id"), rs.getInt("user_id"), rs.getString("titulo"),
						rs.getString("descricao"), rs.getString("palavras_chaves"), rs.getString("tipo"));
				projetos.add(projeto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return projetos;
	}

	public static Project getProject(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from projetos where id=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new Project(rs.getInt("id"), rs.getInt("user_id"), rs.getString("titulo"),
						rs.getString("descricao"), rs.getString("palavras_chaves"), rs.getString("tipo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Project getUserByTitulo(String titulo) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from projetos where titulo=?");

			pStmt.setString(1, titulo);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new Project(rs.getInt("id"), rs.getInt("user_id"), rs.getString("titulo"),
						rs.getString("descricao"), rs.getString("palavras_chaves"), rs.getString("tipo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}