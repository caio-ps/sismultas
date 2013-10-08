package br.com.fiap.sismultas.mobile;

import java.util.Date;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SisMultasMain extends Activity {

	private MultaDAO multaDao = null;
	private String ipServer = "192.168.1.100:8081";
	private EnviaMultas enviaMultas = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sis_multas_main);

		this.enviaMultas = new EnviaMultas(getMultaDao(), "http://"+ipServer+"/EmiteMulta");
		this.enviaMultas.start();
		
		Button btnEmiteMulta = (Button) findViewById(R.id.btnEmiteMulta);
		btnEmiteMulta.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				try {
					
					//Insere multa no banco de dados
					insereMulta();
					
					//Limpa campos
					EditText txtCodCtb = (EditText) findViewById(R.id.txtCodCtb);
					EditText txtDesdCtb = (EditText) findViewById(R.id.txtDesd);
					EditText txtPlaca = (EditText) findViewById(R.id.txtPlaca);
					
					txtCodCtb.setText("");
					txtDesdCtb.setText("");
					txtPlaca.setText("");
					
					//Mensagem de aviso de sucesso
					Toast.makeText(v.getContext(), "Multa emitida.",
							Toast.LENGTH_LONG).show();
						
				} catch (Exception ex) {
					
					//Mensagem de erro
					Toast.makeText(v.getContext(), "Erro ao emitir multa. Tente novamente.",
							Toast.LENGTH_LONG).show();
					
				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sis_multas_main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		
		final Dialog dialog = new Dialog(this);
		
        dialog.setContentView(R.layout.settings_layout);
	    dialog.setTitle("IP do servidor DETRAN:");
	    
        final Button btnOkIp = (Button) dialog.findViewById(R.id.btnOkIp);
        final Button btnCancelIp = (Button) dialog.findViewById(R.id.btnCancelIp);
        final EditText txtIpServer = (EditText) dialog.findViewById(R.id.txtIpServer);

        txtIpServer.setText(ipServer);
        
        btnOkIp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	ipServer = txtIpServer.getText().toString();
            	enviaMultas.URL = "http://"+ipServer+"/EmiteMulta";
            	dialog.dismiss();
            }
        });
        
        btnCancelIp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	dialog.dismiss();
            }
        });
		
        dialog.show();

		return true;
		
	}
	
	public void insereMulta() {
		
		EditText txtIdFiscal = (EditText) findViewById(R.id.txtIdFiscal);
		EditText txtCep = (EditText) findViewById(R.id.txtCep);
		EditText txtCodCtb = (EditText) findViewById(R.id.txtCodCtb);
		EditText txtDesdCtb = (EditText) findViewById(R.id.txtDesd);
		EditText txtPlaca = (EditText) findViewById(R.id.txtPlaca);
		
		MultaTO multa = new MultaTO(txtCep.getText().toString(),
				txtCodCtb.getText().toString(), new Date(), txtDesdCtb.getText().toString(),
				txtIdFiscal.getText().toString(), txtPlaca.getText().toString());
		
		getMultaDao().insere(multa);
		
	}
	
	public MultaDAO getMultaDao() {
		
		if (this.multaDao == null) {
			this.multaDao = new MultaDAO(this);
		}
		
		return this.multaDao;
		
	}
	
}
