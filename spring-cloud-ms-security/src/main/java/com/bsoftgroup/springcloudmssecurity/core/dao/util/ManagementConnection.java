package com.bsoftgroup.springcloudmssecurity.core.dao.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagementConnection {
	
	@Autowired
	private DataSourceConfig ds;
	
	private Connection conn;
	
	
	public Connection getConnection() throws SQLException {
		
		this.conn=ds.dataSource().getConnection();
		
		return conn;
	}
	
	public void closeConnection() throws Exception{
		  closeResources(this.conn, null, null,null,null);	  
	  }
	  public void closeResultSet(ResultSet rs) throws Exception{
		  closeResources(null, rs, null,null,null);	  
	  }
	  public void closeStatement(Statement stmt) throws Exception{
		  closeResources(null, null, stmt,null,null);	  
	  }
	  public void closeCallableStatement(CallableStatement cstmt) throws Exception{
		  closeResources(null, null, null,cstmt,null);	  
	  }
	  public void closePreparedStatement(PreparedStatement pstmt) throws Exception{
		  closeResources(null, null, null,null,pstmt);	  
	  }
	  
	  public void closeResources(Connection conn, ResultSet rs,Statement stmt,CallableStatement cstmt , PreparedStatement pstmt) throws Exception{	 
		   if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException ex) {
		            //System.out.println(ex.getMessage());
		            throw new Exception(ex.getMessage());
		        }
		    }
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException ex) {
		        	//System.out.println(ex.getMessage());
		            throw new Exception(ex.getMessage());
		        }
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException ex) {
		        	//System.out.println(ex.getMessage());
		            throw new Exception(ex.getMessage());
		        }
		    }
		    if (cstmt != null) {
		        try {
		            cstmt.close();
		        } catch (SQLException ex) {
		        	//System.out.println(ex.getMessage());
		            throw new Exception(ex.getMessage());
		        }
		    }
		    if (pstmt != null) {
		        try {
		            pstmt.close();
		        } catch (SQLException ex) {
		        	//System.out.println(ex.getMessage());
		            throw new Exception(ex.getMessage());
		        }
		    }
	  }
	  

}
