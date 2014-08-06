package br.com.wofsolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ExpandableListView.OnChildClickListener;
import br.com.wofsolutions.adapter.CanoneAdapter;
import br.com.wofsolutions.adapter.GlossarioAdapter;
import br.com.wofsolutions.adapter.MyCustomAdapter;
import br.com.wofsolutions.adapter.NewAdapter;
import br.com.wofsolutions.db.RepositorioCodex;
import br.com.wofsolutions.model.Canone;
import br.com.wofsolutions.model.Livro;
import br.com.wofsolutions.model.Parte;

public class MainActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks, NavigationDrawerFragment.NavigationDrawerCallbacksSubItem {
	ListView listView;
	
	private static List<Livro> livros = new ArrayList<Livro>();
	
	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
		
		
		
		
		mNavigationDrawerFragment.getmDrawerListView().setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				Parte parte = mNavigationDrawerFragment.getAdapter().getChild(groupPosition, childPosition);   
				
				
				int number =(groupPosition+1);
				if (number==8) {// glossario
					
					
				
					carregaCanoneGlossarioDetalhe(parte);
					mNavigationDrawerFragment.getmDrawerLayout().closeDrawer(mNavigationDrawerFragment.getmFragmentContainerView());
				}else{
				
					
				carregaCanoneParte(parte);
				
				
				mNavigationDrawerFragment.getmDrawerLayout().closeDrawer(mNavigationDrawerFragment.getmFragmentContainerView());
				
				}
				
				
				
			
				return false;
			}
		});
		listView = (ListView)findViewById(R.id.listCanone);
		 
	
	}
	
	
	
	
	

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}
	
	
//	@Override
//	public void onNavigationDrawerItemSelectedSubItem(int position) {
//		// update the main content by replacing fragments
//		FragmentManager fragmentManager = getFragmentManager();
//		fragmentManager
//				.beginTransaction()
//				.replace(R.id.container,
//						PlaceholderFragment.newInstance(position + 1)).commit();
//	}
	
	public void onSectionAttached(int number) {
	
		Log.i("cdc", "numero "+number);
		
		switch (number) {
		case 1:
			carregaCanone(number);
			break;
		case 2:
			carregaCanone(number);
			break;
		case 3:
			carregaCanone(number);
			break;
		case 4:
			carregaCanone(number);
			break;
		case 5:
			carregaCanone(number);
			break;
		case 6:
			carregaCanone(number);
			break;			
		case 7:
			carregaCanone(number);
			break;	
		case 8:
			carregaTodoGlossario();
			
			break;	
		}
	}
	
	List<Canone> canones = new ArrayList<Canone>();
	public void carregaCanone(int number){
		
		mTitle=mNavigationDrawerFragment.getAdapter().getGroup(number-1).getDescricao();
//		
//		try{
//		mTitle=((Livro)mNavigationDrawerFragment.getmDrawerListView().getAdapter().getItem(number-1)).getDescricao();
//		}catch(ClassCastException ex){
//			mTitle=((Parte)mNavigationDrawerFragment.getmDrawerListView().getAdapter().getItem(number-1)).getDescricao();
//		}
		RepositorioCodex repositorioCodex = new RepositorioCodex(this);
		
		canones.clear();
		canones=repositorioCodex.findCanoneByLivro(number);
		
		int parteId=0;
		int tituloId=0;
		int capituloId=0;
		int artigoId=0;
		for(Canone canone: canones){
			
			
			if(canone.getParte().getParteId()!=parteId ){//encontrando o agrupamento das partes
				//adapter.addSeparatorItem(canone);
				
				canone.setGrupoCanone(true);
				parteId=canone.getParte().getParteId();
				
				Log.i("cdc", "PArte add "+parteId+" canone "+canone.getNumero());
			}else{
				canone.setGrupoCanone(false);
				//adapter.addItem(canone);
			}
			
			
			
			
			if(canone.getTitulo().getTituloId()!=tituloId ){
				//adapter.addSeparatorItem(canone);
				
				canone.setGrupoCanoneTitulo(true);
				tituloId=canone.getTitulo().getTituloId();
				
				
			}else{
				canone.setGrupoCanoneTitulo(false);
				//adapter.addItem(canone);
			}
			
			

			if(canone.getCapitulo().getCapituloId()!=capituloId ){
				//adapter.addSeparatorItem(canone);
				
				canone.setGrupoCanoneCapitulo(true);
				capituloId=canone.getCapitulo().getCapituloId();
				
				
			}else{
				canone.setGrupoCanoneCapitulo(false);
				//adapter.addItem(canone);
			}
			
			
			
			
			if(canone.getArtigo().getArtigoId()!=artigoId ){
			
				
				canone.setGrupoCanoneArtigo(true);
				artigoId=canone.getArtigo().getArtigoId();
				
				
			}else{
				canone.setGrupoCanoneArtigo(false);
				//adapter.addItem(canone);
			}
		}
	
		
        //relaciona o dataSource ao próprio listview
        listView.setAdapter(new CanoneAdapter(MainActivity.this, canones));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void carregaCanoneParte(Parte parte){
		
		mTitle=parte.getLivro().getDescricao();
		
		RepositorioCodex repositorioCodex = new RepositorioCodex(this);
		
		canones.clear();
		canones=repositorioCodex.findCanoneByParte(parte.getParteId());
		
		int parteId=0;
		int tituloId=0;
		int capituloId=0;
		int artigoId=0;
		for(Canone canone: canones){
			
			
			if(canone.getParte().getParteId()!=parteId ){//encontrando o agrupamento das partes
				//adapter.addSeparatorItem(canone);
				
				canone.setGrupoCanone(true);
				parteId=canone.getParte().getParteId();
				
				Log.i("cdc", "PArte add "+parteId+" canone "+canone.getNumero());
			}else{
				canone.setGrupoCanone(false);
				//adapter.addItem(canone);
			}
			
			
			
			
			if(canone.getTitulo().getTituloId()!=tituloId ){
				//adapter.addSeparatorItem(canone);
				
				canone.setGrupoCanoneTitulo(true);
				tituloId=canone.getTitulo().getTituloId();
				
				
			}else{
				canone.setGrupoCanoneTitulo(false);
				//adapter.addItem(canone);
			}
			
			

			if(canone.getCapitulo().getCapituloId()!=capituloId ){
				//adapter.addSeparatorItem(canone);
				
				canone.setGrupoCanoneCapitulo(true);
				capituloId=canone.getCapitulo().getCapituloId();
				
				
			}else{
				canone.setGrupoCanoneCapitulo(false);
				//adapter.addItem(canone);
			}
			
			
			
			
			if(canone.getArtigo().getArtigoId()!=artigoId ){
			
				
				canone.setGrupoCanoneArtigo(true);
				artigoId=canone.getArtigo().getArtigoId();
				
				
			}else{
				canone.setGrupoCanoneArtigo(false);
				//adapter.addItem(canone);
			}
		}
	
		
        //relaciona o dataSource ao próprio listview
        listView.setAdapter(new CanoneAdapter(MainActivity.this, canones));
	}
	
	
	
	
	public void carregaTodoGlossario(){
		
		mTitle="GLOSSÁRIO";
		RepositorioCodex repositorioCodex = new RepositorioCodex(this);
		
		canones.clear();
		canones=repositorioCodex.findAllGlossarioAsCanone();
		
	
		
	
		
        //relaciona o dataSource ao próprio listview
        listView.setAdapter(new GlossarioAdapter(MainActivity.this, canones));
	}
	
	
	public void carregaCanoneGlossarioDetalhe(Parte parte){
		mTitle=parte.getDescricao();
		RepositorioCodex repositorioCodex = new RepositorioCodex(this);
		
		canones.clear();
		//canones=repositorioCodex.findAllGlossarioAsCanone(parte.getParteId());
		canones=repositorioCodex.findAllGlossarioAsCanone();

        listView.setAdapter(new GlossarioAdapter(MainActivity.this, canones, new Canone(parte.getParteId()), listView));
        
        listView.setSelectionFromTop(canones.indexOf(new Canone(parte.getParteId())), 10);
        
		
	}
	

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
	}

}

class StableArrayAdapter extends ArrayAdapter<String> {

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public StableArrayAdapter(Context context, int textViewResourceId,
        List<String> objects) {
      super(context, textViewResourceId, objects);
      for (int i = 0; i < objects.size(); ++i) {
        mIdMap.put(objects.get(i), i);
      }
    }

    @Override
    public long getItemId(int position) {
      String item = getItem(position);
      return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
      return true;
    }

  }

