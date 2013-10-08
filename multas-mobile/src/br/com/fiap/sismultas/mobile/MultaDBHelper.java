package br.com.fiap.sismultas.mobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MultaDBHelper extends SQLiteOpenHelper {

	public static final String DB_MULTAS = "Multa.db";
	
	public class TblMulta {
		
		public static final String TB_MULTA = "TB_MULTAS";
		
		public static final String COD = "COD";
		public static final String CEP = "CEP";
		public static final String COD_INFRACAO_CTB = "COD_CTB";
		public static final String DT_OCORRENCIA = "DT_OC";
		public static final String DESD_CTB = "DESD_CTB";
		public static final String ID_FISCAL = "ID_FISCAL";
		public static final String PLACA = "PLACA";
		
	}
	
	public MultaDBHelper(Context context) {
		super(context, DB_MULTAS, null, 3);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String sql = 
			"CREATE TABLE " + TblMulta.TB_MULTA + "(" +
				TblMulta.COD + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				TblMulta.CEP + " TEXT, " +
				TblMulta.COD_INFRACAO_CTB + " TEXT, " +
				TblMulta.DT_OCORRENCIA + " TEXT, " +
				TblMulta.DESD_CTB + " TEXT, " +
				TblMulta.ID_FISCAL + " TEXT, " +
				TblMulta.PLACA + " TEXT" +
			")";
		
		db.execSQL(sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {

		String sql = 
			"DROP TABLE IF EXISTS " + TblMulta.TB_MULTA;
		db.execSQL(sql);
		
		this.onCreate(db);
		
	}

}