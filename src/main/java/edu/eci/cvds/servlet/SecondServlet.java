package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
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
		urlPatterns = "/urlServlet"
		)

public class SecondServlet extends HttpServlet{
	static final long serialVersionUID = 35L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//
			Writer responseWriter = resp.getWriter();
			//
			String value = req.getParameter("name");
			
			int i = Integer.parseInt(value);
			Todo todo = Service.getTodo(i);
			//
			boolean temp = todo.getCompleted();
			//
			List<Todo> lista = new ArrayList<Todo>();
			lista.add(todo);
			//
			if(temp) {
				responseWriter.write(Service.todosToHTMLTable(lista));
				responseWriter.flush();
			}else if(!temp){
				resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			}
			//
		}catch(NumberFormatException eN) {
			HttpServletResponse response=(HttpServletResponse) resp;
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.setContentType("what you need");
			PrintWriter writer=response.getWriter();
		}catch(MalformedURLException eM) {
			HttpServletResponse response=(HttpServletResponse) resp;
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.setContentType("what you need");
			PrintWriter writer=response.getWriter();
		}catch(Exception e) {
			HttpServletResponse response=(HttpServletResponse) resp;
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.setContentType("what you need");
			PrintWriter writer=response.getWriter();
		}
	}
	
	
}
