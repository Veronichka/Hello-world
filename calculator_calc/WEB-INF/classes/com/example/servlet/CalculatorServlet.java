package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//import task3_reviewed.*;

public class CalculatorServlet extends HttpServlet{

  	  @Override	  
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
		    throws ServletException, IOException{
		  try {
			  inputReader.setInput(req.getParameter("expression"));

			  req.setAttribute("expression", analyzer.analyzer(inputReader.getInput()));
		  } catch(Exception e) {
			  System.out.println("Bad syntax! Try again:");
		  }

		  req.getRequestDispatcher("./result.jsp").forward(req, res);
	  }

}
