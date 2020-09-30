package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.ProjectDAO;
import dao.UserDAO;
import model.Project;
import model.User;

@WebServlet("/api/projects/*")
public class ProjectService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProjectService() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// GET BY ID
		String pathInfo = request.getPathInfo();

		if (pathInfo != null) {
			String[] params = pathInfo.split("/");

			if (params.length > 0) {
				Project projeto = ProjectDAO.getProject(Integer.parseInt(params[1]));

				if (projeto != null) {
					JSONObject jsonObject = new JSONObject();
//	public static Project addProject (int userId, String titulo, String descricao, String palavrasChaves, String tipo) {

					jsonObject.put("id", projeto.getId());
					jsonObject.put("userId", projeto.getUserId());
					jsonObject.put("titulo", projeto.getTitulo());
					jsonObject.put("descricao", projeto.getDescricao());
					jsonObject.put("palavrasChaves", projeto.getPalavrasChaves());
					jsonObject.put("tipo", projeto.getTipo());


					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().print(jsonObject.toString());
					response.getWriter().flush();
				}
				return;
			}
		}

		// GET BY NAME
//		if (request.getParameter("titulo") != null) {
////			System.out.println(request.getParameter("login"));
////			System.out.println(request.getParameter("password"));
//
//			User user = ProjectDAO.getUserByLogin(request.getParameter("titulo"));
//
//			if (user != null) {
//
//				JSONObject jsonObject = new JSONObject();
//
//				jsonObject.put("id", user.getId());
//				jsonObject.put("login", user.getLogin());
//				jsonObject.put("password", user.getPassword());
//				jsonObject.put("instituicao", user.getInstituicao());
//				jsonObject.put("curso", user.getCurso());
//
//				response.setContentType("application/json");
//				response.setCharacterEncoding("UTF-8");
//				response.getWriter().print(jsonObject.toString());
//				response.getWriter().flush();
//
//			}
//			return;
//		}

		// GET ALL
		List<Project> list = ProjectDAO.getAllUsers();

		try {
			JSONArray jArray = new JSONArray();

			for (Project projeto : list) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("id", projeto.getId());
				jsonObject.put("userId", projeto.getUserId());
				jsonObject.put("titulo", projeto.getTitulo());
				jsonObject.put("descricao", projeto.getDescricao());
				jsonObject.put("palavrasChaves", projeto.getPalavrasChaves());
				jsonObject.put("tipo", projeto.getTipo());

				jArray.put(jsonObject);
			}

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jArray.toString());
			response.getWriter().flush();
		} catch (Exception e) {

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
		}

		Project projeto = null;
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			projeto = ProjectDAO.addProject(jsonObject.getInt("userId"), jsonObject.getString("titulo"),
					jsonObject.getString("descricao"), jsonObject.getString("palavrasChaves"),jsonObject.getString("tipo"));

			// Response
			jsonObject = new JSONObject();
			jsonObject.put("id", projeto.getId());
			jsonObject.put("userId", projeto.getUserId());
			jsonObject.put("titulo", projeto.getTitulo());
			jsonObject.put("descricao", projeto.getDescricao());
			jsonObject.put("palavrasChaves", projeto.getPalavrasChaves());
			jsonObject.put("tipo", projeto.getTipo());

			System.out.println(jsonObject);

		} catch (JSONException e) {
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject.toString());
		response.getWriter().flush();
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// UPDATE BY ID
		String pathInfo = request.getPathInfo();

		if (pathInfo != null) {
			String[] params = pathInfo.split("/");

			if (params.length > 0) {
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
					user = UserDAO.updateUser(Integer.parseInt(params[1]), jsonObject.getString("login"),
							jsonObject.getString("password"), jsonObject.getString("instituicao"),
							jsonObject.getString("curso"));

					// Response
					jsonObject = new JSONObject();
					jsonObject.put("id", user.getId());
					jsonObject.put("login", user.getLogin());
					jsonObject.put("password", user.getPassword());
					jsonObject.put("instituicao", user.getInstituicao());
					jsonObject.put("curso", user.getCurso());

				} catch (JSONException e) {
				}

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(jsonObject.toString());
				response.getWriter().flush();
			}
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DELETE BY ID
		String pathInfo = request.getPathInfo();

		if (pathInfo != null) {
			String[] params = pathInfo.split("/");

			if (params.length > 0) {
				ProjectDAO.deleteProject(Integer.parseInt(params[1]));

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().flush();
			}
		}
	}

}
