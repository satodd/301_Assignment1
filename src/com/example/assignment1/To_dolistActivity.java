package com.example.assignment1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

public class To_dolistActivity extends ActionBarActivity {
	
	private Button nButton;
	private AutoCompleteTextView todo;
	
	private static final String FILENAME = "todo.txt";
	private ListView list_view;
	
	TaskList List = new TaskList();	
	TaskList Selected = new TaskList();
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_to_dolist);
		
		//add button function, view and textbox 
		Button nButton = (Button) findViewById(R.id.New_button);
		final AutoCompleteTextView todo_view = (AutoCompleteTextView) findViewById(R.id.add_new);
		list_view = (ListView) findViewById(R.id.listView);
		//oldList.setAdapter(list_adapter);
		
		
	//Click the "new" button, saves the todo
		nButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//add to task list
				String text = todo_view.getText().toString();
				saveInFile(text + "\n");
				List.add_new(text, (List.length() + 1));
				onGoing();
			}
			});
	//listens for clicking an item in the list view, once item is checked, looks for if it was selected already
		list_view.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String string = list_view.getItemAtPosition(position).toString();
				
				boolean isSelected = List.Select(position);
				if (isSelected == false) {
					list_view.setItemChecked(position, true);	
					Selected.add_new(string, position);
					System.out.print("hold");

				}
				else {
					list_view.setItemChecked(position, false);
					Selected.remove(position);
				}
				System.out.print("hold");
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.to_dolist, menu);
		return true;
	}
//dynamically changes listview
private void onGoing(){

	 //String[] todo = loadDuring();
	 String[] task = List.List_To_Array();
	 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.abc_list_menu_item_checkbox, task);
	 list_view.setAdapter(adapter);
}


//Code acquired from lonelytwitter ADD CITING HERE

protected void onStart() {
	// TODO Auto-generated method stub
	super.onStart();
	String[] todo = loadFromFile();
	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.abc_list_menu_item_checkbox, todo);
	list_view.setAdapter(adapter);
}

private String[] loadFromFile() {
	ArrayList<String> todo = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			int index = 0;
				while (line != null) {
					todo.add(line);
					List.add_new(line, index);
					line = in.readLine();
				}
		
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return todo.toArray(new String[todo.size()]);
}

private void saveInFile(String text) {
	try {
		FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
		//text = text + "\n";
		fos.write(new String(text).getBytes());
		fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

// END OF CODE FROM LONELYTWITTER


}
