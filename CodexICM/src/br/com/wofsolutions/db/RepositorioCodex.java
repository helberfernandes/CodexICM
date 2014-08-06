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
/**
 * Para facilitar o glossario vai ser tratado como uma parte comum assim pode ser exibido
 * normalmente pelo meno que recebe um objeto do tipo parte
 * @return
 */
	public List<Parte> findAllGlossario() {
		List<Parte> partes = new ArrayList<Parte>();
		String[] colunas = new String[] { "_id", "palavra" };// o significado será como um canone
		Cursor cursor = database.query("glossario", colunas, null, null, null,
				null, "_id ASC");

		if (cursor.getCount() > 0) {
			cursor.moveToFirst();

			while (!cursor.isAfterLast()) {
				partes.add(new Parte(cursor.getInt(0), cursor.getString(1).replaceAll("—", "")));

				cursor.moveToNext();
			}
			cursor.close();
			
		}

		return partes;
	}
	
	public List<Canone> findAllGlossarioAsCanone() {
		List<Canone> canones = new ArrayList<Canone>();
		String[] colunas = new String[] { "_id", "palavra", "significado" };// o significado será como um canone
		Cursor cursor = database.query("glossario", colunas, null,null, null,
				null, "_id ASC");

		if (cursor.getCount() > 0) {
			cursor.moveToFirst();

			while (!cursor.isAfterLast()) {
				canones.add(new Canone(cursor.getInt(0), cursor.getString(1),cursor.getString(2)));

				cursor.moveToNext();
			}
			cursor.close();
			
		}

		return canones;
	}
	
	
	public List<Canone> findAllGlossarioAsCanone(int glossario_id) {
		List<Canone> canones = new ArrayList<Canone>();
		String[] colunas = new String[] { "_id", "palavra", "significado" };// o significado será como um canone
		Cursor cursor = database.query("glossario", colunas, "_id=? ", new String[]{""+glossario_id}, null,
				null, "_id ASC");

		if (cursor.getCount() > 0) {
			cursor.moveToFirst();

			while (!cursor.isAfterLast()) {
				canones.add(new Canone(cursor.getInt(0), cursor.getString(1),cursor.getString(2)));

				cursor.moveToNext();
			}
			cursor.close();
			
		}

		return canones;
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
	
	
	
	
	public Livro findLivro(int livroId) {
		Livro livro = new Livro();
		String[] colunas = new String[] { "_id", "descricao" };
		Cursor cursor3 = database.query("livros", colunas, "_id=?", new String[] { ""+livroId }, null,
				null, "_id ASC");

		if (cursor3.getCount() > 0) {
			cursor3.moveToFirst();

			while (!cursor3.isAfterLast()) {
				livro=new Livro(cursor3.getInt(0), cursor3.getString(1));

				cursor3.moveToNext();
			}
			cursor3.close();
			
		}

		return livro;
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
						cursor.getInt(6)!=0?findParte(cursor.getInt(6)):new Parte(cursor.getInt(6),findLivro(cursor.getInt(3)))
						
						,
						cursor.getInt(7)!=0?findArtigo(cursor.getInt(7)):new Artigo(cursor.getInt(7))
						));

				cursor.moveToNext();
			}
			cursor.close();
			
		}

		return canones;
	}

	
	
	
	public List<Canone> findCanoneByParte(int parteId) {
		List<Canone> canones = new ArrayList<Canone>();
		String[] colunas = new String[] { "_id", "descricao", "numero", "livro_id", "titulo_id", "capitulo_id", "parte_id", "artigo_id" };
//		Cursor cursor = database.query("canones", colunas, "livro_id=? and artigo_id is null and capitulo_id is null and parte_id is null and titulo_id is null and seccao_id is null", new String[]{""+livroId}, null,
//				null, "_id ASC");

		
		Cursor cursor = database.query("canones", colunas, "parte_id=? ", new String[]{""+parteId}, null,
				null, "_id ASC");
		
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();

			while (!cursor.isAfterLast()) {
				canones.add(new Canone(cursor.getInt(0), cursor.getString(2), cursor.getString(1),
						new Livro(cursor.getInt(3)),
						
				
				cursor.getInt(4)!=0?findTitulo(cursor.getInt(4)):new Titulo(cursor.getInt(4)),				
						
						
						cursor.getInt(5)!=0?findCapitulo(cursor.getInt(5)):new Capitulo(cursor.getInt(5)),
						cursor.getInt(6)!=0?findParte(cursor.getInt(6)):new Parte(cursor.getInt(6),findLivro(cursor.getInt(3)))
						
						,
						cursor.getInt(7)!=0?findArtigo(cursor.getInt(7)):new Artigo(cursor.getInt(7))
						));

				cursor.moveToNext();
			}
			cursor.close();
			
		}

		return canones;
	}
	
	
	public List<Parte> findParteList(int livroId) {
		List<Parte> partes = new ArrayList<Parte>();
		String[] colunas = new String[] { "_id", "descricao",  "livro_id" };
		Cursor cursor2 = database.query("parte", colunas, "livro_id=? ", new String[]{""+livroId}, null,
				null, "_id ASC");

		if (cursor2.getCount() > 0) {
			cursor2.moveToFirst();

			while (!cursor2.isAfterLast()) {
				partes.add(new Parte(cursor2.getInt(0), cursor2.getString(1), findLivro(cursor2.getInt(2))));

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
	
	
	public Artigo findArtigo(int artigoId) {
		Artigo artigo = null;
		String[] colunas = new String[] { "_id", "descricao",   "capitulo_id" };
		Cursor cursor2 = database.query("artigos", colunas, "_id=? ", new String[]{""+artigoId}, null,
				null, "_id ASC");

		if (cursor2.getCount() > 0) {
			cursor2.moveToFirst();

			while (!cursor2.isAfterLast()) {
				artigo=new Artigo(cursor2.getInt(0), cursor2.getString(1));

				cursor2.moveToNext();
			}
			cursor2.close();
			
		}

		return artigo;
	}
}
