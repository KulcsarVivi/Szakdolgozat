package com.example.playfulmath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView profileCardView, badgeCardView, gameCardView, rankingListCardView, logoutCardView;
    FirebaseAuth mAuth;

    TextView helloUsername;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        profileCardView = (CardView) findViewById(R.id.profileCardView);
        badgeCardView = (CardView) findViewById(R.id.badgeCardView);
        gameCardView = (CardView) findViewById(R.id.gameCardView);
        rankingListCardView = (CardView) findViewById(R.id.rankingListCardView);
        logoutCardView = (CardView) findViewById(R.id.logoutCardView);

        profileCardView.setOnClickListener((View.OnClickListener) this);
        badgeCardView.setOnClickListener((View.OnClickListener) this);
        gameCardView.setOnClickListener((View.OnClickListener) this);
        rankingListCardView.setOnClickListener((View.OnClickListener) this);
        logoutCardView.setOnClickListener((View.OnClickListener) this);

        mAuth = FirebaseAuth.getInstance();
        /*logoutButton = findViewById(R.id.logoutButton);


        //helloUsername = findViewById(R.id.helloTextView);           //hello
        //username = getIntent().getExtras().getString("Username");//hello
        //helloUsername.setText("Hello" + username);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent = new Intent(MenuActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });*/

    }

    @Override
    public void onClick(View v){
        Intent i;
        switch (v.getId()){
            case R.id.profileCardView:
                i = new Intent(MenuActivity.this, ProfileActivity.class);
                startActivity(i);
                break;
            case R.id.badgeCardView:
                i = new Intent(MenuActivity.this, BadgeActivity.class);
                startActivity(i);
                break;
            case R.id.gameCardView:
                i = new Intent(MenuActivity.this, GameMenuActivity.class);
                startActivity(i);
                break;
            case R.id.rankingListCardView:
                i = new Intent(MenuActivity.this, RankingListActivity.class);
                startActivity(i);
                break;
            case R.id.logoutCardView:
                mAuth.signOut();
                i = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}