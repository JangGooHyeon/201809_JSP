package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		
		int int_param1 = Integer.parseInt(param1);
		int int_param2 = Integer.parseInt(param2);
		
		int result = 1;
		for(int i=int_param1; i<=int_param2; i++){
			result *= i;
		}
		System.out.println(result);
		String mulResult = result + "";
		
		HttpSession sesstion = request.getSession();
		sesstion.setAttribute("mulResult", mulResult);
		request.getRequestDispatcher("/calculation/mulCalculation.jsp").forward(request, response);
		
	}

}
