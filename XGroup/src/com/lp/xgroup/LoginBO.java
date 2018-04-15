package com.lp.xgroup;

import android.content.Context;

import com.lp.util.WebServiceUtil;

/**
 * Created by Leonardo on 05/05/2015.
 */
public class LoginBO {
    private boolean dadosValidos;

    private Context context;

    public LoginBO(Context context) {

        this.context = context;
    }

    public String validaLogin(String user, String senha) {

        if (user.equals("") || user == null) {
            return "Usuário inválido!";
        }
        else if (senha.equals("") || senha == null) {
            return "Senha inválida!";
        }
        else if(WebServiceUtil.validarLoginRest(user,senha)){
        	return null;
        }
        return "error";
    }
    
    public String verificaLogin(String user) {


    	if(WebServiceUtil.verificarLoginRest(user)){
        	return null;
        }
    	
        return "error";
    }
    
    public String cadastraLogin(String user,String senha) {


    	if(WebServiceUtil.cadastraLoginRest(user, senha)){
        	return null;
        }
    	
        return "error";
    }
    
    public String listaLogin() {


    	return WebServiceUtil.listarLoginRest();
        
    }
}
