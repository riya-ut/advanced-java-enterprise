
package com.jee;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class first extends HttpServlet {
	
	PrintWriter pw;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	pw = resp.getWriter();
	pw.println("<h1>Hello from your servlet");
	}

}
