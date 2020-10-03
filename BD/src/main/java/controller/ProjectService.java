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

					jsonObject.put("id", projeto.getId());
					jsonObject.put("user_id", projeto.getuser_id());
					jsonObject.put("titulo", projeto.getTitulo());
					jsonObject.put("descricao", projeto.getDescricao());
					jsonObject.put("palavras_chaves", projeto.getpalavras_chaves());
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
		List<Project> list = ProjectDAO.getAllProjects();

		try {
			JSONArray jArray = new JSONArray();

			for (Project projeto : list) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("id", projeto.getId());
				jsonObject.put("user_id", projeto.getuser_id());
				jsonObject.put("titulo", projeto.getTitulo());
				jsonObject.put("descricao", projeto.getDescricao());
				jsonObject.put("palavras_chaves", projeto.getpalavras_chaves());
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
		System.out.println("Entrou no doPost de projectService");
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			System.out.println("Entrou no try do BufferedReader no doPost de projectService");
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			System.out.println("Entrou no catch do Exception no doPost de projectService");

		}
		
		Project projeto = null;
		JSONObject jsonObject = new JSONObject(jb.toString());
		System.out.println("Antes de entrar no try principal doPost");
		try {
			System.out.println("Entrou no try principal doPost");
			System.out.println("AddProject --> Projeto: " + projeto);
			System.out.println("Print do JsonObject --->" + jsonObject);
			projeto = ProjectDAO.addProject((jsonObject.getInt("user_id")), jsonObject.getString("titulo"), jsonObject.getString("descricao")
					,jsonObject.getString("palavras_chaves"), jsonObject.getString("tipo"));
			//Buga antes disso
			System.out.println("Atribuiu variaveis ao projeto");

			// Response
			jsonObject = new JSONObject();
			jsonObject.put("id", projeto.getId());
			jsonObject.put("user_id", projeto.getuser_id());
			jsonObject.put("titulo", projeto.getTitulo());
			jsonObject.put("descricao", projeto.getDescricao());
			jsonObject.put("palavras_chaves", projeto.getpalavras_chaves());
			jsonObject.put("tipo", projeto.getTipo());
			System.out.println("Atribuiu variaveis ao jsonObject");


		} catch (JSONException e) {
			System.out.println("Entro no catch principal doPost... JSONException");

		}

		if (jsonObject != null) {
			System.out.println("jsonObject não é nulo");
			System.out.println("Printando jsonObject: " + jsonObject);


			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jsonObject.toString());
			response.getWriter().flush();
		}
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

				Project projeto = null;
				JSONObject jsonObject = null;

				try {
					// Request
					jsonObject = new JSONObject(jb.toString());
					projeto = ProjectDAO.updateProject(Integer.parseInt(params[1]), jsonObject.getInt("user_id"), jsonObject.getString("titulo"),
							jsonObject.getString("descricao"),  jsonObject.getString("palavras_chaves"),  jsonObject.getString("tipo"));

					// Response
					jsonObject = new JSONObject();
					jsonObject.put("id", projeto.getId());
					jsonObject.put("user_id", projeto.getuser_id());
					jsonObject.put("titulo", projeto.getTitulo());
					jsonObject.put("descricao", projeto.getDescricao());
					jsonObject.put("palavras_chaves", projeto.getpalavras_chaves());
					jsonObject.put("tipo", projeto.getTipo());

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
