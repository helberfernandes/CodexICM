package br.com.wofsolutions.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.wofsolutions.model.Canone;
import br.com.wofsolutions.model.Livro;
import br.com.wofsolutions.model.Parte;

public class RepositorioCodex {
	private SQLiteHelper sqLiteHelper;
	
	private SQLiteDatabase database;
	
	

	public RepositorioCodex(Context context) {
		sqLiteHelper = new SQLiteHelper(context);
		database = sqLiteHelper.getWritableDatabase();
	}

	public List<Livro> findAllLivro() {
		List<Livro> livros = new ArrayList<Livro>();
		String[] colunas = new String[] { "_id", "descricao" };
		Cursor cursor = database.query("livros", colunas, null, null, null,
				null, "_id ASC");

		if (cursor.getCount() > 0) {
			cursor.moveToFirst();

			while (!cursor.isAfterLast()) {
				livros.add(new Livro(cursor.getInt(0), cursor.getString(1)));

				cursor.moveToNext();
			}
			cursor.close();
			
		}

		return livros;
	}
	
	
	public List<Canone> findCanoneByLivro(int livroId) {
		List<Canone> canones = new ArrayList<Canone>();
		String[] colunas = new String[] { "_id", "descricao", "numero", "livro_id" };
		Cursor cursor = database.query("canones", colunas, "livro_id=? and artigo_id is null and capitulo_id is null and parte_id is null and titulo_id is null and seccao_id is null", new String[]{""+livroId}, null,
				null, "_id ASC");

		if (cursor.getCount() > 0) {
			cursor.moveToFirst();

			while (!cursor.isAfterLast()) {
				canones.add(new Canone(cursor.getInt(0), cursor.getString(2), cursor.getString(1)));

				cursor.moveToNext();
			}
			cursor.close();
			
		}

		return canones;
	}

	
	
	
	public List<Parte> findCanoneByParte(int livroId) {
		List<Parte> partes = new ArrayList<Parte>();
		String[] colunas = new String[] { "_id", "descricao",  "livro_id" };
		Cursor cursor = database.query("parte", colunas, "livro_id=? ", new String[]{""+livroId}, null,
				null, "_id ASC");

		if (cursor.getCount() > 0) {
			cursor.moveToFirst();

			while (!cursor.isAfterLast()) {
				partes.add(new Parte(cursor.getInt(0), cursor.getString(1)));

				cursor.moveToNext();
			}
			cursor.close();
			
		}

		return partes;
	}
}
