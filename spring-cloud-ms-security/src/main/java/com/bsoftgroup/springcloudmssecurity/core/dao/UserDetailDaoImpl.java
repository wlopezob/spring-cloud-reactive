package com.bsoftgroup.springcloudmssecurity.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bsoftgroup.springcloudmssecurity.core.dao.util.ManagementConnection;
import com.bsoftgroup.springcloudmssecurity.core.service.Usuario;




@Repository
public class UserDetailDaoImpl implements UserDetailDaoInterface {
	
	@Autowired
	private ManagementConnection mng;

	@Override
	public Usuario getUsuario(String username) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			
			String SQL = "Select username, password from esq_ms_security.TBL_USUARIO where username=? order by id";
			pstmt = mng.getConnection().prepareStatement(SQL);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setUsername(rs.getString("username"));
				usuario.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				mng.closeConnection();
				mng.closePreparedStatement(pstmt);
				mng.closeResultSet(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return usuario;
	}

}