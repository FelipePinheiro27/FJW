package controller;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import dao.UserDAO;
import model.User;

@WebServlet("/api/users/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Testando");
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
		}

		User user = null;
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			user = UserDAO.getUserByLoginAndPassword(jsonObject.getString("login"), jsonObject.getString("password"));

			if (user != null) {
				// Response
				jsonObject = new JSONObject();
				jsonObject.put("id", user.getId());
				jsonObject.put("login", user.getLogin());
				jsonObject.put("password", user.getPassword());
				jsonObject.put("instituicao", user.getInstituicao());
				jsonObject.put("curso", user.getCurso());

				

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(jsonObject.toString());
				response.getWriter().flush();
			} else {
				return;
			}

		} catch (JSONException e) {
		}
	}
}
