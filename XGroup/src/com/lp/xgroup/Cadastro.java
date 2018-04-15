package com.lp.xgroup;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lp.util.Util;

public class Cadastro extends Activity {
	private EditText etUsuario, etSenha, etConfirmaSenha, etCelular,etEmail,etNome;
	private Button btCadastrar;
	private Util util;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro);
		initComponents();
		btCadastrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(etUsuario.getText().toString().trim().length() > 0 && etSenha.getText().toString().trim().length() > 0
			        	&& etConfirmaSenha.getText().toString().trim().length() > 0 && etNome.getText().toString().trim().length() > 0 
			        	&& etSenha.getText().toString().equals(etConfirmaSenha.getText().toString())){
					new LoadingTask().execute();
					
			    }
			    else{
			    	
	        		if(etUsuario.getText().toString().trim().length() == 0){etUsuario.setError("Campo obrigatório");}
	        		if(etSenha.getText().toString().trim().length() == 0){etSenha.setError("Campo obrigatório");}
	        		if(etConfirmaSenha.getText().toString().trim().length() == 0){etConfirmaSenha.setError("Campo obrigatório");}
	        		else{
	        			if(!etSenha.getText().toString().equals(etConfirmaSenha.getText().toString())){etConfirmaSenha.setError("Senhas não conferem");}
	        		}
	        		if(etNome.getText().toString().trim().length() == 0){etNome.setError("Campo obrigatório");}
			   }
				
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}
	
	public void initComponents(){
		util = new Util();
		btCadastrar = (Button)findViewById(R.id.cadastro_bt_cadastrar);
		etUsuario = (EditText)findViewById(R.id.cadastro_et_usuario);
		etSenha = (EditText)findViewById(R.id.cadastro_et_senha);
		etConfirmaSenha = (EditText)findViewById(R.id.cadastro_et_confirmasenha);
		etCelular = (EditText)findViewById(R.id.cadastro_et_celular);
		etEmail = (EditText)findViewById(R.id.cadastro_et_email);
		etNome = (EditText)findViewById(R.id.cadastro_et_nome);
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/*
	    * Classe responsavel por fazer o acesso a conta, usando threads. A classe executa o preExecute, verifica o login no
	    * doInBacground e depois finaliza o login do app.
	     */
	    private class LoadingTask extends AsyncTask<Void, Void, String> {
	    	private String verificaUser = null;
	    	private LoginBO loginBO = new LoginBO(Cadastro.this);    	
	        private ProgressDialog pg = new ProgressDialog(Cadastro.this);
	        private String user = etUsuario.getText().toString();
	        private String senha = etSenha.getText().toString();
	        private String key = "123";
	        @Override
	        protected String doInBackground(Void... params) {
	        	
	        	//verificaUser = loginBO.verificaLogin(user);
	        	
	        	//if(verificaUser != null){return loginBO.cadastraLogin(user, senha);}
	            
	        	return loginBO.cadastraLogin(user, senha);

	        }

	        @Override
	        protected void onPreExecute() {

	    		pg.setMessage("Carregando...");
	            pg.show();
	        	
	        }

	        @Override
	        protected void onPostExecute(String mensagem) {

	            pg.dismiss();
	            if (verificaUser ==  null) {
	                etUsuario.setError("cadastrado");
	            	
	            }else{
	            	etUsuario.setError("nao cadastrado");
	            }
	            /*if(mensagem.equals("error")){
	            	util.addMensage(Cadastro.this, "Não foi possível cadastrar");
	            }else{
	            	loginBO.cadastraLogin(user, senha);
	            	util.addMensage(Cadastro.this, "Cadastrado");
	            }*/
	        }


	    }
}
