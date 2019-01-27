package com.codepath.examples.basicsnakegame;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.app.ListActivity;

public class HighScoreListActivity extends ListActivity {

    private TextView text;
    private List<String> listValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_list);

        text = (TextView) findViewById(R.id.mainText);

        listValues = new ArrayList<String>();
        listValues.add("jj: 600");
        listValues.add("secondPlace: 500");
        listValues.add("mp: 450");
        listValues.add("hello: 450");
        listValues.add("meow: 400");
        listValues.add("mprouty: 300");
        listValues.add("frisco: 250");
        listValues.add("justin: 200");
        listValues.add("bob: 150");
        listValues.add("alice: 100");

        // initiate the listadapter
        ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this,
                R.layout.row_layout, R.id.listText, listValues);

        // assign the list adapter
        setListAdapter(myAdapter);
    }

    // when an item of the list is clicked
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);

        String selectedItem = (String) getListView().getItemAtPosition(position);
        //String selectedItem = (String) getListAdapter().getItem(position);

        text.setText("You clicked " + selectedItem + " at position " + position);
    }
}
