package com.codepath.examples.basicsnakegame;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SnakeGameActivity extends simplegame.GameActivity {

	private DatabaseReference mDatabase;

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		
		//before activity is created : cold start
        //switch back to original Theme (App Theme)
        setTheme(R.style.AppTheme);

		//Initialize the high score list
		if (!HighScoreList.isPopulated()) {
			HighScoreList.populateList();

			//gets root reference
			mDatabase = FirebaseDatabase.getInstance().getReference();
			mDatabase.child("Player").addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(@NonNull DataSnapshot data) {
					for (DataSnapshot child : data.getChildren()) {
						Player player = child.getValue(Player.class);
						HighScoreList.updateList(player);
					}
				}

				@Override
				public void onCancelled(@NonNull DatabaseError databaseError) {
					//pass
				}
			});

		}

		switchFullscreen();
		setContentView(R.layout.activity_game);
		setContentView(new SnakeGamePanel(this));
	}
}
