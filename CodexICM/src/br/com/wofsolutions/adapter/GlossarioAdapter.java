package br.com.wofsolutions.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import br.com.wofsolutions.R;
import br.com.wofsolutions.model.Canone;
import br.com.wofsolutions.model.Parte;

@SuppressWarnings("unchecked")
public class GlossarioAdapter extends BaseAdapter {

	public ArrayList<String> tempChild;
	private List<Canone> canones;

	public LayoutInflater minflater;
	public Activity activity;
	private final Context context;
	private Canone canoneSelected = null;
	private ListView listView;

	public GlossarioAdapter(Context context, List<Canone> canones) {
		this.context = context;
		this.canones = canones;
	}

	public GlossarioAdapter(Context context, List<Canone> canones,
			Canone canoneSelected) {
		this.context = context;
		this.canones = canones;
		this.canoneSelected = canoneSelected;
	}

	public GlossarioAdapter(Context context, List<Canone> canones,
			Canone canoneSelected, ListView listView) {
		super();
		this.context = context;
		this.canones = canones;
		this.canoneSelected = canoneSelected;
		this.listView = listView;
	}

	public void setInflater(LayoutInflater mInflater, Activity act) {
		this.minflater = mInflater;
		activity = act;
	}

	public int getCount() {

		return canones.size();
	}

	public Object getItem(int position) {
		return canones.get(position);
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		DrawerItemHolder drawerHolder;

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View view = inflater.inflate(R.layout.glossario, null);

		drawerHolder = new DrawerItemHolder();

		drawerHolder.ItemName = (TextView) view.findViewById(R.id.txtPalavra);

		drawerHolder.ItemName.setText(canones.get(position).getNumero());
		drawerHolder.ItemName.setPadding(0, 5, 0, 5);
		// Definimos o tamanho do texto
		drawerHolder.ItemName.setTextSize(16);
		// Definimos que o texto estará em negrito
		drawerHolder.ItemName.setTypeface(null, Typeface.BOLD);

		drawerHolder.Significado = (TextView) view
				.findViewById(R.id.txtSignificado);

		drawerHolder.Significado.setText(canones.get(position).getDescricao());

		if (canoneSelected != null) {// deixa selecionado
			if (canoneSelected.getCanoneId() == canones.get(position)
					.getCanoneId()) {

				Log.i("cdc", "Igual");
				
				
				
				
			
				
				
				view.setBackgroundColor(Color.RED);
			}

		}

		view.setTag(drawerHolder);

		return view;
	}

	private static class DrawerItemHolder {
		TextView ItemName;
		TextView Significado;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

}
