package com.ed.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ed.daos.ReimbursementsDAO;
import com.ed.daos.ReimbursementsDAOImpl;
import com.ed.models.Reimbursements;
import com.ed.utils.User;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class PendingReimbursementsServlet
 */
public class PendingReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingReimbursementsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!User.isNull() && !User.isManager()) {
			ReimbursementsDAO rd = new ReimbursementsDAOImpl();
			ObjectMapper om = new ObjectMapper();
			PrintWriter out = response.getWriter();
			List<Reimbursements> reimbursements = rd.getPendingReimbursementsFromEmployeeID(User.getUserId());
			String reimbursementsString = om.writeValueAsString(reimbursements);
			reimbursementsString = "{\"reimbursements\":"+reimbursementsString+"}";
			out.print(reimbursementsString);
		} else {
			request.getRequestDispatcher("Login.html").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
