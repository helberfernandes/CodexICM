package br.com.wofsolutions.adapter;

import java.util.ArrayList;
import java.util.TreeSet;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.wofsolutions.R;
import br.com.wofsolutions.model.Canone;

public class MyCustomAdapter extends BaseAdapter {
	 
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;
    private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;

    private ArrayList<Canone> mData = new ArrayList<Canone>();
    private LayoutInflater mInflater;

    private TreeSet mSeparatorsSet = new TreeSet();

    public MyCustomAdapter(Context context) {
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Canone getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int type = getItemViewType(position);
        
        if (convertView == null) {
            holder = new ViewHolder();
            switch (type) {
             
                    
                case TYPE_ITEM:
                    
                	convertView = mInflater.inflate(R.layout.listcanones, null);
                    holder.textView = (TextView)convertView.findViewById(R.id.txtCanoneDescricao);
                    holder.textView.setText(mData.get(position).getDescricao());
                    break;
                    
                    
                case TYPE_SEPARATOR:
                    convertView = mInflater.inflate(R.layout.listcanonesparte, null);
                    holder.textView = (TextView)convertView.findViewById(R.id.txtParteTitulo);
                    holder.textView.setText(mData.get(position).getParte().getDescricao());
                    holder.textView.setTypeface(null, Typeface.BOLD);
                    
                    holder.txtTipoCanone = (TextView)convertView.findViewById(R.id.txtCanoneDescricaoParte);
                    holder.txtTipoCanone.setText(mData.get(position).getDescricao());
                    
                    break;  
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
  
        return convertView;
    }

    private static class ViewHolder {
        public TextView textView;
        public TextView txtTipoCanone;       
    }
}



