package com.lp.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.xml.sax.InputSource;

/**
 * Created by Leonardo on 09/05/2015.
 */
public class WebServiceUtil {

    public static String URL = "http://192.168.56.1:8080/LoginWebService/services/Login?wsdl";
    public static String NAMESPACE = "http://login.lp.br/";

    
    public static boolean validarLoginRest(String login, String senha){
		boolean resultado = false;
    	try {
			URL url = new URL("http://192.168.56.1:8080/LoginRestful/login/logar?usuario=" + login 
					+ "&senha="+ senha);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedInputStream buffer = new BufferedInputStream(connection.getInputStream());
			
			resultado = Boolean.parseBoolean(converterToString(buffer));
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return resultado;
    	
    	
    }
    
    public static boolean verificarLoginRest(String login){
		boolean resultado = false;
    	try {
			URL url = new URL("http://192.168.56.1:8080/LoginRestful/login/verifica?usuario=" + login);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedInputStream buffer = new BufferedInputStream(connection.getInputStream());
			
			resultado = Boolean.parseBoolean(converterToString(buffer));
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return resultado;
    	
    	
    }
    
    public static boolean cadastraLoginRest(String login,String senha){
		boolean resultado = false;
    	try {
			URL url = new URL("http://192.168.56.1:8080/LoginRestful/login/cadastrar?usuario=" + login 
				+ "&senha="+ senha);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedInputStream buffer = new BufferedInputStream(connection.getInputStream());
			
			resultado = Boolean.parseBoolean(converterToString(buffer));
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return resultado;
    	
    	
    }
    
    private static String converterToString(InputStream in){
    	BufferedReader bufer = new BufferedReader(new InputStreamReader(in));
    	StringBuilder builder = new StringBuilder();
    	String linha = null;
    	try {
			while((linha = bufer.readLine()) != null){
				builder.append(linha);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return builder.toString();
    }
    
    public static String listarLoginRest(){
		String resultado = "";
    	try {
			URL url = new URL("http://192.168.56.1:8080/LoginRestful/login/listar");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedInputStream buffer = new BufferedInputStream(connection.getInputStream());
			
			resultado = converterToString(buffer);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return resultado;
    	
    	
    }
}
