package com.alomindia;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alomindia.dao.EmpDao;
import com.alomindia.model.EmpModel;

public class AddServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		Integer empNo = Integer.parseInt(req.getParameter("empId"));
		String empName = req.getParameter("empName");
		Double empSal = Double.parseDouble(req.getParameter("empSal"));
		
		EmpModel empModel = new EmpModel();
		empModel.setEmpNo(empNo);
		empModel.setEmpName(empName);
		empModel.setEmpSal(empSal);
		try {
			EmpDao empDao = new EmpDao();
			int c = empDao.addRecord(empModel);
			out.println(c+" Record Added in Database");
		}catch (ClassNotFoundException e) {
		}catch (SQLException e) {
		}
		
	}

}
