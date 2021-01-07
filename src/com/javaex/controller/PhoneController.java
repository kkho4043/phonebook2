package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

@WebServlet("/pnc")
public class PhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("controller");

		String action = request.getParameter("action");

		if ("list".equals(action)) {
			System.out.println("리스트");
			PhoneDao phoneDao = new PhoneDao();
			List<PersonVo> personList = phoneDao.getPersonList();

			// 데이터 전달
			request.setAttribute("plist", personList);

			// jsp포어드
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/list.jsp");
			rd.forward(request, response);

		} else if ("wform".equals(action)) {
			System.out.println("등록폼");
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/writeform.jsp");
			rd.forward(request, response);
		} else if ("insert".equals(action)) {
			System.out.println("저장");
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");

			PersonVo personVo = new PersonVo(name, hp, company);

			PhoneDao phoneDao = new PhoneDao();
			phoneDao.personInsert(personVo);
			
			response.sendRedirect("/phonebook2/pnc?action=list");
		} else if("delete".equals(action)) {
			System.out.println("삭제");
			int no = Integer.parseInt(request.getParameter("no"));
			
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.parsonDelete(no);
			
			response.sendRedirect("/phonebook2/pnc?action=list");
		} else if("upform".equals(action)) {
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			PhoneDao phoneDao = new PhoneDao();
			
			PersonVo updatelist =  phoneDao.getPerson(no);
			request.setAttribute("ulist", updatelist);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/updateform.jsp");
			rd.forward(request, response);
			
		}else if("update".equals(action)) {
			
			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			PhoneDao phoneDao = new PhoneDao();
			PersonVo updateVo = new PersonVo(no,name, hp, company);
			phoneDao.personUpdate(updateVo);
			
			response.sendRedirect("/phonebook2/pnc?action=list");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doGet(request, response);
	}

}
