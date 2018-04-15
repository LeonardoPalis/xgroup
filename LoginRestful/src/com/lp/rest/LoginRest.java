package com.lp.rest;
import java.sql.Connection;
import java.sql.Date;

import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lp.bo.LoginBO;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

@Path("login")
public class LoginRest {
	
	private LoginBO loginBO = new LoginBO();
	@GET 
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String aloMundo(){
		return "Alo LPZAO";
	}
	
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_HTML)
	public String aloMundoHTML(@PathParam("nome") String nome){
		return "<html><heady><title> Ola mundo!</title>Ola,!</heady></html>";
	}
	
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	@Path("logar")
	public boolean logar(@QueryParam("usuario") String user, @QueryParam("senha") String senha){
		
		
		return loginBO.validarLogin(user, senha);
	}
	
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	@Path("verifica")
	public boolean verificaLogin(@QueryParam("usuario") String user){
			
		return loginBO.verificaLogin(user);
	}
	
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	@Path("cadastrar")
	public boolean cadastraLogin(@QueryParam("usuario") String user,@QueryParam("senha") String senha){
		
		return loginBO.cadastraLogin(user,senha);
	}
	
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	@Path("listar")
	public String listaLogin(){
			
		return loginBO.listarLogin();
	}
	
	
}
