package br.com.fiap.sismultas.mobile;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MultaDAO {

	private SQLiteDatabase db;
	
	public MultaDAO(Context context) {
		
		MultaDBHelper clienteHelper = new MultaDBHelper(context);
		db = context.openOrCreateDatabase(MultaDBHelper.DB_MULTAS,
										  Context.MODE_PRIVATE,
										  null);
		db = clienteHelper.getWritableDatabase();
		
	}
	
	public void insere(MultaTO multa) {
		
		ContentValues ctVal = new ContentValues();
		
		ctVal.put(MultaDBHelper.TblMulta.CEP, multa.cepLocalOcorrencia);
		ctVal.put(MultaDBHelper.TblMulta.COD_INFRACAO_CTB, multa.codigoInfracaoCtb);
		ctVal.put(MultaDBHelper.TblMulta.DT_OCORRENCIA, multa.dataOcorrencia);
		ctVal.put(MultaDBHelper.TblMulta.DESD_CTB, multa.desdobramentoCtb);
		ctVal.put(MultaDBHelper.TblMulta.ID_FISCAL, multa.idFiscal);
		ctVal.put(MultaDBHelper.TblMulta.PLACA, multa.placaVeiculo);
		
		db.insert(MultaDBHelper.TblMulta.TB_MULTA, "", ctVal);
		
	}
	
	public List<MultaTO> consultaTodos() {
		
		List<MultaTO> multas = new ArrayList<MultaTO>();
		
		Cursor c = db.query(MultaDBHelper.TblMulta.TB_MULTA,
				 			new String[] {
								MultaDBHelper.TblMulta.COD,
								MultaDBHelper.TblMulta.CEP,
								MultaDBHelper.TblMulta.COD_INFRACAO_CTB,
								MultaDBHelper.TblMulta.DESD_CTB,
								MultaDBHelper.TblMulta.DT_OCORRENCIA,
								MultaDBHelper.TblMulta.ID_FISCAL,
								MultaDBHelper.TblMulta.PLACA
							},
							null,
							null,
							null,
							null,
							null);
		
		if (c.getCount() > 0) {
			
			c.moveToFirst();
			
			do {
				
				MultaTO multaTo = new MultaTO();
				multaTo.cod = c.getInt(0);
				multaTo.cepLocalOcorrencia = c.getString(1);
				multaTo.codigoInfracaoCtb = c.getString(2);
				multaTo.desdobramentoCtb = c.getString(3);
				multaTo.dataOcorrencia = c.getString(4);
				multaTo.idFiscal = c.getString(5);
				multaTo.placaVeiculo = c.getString(6);
				
				multas.add(multaTo);
				
			} while (c.moveToNext());
			
			c.close();
			
		}
		
		return multas;
		
	}
	
	public void exclui(MultaTO multaTo) {
		
		db.delete(MultaDBHelper.TblMulta.TB_MULTA,
				  "COD=?",
				  new String[] {multaTo.cod.toString()});
		
	}
	
	public void fechaDB() {
		
		if (db != null) {
			db.close();
		}
		
	}
	
}