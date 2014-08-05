package br.com.wofsolutions.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.wofsolutions.R;
import br.com.wofsolutions.model.Livro;
import br.com.wofsolutions.model.Parte;

@SuppressWarnings("unchecked")
public class NewAdapter extends BaseExpandableListAdapter {

	public ArrayList<String>  tempChild;
	private List<Livro> livros;
	
	public LayoutInflater minflater;
	public Activity activity;
	private final Context context;

	public NewAdapter(Context context,List<Livro> livros) {
		this.context = context;
		this.livros = livros;	
	}

	public void setInflater(LayoutInflater mInflater, Activity act) {
		this.minflater = mInflater;
		activity = act;
	}

	@Override
	public Parte getChild(int groupPosition, int childPosition) {
		return livros.get(groupPosition).getPartes().get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return livros.get(groupPosition).getPartes().get(childPosition).getParteId();
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		
		DrawerItemHolder drawerHolder;
		
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			view = inflater.inflate(R.layout.custom_drawer_sub_item, parent, false);
		}	
			
			drawerHolder = new DrawerItemHolder();
			
			
			
			
			drawerHolder.ItemName = (TextView) view
					.findViewById(R.id.drawer_itemName);			

			
			drawerHolder.ItemName.setText(livros.get(groupPosition).getPartes().get(childPosition).getDescricao());
			
			
			drawerHolder.ItemName.setPadding(16, 5, 0, 5);
		
			
			view.setTag(drawerHolder);
		
		
		
		
		

		
		
		
		
		
		return view;
	}

	

	@Override
	public int getChildrenCount(int groupPosition) {
		return livros.get(groupPosition).getPartes().size();
	}

	@Override
	public Livro getGroup(int groupPosition) {
		return livros.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return livros.size();
	}

	@Override
	public void onGroupCollapsed(int groupPosition) {
		super.onGroupCollapsed(groupPosition);
	}

	@Override
	public void onGroupExpanded(int groupPosition) {
		super.onGroupExpanded(groupPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return livros.get(groupPosition).getLivroId();
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		
		
		
		
		DrawerItemHolder drawerHolder;
		
		View view = convertView;
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		if (view == null) {
		
			view = inflater.inflate(R.layout.custom_drawer_item, parent, false);
		}	
			
			drawerHolder = new DrawerItemHolder();
			
		
			
			
			drawerHolder.ItemName = (TextView) view
					.findViewById(R.id.drawer_itemName);			

			drawerHolder.icon = (ImageView) view.findViewById(R.id.expandableIcone);
			
			
			
			drawerHolder.ItemName.setText(livros.get(groupPosition).getDescricao());
			drawerHolder.ItemName.setPadding(0, 5, 0, 5);
			// Definimos o tamanho do texto
			drawerHolder.ItemName.setTextSize(16);
			// Definimos que o texto estará em negrito
			drawerHolder.ItemName.setTypeface(null, Typeface.BOLD);
			
			
//			
			if(livros.get(groupPosition).getPartes().size() > 0){
				int imageResourceId = isExpanded ? android.R.drawable.arrow_up_float : android.R.drawable.arrow_down_float;
				drawerHolder.icon.setImageResource(imageResourceId);
				
				drawerHolder.icon.setVisibility(View.VISIBLE);
				drawerHolder.icon.setPadding(8, 8, 8, 8);
			} else {
				drawerHolder.icon.setVisibility(View.INVISIBLE);
			}
			
			
			
			view.setTag(drawerHolder);
//		} else {
//			drawerHolder = (DrawerItemHolder) view.getTag();
//
//		}
		
		
		
		

		
		
		
		
		view.setTag(drawerHolder);
		
		
		
//		if (convertView == null) {
//			convertView = new TextView(context);
//		}
//		((TextView) convertView).setText(livros.get(groupPosition));
//		convertView.setTag(livros.get(groupPosition));
//		
		
		
		return view;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

	private static class DrawerItemHolder {
		TextView ItemName;
		ImageView icon;
	}
}


