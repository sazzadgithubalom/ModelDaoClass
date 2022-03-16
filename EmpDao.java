package com.alomindia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alomindia.model.EmpModel;

public class EmpDao {
	private Connection conn;
	private PreparedStatement pst;
	private String sqlStatement ;
	public EmpDao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sazzaddb","root","root");
	}
	public int addRecord(EmpModel empModel) throws SQLException
	{
		sqlStatement = "insert into employee values(?,?,?)";
		pst = conn.prepareStatement(sqlStatement);
		pst.setInt(1, empModel.getEmpNo());
		pst.setString(2, empModel.getEmpName());
		pst.setDouble(3, empModel.getEmpSal());
		return pst.executeUpdate();
		
	}	
	
	public int deleteRecord(EmpModel empModel) throws SQLException {
		sqlStatement = "delete from employee where emp_no=?";
		pst = conn.prepareStatement(sqlStatement);
		pst.setInt(1, empModel.getEmpNo());
		
		return pst.executeUpdate();
		
	}
	public int updateRecord(EmpModel empModel) throws SQLException
	{
		sqlStatement = "update employee set emp_name=?,emp_sal=? where emp_no=?";
		pst = conn.prepareStatement(sqlStatement);
		pst.setInt(3, empModel.getEmpNo());
		pst.setString(1, empModel.getEmpName());
		pst.setDouble(2, empModel.getEmpSal());
		return pst.executeUpdate();
		
	}
	public ResultSet findRecord(EmpModel empModel) throws SQLException
	{
		sqlStatement = "select * from employee where emp_no=?";
		pst = conn.prepareStatement(sqlStatement);
		pst.setInt(1, empModel.getEmpNo());
	    ResultSet rs = pst.executeQuery();
	    return rs;
		
	}
}
