package com.example.listmultiselect;

import java.lang.reflect.Array;
import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	ListView list_view;
	ImageView markAsComplete, delete, edit;
	//String[] items = {"item one","item two","item three","item four","item five","item six","item seven","item eight","item nine","item ten"};
	ArrayList<String> items = new ArrayList<String>();
	ArrayList<Long> selectedItems = new ArrayList<Long>();
	ArrayAdapter<String> adapter;
	int count;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		count = 0;
		list_view = (ListView) findViewById(R.id.listViewShowItems);
		markAsComplete = (ImageView) findViewById(R.id.imageViewMarkAsComplete);
		delete = (ImageView) findViewById(R.id.imageViewDelete);
		edit = (ImageView) findViewById(R.id.imageViewEdit);
		items.add("item one");
		items.add("item two");
		items.add("item three");
		items.add("item four");
		items.add("item five");
		list_view.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, items);
		list_view.setAdapter(adapter);
		
		list_view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				
				if(selectedItems.contains(id)){
					view.setBackgroundResource(0);
					selectedItems.remove(id);
				}
				else{
					selectedItems.add(id);
					int color = Color.argb(255, 255, 175, 64);
					view.setBackgroundColor(color);
					
				}
				if(selectedItems.size() == 1){
					markAsComplete.setVisibility(View.VISIBLE);
					delete.setVisibility(View.VISIBLE);
					edit.setVisibility(View.VISIBLE);
				}
				if(selectedItems.size() > 1){
					edit.setVisibility(View.INVISIBLE);
					markAsComplete.setVisibility(View.VISIBLE);
					delete.setVisibility(View.VISIBLE);
					
				}
				if(selectedItems.size()==0){
					edit.setVisibility(View.INVISIBLE);
					markAsComplete.setVisibility(View.INVISIBLE);
					delete.setVisibility(View.INVISIBLE);
				}
				
			}
		});
	}

	
}
