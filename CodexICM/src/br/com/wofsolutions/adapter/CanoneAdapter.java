package br.com.wofsolutions.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.wofsolutions.R;
import br.com.wofsolutions.model.Canone;
import br.com.wofsolutions.model.Parte;

public class CanoneAdapter extends BaseAdapter {
	private Context context;

	private List<Canone> mData = new ArrayList<Canone>();
	private TreeSet mSeparatorsSet = new TreeSet();

	private List<String> head = new ArrayList<String>();

	private static int COR_BARRA_CINZA = Color.rgb(236, 233, 216);

	private static final int TYPE_ITEM = 0;
	private static final int TYPE_SEPARATOR = 1;
	private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;
	

	public CanoneAdapter(Context context, List<Canone> ri) {
		super();
		this.context = context;
		this.mData = ri;
	}

	public CanoneAdapter(Context context) {
		super();
		this.context = context;
	}

	public int getCount() {

		return mData.size();
	}

	public Object getItem(int position) {
		return mData.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView = null;
		gridView = inflater.inflate(R.layout.listcanones, null);
		
		// set value into textview
				TextView textView = (TextView) gridView
						.findViewById(R.id.txtCanoneDescricao);

		if (convertView == null) {
			gridView = new View(context);
			gridView = inflater.inflate(R.layout.listcanones, null);

			
			
		
			
		} else {
			gridView = (View) convertView;
		}

		
		
		if (mData.get(position).isGrupoCanone()) {

			if(mData.get(position).getNumero().equals("204")){
				Log.i("cdc", "erro "+mData.get(position).getParte().getDescricao());
			}
			
			gridView = inflater.inflate(R.layout.listcanonesparte, null);

			textView = (TextView) gridView.findViewById(R.id.txtParteTitulo);
			textView.setText(mData.get(position).getParte().getDescricao());
			Log.i("Dao",""+mData.get(position).getParte().getDescricao());
			
			textView.setTypeface(null, Typeface.BOLD);

			textView.setBackgroundColor(CanoneAdapter.COR_BARRA_CINZA);
			// textView.setVisibility(TextView.VISIBLE);
			

			if(mData.get(position).isGrupoCanoneCapitulo()){
				textView = (TextView) gridView
						.findViewById(R.id.txtpartecapitulo);

				textView.setText(mData.get(position).getCapitulo().getDescricao());
				textView.setTypeface(null, Typeface.BOLD);
				textView.setVisibility(TextView.VISIBLE);
			}
			
			
			
			
			textView = (TextView) gridView
					.findViewById(R.id.txtCanoneDescricaoParte);

			textView.setText(mData.get(position).getDescricao());

			Log.i("cdc", "parte");

		} else if (mData.get(position).isGrupoCanoneTitulo()) {

			gridView = inflater.inflate(R.layout.listcanonestitulo, null);

			textView = (TextView) gridView.findViewById(R.id.txtTitulo);
			textView.setText(mData.get(position).getTitulo().getDescricao());
			
			
			textView.setTypeface(null, Typeface.BOLD);

			textView.setBackgroundColor(CanoneAdapter.COR_BARRA_CINZA);
			// textView.setVisibility(TextView.VISIBLE);
			
			
			
			
			if(mData.get(position).isGrupoCanoneTitulo()){
				textView = (TextView) gridView.findViewById(R.id.txtCapitulo);
				textView.setText(mData.get(position).getCapitulo().getDescricao());
				textView.setVisibility(TextView.VISIBLE);
			}else{
				textView.setVisibility(TextView.GONE);
			}
			
			
			

			textView = (TextView) gridView
					.findViewById(R.id.txtCanoneDescricaoTitulo);

			textView.setText(mData.get(position).getDescricao());

			Log.i("cdc", "parte");

	
		}			else if (mData.get(position).isGrupoCanoneCapitulo()) {

				gridView = inflater.inflate(R.layout.listcanonescapitulo, null);

				textView = (TextView) gridView.findViewById(R.id.txtTituloCapitulo);
				textView.setText(mData.get(position).getCapitulo().getDescricao());
				
				
				textView.setTypeface(null, Typeface.BOLD);

				textView.setBackgroundColor(CanoneAdapter.COR_BARRA_CINZA);
				// textView.setVisibility(TextView.VISIBLE);
				
				
				if(mData.get(position).isGrupoCanoneArtigo()){
					textView = (TextView) gridView
							.findViewById(R.id.txtCapituloArtigo);

					textView.setText(mData.get(position).getArtigo().getDescricao());
					textView.setTypeface(null, Typeface.BOLD);
					textView.setVisibility(TextView.VISIBLE);
					
				}else{
					textView.setVisibility(TextView.GONE);
				}
				

				textView = (TextView) gridView
						.findViewById(R.id.txtCanoneDescricaoCapitulo);

				textView.setText(mData.get(position).getDescricao());

				
		}else if (mData.get(position).isGrupoCanoneArtigo()) {

					gridView = inflater.inflate(R.layout.listcanonesartigo, null);

					textView = (TextView) gridView.findViewById(R.id.txtTituloArtigo);
					textView.setText(mData.get(position).getArtigo().getDescricao());
					
					
					textView.setTypeface(null, Typeface.BOLD);

					textView.setBackgroundColor(CanoneAdapter.COR_BARRA_CINZA);
					// textView.setVisibility(TextView.VISIBLE);
					

					textView = (TextView) gridView
							.findViewById(R.id.txtCanoneDescricaoArtigo);

					textView.setText(mData.get(position).getDescricao());

					
				
		
	}else{
			gridView = inflater.inflate(R.layout.listcanones, null);
			textView = (TextView) gridView
					.findViewById(R.id.txtCanoneDescricao);
			textView.setText(mData.get(position).getDescricao());
		}
		

		

		// se o canone conciver a mesma parte exibe so o canone pois foi exibido
		// a parte

		
			// textView.setVisibility(TextView.GONE);

			
		
		

		return gridView;
	}

	public void addItem(final Canone item) {
		mData.add(item);
		notifyDataSetChanged();
	}

	public void addSeparatorItem(final Canone item) {
		mData.add(item);
		// save separator position
		mSeparatorsSet.add(mData.size() - 1);
		notifyDataSetChanged();
	}

	@Override
	public int getItemViewType(int position) {
		return mSeparatorsSet.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
	}

}
