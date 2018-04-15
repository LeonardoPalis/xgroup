package com.lp.xgroup;



import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.lp.util.Util;

public class Principal extends Activity {
	private Util util = new Util();
	private TextView n1,n2,n3,n4,n5,n6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		initComponents();
		new LoadingTask().execute();
		n1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				util.addMensage(Principal.this, "AE");
			}
		});
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
	
	public void initComponents(){
		
		n1 = (TextView)findViewById(R.id.principal_tv_n1);
		n2 = (TextView)findViewById(R.id.principal_tv_n2);
		n3 = (TextView)findViewById(R.id.principal_tv_n3);
		n4 = (TextView)findViewById(R.id.principal_tv_n4);
		n5 = (TextView)findViewById(R.id.principal_tv_n5);
		n6 = (TextView)findViewById(R.id.principal_tv_n6);
	}
	
	/*
	    * Classe responsavel por fazer o acesso a conta, usando threads. A classe executa o preExecute, verifica o login no
	    * doInBacground e depois finaliza o login do app.
	     */
	    private class LoadingTask extends AsyncTask<Void, Void, String> {
	    	
	    	private LoginBO loginBO = new LoginBO(Principal.this);
	        private ProgressDialog pg = new ProgressDialog(Principal.this);
	        @Override
	        protected String doInBackground(Void... params) {
	            
	            return loginBO.listaLogin();


	        }

	        @Override
	        protected void onPreExecute() {

	            pg.setMessage("Carregando...");
	            pg.show();
	        }

	        @Override
	        protected void onPostExecute(String mensagem) {

	            String[] listaNomes = mensagem.split("-");
	            n1.setText(listaNomes[0]);
	            n2.setText(listaNomes[1]);
	            n3.setText(listaNomes[2]);
	            n4.setText(listaNomes[3]);
	            n5.setText(listaNomes[4]);
	            n6.setText(listaNomes[5]);
	            pg.dismiss();
	        }


	    }
}
