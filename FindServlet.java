package com.alomindia;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alomindia.dao.EmpDao;
import com.alomindia.model.EmpModel;

public class FindServlet extends HttpServlet{
public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		Integer empNo = Integer.parseInt(req.getParameter("empId"));
		
		EmpModel empModel = new EmpModel();
		empModel.setEmpNo(empNo);
		try {
			EmpDao empDao = new EmpDao();
		 ResultSet rs =	empDao.findRecord(empModel);
			while(rs.next()) {
				out.println(rs.getInt(1));
				out.println(rs.getString(2));
				out.println(rs.getDouble(3));
			}
			
		}catch (ClassNotFoundException e) {
		}catch (SQLException e) {
		}
		
	}
}
