package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.JSONObject;

import util.FileUtil;

@WebServlet("/upload/*")
@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Upload() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// File
		Part filePart = request.getPart("file");
		InputStream fileContent = filePart.getInputStream();

		// Object
		JSONObject jsonObject = new JSONObject(request.getParameter("obj"));

		String resource = jsonObject.getString("resource");
		int id = jsonObject.getInt("id");

		FileUtil.uploadFile(fileContent, resource, ""+id);

		response.getWriter().flush();
	}
}
