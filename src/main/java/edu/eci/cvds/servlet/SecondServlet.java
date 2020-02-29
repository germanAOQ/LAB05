package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.model.Todo;

@WebServlet(
		urlPatterns = "/secondServlet"
		)

public class SecondServlet extends HttpServlet{
	static final long serialVersionUID = 35L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Writer responseWriter = resp.getWriter();
			String value = req.getParameter("name");
			int i = Integer.parseInt(value);
			Todo todo = Service.getTodo(i);
			int valor = todo.getUserId();
			boolean temp = ((valor>=1) && (valor<=10));
			List<Todo> lista = new ArrayList<Todo>();
			lista.add(todo);
			System.out.println(Service.todosToHTMLTable(lista));
			if(temp){
				responseWriter.write(Service.todosToHTMLTable(lista));
				responseWriter.flush();
			}
		}catch(NumberFormatException eN) {
			HttpServletResponse response=(HttpServletResponse) resp;
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			response.setContentType("what you need");
		}catch(MalformedURLException eM) {
			HttpServletResponse response=(HttpServletResponse) resp;
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.setContentType("what you need");
		}catch(FileNotFoundException eF) {
			HttpServletResponse response=(HttpServletResponse) resp;
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			response.setContentType("what you need");
		}catch(Exception eG){
			HttpServletResponse response=(HttpServletResponse) resp;
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.setContentType("what you need");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Writer responseWriter = resp.getWriter();
			String value = req.getParameter("name");
			int i = Integer.parseInt(value);
			Todo todo = Service.getTodo(i);
			int valor = todo.getUserId();
			boolean temp = ((valor>=1) && (valor<=10));
			List<Todo> lista = new ArrayList<Todo>();
			lista.add(todo);
			System.out.println(Service.todosToHTMLTable(lista));
			if(temp){
				responseWriter.write(Service.todosToHTMLTable(lista));
				responseWriter.flush();
			}
		}catch(NumberFormatException eN) {
			HttpServletResponse response=(HttpServletResponse) resp;
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			response.setContentType("what you need");
		}catch(MalformedURLException eM) {
			HttpServletResponse response=(HttpServletResponse) resp;
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.setContentType("what you need");
		}catch(FileNotFoundException eF) {
			HttpServletResponse response=(HttpServletResponse) resp;
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			response.setContentType("what you need");
		}catch(Exception eG){
			HttpServletResponse response=(HttpServletResponse) resp;
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.setContentType("what you need");
		}
	}
}


