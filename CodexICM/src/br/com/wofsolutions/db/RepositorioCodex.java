package br.com.wofsolutions.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import br.com.wofsolutions.model.Artigo;
import br.com.wofsolutions.model.Canone;
import br.com.wofsolutions.model.Capitulo;
import br.com.wofsolutions.model.Livro;
import br.com.wofsolutions.model.Parte;
import br.com.wofsolutions.model.Titulo;

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
		String[] colunas = new String[] { "_id", "descricao", "numero", "livro_id", "titulo_id", "capitulo_id", "parte_id", "artigo_id" };
//		Cursor cursor = database.query("canones", colunas, "livro_id=? and artigo_id is null and capitulo_id is null and parte_id is null and titulo_id is null and seccao_id is null", new String[]{""+livroId}, null,
//				null, "_id ASC");

		
		Cursor cursor = database.query("canones", colunas, "livro_id=? ", new String[]{""+livroId}, null,
				null, "_id ASC");
		
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();

			while (!cursor.isAfterLast()) {
				canones.add(new Canone(cursor.getInt(0), cursor.getString(2), cursor.getString(1),
						new Livro(cursor.getInt(3)),
						
				
				cursor.getInt(4)!=0?findTitulo(cursor.getInt(4)):new Titulo(cursor.getInt(4)),				
						
						
						cursor.getInt(5)!=0?findCapitulo(cursor.getInt(5)):new Capitulo(cursor.getInt(5)),
						cursor.getInt(6)!=0?findParte(cursor.getInt(6)):new Parte(cursor.getInt(6))
						
						,
						new Artigo(cursor.getInt(7))
						));

				cursor.moveToNext();
			}
			cursor.close();
			
		}

		return canones;
	}

	
	
	
	public List<Parte> findCanoneByParte(int livroId) {
		List<Parte> partes = new ArrayList<Parte>();
		String[] colunas = new String[] { "_id", "descricao",  "livro_id" };
		Cursor cursor2 = database.query("parte", colunas, "livro_id=? ", new String[]{""+livroId}, null,
				null, "_id ASC");

		if (cursor2.getCount() > 0) {
			cursor2.moveToFirst();

			while (!cursor2.isAfterLast()) {
				partes.add(new Parte(cursor2.getInt(0), cursor2.getString(1)));

				cursor2.moveToNext();
			}
			cursor2.close();
			
		}

		return partes;
	}
	
	
	public Parte findParte(int parteId) {
		Parte parte = null;
		String[] colunas = new String[] { "_id", "descricao",  "livro_id" };
		Cursor cursor2 = database.query("parte", colunas, "_id=? ", new String[]{""+parteId}, null,
				null, "_id ASC");

		if (cursor2.getCount() > 0) {
			cursor2.moveToFirst();

			while (!cursor2.isAfterLast()) {
				parte=new Parte(cursor2.getInt(0), cursor2.getString(1));

				cursor2.moveToNext();
			}
			cursor2.close();
			
		}

		return parte;
	}
	
	
	
	public Titulo findTitulo(int tituloId) {
		Titulo titulo = null;
		String[] colunas = new String[] { "_id", "descricao",  "livro_id", "parte_id", "seccao_id" };
		Cursor cursor2 = database.query("titulos", colunas, "_id=? ", new String[]{""+tituloId}, null,
				null, "_id ASC");

		if (cursor2.getCount() > 0) {
			cursor2.moveToFirst();

			while (!cursor2.isAfterLast()) {
				titulo=new Titulo(cursor2.getInt(0), cursor2.getString(1));

				cursor2.moveToNext();
			}
			cursor2.close();
			
		}

		return titulo;
	}
	
	
	public Capitulo findCapitulo(int capituloId) {
		Capitulo capitulo = null;
		String[] colunas = new String[] { "_id", "descricao",  "titulo_id", "parte_id", "seccao_id" };
		Cursor cursor2 = database.query("capitulos", colunas, "_id=? ", new String[]{""+capituloId}, null,
				null, "_id ASC");

		if (cursor2.getCount() > 0) {
			cursor2.moveToFirst();

			while (!cursor2.isAfterLast()) {
				capitulo=new Capitulo(cursor2.getInt(0), cursor2.getString(1));

				cursor2.moveToNext();
			}
			cursor2.close();
			
		}

		return capitulo;
	}
}
