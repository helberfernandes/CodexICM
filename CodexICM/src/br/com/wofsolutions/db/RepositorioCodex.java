package br.com.wofsolutions.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.wofsolutions.model.Livro;

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
			database.close();
		}

		return livros;
	}

}
