package edu.ntut.java007.farmerCoop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import edu.ntut.java007.farmerCoop.model.SuserDao;
import edu.ntut.java007.farmerCoop.model.Suser;

@WebServlet("/showSuser.do")
public class showSuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		SuserDao dao = context.getBean("SuserJdbcDaoSupport",SuserDao.class);
		
		List<Suser> list = dao.select();
		request.setAttribute("Susers", list);

		RequestDispatcher rd = request.getRequestDispatcher("/showSusers.jsp");
		rd.forward(request, response);
		return;
	}

}
