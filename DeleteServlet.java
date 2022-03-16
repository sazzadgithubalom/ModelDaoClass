package com.alomindia;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alomindia.dao.EmpDao;
import com.alomindia.model.EmpModel;

public class DeleteServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Integer empNo = Integer.parseInt(req.getParameter("empId"));
		
		EmpModel empModel = new EmpModel();
		empModel.setEmpNo(empNo);
		try {
			EmpDao empDao = new EmpDao();
			int c = empDao.deleteRecord(empModel);
			out.println(c+" Record Deleted from Database");
		}catch (ClassNotFoundException e) {
		}catch (SQLException e) {
		}
		
	}
}
