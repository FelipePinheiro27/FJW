package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.DbUtil;

public class UserDAO {

	private static Connection connection = DbUtil.getConnection();

	public static User addUser(String login, String password, String curso, String instituicao) {
		System.out.println("Entrou no addUser");
		try {
			PreparedStatement pStmt = connection.prepareStatement(
					"insert into users(login, password, curso, instituicao) values (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, login);
			pStmt.setString(2, password);
			pStmt.setString(3, curso);
			pStmt.setString(4, instituicao);
			pStmt.executeUpdate();

			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("curso"),
						rs.getString("instituicao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User updateUser(int id, String login, String password, String curso, String instituicao) {
		try {
			PreparedStatement pStmt = connection.prepareStatement(
					"update users set login=?, password=? where id=?, curso=?, instituicao=?",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, login);
			pStmt.setString(2, password);
			pStmt.setInt(3, id);
			pStmt.setString(4, curso);
			pStmt.setString(5, instituicao);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("curso"),
						rs.getString("instituicao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void deleteUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("delete from users where id=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users order by id");
			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"),
						rs.getString("curso"), rs.getString("instituicao"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public static User getUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where id=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("curso"),
						rs.getString("instituicao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User getUserByLogin(String login) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where login=?");
			pStmt.setString(1, login);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("curso"),
						rs.getString("instituicao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}