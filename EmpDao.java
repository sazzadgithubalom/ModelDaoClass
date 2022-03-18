package com.alomindia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alomindia.model.EmpModel;

public class EmpDao {
	private Connection conn;
	private PreparedStatement pst;
	private String sqlStatement ;
	private ResultSet rs;
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
	public EmpModel findRecord(EmpModel empModel) throws SQLException
	{
		
		sqlStatement = "select * from employee where emp_no=?";
		pst = conn.prepareStatement(sqlStatement);
		pst.setInt(1, empModel.getEmpNo());
	      rs = pst.executeQuery();
	    
	    EmpModel emModel = new EmpModel();
	    
	    while(rs.next()){
	    	emModel.setEmpNo(rs.getInt(1));
	    	emModel.setEmpName(rs.getString(2));
	    	emModel.setEmpSal(rs.getDouble(3));
	    }
	    
	    return emModel;
		
	}
	public List findAllRecord() throws SQLException {
		sqlStatement = "select * from employee";
		pst = conn.prepareStatement(sqlStatement);
		rs = pst.executeQuery();
		List<EmpModel> store = new ArrayList<EmpModel>();
		while(rs.next()) {
			EmpModel empModel = new EmpModel();
			empModel.setEmpNo(rs.getInt(1));
			empModel.setEmpName(rs.getString(2));
			empModel.setEmpSal(rs.getDouble(3));
			store.add(empModel);
		}
		return store;
		
	}
}
