package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import task3_reviewed.*;
import task3_reviewed.Operation.*;

public class CalculatorServlet extends HttpServlet{

//	Analyzer analyzer = new Analyzer();
//	InputReader inputReader = new InputReader();
	Calculator calculator = new Calculator();

  	  @Override	  
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
		    throws ServletException, IOException{



		  try {
			  String result = "" + calculator.calculate(req.getParameter("expression"));
			//  inputReader.setInput(req.getParameter("expression"));

			  req.setAttribute("expression", result);
		  } catch(Exception e) {
			  req.setAttribute("expression", "Bad syntax! Try again:");
		  }

		  req.getRequestDispatcher("./result.jsp").forward(req, res);
	  }

}
