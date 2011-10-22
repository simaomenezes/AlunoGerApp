/**
 * 
 */
package com.simaomenezes.dao;

import java.util.ArrayList;
import java.util.List;

import com.simaomenezes.model.Aluno;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * @author simao
 *
 */
public class AlunoDAO extends SQLiteOpenHelper {
	/**
	 * Constantes para a configuração do 
	 * banco de dados
	 **/
	private static int VERSION = 1;
	private static String TABELA = "tb_aluno";
	private static String[] COLS = {"id", "name", "telefone", "endereco", "nota1", "nota2", "media", "foto"};

	/**
	 * @param context
	 */
	public AlunoDAO(Context context) {
		super(context, TABELA, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sqlCreateTable = "CREATE TABLE" + TABELA +
		"(id INTEGER PRMARY KEY," +
		"name TEXT UNIQUE NOT NULL," +
		"telefone TEXT," +
		"endereco TEXT," +
		"nota1 DECIMAL," +
		"nota2 DECIMAL," +
		"media DECIMAL," +
		"foto TEXT" +
		");";
		
		db.execSQL(sqlCreateTable);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + AlunoDAO.TABELA);
	}
	
	/**
	 * Adiciona dados ao banco - método insert aluno
	 **/
	public void inserir(Aluno aluno){
		
		ContentValues a = new ContentValues();
		a.put("name", aluno.getName());
		a.put("telefone", aluno.getTelefone());
		a.put("endereco", aluno.getEndereco());
		a.put("nota1", aluno.getNota1());
		a.put("nota2", aluno.getNota2());
		a.put("media", aluno.getMedia());
		a.put("foto", aluno.getFoto());
		
		getWritableDatabase().insert(TABELA, null, a);
	}
	
	/**
	 * Pega todos os alunos
	 **/
	public List<Aluno> getAlunos(){
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		Cursor c = getWritableDatabase().query(TABELA, COLS, null, null, null, null, null);
		
		while (c.moveToFirst()) {
			Aluno aluno = new Aluno();
			
			aluno.setId(c.getInt(0));
			aluno.setName(c.getString(1));
			aluno.setTelefone(c.getString(2));
			aluno.setEndereco(c.getString(3));
			aluno.setNota1(c.getFloat(4));
			aluno.setNota2(c.getFloat(5));
			aluno.setMedia(c.getFloat(6));
			aluno.setFoto(c.getString(7));
			
			alunos.add(aluno);			
		}
		
		c.close();
		
		return alunos;
	}

}
