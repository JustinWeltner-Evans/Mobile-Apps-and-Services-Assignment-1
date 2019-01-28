package com.codepath.examples.basicsnakegame;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.app.ListActivity;

/**
 * https://examples.javacodegeeks.com/android/core/app/listactivity/android-listactivity-example/
 */

public class HighScoreListActivity extends ListActivity {

    private TextView text;
    private List<String> listValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_list);

        text = (TextView) findViewById(R.id.mainText);

        //Initialize the high score list
        if (!HighScoreList.isPopulated()) {
            HighScoreList.populateList();
        }
        listValues = HighScoreList.convertToStringList();

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
