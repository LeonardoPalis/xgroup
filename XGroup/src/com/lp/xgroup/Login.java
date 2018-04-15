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

public class Login extends Activity {
	private Util util;
	private static String APP_ID = "455343471291580";
	private Button btEntrar;
	private EditText etUsuario;
	private EditText etSenha;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initComponents();
		
		btEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	
                new LoadingTask().execute();


            }
        });
		
		
		
		
	}
	
	public void verPerfil(View view){
		
	}
	
	public void cadastrarButton(View view){
		
		Intent it = new Intent("com.lp.xgroup.CADASTRO");
		startActivity(it);
		
	}
	
	public void initComponents(){
		
		btEntrar = (Button)findViewById(R.id.login_bt_entrar);
		etUsuario = (EditText)findViewById(R.id.login_et_usuario);
		etSenha = (EditText)findViewById(R.id.login_et_senha);
		util = new Util();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
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
	    	
	    	private LoginBO loginBO = new LoginBO(Login.this);
	        private ProgressDialog pg = new ProgressDialog(Login.this);
	        private String user = etUsuario.getText().toString();
	        private String key = etSenha.getText().toString();
	        @Override
	        protected String doInBackground(Void... params) {
	            
	            return loginBO.validaLogin(user,key);


	        }

	        @Override
	        protected void onPreExecute() {

	            pg.setMessage("Carregando...");
	            pg.show();
	        }

	        @Override
	        protected void onPostExecute(String mensagem) {

	            pg.dismiss();
	            if (mensagem ==  null) {
	                util.addMensage(Login.this, mensagem);
	            	Intent it = new Intent("com.lp.xgroup.PRINCIPAL");
	                startActivity(it);
	            } else {
	                util.addMensage(Login.this, mensagem);
	            }
	        }


	    }
}


