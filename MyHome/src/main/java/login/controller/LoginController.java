package login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.CheckAction;
import login.action.FindAction;
import login.action.FormAction;
import login.action.LogoutAction;
import util.Action;
import util.ActionForward;

@WebServlet("*.do") // /MyHome/........ .do인 url을 담당하는 패턴
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Action action = null;
		ActionForward actionForward = null;
		
		String requestURL = request.getRequestURL().toString();
		
		//System.out.println(requestURL);
		
		int start = requestURL.lastIndexOf("/");
		int end = requestURL.lastIndexOf(".do");
		
		String path = requestURL.substring(start + 1,end);
		
		//System.out.println(path);
		RequestDispatcher rd = null;
		switch(path) {
		case "login":
			action = new FormAction();
			actionForward = new ActionForward("/login/form.jsp", false);
//			rd = request.getRequestDispatcher("/login/form.jsp");
//			rd.forward(request, response);
			break;
		case "check":
			action = new CheckAction();
			actionForward = new ActionForward("/login/result.jsp", false);
//			rd = request.getRequestDispatcher("/login/result.jsp");
//			rd.forward(request, response);
			break;
		case "findForm":
			String mode = request.getParameter("mode");
			actionForward = new ActionForward("/MyHome/login/findForm.jsp?mode=" + mode, true);
//			response.sendRedirect("/MyHome/login/findForm.jsp?mode=" + mode);
			break;
		case "logout":
			action = new LogoutAction();
			actionForward = new ActionForward("/login/logout.jsp", false);
			break;
		case "find":
			action = new FindAction();
			actionForward = new ActionForward("/login/findResult.jsp", false);
			break;
		}
		
		if(action != null) {
			action.execute(request, response);
		}
		
		if(actionForward.isRedirect()) {
			response.sendRedirect(actionForward.getNextPath());
		}else {
			request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.doGet(request, response);
	}
	
}














