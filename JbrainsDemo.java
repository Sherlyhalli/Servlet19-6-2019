package com.servlet.assign;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JbrainsDemo
 */
@WebServlet("/JbrainsDemo")
public class JbrainsDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JbrainsDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("user");
		//out.println("Hello i am from get"+user);
		HttpSession session=request.getSession();
		ServletContext context=request.getServletContext();
		if(username!=" " && username!=null)
		{
			session.setAttribute("savedusername",username );
			context.setAttribute("savedusername",username);
		}
		out.println("Request parameter "+ username);
		out.println("session parameter "+ (String)session.getAttribute("savedusername"));
		out.println("Context parameter "+ (String)context.getAttribute("savedusername"));
	}
	/*protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("user");
		/*String password=request.getParameter("pass");
		//out.println("Hello i am from post"+user);
		out.println(" Hello " + user + " and your password is " + password);
		String prof=request.getParameter("prof");
		out.println("Your Profession is " + prof);
		/*String location=request.getParameter("location");
		out.println("You are from "+location);
		String[] location=request.getParameterValues("location");
		out.println("you are in " + location.length + "place");
		for(int i=0;i<location.length;i++)
		{
			out.println("location: " + location[i]);
		}*/
		
	}

