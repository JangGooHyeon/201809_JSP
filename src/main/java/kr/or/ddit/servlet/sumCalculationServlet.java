package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CalculationServlet")
public class sumCalculationServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startParam  = request.getParameter("start");
		String endParam    = request.getParameter("end");
		
		int result = 0;
		for(int i=Integer.parseInt(startParam); i<=Integer.parseInt(endParam); i++){
			result += i;
		}
		
		System.out.println(result);
		String sumResult = result+"";
		
		HttpSession sesstion = request.getSession();
		sesstion.setAttribute("sumResult", sumResult);
		request.getRequestDispatcher("/calculation/sumCalculation.jsp").forward(request, response);
	}

}
