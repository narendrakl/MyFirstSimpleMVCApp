package com.naren;

import java.io.IOException;
import java.net.URI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        System.out.println("Inside no arg constructor");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside of doGet method");
		
		process(request, response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		Model m = new Model();
				
		if(uri.contains("/register")){
			RegBean rb = (RegBean)request.getAttribute("reg");
			System.out.println("User inputs from bean"+rb.getEmail()+rb.getUname()+rb.getPwd()+rb.getRpwd());
			
			RequestDispatcher rd = null;
			String result = m.register(rb);
			
			System.out.println("Result from the register"+result);
			if(result.equals(Constants.SUCCESS)){
				rd = request.getRequestDispatcher("Success.html");
				rd.forward(request, response);
			}else{
				request.setAttribute("errormsg",result);
				rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside of doPost method");
		
		process(request, response);
	}

}
