package com.lp.bo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.lp.db.DBUtil;
import com.mysql.jdbc.PreparedStatement;
public class LoginBO {
	
	public boolean validarLogin(String usuario, String senha){
		boolean resultado = false;
		Connection con = null;
		try {
			con = DBUtil.getConexao();
			
			String  sql = "SELECT * FROM tb_usuario WHERE LOGIN = ? AND SENHA = ?";
			PreparedStatement st =  (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, usuario);
			st.setString(2, senha);
			
			ResultSet rs = st.executeQuery();
			resultado = rs.next();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if( con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return resultado;
	}
	
	public boolean verificaLogin(String user){
		
		boolean resultado = false;
		Connection con = null;
		try {
			con = DBUtil.getConexao();
			
			String  sql2 = "SELECT * FROM tb_usuario WHERE LOGIN = ?";
			PreparedStatement st =  (PreparedStatement) con.prepareStatement(sql2);
			st.setString(1, user);
			
			ResultSet rs = st.executeQuery();
			resultado = rs.next();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if( con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return resultado;
	}
	
public boolean cadastraLogin(String user,String senha){
		
		boolean resultado = false;
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBUtil.getConexao();
			
			String  sql2 = "insert into tb_usuario(login,senha,bancousuario) VALUES (?,?,'teste')";
			
			st =  (PreparedStatement) con.prepareStatement(sql2);
			st.setString(1, user);
			st.setString(2, senha);
			st.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if( con != null && st !=null){
				try {
					con.close();
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return resultado;
	}

	public String listarLogin(){
		String resultConcatenado = "";
		boolean resultado = false;
		Connection con = null;
		try {
			con = DBUtil.getConexao();
						
			java.sql.Statement st = con.createStatement();
            st.executeQuery("select * from tb_usuario");
            ResultSet rs = st.getResultSet();
            
            while (rs.next()) {
                //JOptionPane.showMessageDialog(null,rs.getString("login") + ", ");
            	resultConcatenado += rs.getString("login") + '-';
            }
			

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if( con != null){
				try {
					con.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resultConcatenado;
		
	}
	
}
